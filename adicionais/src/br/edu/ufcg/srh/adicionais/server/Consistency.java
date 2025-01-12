package br.edu.ufcg.srh.adicionais.server;

import java.util.Collection;
import java.util.Iterator;

/**
 * Provides several methods that can be used for checking objects consistency.
 * <p>
 * Use this class to replace {@code if-throw} blocks that may spread through all
 * the code. All its methods are general enough to allow them reuse. The type of
 * objects to check is generic as well as the type of exception to throw.
 * 
 * @author Cleber Sousa
 */
public class Consistency {

    /**
     * Checks whether the given {@code exception} is not {@code null} and,
     * otherwise, throws an exception.
     * 
     * @param exception the exception to check
     * @throws IllegalArgumentException if the given exception is {@code null}
     */
    private static <E extends Exception> void checkException(E exception) {
        if (exception == null) {
            throw new IllegalArgumentException("exception should not be null");
        }
    }

    /**
     * Checks whether the given {@code assertion} is {@code true} and,
     * otherwise, throws the specified {@code exception}.
     * 
     * @param assertion the assertion to check
     * @param exception the exception to throw
     * @throws E if the given {@code assertion} is not {@code true}
     * @throws IllegalArgumentException if the given exception is {@code null}
     */
    public static <E extends Exception> void isTrue(boolean assertion,
            E exception) throws E {
        Consistency.checkException(exception);

        if (!assertion) {
            throw exception;
        }
    }

    /**
     * Checks whether the given {@code assertion} is {@code false} and,
     * otherwise, throws the specified {@code exception}.
     * 
     * @param assertion the assertion to check
     * @param exception the exception to throw
     * @throws E if the given {@code assertion} is not {@code false}
     * @throws IllegalArgumentException if the given exception is {@code null}
     */
    public static <E extends Exception> void isFalse(boolean assertion,
            E exception) throws E {
        Consistency.isTrue(!assertion, exception);
    }

    /**
     * Checks whether the given {@code object} is {@code null} and, otherwise,
     * throws the specified {@code exception}.
     * 
     * @param object the object to check
     * @param exception the exception to throw
     * @throws E if the given {@code object} is not {@code null}
     * @throws IllegalArgumentException if the given exception is {@code null}
     */
    public static <E extends Exception> void isNull(Object object, E exception)
            throws E {
        Consistency.isTrue(object == null, exception);
    }

    /**
     * Checks whether the given {@code object} is not {@code null} and,
     * otherwise, throws the specified {@code exception}.
     * 
     * @param object the object to check
     * @param exception the exception to throw
     * @throws E if the given {@code object} is {@code null}
     * @throws IllegalArgumentException if the given exception is {@code null}
     */
    public static <E extends Exception> void notNull(Object object, E exception)
            throws E {
        Consistency.isFalse(object == null, exception);
    }

    /**
     * Checks whether the given {@code array} has no {@code null} elements and,
     * otherwise, throws the specified {@code exception}.
     * 
     * @param array the array to check
     * @param exception the exception to throw
     * @throws E if the given {@code array} is {@code null} or has at least one
     *         {@code null} element
     * @throws IllegalArgumentException if the given exception is {@code null}
     */
    public static <T, E extends Exception> void noNullElements(T[] array,
            E exception) throws E {
        Consistency.notNull(array, exception);
        for (T t : array) {
            Consistency.notNull(t, exception);
        }
    }

    /**
     * 
     * @param <E>
     * @param array
     * @param exception
     * @throws E
     */
    public static <E extends Exception> void noBlankElements(String[] array,
            E exception) throws E {
        Consistency.notNull(array, exception);
        for (String s : array) {
            Consistency.notBlank(s, exception);
        }
    }

    /**
     * Checks whether the given {@code iterable} has no {@code null} elements
     * and, otherwise, throws the specified {@code exception}.
     * 
     * @param iterable the iterable to check
     * @param exception the exception to throw
     * @throws E if the given {@code iterable} is {@code null} or has at least
     *         one {@code null} element
     * @throws IllegalArgumentException if the given exception is {@code null}
     */
    public static <T extends Iterable<?>, E extends Exception> void noNullElements(
            T iterable, E exception) throws E {
        Consistency.notNull(iterable, exception);
        Iterator<?> i = iterable.iterator();
        while (i.hasNext()) {
            Consistency.notNull(i.next(), exception);
        }
    }
    
    /**
     * 
     * @param <T>
     * @param <E>
     * @param iterable
     * @param exception
     * @throws E
     */
    public static <T extends Iterable<String>, E extends Exception> void noBlankElements(
            T iterable, E exception) throws E {
        Consistency.notNull(iterable, exception);
        Iterator<String> i = iterable.iterator();
        while (i.hasNext()) {
            Consistency.notBlank(i.next(), exception);
        }
    }

    /**
     * Checks whether the given {@code string} is not blank ({@code null}, empty
     * or whitespace) and, otherwise, throws the specified {@code exception}.
     * 
     * @param string the string to check
     * @param exception the exception to throw
     * @throws E if the given {@code string} is blank
     * @throws IllegalArgumentException if the given exception is {@code null}
     */
    public static <E extends Exception> void notBlank(String string, E exception)
            throws E {
        Consistency.notNull(string, exception);
        Consistency.isFalse(string.trim().isEmpty(), exception);
    }

