package org.example.service;

import org.example.domain.Animal;
import org.example.domain.Question;
import org.example.repository.AnimalDBRepository;
import org.example.repository.QuestionDBRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Service implements ServiceInterface{
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
    public List<Question> getQuestions() {
        List<Question> questions = new ArrayList<>();
        questionRepo.findAll().forEach(questions::add);
        return questions;
    }
    public void deleteList(MyFunction func, List<Animal> currentAnimals, String answer) {
        // func.apply();
        for (int i = 0; i < currentAnimals.size(); i++) {
            if (func.apply(currentAnimals.get(i), answer)) {
                currentAnimals.remove(i);
                i--;
            }
        }
    }
}
