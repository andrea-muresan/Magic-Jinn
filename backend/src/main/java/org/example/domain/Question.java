package org.example.domain;

public class Question extends Entity<Long>{
    private String characteristic;
    private String textQuestion;
    private String answer;

    public Question(String characteristic, String textQuestion, String answer) {
        this.characteristic = characteristic;
        this.textQuestion = textQuestion;
        this.answer = answer;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public String getTextQuestion() {
        return textQuestion;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "characteristic='" + characteristic + '\'' +
                ", textQuestion='" + textQuestion + '\'' +
                '}';
    }
}
