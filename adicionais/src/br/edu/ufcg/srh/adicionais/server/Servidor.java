package br.edu.ufcg.srh.adicionais.server;

public class Servidor implements Entidade<Servidor> {
	private Id id;
	private String matricula;
	private String nome;
	private String carreira;
	private String centro;
	private String localizacao;
	private String setorDeRisco;
	private String horasNoSetorDeRisco;
	private String tipoDeRisco;
	private String risco;
	private String descricao;

	public Servidor (Id id,
			         String matricula,
			         String nome,
			         String carreira,
			         String centro,
			         String localizacao,
			         String setorDeRisco,
			         String horasNoSetorDeRisco,
			         String tipoDeRisco,
			         String risco,
			         String descricao) {
		Consistency.notNull(id, new IllegalArgumentException("Id deve ser informado!"));
		Consistency.notBlank(matricula, new IllegalArgumentException("Matrícula deve ser informada!"));
		Consistency.notBlank(nome, new IllegalArgumentException("Nome deve ser informado!"));
		Consistency.notBlank(carreira, new IllegalArgumentException("Carreira deve ser informada!"));
		Consistency.notBlank(centro, new IllegalArgumentException("Centro deve ser informado!"));
		Consistency.notBlank(localizacao, new IllegalArgumentException("Localização deve ser informada!"));
		Consistency.notBlank(setorDeRisco, new IllegalArgumentException("Setor de risco deve ser informado!"));
		Consistency.notBlank(horasNoSetorDeRisco, new IllegalArgumentException("Número de horas no setor de risco deve ser informado!"));
		Consistency.notBlank(tipoDeRisco, new IllegalArgumentException("Tipo de risco deve ser informado!"));
		Consistency.notBlank(risco, new IllegalArgumentException("Risco deve ser informado!"));
		Consistency.notBlank(descricao, new IllegalArgumentException("Descrição deve ser informada!"));
		this.id = id;
		this.matricula = matricula;
		this.nome = nome;
		this.carreira = carreira;
		this.localizacao = localizacao;
		this.setorDeRisco = setorDeRisco;
		this.horasNoSetorDeRisco = horasNoSetorDeRisco;
		this.tipoDeRisco = tipoDeRisco;
		this.risco = risco;
		this.descricao = descricao;
	}
	
	@Override
	public Id getId() {
		return this.id;
	}

	public String getMatricula() {
		return this.matricula;
	}

	public String getNome() {
		return this.nome;
	}

	public String getCarreira() {
		return this.carreira;
	}

	public String getCentro() {
		return this.centro;
	}

	public String getLocalizacao() {
		return this.localizacao;
	}

	public String getSetorDeRisco() {
		return this.setorDeRisco;
	}

	public String getHorasNoSetorDeRisco() {
		return this.horasNoSetorDeRisco;
	}

	public String getTipoDeRisco() {
		return this.tipoDeRisco;
	}

	public String getRisco() {
		return this.risco;
	}

	public String getDescricao() {
		return this.descricao;
	}
	
	@Override
	public boolean mesmoIdQue(Servidor outro) {
		return (outro != null) && outro.id.equals(this.id);
	}

	@Override
	public int hashCode() {
		return this.id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof Servidor) &&
		       this.mesmoIdQue((Servidor) obj);
	}
}
