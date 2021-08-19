package br.com.cadastro.model;

public class Boletim {
	private int rgm;
	private String nome;
	private String curso;
	private String disciplina;
	private double nota;
	private int faltas;
	
	public Boletim() {
		
	}
	
	public Boletim(int rgm, String nome, String curso, String disciplina, double nota, int falta) {
		super();
		this.rgm = rgm;
		this.nome = nome;
		this.curso = curso;
		this.disciplina = disciplina;
		this.nota = nota;
		this.faltas = faltas;
	}

	public int getRgm() {
		return rgm;
	}

	public void setRgm(int rgm) {
		this.rgm = rgm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
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
