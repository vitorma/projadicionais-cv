package br.edu.ufcg.srh.adicionais.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("submit")
public interface SubmitService extends RemoteService{
	String submit(String matricula, String nome, String carreira, String localizacao, String setor, String horas, String tipoDeRisco, String agenteDeRisco, String descricao);

}
