package org.example.repository;

import org.example.domain.Entity;

import java.util.Optional;

public interface Repository<ID, E extends Entity<ID>> {
    /**
     *
     * @param id -the id of the entity to be returned
     *           id must not be null
     * @return an {@code Optional} encapsulating the entity with the given id
     * @throws IllegalArgumentException
     *                  if id is null.
     */
    Optional<E> findOne(ID id);

    /**
     *
     * @return all entities
     */
    Iterable<E> findAll();

}
