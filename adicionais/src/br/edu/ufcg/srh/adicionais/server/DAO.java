package br.edu.ufcg.srh.adicionais.server;

import java.util.Collection;

/**
 * A generic Data Access Object (DAO).
 * <p>
 * Objects to persist must be of type {@link Entity} to ensure that they have an
 * identifier (id) of type {@link Integer}.
 * 
 * @param <E> the type of the {@link Entity} to persist
 * @author Cleber G. de Sousa
 */
public interface DAO<E extends Entidade<E>> {

    /**
     * Stores the given {@code entity} if it isn't already stored.
     * 
     * @param entity the entity to store
     * @throws IllegalArgumentException if the given {@code entity} is {@code
     *         null}
     */
    public void add(E entity);

    /**
     * Removes the given entity if it's stored.
     * 
     * @param entity the entity to remove
     * @throws IllegalArgumentException if the given {@code entity} is {@code
     *         null}
     */
    public void remove(E entity);

    /**
     * Updates the given {@code entity} if it is stored.
     * 
     * @param entity the entity to update
     * @throws IllegalArgumentException if the given {@code entity} is {@code
     *         null}
     */
    public void update(E entity);

    /**
     * Retrieves an entity by its {@code id}.
     * 
     * @param id the id of the entity to retrieve
     * @return the entity with the given {@code id} or {@code null} if such
     *         entity is not stored
     */
    public E get(Id id);

    /**
     * Retrieves the first occurrence of entity that satisfies the given {@code
     * specification}.
     * 
     * @param specification the specification to satisfy
     * @return an entity that satisfies the given {@code specification} or
     *         {@code null} if such entity isn't stored
     * @throws IllegalArgumentException if the given {@code specification} is
     *         {@code null}
     */
    public E getBy(Especificacao<E> specification);

    /**
     * Retrieves all the entities that satisfy the given {@code specification}.
     * 
     * @param specification the specification to satisfy
     * @return the entities that satisfy the given {@code specification} or an
     *         empty collection if there aren't such entities stored
     * @throws IllegalArgumentException if the given {@code specification} is
     *         {@code null}
     */
    public Collection<E> getAllBy(Especificacao<E> specification);

    /**
     * @return all stored entities
     */
    public Collection<E> getAll();

    /**
     * @return a new valid Id
     */
    Id getNewId();
}
