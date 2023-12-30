package org.example.domain;

public class Question extends Entity<Long>{
    private String characteristic;
    private String textQuestion;

    public Question(String characteristic, String textQuestion) {
        this.characteristic = characteristic;
        this.textQuestion = textQuestion;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public String getTextQuestion() {
        return textQuestion;
    }

    @Override
    public String toString() {
        return "Question{" +
                "characteristic='" + characteristic + '\'' +
                ", textQuestion='" + textQuestion + '\'' +
                '}';
    }
}
