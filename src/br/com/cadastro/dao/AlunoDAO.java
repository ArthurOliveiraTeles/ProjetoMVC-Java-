package br.com.cadastro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.cadastro.model.Aluno;
import br.com.cadastro.model.Boletim;
import br.com.cadastro.model.Curso;
import br.com.cadastro.model.NotasFaltas;
import br.com.cadastro.util.ConnectionFactory;

public class AlunoDAO {	 // CRUD
 // Data Access Object
	
	private Aluno aluno;
	private Curso curso;
	private NotasFaltas notas;
	private Boletim boletim;
	private Connection conn; // conecta com o banco de dados
	private PreparedStatement ps; // permite executar comandos sql dentro do java
	private ResultSet rs;
	
	public AlunoDAO() throws Exception { // não irá tratar erro
		try {
			// Ao mexer com banco de dados em Java é necessário usar try catch
			conn = ConnectionFactory.getConnection();
		}catch(Exception e) {
			throw new Exception("Erro"+ e.getMessage());
		}
	}
	public void salvar(Aluno aluno, Curso curso) throws Exception {
		try {
			String sql = "INSERT INTO ALUNO(RGM, NOME_ALUNO, DATA_NASCIMENTO, CPF, EMAIL, ENDERECO, MUNICIPIO,"
					+ "UF, CELULAR) VALUES (?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, aluno.getRgm()); // 1° campo representa o rgm na inserção do sql
			ps.setString(2, aluno.getNome());
			ps.setString(3, aluno.getDataNasc());
			ps.setString(4, aluno.getCpf());
			ps.setString(5, aluno.getEmail());
			ps.setString(6, aluno.getEndereco());
			ps.setString(7, aluno.getMunicipio());
			ps.setString(8, aluno.getUf());
			ps.setString(9, aluno.getCelular());
			ps.executeUpdate();
			
			String sql2 = "INSERT INTO CURSO(RGM, NOME_CURSO, CAMPUS, PERIODO) VALUES (?, ?, ?, ?)";
			ps = conn.prepareStatement(sql2);
			ps.setInt(1, curso.getRgm());
			ps.setString(2, curso.getNomeCurso());
			ps.setString(3, curso.getCampus());
			ps.setString(4, curso.getPeriodo());
			ps.executeUpdate();
		}catch(Exception e) {
			throw new Exception("Erro ao salvar" + e.getMessage());
		}
		
	}
	
	public void salvarNotas(NotasFaltas notas) throws Exception {
		try {
			String sql = "INSERT INTO NOTASFALTAS(RGM, NOME_CURSO, DISCIPLINA, SEMESTRE, NOTA, FALTAS)"
					+ "VALUES (?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, notas.getRgm()); // 1° campo representa o rgm na inserção do sql
			ps.setString(2, notas.getNomeCurso());
			ps.setString(3, notas.getDisciplina());
			ps.setString(4, notas.getSemestre());
			ps.setDouble(5, notas.getNota());
			ps.setInt(6, notas.getFaltas());
			ps.executeUpdate();
		
		}catch(Exception e) {
			throw new Exception("Erro ao salvar" + e.getMessage());
		}
		
	}
	
	public void alterar(Aluno aluno, Curso curso) throws Exception {
		try {
			String sql = "UPDATE ALUNO SET NOME_ALUNO = ?, DATA_NASCIMENTO = ?, CPF = ?, EMAIL = ?, ENDERECO = ?, MUNICIPIO = ?,"
					+ "UF=?, CELULAR=? WHERE RGM=? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, aluno.getNome());
			ps.setString(2, aluno.getDataNasc());
			ps.setString(3, aluno.getCpf());
			ps.setString(4, aluno.getEmail());
			ps.setString(5, aluno.getEndereco());
			ps.setString(6, aluno.getMunicipio());
			ps.setString(7, aluno.getUf());
			ps.setString(8, aluno.getCelular());
			ps.setInt(9, aluno.getRgm());
			ps.executeUpdate();
			
			String sql2 = "UPDATE CURSO SET NOME_CURSO = ?, CAMPUS = ?, PERIODO = ? WHERE RGM = ?";
			ps = conn.prepareStatement(sql2);
			ps.setString(1, curso.getNomeCurso());
			ps.setString(2, curso.getCampus());
			ps.setString(3, curso.getPeriodo());
			ps.setInt(4, curso.getRgm());
			ps.executeUpdate();
		}catch(Exception e) {
			throw new Exception("Erro ao alterar" + e.getMessage());
		}
		
	}
	
