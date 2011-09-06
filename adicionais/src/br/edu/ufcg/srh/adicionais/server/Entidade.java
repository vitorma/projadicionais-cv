package br.edu.ufcg.srh.adicionais.server;


/**
 * 
 * @param <T>
 *
 * @author Cleber Gonçalves de Sousa
 */
public interface Entidade<T> {

    public Id getId();

    public boolean mesmoIdQue(T t);
}
