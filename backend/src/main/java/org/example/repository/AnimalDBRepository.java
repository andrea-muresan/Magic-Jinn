package org.example.repository;

import org.example.domain.Animal;

import java.sql.*;
import java.util.*;

import static java.sql.DriverManager.getConnection;

public class AnimalDBRepository implements Repository<Long, Animal> {
    private final String url;
    private final String user;
    private final String password;

    public AnimalDBRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    private Animal mapResultSetToAnimal(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        String canSwim = resultSet.getString("can_swim");
        String canFly = resultSet.getString("can_fly");
        String isDomestic = resultSet.getString("is_domestic");
        String numberOfFeet = resultSet.getString("number_of_feet");
        String size = resultSet.getString("size");
        String habitat = resultSet.getString("habitat");
        String diet = resultSet.getString("diet");
        String distinctiveFeature = resultSet.getString("distinctive_feature");
        String socialBehavior = resultSet.getString("social_behavior");
        String predatorOrPrey = resultSet.getString("predator_or_prey");
        String nocturnalDiurnal = resultSet.getString("nocturnal_diurnal");
        String specialAbility = resultSet.getString("special_ability");
        String speed = resultSet.getString("speed");

        // Create and return an animal object
        return new Animal(name, canSwim,canFly, isDomestic, numberOfFeet, size, habitat, diet,
                distinctiveFeature, socialBehavior, predatorOrPrey, nocturnalDiurnal, specialAbility, speed);
    }

    @Override
    public Optional<Animal> findOne(Long aLong) {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM animal WHERE id=?");) {
            statement.setLong(1, aLong);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Animal animal = mapResultSetToAnimal(resultSet);
                return Optional.of(animal);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public Iterable<Animal> findAll() {
        Set<Animal> animals = new HashSet<>();

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement("select * from animal");
             ResultSet resultSet = statement.executeQuery()
        ) {

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                Animal animal = mapResultSetToAnimal(resultSet);
                animal.setId(id);
                animals.add(animal);
            }
            return animals;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
