package br.edu.ufcg.srh.adicionais.server;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;

import com.thoughtworks.xstream.persistence.FilePersistenceStrategy;
import com.thoughtworks.xstream.persistence.XmlArrayList;

/**
 * A {@link DAO} for persistence on XML files. It internally uses the XStream
 * library for handling the XML files.
 *
 * @param <E> the type of the {@link Entity} to persist
 * @author Cleber G. de Sousa
 */
public class XStreamDAO<E extends Entidade<E>> implements DAO<E> {
    private File directory;
    private Collection<E> entities;
    private Id lastId;

    /**
     * Creates a new {@code XSTreamDAO} that will work with XML files in the
     * given {@code directory}.
     * 
     * @param directory the directory of the XML files
     */
    public XStreamDAO(File directory) {
        this.directory = directory;
        this.entities = this.getEntitiesFromXml();
        this.lastId = this.getLastId(this.entities);
    }

    /**
     * @return a set of entities, translated from XML files
     */
    @SuppressWarnings("unchecked")
    private Collection<E> getEntitiesFromXml() {
        return new XmlArrayList(new FilePersistenceStrategy(this.directory));
    }

    /**
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    public void add(E entity) {
        Consistency.notNull(entity, new IllegalArgumentException(
                "entity is required"));
        Consistency.notContains(this.entities, entity, new IllegalArgumentException(
        		"entity already exists"));

        this.entities.add(entity);
    }

    /**
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    public void remove(E entity) {
        Consistency.notNull(entity, new IllegalArgumentException(
                "entity is required"));
        Consistency.contains(this.entities, entity, new IllegalArgumentException(
        		"entity doesn't exist"));

        this.entities.remove(entity);
    }

    /**
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    public void update(E entity) {
        Consistency.notNull(entity, new IllegalArgumentException(
                "entity is required"));
        Consistency.contains(this.entities, entity, new IllegalArgumentException(
				"entity doesn't exist"));

        int index = ((XmlArrayList) this.entities).indexOf(entity);
        ((XmlArrayList) this.entities).set(index, entity);
    }

    @Override
    public E get(Id id) {
        for (E e : this.getAll()) {
            if (e.getId().equals(id)) {
                return e;
            }
        }
        return null;
    }

    /**
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    public E getBy(Especificacao<E> specification) {
        Consistency.notNull(specification, new IllegalArgumentException(
                "specification is required"));

        for (E e : this.getAll()) {
            if (specification.isSatisfiedBy(e)) {
                return e;
            }
        }
        return null;
    }

    /**
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    public Collection<E> getAllBy(Especificacao<E> specification) {
        Consistency.notNull(specification, new IllegalArgumentException(
                "specification is required"));

        Collection<E> result = new HashSet<E>();
        for (E e : this.getAll()) {
            if (specification.isSatisfiedBy(e)) {
                result.add(e);
            }
        }
        return result;
    }

    @Override
    public Collection<E> getAll() {
        return new ArrayList<E>(this.entities);
    }

    private Id getLastId(Collection<E> entities) {
    	SortedSet<Id> ids = new TreeSet<Id>();
    	for (E e : entities) {ids.add(e.getId());}
    	return ids.isEmpty() ? new Id(Long.MIN_VALUE) : ids.last();
    }

    @Override
    public Id getNewId() {
    	this.lastId = this.lastId.proximo(); 
        return this.lastId;
    }
}
