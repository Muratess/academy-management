package br.com.accenture.model;

public class Aluno extends Pessoa {

	private double nota;
	private boolean presenca;
	private boolean aprovacao;
	private int id_academia;
	private String nomeAcademia;

	public boolean isPresenca() {
		return presenca;
	}

	public void setPresenca(boolean presenca) {
		this.presenca = presenca;
	}

	public boolean isAprovacao() {
		return aprovacao;
	}

	public void setAprovacao(boolean aprovacao) {
		this.aprovacao = aprovacao;
	}

	public int getId_academia() {
		return id_academia;
	}

	public void setId_academia(int id_academia) {
		this.id_academia = id_academia;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public double getNota() {
		return nota;
	}


	public boolean isPresente() {
		return presenca;
	}

	public void setPresente(boolean presente) {
		this.presenca = presente;
	}

	public boolean isAprovado() {
		return aprovacao;
	}

	public void setAprovado(boolean aprovado) {
		this.aprovacao = aprovado;
	}

	public String getNomeAcademia() {
		return nomeAcademia;
	}

	public void setNomeAcademia(String nomeAcademia) {
		this.nomeAcademia = nomeAcademia;
	}

}
