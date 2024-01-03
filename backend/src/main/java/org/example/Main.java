package org.example;

import org.example.domain.Animal;
import org.example.domain.Question;
import org.example.repository.AnimalDBRepository;
import org.example.repository.QuestionDBRepository;
import org.example.service.MyFunction;
import org.example.service.Service;

import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main  {

    private static String language = "ro";
    public static void main(String[] args) {
        AnimalDBRepository animalRepo = new AnimalDBRepository("jdbc:postgresql://localhost:5432/magicJinn", "postgres", "postgres", language);
        QuestionDBRepository questionRepo = new QuestionDBRepository("jdbc:postgresql://localhost:5432/magicJinn", "postgres", "postgres", language);
        Service service = new Service(animalRepo, questionRepo);

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        List<Animal> possibleAnimals = service.getAnimals();
        List<Question> possibleQuestions = service.getQuestions();


        while (possibleAnimals.size() > 1 && !possibleQuestions.isEmpty()) {
            int index = random.nextInt(possibleQuestions.size());
            System.out.println(possibleQuestions.get(index));

            String yes_no = scanner.next();
            if (yes_no.equals("yes") || yes_no.equals("da")) {
                if (Objects.equals(possibleQuestions.get(index).getCharacteristic(), "can_fly")) {
                    MyFunction canFly = (animal, answer) -> !animal.getCanFly().equals(answer);
                    service.deleteList(canFly, possibleAnimals, possibleQuestions.get(index).getAnswer());
                } else if (Objects.equals(possibleQuestions.get(index).getCharacteristic(), "can_swim")) {
                    MyFunction canSwim = (animal, answer) -> !animal.getCanSwim().equals(answer);
                    service.deleteList(canSwim, possibleAnimals, possibleQuestions.get(index).getAnswer());
                }
            } else {
                if (Objects.equals(possibleQuestions.get(index).getCharacteristic(), "can_fly")) {
                    MyFunction canFly = (animal, answer) -> animal.getCanFly().equals(answer);
                    service.deleteList(canFly, possibleAnimals, possibleQuestions.get(index).getAnswer());
                } else if (Objects.equals(possibleQuestions.get(index).getCharacteristic(), "can_swim")) {
                    MyFunction canSwim = (animal, answer) -> animal.getCanSwim().equals(answer);
                    service.deleteList(canSwim, possibleAnimals, possibleQuestions.get(index).getAnswer());
                }
            }

            possibleQuestions.remove(index);
        }

        if(!possibleAnimals.isEmpty())
            System.out.println(possibleAnimals.get(0));
        else System.out.println(":(((");

    }


}