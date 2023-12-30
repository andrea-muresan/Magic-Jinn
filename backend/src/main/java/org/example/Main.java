package org.example;

import org.example.domain.Animal;
import org.example.domain.Question;
import org.example.repository.AnimalDBRepository;
import org.example.repository.QuestionDBRepository;
import org.example.service.Service;

import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AnimalDBRepository animalRepo = new AnimalDBRepository("jdbc:postgresql://localhost:5432/magicJinn", "postgres", "postgres");
        QuestionDBRepository questionRepo = new QuestionDBRepository("jdbc:postgresql://localhost:5432/magicJinn", "postgres", "postgres");
        Service service = new Service(animalRepo, questionRepo);

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        List<Animal> possibleAnimals = service.getAnimals();
        List<Question> possibleQuestions = service.getQuestions();

        while (possibleAnimals.size() != 1 && !possibleQuestions.isEmpty()) {
            int index = random.nextInt(possibleQuestions.size());
            System.out.println(possibleQuestions.get(index));
            if (scanner.next().equals("yes")) {
                for (int i = 0; i < possibleAnimals.size(); i++) {
                    Animal a = possibleAnimals.get(i);
                    if (Objects.equals(possibleQuestions.get(index).getCharacteristic(), "can_fly") && !a.isCanFly()) {
                        possibleAnimals.remove(i);
                        i--;
                    } else if (Objects.equals(possibleQuestions.get(index).getCharacteristic(), "can_swim") && !a.isCanSwim()) {
                        possibleAnimals.remove(i);
                        i--;
                    }
                }
            } else {
                for (int i = 0; i < possibleAnimals.size(); i++) {
                    Animal a = possibleAnimals.get(i);
                    if (Objects.equals(possibleQuestions.get(index).getCharacteristic(), "can_fly") && a.isCanFly()) {
                        possibleAnimals.remove(i);
                        i--;
                    } else if (Objects.equals(possibleQuestions.get(index).getCharacteristic(), "can_swim") && a.isCanSwim()) {
                        possibleAnimals.remove(i);
                        i--;
                    }
                }
            }

            possibleQuestions.remove(index);
        }

        if(!possibleAnimals.isEmpty())
            System.out.println(possibleAnimals.get(0));

        //TODO: - questions
        //TODO: - UI
    }
}