package br.edu.ufcg.srh.adicionais.server;

/**
 * A specification.
 * </p>
 * This interface is the root of the Specification Pattern implementation.
 * </p>
 * Use {@link EspecificacaoAbstrata} as base for creating specifications. Thus,
 * only the method {@link #isSatisfiedBy} will need be implemented.
 * </p>
 *
 * @param <T> the type of object to check
 * @author Cleber Sousa
 * @see <a href="http://en.wikipedia.org/wiki/Specification_pattern"
 *      >Specification Pattern</a>
 */
public interface Especificacao<T> {

    /**
     * Checks if {@code t} satisfies this specification.
     *
     * @param t the object to check
     * @return {@code true} if {@code t} is not {@code null} and satisfies this
     *         specification, {@code false} otherwise
     */
    public boolean isSatisfiedBy(T t);

    /**
     * Creates a new specification that is the result of the AND operation on
     * this specification and {@code s}.
     *
     * @param s the other operand of the AND operation
     * @return a new specification resulted by the AND operation
     * @throws IllegalArgumentException if {@code s} is {@code null}
     */
    public Especificacao<T> and(Especificacao<T> s);

    /**
     * Creates a new specification that is the result of the OR operation on
     * this specification and {@code s}.
     *
     * @param s the other operand of the OR operation
     * @return a new specification resulted by the OR operation
     * @throws IllegalArgumentException if {@code s} is {@code null}
     */
    public Especificacao<T> or(Especificacao<T> s);

    /**
     * Creates a new specification that is the result of the NOT operation on
     * this specification.
     *
     * @return a new specification resulted by the NOT operation
     */
    public Especificacao<T> not();
}
