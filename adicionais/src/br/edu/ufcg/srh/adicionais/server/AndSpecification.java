package br.edu.ufcg.srh.adicionais.server;

/**
 * A {@link Especificacao} that represents the AND operation on two other
 * specifications.
 * 
 * @param <T> the type of object to check
 * @author Cleber Sousa
 */
public class AndSpecification<T> extends EspecificacaoAbstrata<T> {
    private Especificacao<T> s1;
    private Especificacao<T> s2;

    /**
     * Creates a new {@code AndEspecification} with {@code s1} and {@code s2}.
     * 
     * @param s1 any specification
     * @param s2 any specification
     * @throws IllegalArgumentException if {@code s1} or {@code s2} is {@code
     *         null}
     */
    public AndSpecification(Especificacao<T> s1, Especificacao<T> s2) {
        Consistency.notNull(s1, new IllegalArgumentException("s1 is required."));
        Consistency.notNull(s2, new IllegalArgumentException("s2 is required."));

        this.s1 = s1;
        this.s2 = s2;
    }

    @Override
    public boolean isSatisfiedBy(T t) {
        return s1.isSatisfiedBy(t) && s2.isSatisfiedBy(t);
    }
}
