package br.edu.ufcg.srh.adicionais.server;

import java.util.Collection;

/**
 * 
 * @author Cleber Gonçalves de Sousa
 */
public final class Persistencia {
    private static Persistencia instancia;

    private DAO<Servidor> servidores;

    private Persistencia() {
        this.servidores = new XmlDAOFactory().criarServidorDAO();
    }

    public synchronized static Persistencia getInstancia() {
        if (instancia == null) {
            instancia = new Persistencia();
        }

        return instancia;
    }

    public synchronized void inserirServidor(Servidor s) {
        this.servidores.add(s);
    }
    
    public synchronized void removerServidor(Id id) {
        this.servidores.remove(this.getServidor(id));
    }

    public synchronized void atualizarServidor(Servidor s) {
        this.servidores.update(s);
    }

    public synchronized Servidor getServidor(Id id) {
        return this.servidores.get(id);
    }

    public synchronized Servidor getServidorPor(
            Especificacao<Servidor> specification) {
        return this.servidores.getBy(specification);
    }

    public synchronized Collection<Servidor> getTodosServidoresPor(
            Especificacao<Servidor> specification) {
        return this.servidores.getAllBy(specification);
    }

    public synchronized Collection<Servidor> getTodosServidores() {
        return this.servidores.getAll();
    }

    public synchronized Id novoIdServidor() {
        return this.servidores.getNewId();
    }
}
