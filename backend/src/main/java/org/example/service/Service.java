package org.example.service;

import org.example.domain.Animal;
import org.example.domain.Question;
import org.example.repository.AnimalDBRepository;
import org.example.repository.QuestionDBRepository;

import java.util.*;

public class Service implements ServiceInterface {
    protected AnimalDBRepository animalRepo;
    protected QuestionDBRepository questionRepo;

    public Service(AnimalDBRepository animalRepo, QuestionDBRepository questionRepo) {
        this.animalRepo = animalRepo;
        this.questionRepo = questionRepo;
    }

    @Override
    public List<Animal> getAnimals() {
        List<Animal> animals = new ArrayList<>();
        animalRepo.findAll().forEach(animals::add);
        return animals;
    }

    @Override
    public Map<String, List<Question>> getQuestions() {
        Map<String, List<Question>> multiMapQuestions = new HashMap<>();

        questionRepo.findAll().forEach((question) -> {
                    multiMapQuestions.computeIfPresent(question.getCharacteristic(), (k, v) -> {
                        v.add(question);
                        return v;
                    });
                    multiMapQuestions.computeIfAbsent(question.getCharacteristic(), k -> new ArrayList<>(Collections.singletonList(question)));
                }
        );


        return multiMapQuestions;
    }

    public void deleteList(MyFunction func, List<Animal> currentAnimals, String answer) {
        for (int i = 0; i < currentAnimals.size(); i++) {
            if (func.apply(currentAnimals.get(i), answer)) {
                currentAnimals.remove(i);
                i--;
            }
        }
    }

    public void deleteQuestionsCharacteristic(Map<String, List<Question>> currentQuestions, String key) {
        currentQuestions.remove(key);
    }

    public void deleteCharacteristicFirstQuestion(Map<String, List<Question>> currentQuestions, String key) {
        if (currentQuestions.get(key).size() == 1) {
            currentQuestions.remove(key);
        } else {
            currentQuestions.computeIfPresent(key, (k, v) -> {
                v.remove(0);
                return v;
            });
        }
    }


}
