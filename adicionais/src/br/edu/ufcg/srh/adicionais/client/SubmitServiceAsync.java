package br.edu.ufcg.srh.adicionais.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface SubmitServiceAsync {
	void submit(String matricula, String nome, String carreira, String localizacao, String setor, String horas, String tipoDeRisco, String agenteDeRisco, String descricao, AsyncCallback<String> callback);

}
