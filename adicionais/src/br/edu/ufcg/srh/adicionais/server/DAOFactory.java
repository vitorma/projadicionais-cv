package br.edu.ufcg.srh.adicionais.server;

/**
 * A {@link DAO} factory.
 * 
 * @author Cleber Gonçalves de Sousa
 */
public interface DAOFactory {

    /**
     * @return a new {@link Operadora} DAO
     */
    public DAO<Servidor> criarServidorDAO();
}
