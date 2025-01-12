package br.edu.ufcg.srh.adicionais.server;

/**
 * Abstract base implementation of {@link Especificacao}, with default
 * implementations for {@link #and}, {@link #or} and {@link #not} methods.
 *
 * @param <T> the type of object to check
 * @author Cleber Sousa
 */
public abstract class EspecificacaoAbstrata<T> implements Especificacao<T> {

    @Override
    public abstract boolean isSatisfiedBy(T t);

    /**
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    public Especificacao<T> and(Especificacao<T> s) {
        return new AndSpecification<T>(this, s);
    }

    /**
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    public Especificacao<T> or(Especificacao<T> s) {
        return new OrSpecification<T>(this, s);
    }

    @Override
    public Especificacao<T> not() {
        return new NotSpecification<T>(this);
    }
}
