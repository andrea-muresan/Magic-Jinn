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

        while (true) {
            List<Animal> possibleAnimals = service.getAnimals();
            List<Question> possibleQuestions = service.getQuestions();


            while (possibleAnimals.size() > 1 && !possibleQuestions.isEmpty()) {
                int index = random.nextInt(possibleQuestions.size());
                Question question = possibleQuestions.get(index);
                System.out.println(question);

                String yes_no = scanner.next();
                if (yes_no.equals("yes") || yes_no.equals("da")) {
                    if (Objects.equals(question.getCharacteristic(), "can_fly")) {
                        MyFunction canFly = (animal, answer) -> !animal.getCanFly().equals(answer);
                        service.deleteList(canFly, possibleAnimals, question.getAnswer());

                    } else if (Objects.equals(question.getCharacteristic(), "can_swim")) {
                        MyFunction canSwim = (animal, answer) -> !animal.getCanSwim().equals(answer);
                        service.deleteList(canSwim, possibleAnimals, question.getAnswer());
                    } else if (Objects.equals(question.getCharacteristic(), "is_domestic")) {
                        MyFunction isDomestic = (animal, answer) -> !animal.getIsDomestic().equals(answer);
                        service.deleteList(isDomestic, possibleAnimals,question.getAnswer());
                    } else if (Objects.equals(question.getCharacteristic(), "number_of_feet")) {
                        MyFunction isDomestic = (animal, answer) -> !animal.getNumberOfFeet().equals(answer);
                        service.deleteList(isDomestic, possibleAnimals,question.getAnswer());
                    } else if (Objects.equals(question.getCharacteristic(), "size")) {
                        MyFunction isDomestic = (animal, answer) -> !animal.getSize().equals(answer);
                        service.deleteList(isDomestic, possibleAnimals,question.getAnswer());
                    } else if (Objects.equals(question.getCharacteristic(), "nocturnal_diurnal")) {
                        MyFunction isDomestic = (animal, answer) -> !animal.getNocturnalDiurnal().equals(answer);
                        service.deleteList(isDomestic, possibleAnimals,question.getAnswer());
                    }

                    service.deleteQuestionsCharacteristic(possibleQuestions, question.getCharacteristic());
                } else if(yes_no.equals("no") || yes_no.equals("nu")) {
                    if (Objects.equals(question.getCharacteristic(), "can_fly")) {
                        MyFunction canFly = (animal, answer) -> animal.getCanFly().equals(answer);
                        service.deleteList(canFly, possibleAnimals, question.getAnswer());
                    } else if (Objects.equals(question.getCharacteristic(), "can_swim")) {
                        MyFunction canSwim = (animal, answer) -> animal.getCanSwim().equals(answer);
                        service.deleteList(canSwim, possibleAnimals, question.getAnswer());
                    } else if (Objects.equals(question.getCharacteristic(), "is_domestic")) {
                        MyFunction isDomestic = (animal, answer) -> animal.getIsDomestic().equals(answer);
                        service.deleteList(isDomestic, possibleAnimals,question.getAnswer());
                    } else if (Objects.equals(question.getCharacteristic(), "number_of_feet")) {
                        MyFunction isDomestic = (animal, answer) -> animal.getNumberOfFeet().equals(answer);
                        service.deleteList(isDomestic, possibleAnimals,question.getAnswer());
                    } else if (Objects.equals(question.getCharacteristic(), "size")) {
                        MyFunction isDomestic = (animal, answer) -> animal.getSize().equals(answer);
                        service.deleteList(isDomestic, possibleAnimals,question.getAnswer());
                    } else if (Objects.equals(question.getCharacteristic(), "nocturnal_diurnal")) {
                        MyFunction isDomestic = (animal, answer) -> animal.getNocturnalDiurnal().equals(answer);
                        service.deleteList(isDomestic, possibleAnimals, question.getAnswer());
                    }

                    possibleQuestions.remove(index);
                } else {
                    System.out.println("Nu am inteles");
                }


            }

            if(!possibleAnimals.isEmpty())
                System.out.println(possibleAnimals.get(0));
            else System.out.println(":(((");
        }

    }


}