package br.edu.ufcg.srh.adicionais.server;


public class Registro{
	
	String matricula;
	String nome;
	String carreira;
	String localizacao;
	String setor;
	String horas;
	String tipoDeRisco;
	String agenteDeRisco;
	String descricao;
	
	public Registro() {
		
	}
	
	public Registro (String matricula, String nome, String carreira,
			String localizacao, String setor, String horas, String tipoDeRisco,
			String agenteDeRisco, String descricao) {
		
		this.matricula = matricula;
		this.nome = nome;
		this.carreira = carreira;
		this.localizacao = localizacao;
		this.setor = setor;
		this.horas = horas;
		this.tipoDeRisco = tipoDeRisco;
		this.agenteDeRisco = agenteDeRisco;
		this.descricao = descricao;
		
		}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCarreira() {
		return carreira;
	}

	public void setCarreira(String carreira) {
		this.carreira = carreira;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String getHoras() {
		return horas;
	}

	public void setHoras(String horas) {
		this.horas = horas;
	}

	public String getTipoDeRisco() {
		return tipoDeRisco;
	}

	public void setTipoDeRisco(String tipoDeRisco) {
		this.tipoDeRisco = tipoDeRisco;
	}

	public String getAgenteDeRisco() {
		return agenteDeRisco;
	}

	public void setAgenteDeRisco(String agenteDeRisco) {
		this.agenteDeRisco = agenteDeRisco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
