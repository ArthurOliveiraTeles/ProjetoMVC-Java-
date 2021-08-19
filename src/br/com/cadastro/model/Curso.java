package br.com.cadastro.model;

public class Curso {
	private int rgm;
	private String nomeCurso;
	private String campus;
	private String periodo;
	
	
	public Curso() {
	}


	public Curso(int rgm, String nomeCurso, String campus, String periodo) {
		super();
		this.rgm = rgm;
		this.nomeCurso = nomeCurso;
		this.campus = campus;
		this.periodo = periodo;
	}


	public int getRgm() {
		return rgm;
	}


	public void setRgm(int rgm) {
		this.rgm = rgm;
	}


	public String getNomeCurso() {
		return nomeCurso;
	}


	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}


	public String getCampus() {
		return campus;
	}


	public void setCampus(String campus) {
		this.campus = campus;
	}


	public String getPeriodo() {
		return periodo;
	}


	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
}
