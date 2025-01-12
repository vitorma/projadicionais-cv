package br.edu.ufcg.srh.adicionais.server;


/**
 * A {@link Especificacao} that represents the NOT operation on another
 * specification.
 *
 * @param <T> the type of object to check
 * @author Cleber Sousa
 */
public class NotSpecification<T> extends EspecificacaoAbstrata<T> {
    private Especificacao<T> specification;

    /**
     * Creates a new {@code NotEspecification} with {@code s}.
     *
     * @param s any specification
     * @throws IllegalArgumentException if {@code s} is {@code null}
     */
    public NotSpecification(Especificacao<T> s) {
        Consistency.notNull(s, new IllegalArgumentException("s is required."));

        this.specification = s;
    }

    @Override
    public boolean isSatisfiedBy(T t) {
        return !this.specification.isSatisfiedBy(t);
    }
}
