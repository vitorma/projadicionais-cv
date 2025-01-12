package br.edu.ufcg.srh.adicionais.server;

/**
 * A {@link DAOFactory} that creates {@link DAO} objects for persistence on XML
 * files.
 * 
 * @author Cleber G. de Sousa
 */
public class XmlDAOFactory implements DAOFactory {

    @Override
    public DAO<Servidor> criarServidorDAO() {
        return new XStreamDAO<Servidor>(
                DataFolder.SERVIDORES.getDirectory());
    }
}
