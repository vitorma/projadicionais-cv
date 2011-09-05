package br.edu.ufcg.srh.adicionais.server;

import br.edu.ufcg.srh.adicionais.client.SubmitService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;


@SuppressWarnings("serial")
public class SubmitServiceImpl extends RemoteServiceServlet implements
  SubmitService {

	@Override
	public String subimit(String matricula, String nome, String carreira,
			String localizacao, String setor, String horas, String tipoDeRisco,
			String agenteDeRisco, String descricao) {
		
		Registro r = new Registro(matricula, nome, carreira, localizacao, setor, horas, tipoDeRisco, agenteDeRisco, descricao);
		return r.getMatricula();
				
	}
}