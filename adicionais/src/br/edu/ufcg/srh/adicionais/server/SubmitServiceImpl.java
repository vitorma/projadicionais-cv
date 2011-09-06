package br.edu.ufcg.srh.adicionais.server;

import java.io.Serializable;

import br.edu.ufcg.srh.adicionais.client.SubmitService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class SubmitServiceImpl extends RemoteServiceServlet implements
  SubmitService, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public String submit(String matricula, String nome, String carreira,
			String localizacao, String setor, String horas, String tipoDeRisco,
			String agenteDeRisco, String descricao) {
		Id id = Persistencia.getInstancia().novoIdServidor();
		Servidor r = new Servidor(id, matricula, nome, carreira, "reitoria", localizacao, setor, horas, tipoDeRisco, agenteDeRisco, descricao);
		Persistencia.getInstancia().inserirServidor(r);
		return r.getMatricula();
	}
}