	public void alterarNotas(NotasFaltas notas) throws Exception {
		try {
			String sql = "UPDATE NOTASFALTAS SET NOME_CURSO = ?, DISCIPLINA = ?, SEMESTRE = ?, NOTA = ?, FALTAS = ? WHERE RGM=? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, notas.getNomeCurso());
			ps.setString(2, notas.getDisciplina());
			ps.setString(3, notas.getSemestre());
			ps.setDouble(4, notas.getNota());
			ps.setInt(5, notas.getFaltas());
			ps.setInt(6, notas.getRgm());
			ps.executeUpdate();
			
		}catch(Exception e) {
			throw new Exception("Erro ao alterar" + e.getMessage());
		}
		
	}
	
	public void excluir(int rgm) throws Exception {
		try {
			String sql = "DELETE FROM ALUNO WHERE RGM=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, rgm);
			ps.executeUpdate();
			
			String sql2 = "DELETE FROM CURSO WHERE RGM=?";
			ps = conn.prepareStatement(sql2);
			ps.setInt(1, rgm);
			ps.executeUpdate();
			
			String sql3 = "DELETE FROM NOTASFALTAS WHERE RGM=?";
			ps = conn.prepareStatement(sql3);
			ps.setInt(1, rgm);
			ps.executeUpdate();
			
		}catch(Exception e) {
			throw new Exception("Erro ao excluir" + e.getMessage());
		}
		
	}
	
	public void excluirNotas(int rgm) throws Exception {
		try {
			String sql = "DELETE FROM NOTASFALTAS WHERE RGM=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, rgm);
			ps.executeUpdate();
			
		}catch(Exception e) {
			throw new Exception("Erro ao excluir" + e.getMessage());
		}
		
	}
	
	
	public List listarTodos(int rgm) throws Exception {
		List<Boletim> lista = new ArrayList<Boletim>(); // alterei aqui para testar, mudar dps para adicionar no boletim
		try{
			String sql = "SELECT ALN.NOME_ALUNO, NF.NOME_CURSO, NF.DISCIPLINA, NF.NOTA, NF.FALTAS "
					+ "FROM MVC.ALUNO ALN "
					+ "JOIN MVC.NOTASFALTAS NF ON ALN.RGM = NF.RGM " + "WHERE NF.RGM=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, rgm);
			rs = ps.executeQuery();
			while(rs.next()) {
				String nomeAluno = rs.getString("NOME_ALUNO");
				String nomeCurso = rs.getString("NOME_CURSO");
				String disciplina = rs.getString("DISCIPLINA");
				double nota = rs.getDouble("NOTA");
				int faltas = rs.getInt("FALTAS");
				
				boletim = new Boletim(rgm, nomeAluno, nomeCurso, disciplina, nota, faltas);
				lista.add(boletim);
			}
			//JOptionPane.showMessageDialog(null, lista);
			return lista;
		}catch(Exception e) {
			throw new Exception("Erro ao listar"+ e.getMessage());
		}
		
	}
	
	public Aluno consultar(int rgm) throws Exception {
		try {
			String sql = "SELECT * FROM ALUNO WHERE RGM = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, rgm);
			rs = ps.executeQuery();
			if(rs.next()) {
				String nome = rs.getString("NOME_ALUNO");
				String dataNasc = rs.getString("DATA_NASCIMENTO");
				String cpf = rs.getString("CPF");
				String email = rs.getString("EMAIL");
				String endereco = rs.getString("ENDERECO");
				String municipio = rs.getString("MUNICIPIO");
				String uf = rs.getString("UF");
				String celular = rs.getString("CELULAR");
				aluno = new Aluno(rgm, nome, dataNasc, cpf, email, endereco, municipio, uf, celular);
			}
			
		}catch(Exception e) {
			throw new Exception("Erro ao consultar" + e.getMessage());
		}
		return aluno;
		
	}
	
	public Curso consultarCurso(int rgm) throws Exception {
		try {
			String sql2 = "SELECT * FROM CURSO WHERE RGM = ?";
			ps = conn.prepareStatement(sql2);
			ps.setInt(1, rgm);
			rs = ps.executeQuery();
			if(rs.next()) {
				String nomeCurso = rs.getString("NOME_CURSO");
				String campus = rs.getString("CAMPUS");
				String periodo = rs.getString("PERIODO");
				curso = new Curso(rgm, nomeCurso, campus, periodo);
			}
		}catch(Exception e) {
			throw new Exception("Erro ao consultar" + e.getMessage());
		}
		return curso;
		
	}
	
}
