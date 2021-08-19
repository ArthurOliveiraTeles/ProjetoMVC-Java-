package br.com.cadastro.model;

public class NotasFaltas {
	private int rgm;
	private String nomeCurso;
	private String disciplina;
	private String semestre;
	private double nota;
	private int faltas;
	
	public NotasFaltas() {
	}
	
	
	public NotasFaltas(int rgm, String nomeCurso, String disciplina, String semestre, double nota, int faltas) {
		super();
		this.rgm = rgm;
		this.nomeCurso = nomeCurso;
		this.disciplina = disciplina;
		this.semestre = semestre;
		this.nota = nota;
		this.faltas = faltas;
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


	public String getDisciplina() {
		return disciplina;
	}


	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}


	public String getSemestre() {
		return semestre;
	}


	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}


	public double getNota() {
		return nota;
	}


	public void setNota(double nota) {
		this.nota = nota;
	}


	public int getFaltas() {
		return faltas;
	}


	public void setFaltas(int faltas) {
		this.faltas = faltas;
	}
	
	
	
	
}

