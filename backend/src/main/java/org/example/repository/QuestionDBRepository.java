package org.example.repository;

import org.example.domain.Animal;
import org.example.domain.Question;

import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class QuestionDBRepository implements Repository<Long, Question> {
    private final String url;
    private final String user;
    private final String password;

    public QuestionDBRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    private Question mapResultSetToQuestion(ResultSet resultSet) throws SQLException {
        String characteristic =  resultSet.getString("characteristic");
        String questionText =  resultSet.getString("question_text");

        // Create and return an question object
        return new Question(characteristic, questionText);
    }

    @Override
    public Optional<Question> findOne(Long aLong) {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM question WHERE id=?");) {
            statement.setLong(1, aLong);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Question question = mapResultSetToQuestion(resultSet);
                return Optional.of(question);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public Iterable<Question> findAll() {
        Set<Question> questions = new HashSet<>();

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("select * from question");
             ResultSet resultSet = statement.executeQuery()
        ) {

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                Question question = mapResultSetToQuestion(resultSet);
                question.setId(id);
                questions.add(question);
            }
            return questions;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}