    /**
     * Checks whether the given {@code array} is not empty and, otherwise,
     * throws the specified {@code exception}.
     * 
     * @param array the array to check
     * @param exception the exception to throw
     * @throws E if the given {@code array} is {@code null} or empty
     * @throws IllegalArgumentException if the given exception is {@code null}
     */
    public static <T, E extends Exception> void notEmpty(T[] array, E exception)
            throws E {
        Consistency.notNull(array, exception);
        Consistency.isFalse(array.length == 0, exception);
    }

    /**
     * Checks whether the given {@code collection} is not empty and, otherwise,
     * throws the specified {@code exception}.
     * 
     * @param collection the collection to check
     * @param exception the exception to throw
     * @throws E if the given {@code collection} is {@code null} or empty
     * @throws IllegalArgumentException if the given exception is {@code null}
     */
    public static <T extends Collection<?>, E extends Exception> void notEmpty(
            T collection, E exception) throws E {
        Consistency.notNull(collection, exception);
        Consistency.isFalse(collection.isEmpty(), exception);
    }

    public static <T extends Collection<?>, E extends Exception> void isEmpty(
            T collection, E exception) throws E {
        Consistency.notNull(collection, exception);
        Consistency.isTrue(collection.isEmpty(), exception);
    }

    /**
     * Checks whether the given {@code index} is valid for the given {@code
     * array} and, otherwise, throws the specified {@code exception}.
     * <p>
     * This method will throw the given {@code exception} if, and only if,
     * <blockquote> {@code array} == null || {@code index} &lt 0 || {@code
     * index} &ge {@code array.length}. </blockquote>
     * 
     * @param array the array to check
     * @param index the index to check
     * @param exception the exception to throw
     * @throws E if the given {@code index} is not valid for the given {@code
     *         array} or if the {@code array} is {@code null}
     * @throws IllegalArgumentException if the given exception is {@code null}
     */
    public static <T, E extends Exception> void validIndex(T[] array,
            int index, E exception) throws E {
        Consistency.notNull(array, exception);
        Consistency.isTrue(index >= 0 && index < array.length, exception);
    }

    /**
     * Checks whether the given {@code index} is valid for the given {@code
     * collection} and, otherwise, throws the specified {@code exception}.
     * <p>
     * This method will throw the given {@code exception} if, and only if,
     * <blockquote> {@code collection} == null || {@code index} &lt 0 || {@code
     * index} &ge {@code collection.size()}. </blockquote>
     * 
     * @param collection the collection to check
     * @param index the index to check
     * @param exception the exception to throw
     * @throws E if the given {@code index} is not valid for the given {@code
     *         collection} or if the {@code collection} is {@code null}
     * @throws IllegalArgumentException if the given exception is {@code null}
     */
    public static <T extends Collection<?>, E extends Exception> void validIndex(
            T collection, int index, E exception) throws E {
        Consistency.notNull(collection, exception);
        Consistency.isTrue(index >= 0 && index < collection.size(), exception);
    }

    /**
     * 
     * @param <E>
     * @param str
     * @param regex
     * @param exception
     * @throws E
     */
    public static <E extends Exception> void matches(String str, String regex,
            E exception) throws E {
        Consistency.notNull(str, new IllegalArgumentException("str is required"));
        Consistency.notNull(regex, new IllegalArgumentException("regex is required"));
        Consistency.isTrue(str.matches(regex), exception);
    }

    /**
     * 
     * @param <E>
     * @param o1
     * @param o2
     * @param exception
     * @throws E
     */
    public static <E extends Exception> void equals(Object o1, Object o2,
            E exception) throws E {
        Consistency.notNull(o1, new IllegalArgumentException("o1 is required"));
        Consistency.notNull(o2, new IllegalArgumentException("o2 is required"));
        Consistency.isTrue(o1.equals(o2), exception);
    }

    /**
     * 
     * @param <T>
     * @param <E>
     * @param collection
     * @param element
     * @param exception
     * @throws E
     */
    public static <T, E extends Exception> void contains(
            Collection<T> collection, T element, E exception) throws E {
        Consistency.notNull(collection, new IllegalArgumentException("collection is required"));
        Consistency.isTrue(collection.contains(element), exception);
    }

    /**
     * 
     * @param <T>
     * @param <E>
     * @param collection
     * @param element
     * @param exception
     * @throws E
     */
    public static <T, E extends Exception> void notContains(
            Collection<T> collection, T element, E exception) throws E {
        Consistency.notNull(collection, new IllegalArgumentException("collection is required"));
        Consistency.notNull(element, new IllegalArgumentException("element is required"));
        Consistency.isFalse(collection.contains(element), exception);
    }

    public static <E extends Exception> void implies(boolean left, boolean right, E exception) throws E {
        Consistency.checkException(exception);

        if (left) {
            if (!right) {
                throw exception;
            }
        }
    }
}
