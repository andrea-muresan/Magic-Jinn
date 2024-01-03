package org.example.service;

import org.example.domain.Animal;

@FunctionalInterface
public interface MyFunction {
    boolean apply(Animal a, String answer);
}
