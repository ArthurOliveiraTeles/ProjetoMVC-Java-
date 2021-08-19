package br.com.cadastro.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.com.cadastro.dao.AlunoDAO;
import br.com.cadastro.model.Aluno;
import br.com.cadastro.model.Boletim;
import br.com.cadastro.model.Curso;
import br.com.cadastro.model.NotasFaltas;
import java.awt.TextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private MaskFormatter campoData;
	private JTabbedPane tabbedPane;
	private JLabel lblRgm;
	private JTextField txtRgm;
	private JLabel lblNome;
	private JTextField txtNome;
	private JLabel lblDataDeNascimento;
	private JFormattedTextField formatDataTeste;
	private JLabel lblCpf;
	private JFormattedTextField formatCpf;
	private JLabel lblEmail;
	private JTextField txtEmail;
	private JLabel lblEndereco;
	private JTextField txtEndereco;
	private JLabel lblMunicpio;
	private JTextField txtMunicipio;
	private JLabel lblUf;
	private JComboBox cmbUf;
	private JLabel lblCelular;
	private JFormattedTextField formatCelular;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblCurso;
	private JComboBox cmbCurso;
	private JLabel lblCampus;
	private JComboBox cmbCampus;
	private JLabel lblPerodo;
	private JRadioButton rdbMatutino;
	private JRadioButton rdbVespertino;
	private JRadioButton rdbNoturno;
	private final ButtonGroup btgPeriodo = new ButtonGroup();
	private JButton btnNovo;
	private JButton btnSalvar;
	private JButton btnConsultar;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private Aluno aluno;
	private Curso curso;
	private NotasFaltas notas;
	private AlunoDAO dao;
	private JPanel panel_2;
	private JLabel lblNewLabel;
	private JTextField txtRGM2;
	private JTextField txtnomeAluno;
	private JTextField txtCursoAluno;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JComboBox cmbNota;
	private JComboBox cmbSemestre;
	private JComboBox cmbDisciplina;
	private JTextField txtFaltas;
	private JButton btnSalvar2;
	private JButton btnConsultar2;
	private JButton btnAlterar2;
	private JButton btnExcluir2;
	private JButton btnNovo2;
	private JPanel panel_3;
	private JLabel lblBoletimdoaluno;
	private JButton btnListar;
	private JTextField txtRgm3;
	private JLabel lblRgmDoAluno;
	private TextArea txtAreaBoletim;
	private JButton btnNovo3;
	private JMenuBar menuBar;
	private JMenu mnAluno;
	private JMenuItem mntmSalvar;
	private JMenu mnNotasEFaltas;
	private JMenu mnAjuda;
	private JMenuItem mntmAlterar;
	private JMenuItem mntmConsultar;
	private JMenuItem mntmSair;
	private JSeparator separator;
	private JMenuItem mntmSalvar_1;
	private JMenuItem mntmAlterar_1;
	private JMenuItem mntmExcluir;
	private JMenuItem mntmConsultar_1;
	private JMenuItem mntmSobre;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JMenuItem mntmExcluir_1;
	
	private void formatarCampo() {
		try {
			MaskFormatter mask = new MaskFormatter("##/##/####");
			mask.install(formatDataTeste);
		} catch (ParseException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao formatar");
		}
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() throws Exception{
		
		formatarCampo();
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.GRAY);
		tabbedPane.setBounds(21, 34, 607, 344);
		contentPane.add(tabbedPane);
		
		panel = new JPanel();
		tabbedPane.addTab("Dados Pessoais", null, panel, null);
		panel.setLayout(null);
		
		lblRgm = new JLabel("RGM");
		lblRgm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRgm.setBounds(10, 11, 100, 34);
		panel.add(lblRgm);
		
		txtRgm = new JTextField();
		txtRgm.setFont(new Font("Dialog", Font.PLAIN, 18));
		txtRgm.setColumns(10);
		txtRgm.setBounds(70, 14, 150, 35);
		panel.add(txtRgm);
		
		lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNome.setBounds(244, 11, 100, 34);
		panel.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Dialog", Font.PLAIN, 18));
		txtNome.setColumns(10);
		txtNome.setBounds(308, 14, 269, 35);
		panel.add(txtNome);
		
		lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDataDeNascimento.setBounds(10, 70, 185, 34);
		panel.add(lblDataDeNascimento);
		
		formatDataTeste = new JFormattedTextField(new MaskFormatter("##/##/####"));
		formatDataTeste.setFont(new Font("Dialog", Font.PLAIN, 18));
		formatDataTeste.setToolTipText("");
		formatDataTeste.setBounds(187, 75, 111, 30);
		panel.add(formatDataTeste);
		
		lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCpf.setBounds(308, 70, 70, 34);
		panel.add(lblCpf);
		
		formatCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		formatCpf.setFont(new Font("Dialog", Font.PLAIN, 18));
		formatCpf.setToolTipText("");
		formatCpf.setBounds(361, 75, 216, 30);
		panel.add(formatCpf);
		
		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmail.setBounds(10, 140, 70, 34);
		panel.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Dialog", Font.PLAIN, 18));
		txtEmail.setColumns(10);
		txtEmail.setBounds(70, 140, 507, 35);
		panel.add(txtEmail);
		
		lblEndereco = new JLabel("End.");
		lblEndereco.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEndereco.setBounds(10, 205, 70, 34);
		panel.add(lblEndereco);
		
		txtEndereco = new JTextField();
		txtEndereco.setFont(new Font("Dialog", Font.PLAIN, 18));
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(70, 205, 507, 35);
		panel.add(txtEndereco);
		
		lblMunicpio = new JLabel("Munic\u00EDpio");
		lblMunicpio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMunicpio.setBounds(10, 268, 89, 34);
		panel.add(lblMunicpio);
		
		txtMunicipio = new JTextField();
		txtMunicipio.setFont(new Font("Dialog", Font.PLAIN, 18));
		txtMunicipio.setColumns(10);
		txtMunicipio.setBounds(97, 271, 150, 35);
		panel.add(txtMunicipio);
		
		lblUf = new JLabel("UF");
		lblUf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUf.setBounds(257, 268, 41, 34);
		panel.add(lblUf);
		
		cmbUf = new JComboBox();
		cmbUf.setModel(new DefaultComboBoxModel(new String[] {"SP", "RJ", "MG", "SC"}));
		cmbUf.setFont(new Font("Dialog", Font.PLAIN, 18));
		cmbUf.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		cmbUf.setBounds(286, 273, 70, 26);
		panel.add(cmbUf);
		
		lblCelular = new JLabel("Celular");
		lblCelular.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCelular.setBounds(361, 268, 55, 34);
		panel.add(lblCelular);
		
		formatCelular = new JFormattedTextField(new MaskFormatter("##.####.####"));
		formatCelular.setFont(new Font("Dialog", Font.PLAIN, 18));
		formatCelular.setToolTipText("");
		formatCelular.setBounds(422, 273, 155, 30);
		panel.add(formatCelular);
		
		panel_1 = new JPanel();
		tabbedPane.addTab("Curso", null, panel_1, null);
		panel_1.setLayout(null);
		
		lblCurso = new JLabel("Curso");
		lblCurso.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCurso.setBounds(10, 21, 67, 27);
		panel_1.add(lblCurso);
		
		cmbCurso = new JComboBox();
		cmbCurso.setBackground(Color.WHITE);
		cmbCurso.setBorder(UIManager.getBorder("OptionPane.messageAreaBorder"));
		cmbCurso.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cmbCurso.setModel(new DefaultComboBoxModel(new String[] {"Selecione o curso...", "Analise e Desenvolvimento de Sistemas", "Engenharia de Software", "Ci\u00EAncia da Computa\u00E7\u00E3o"}));
		cmbCurso.setBounds(106, 19, 460, 36);
		panel_1.add(cmbCurso);
		
		lblCampus = new JLabel("Campus");
		lblCampus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCampus.setBounds(10, 91, 67, 27);
		panel_1.add(lblCampus);
		
		cmbCampus = new JComboBox();
		cmbCampus.setModel(new DefaultComboBoxModel(new String[] {"Selecione o campus...", "Tatuap\u00E9"}));
		cmbCampus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cmbCampus.setBorder(UIManager.getBorder("OptionPane.messageAreaBorder"));
		cmbCampus.setBackground(Color.WHITE);
		cmbCampus.setBounds(106, 86, 460, 36);
		panel_1.add(cmbCampus);
		
		lblPerodo = new JLabel("Per\u00EDodo");
		lblPerodo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPerodo.setBounds(10, 158, 67, 27);
		panel_1.add(lblPerodo);
		
		rdbMatutino = new JRadioButton("Matutino");
		btgPeriodo.add(rdbMatutino);
		rdbMatutino.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbMatutino.setBounds(106, 162, 109, 23);
		panel_1.add(rdbMatutino);
		
		rdbVespertino = new JRadioButton("Vespertino");
		btgPeriodo.add(rdbVespertino);
		rdbVespertino.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbVespertino.setBounds(265, 162, 109, 23);
		panel_1.add(rdbVespertino);
		
		rdbNoturno = new JRadioButton("Noturno");
		btgPeriodo.add(rdbNoturno);
		rdbNoturno.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbNoturno.setBounds(435, 162, 109, 23);
		panel_1.add(rdbNoturno);
		
		btnNovo = new JButton("");
		btnNovo.setIcon(new ImageIcon("D:\\Downloads\\icons8-novo-arquivo-52.png"));
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ======================
				txtRgm.setText(null);
				txtNome.setText(null);
				formatDataTeste.setText(null);
				formatCpf.setText(null);
				txtEmail.setText(null);
				txtEndereco.setText(null);
				txtMunicipio.setText(null);
				cmbUf.setSelectedIndex(0);
				formatCelular.setText(null);
				cmbCurso.setSelectedIndex(0);
				cmbCampus.setSelectedIndex(0);
				btgPeriodo.clearSelection();
				// ======================
			}
		});
		btnNovo.setFont(new Font("Tahoma", Font.PLAIN, 6));
		btnNovo.setBounds(20, 228, 93, 65);
		panel_1.add(btnNovo);
		
		btnSalvar = new JButton("");
		btnSalvar.setIcon(new ImageIcon("D:\\Downloads\\icons8-salvar-52.png"));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ======================
				try {
					if(cmbCurso.getSelectedIndex() == 0) {
						JOptionPane.showMessageDialog(null, "Você deve selecionar o curso! Cadastre novamente.");
						System.exit(0); // sai do sistema
					}
					
					if(cmbCampus.getSelectedIndex() == 0) {
						JOptionPane.showMessageDialog(null, "Você deve selecionar o campus! Cadastre novamente.");
						System.exit(0); // sai do sistema
					}
					
					// formatar os meus campos JFormattedText
					String dataNasc = formatDataTeste.getText();
					dataNasc = dataNasc.replaceAll("/", ".");
					
					String cpf = formatCpf.getText();
					cpf = cpf.replaceAll("\\.", ""); // o Java interpreta o '.' como expressão regular (regex)
					cpf = cpf.replaceAll("-", "");
					
					String celular = formatCelular.getText();
					celular = celular.replaceAll("\\.", ""); // e para ele não interpretar desse modo, usamos as "\\"
					
					// criei o objeto aluno para pegar os dados da interface gráfica
					aluno = new Aluno();
					aluno.setRgm(Integer.parseInt(txtRgm.getText()));
					aluno.setNome(txtNome.getText());
					aluno.setDataNasc(dataNasc);
					aluno.setCpf(cpf);
					aluno.setEmail(txtEmail.getText());
					aluno.setEndereco(txtEndereco.getText());
					aluno.setMunicipio(txtMunicipio.getText());
					aluno.setUf((String) cmbUf.getSelectedItem());
					aluno.setCelular(celular);
					
					// criei o objeto curso para pegar os dados do curso
					curso = new Curso();
					curso.setRgm(Integer.parseInt(txtRgm.getText()));
					
					String nomeCurso = (String) cmbCurso.getSelectedItem();
					String nomeCampus = (String) cmbCampus.getSelectedItem();
					String periodo = null;
					
					if(rdbMatutino.isSelected()) {
						periodo = "M"; // Matutino
					}
					
					if(rdbVespertino.isSelected()) {
						periodo = "V"; // Vespertino
					}
					
					if(rdbNoturno.isSelected()) {
						periodo = "N"; // Noturno
					}
					
					curso.setNomeCurso(nomeCurso);
					curso.setCampus(nomeCampus);
					curso.setPeriodo(periodo);
					
					// abrir a conexão
					dao = new AlunoDAO();
					// salvar
					dao.salvar(aluno, curso);
					JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
				}catch(Exception error) {
					error.printStackTrace();
					JOptionPane.showMessageDialog(null, "Erro ao salvar, verifique os campos!");
				}
				
				// ======================
			}
		});
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSalvar.setBounds(135, 228, 95, 65);
		panel_1.add(btnSalvar);
		
		btnConsultar = new JButton(""); // Consultar
		btnConsultar.setIcon(new ImageIcon("D:\\Downloads\\icons8-search-account-52.png"));
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dao = new AlunoDAO();
					int rgm = Integer.parseInt(txtRgm.getText());
					aluno = dao.consultar(rgm);
					curso = dao.consultarCurso(rgm);
					
					// ==================
					
					txtRGM2.setText(String.valueOf(rgm));
					txtnomeAluno.setText(aluno.getNome());
					txtCursoAluno.setText(curso.getNomeCurso());
					
					
					// ==================
					
					JOptionPane.showMessageDialog(null, "Consulta feita com sucesso. Verifique na página 'Notas e Faltas'!");
				}catch(Exception error) {
					error.printStackTrace();
					JOptionPane.showMessageDialog(null, "Erro ao consultar...");
				}
			}
		});
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConsultar.setBounds(253, 228, 94, 65);
		panel_1.add(btnConsultar);
		
		btnAlterar = new JButton("");
		btnAlterar.setIcon(new ImageIcon("D:\\Downloads\\icons8-alterar-52.png"));
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// formatar os meus campos JFormattedText
					String dataNasc = formatDataTeste.getText();
					dataNasc = dataNasc.replaceAll("/", ".");
					
					String cpf = formatCpf.getText();
					cpf = cpf.replaceAll("\\.", ""); // o Java interpreta o '.' como expressão regular (regex)
					cpf = cpf.replaceAll("-", "");
					
					String celular = formatCelular.getText();
					celular = celular.replaceAll("\\.", ""); // e para ele não interpretar desse modo, usamos as "\\"
					
					// criei o objeto aluno para pegar os dados da interface gráfica
					aluno = new Aluno();
					aluno.setRgm(Integer.parseInt(txtRgm.getText()));
					aluno.setNome(txtNome.getText());
					aluno.setDataNasc(dataNasc);
					aluno.setCpf(cpf);
					aluno.setEmail(txtEmail.getText());
					aluno.setEndereco(txtEndereco.getText());
					aluno.setMunicipio(txtMunicipio.getText());
					aluno.setUf((String) cmbUf.getSelectedItem());
					aluno.setCelular(celular);
					
					// criei o objeto curso para pegar os dados do curso
					curso = new Curso();
					curso.setRgm(Integer.parseInt(txtRgm.getText()));
					
					String nomeCurso = (String) cmbCurso.getSelectedItem();
					String nomeCampus = (String) cmbCampus.getSelectedItem();
					String periodo = null;
					
					if(rdbMatutino.isSelected()) {
						periodo = "M"; // Matutino
					}
					
					if(rdbVespertino.isSelected()) {
						periodo = "V"; // Vespertino
					}
					
					if(rdbNoturno.isSelected()) {
						periodo = "N"; // Noturno
					}
					
					curso.setNomeCurso(nomeCurso);
					curso.setCampus(nomeCampus);
					curso.setPeriodo(periodo);
					
					// abrir a conexão
					dao = new AlunoDAO();
					// salvar
					dao.alterar(aluno, curso);
					JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
				}catch(Exception error) {
					error.printStackTrace();
					JOptionPane.showMessageDialog(null, "Erro ao alterar, verifique os campos!");
				}
			}
		});
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAlterar.setBounds(367, 228, 85, 65);
		panel_1.add(btnAlterar);
		
		btnExcluir = new JButton("");
		btnExcluir.setIcon(new ImageIcon("D:\\Downloads\\icons8-excluir-52.png"));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dao = new AlunoDAO();
					int rgm = Integer.parseInt(txtRgm.getText());
					dao.excluir(rgm);
					JOptionPane.showMessageDialog(null, "Dados excluídos com sucesso!");
				}catch(Exception error) {
					JOptionPane.showMessageDialog(null, "Erro ao excluir");
				}
			}
		});
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnExcluir.setBounds(478, 227, 94, 66);
		panel_1.add(btnExcluir);
		
		panel_2 = new JPanel();
		tabbedPane.addTab("Notas e Faltas", null, panel_2, null);
		panel_2.setLayout(null);
		
		lblNewLabel = new JLabel("RGM");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 23, 46, 14);
		panel_2.add(lblNewLabel);
		
		txtRGM2 = new JTextField();
		/*txtRGM2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int verificaRGM = Integer.parseInt(txtRGM2.getText()); 
				if(verificaRGM == aluno.getRgm()) {
					try {
						dao = new AlunoDAO();
						aluno = dao.consultar(verificaRGM);
						

						txtnomeAluno.setText(aluno.getNome());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});*/
		
		txtRGM2.setBounds(86, 23, 174, 20);
		panel_2.add(txtRGM2);
		txtRGM2.setColumns(10);
		
		txtnomeAluno = new JTextField();
		txtnomeAluno.setBounds(280, 23, 312, 20);
		panel_2.add(txtnomeAluno);
		txtnomeAluno.setColumns(10);
		
		txtCursoAluno = new JTextField();
		txtCursoAluno.setBounds(10, 54, 582, 20);
		panel_2.add(txtCursoAluno);
		txtCursoAluno.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Disciplina");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 116, 94, 14);
		panel_2.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Semestre");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(10, 182, 94, 14);
		panel_2.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Nota");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(217, 182, 61, 14);
		panel_2.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Faltas");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(398, 182, 46, 14);
		panel_2.add(lblNewLabel_4);
		
		cmbNota = new JComboBox();
		cmbNota.setModel(new DefaultComboBoxModel(new String[] {"0", "0.5", "1.0", "1.5", "2.0", "2.5", "3.0", "3.5", "4.0", "4.5", "5.0", "5.5", "6.0", "6.5", "7.0", "7.5", "8.0", "8.5", "9.0", "9.5", "10.0"}));
		cmbNota.setBounds(288, 181, 61, 22);
		panel_2.add(cmbNota);
		
		cmbSemestre = new JComboBox();
		cmbSemestre.setModel(new DefaultComboBoxModel(new String[] {"2021-1", "2021-2"}));
		cmbSemestre.setBounds(101, 181, 93, 22);
		panel_2.add(cmbSemestre);
		
		cmbDisciplina = new JComboBox();
		cmbDisciplina.setModel(new DefaultComboBoxModel(new String[] {"Selecione a disciplina", "Programa\u00E7\u00E3o Orientada a Objetos", "Modelagem de Dados", "Engenharia de Requisitos", "T\u00E9cnicas de Programa\u00E7\u00E3o"}));
		cmbDisciplina.setBounds(114, 115, 478, 22);
		panel_2.add(cmbDisciplina);
		
		txtFaltas = new JTextField();
		txtFaltas.setBounds(474, 182, 118, 20);
		panel_2.add(txtFaltas);
		txtFaltas.setColumns(10);
		
		btnSalvar2 = new JButton("");
		btnSalvar2.setIcon(new ImageIcon("D:\\Downloads\\icons8-salvar-52.png"));
		btnSalvar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if((cmbDisciplina.getSelectedIndex() == 0) || (txtFaltas.getText() == null)) {
					JOptionPane.showMessageDialog(null, "Você deve selecionar a disciplina!");
					} else {
						notas = new NotasFaltas();
						notas.setRgm(Integer.parseInt(txtRGM2.getText()));
						notas.setNomeCurso(txtCursoAluno.getText());
						notas.setDisciplina((String) cmbDisciplina.getSelectedItem());
						notas.setSemestre((String) cmbSemestre.getSelectedItem());
						notas.setNota(Double.parseDouble((String) cmbNota.getSelectedItem()));
						notas.setFaltas(Integer.parseInt(txtFaltas.getText()));
					
						// abrir a conexão
						dao = new AlunoDAO();
						// salvar
						dao.salvarNotas(notas);
						JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
					}
				} catch(Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Erro ao salvar, verifique os campos!");
				}
			}
		});
		btnSalvar2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSalvar2.setBounds(144, 223, 83, 68);
		panel_2.add(btnSalvar2);
		
		btnConsultar2 = new JButton("");
		btnConsultar2.setIcon(new ImageIcon("D:\\Downloads\\icons8-search-account-52.png"));
		btnConsultar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Botão 2 Consultar
				try {
					dao = new AlunoDAO();
					int rgm = Integer.parseInt(txtRGM2.getText());
					aluno = dao.consultar(rgm);
					curso = dao.consultarCurso(rgm);
					
					txtnomeAluno.setText(aluno.getNome());
					txtCursoAluno.setText(curso.getNomeCurso());
				
					
					
					// ==================
					
					JOptionPane.showMessageDialog(null, "Consulta feita com sucesso.");
				}catch(Exception error) {
					error.printStackTrace();
					JOptionPane.showMessageDialog(null, "Erro ao consultar...");
				}
			}
			}
		);
		btnConsultar2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConsultar2.setBounds(256, 224, 87, 67);
		panel_2.add(btnConsultar2);
		
		btnAlterar2 = new JButton("");
		btnAlterar2.setIcon(new ImageIcon("D:\\Downloads\\icons8-alterar-52.png"));
		btnAlterar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Botão Alterar 2
				try {
					if((cmbDisciplina.getSelectedIndex() == 0) || (txtFaltas.getText() == null)) {
					JOptionPane.showMessageDialog(null, "Você deve selecionar a disciplina!");
					} else {
						notas = new NotasFaltas();
						notas.setRgm(Integer.parseInt(txtRGM2.getText()));
						notas.setNomeCurso(txtCursoAluno.getText());
						notas.setDisciplina((String) cmbDisciplina.getSelectedItem());
						notas.setSemestre((String) cmbSemestre.getSelectedItem());
						notas.setNota(Double.parseDouble((String) cmbNota.getSelectedItem()));
						notas.setFaltas(Integer.parseInt(txtFaltas.getText()));
					
						// abrir a conexão
						dao = new AlunoDAO();
						// salvar
						dao.alterarNotas(notas);
						JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
					}
				} catch(Exception error) {
					error.printStackTrace();
					JOptionPane.showMessageDialog(null, "Erro ao Alterar, verifique os campos!");
				}
			}
		});
		btnAlterar2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAlterar2.setBounds(369, 224, 80, 67);
		panel_2.add(btnAlterar2);
		
		btnExcluir2 = new JButton("");
		btnExcluir2.setIcon(new ImageIcon("D:\\Downloads\\icons8-excluir-52.png"));
		btnExcluir2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					dao = new AlunoDAO();
					int rgm = Integer.parseInt(txtRGM2.getText());
					dao.excluirNotas(rgm);
					JOptionPane.showMessageDialog(null, "Dados excluídos com sucesso!");
				}catch(Exception error) {
					JOptionPane.showMessageDialog(null, "Erro ao excluir");
				}
			}
			}
		);
		btnExcluir2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnExcluir2.setBounds(482, 225, 85, 66);
		panel_2.add(btnExcluir2);
		
		btnNovo2 = new JButton("");
		btnNovo2.setIcon(new ImageIcon("D:\\Downloads\\icons8-novo-arquivo-52.png"));
		btnNovo2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtRGM2.setText(null);
				txtnomeAluno.setText(null);
				txtCursoAluno.setText(null);
				txtFaltas.setText(null);
				cmbDisciplina.setSelectedIndex(0);
				cmbSemestre.setSelectedIndex(0);
				cmbNota.setSelectedIndex(0);
				
			}
		});
		btnNovo2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNovo2.setBounds(28, 223, 85, 68);
		panel_2.add(btnNovo2);
		
		panel_3 = new JPanel();
		tabbedPane.addTab("Boletim", null, panel_3, null);
		panel_3.setLayout(null);
		
		lblBoletimdoaluno = new JLabel("Boletim do Aluno");
		lblBoletimdoaluno.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBoletimdoaluno.setBounds(234, 11, 179, 14);
		panel_3.add(lblBoletimdoaluno);
		
		btnListar = new JButton("");
		btnListar.setIcon(new ImageIcon("D:\\Downloads\\icons8-lista-52.png"));
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int rgm = 0; // usei o 0 para inicializar a variável
					if(txtRgm3.getText() != "") {
						rgm = Integer.parseInt(txtRgm3.getText());
					}
					// Criando uma lista
					List<Boletim> lista = new ArrayList<Boletim>();
					
					// Abrir conexão com AlunoDAO
					dao = new AlunoDAO();
					lista = dao.listarTodos(rgm);
					
					txtAreaBoletim.setText("");
					txtAreaBoletim.append("\n");
					
					String tabulation = "\t\t";
					
					for(Boletim boletim: lista) {
						txtAreaBoletim.append("Nome.............. "+ boletim.getNome() + "\n");
						txtAreaBoletim.append("Curso............." + boletim.getCurso() + "\n");
						txtAreaBoletim.append("Disciplina........" + boletim.getDisciplina() + "\n");
						txtAreaBoletim.append("Nota.............." + boletim.getNota() + "\n");
						txtAreaBoletim.append("Faltas............" + boletim.getFaltas() + "\n\n");
				
					}
					
				} catch(Exception error) {
					error.printStackTrace();
					JOptionPane.showMessageDialog(null, "Erro ao listar, verifique o RGM!");
				}
			}
			}
		);
		btnListar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnListar.setBounds(492, 252, 93, 53);
		panel_3.add(btnListar);
		
		txtRgm3 = new JTextField();
		txtRgm3.setBounds(140, 42, 179, 22);
		panel_3.add(txtRgm3);
		txtRgm3.setColumns(10);
		
		lblRgmDoAluno = new JLabel("RGM do Aluno:");
		lblRgmDoAluno.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRgmDoAluno.setBounds(10, 43, 120, 14);
		panel_3.add(lblRgmDoAluno);
		
		txtAreaBoletim = new TextArea();
		txtAreaBoletim.setText("                  Para visualizar os dados voc\u00EA deve clicar no bot\u00E3o para listar!");
		txtAreaBoletim.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtAreaBoletim.setBounds(10, 70, 582, 174);
		panel_3.add(txtAreaBoletim);
		
		btnNovo3 = new JButton("");
		btnNovo3.setIcon(new ImageIcon("D:\\Downloads\\icons8-novo-arquivo-52.png"));
		btnNovo3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Botão "novo" do boletim
				
				txtAreaBoletim.setText("");
			}
		});
		btnNovo3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNovo3.setBounds(20, 251, 83, 54);
		panel_3.add(btnNovo3);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(10, 2, 250, 21);
		contentPane.add(menuBar);
		
		mnAluno = new JMenu("Aluno");
		menuBar.add(mnAluno);
		
		mntmSalvar = new JMenuItem("Salvar");
		mntmSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSalvar.doClick();
			}
		});
		mntmSalvar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnAluno.add(mntmSalvar);
		
		mntmAlterar = new JMenuItem("Alterar");
		mntmAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAlterar.doClick();
			}
		});
		mnAluno.add(mntmAlterar);
		
		mntmConsultar = new JMenuItem("Consultar");
		mntmConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnConsultar.doClick();
			}
		});
		mnAluno.add(mntmConsultar);
		
		mntmSair = new JMenuItem("Sair");
		mntmSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.SHIFT_MASK));
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
		
		separator = new JSeparator();
		mnAluno.add(separator);
		
		mntmExcluir_1 = new JMenuItem("Excluir");
		mntmExcluir_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnExcluir.doClick();
			}
		});
		mnAluno.add(mntmExcluir_1);
		mnAluno.add(mntmSair);
		
		mnNotasEFaltas = new JMenu("Notas e Faltas");
		menuBar.add(mnNotasEFaltas);
		
		mntmSalvar_1 = new JMenuItem("Salvar");
		mntmSalvar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSalvar2.doClick();
			}
		});
		mnNotasEFaltas.add(mntmSalvar_1);
		
		mntmAlterar_1 = new JMenuItem("Alterar");
		mntmAlterar_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mntmAlterar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAlterar2.doClick();
			}
		});
		mnNotasEFaltas.add(mntmAlterar_1);
		
		mntmExcluir = new JMenuItem("Excluir");
		mntmExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnExcluir2.doClick();
			}
		});
		mnNotasEFaltas.add(mntmExcluir);
		
		mntmConsultar_1 = new JMenuItem("Consultar");
		mntmConsultar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnConsultar2.doClick();
			}
		});
		mnNotasEFaltas.add(mntmConsultar_1);
		
		mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);
		
		mntmSobre = new JMenuItem("Sobre");
		mntmSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Aplicativo de cadastro, consulta e armazenamento de Aluno - MVC");
			}
		});
		mnAjuda.add(mntmSobre);
		
	}
}
