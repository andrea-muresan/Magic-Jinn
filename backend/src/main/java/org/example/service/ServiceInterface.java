package org.example.service;

import org.example.domain.Animal;
import org.example.domain.Question;

import java.util.List;
import java.util.Optional;

public interface ServiceInterface {
    /**
     * @return an Iterable of all the animals
     */
    List<Animal> getAnimals();

    /**
     * @return an Iterable of all the questions
     */
    List<Question> getQuestions();


}
