package br.com.fiap.beans;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TelaLogin extends JFrame implements ActionListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String loginPadrao = "admin", senhaPadrao = "admin";
	private JTextField lblLogin, lblSenha;
	private JButton lblEntrar, lblCadastrar, lblListarUsuarios;
	// private ImageIcon imagem = new ImageIcon(getClass().getResource("logo.png"));
	// private JLabel lblLogo = new JLabel(imagem);

	private ImageIcon imagem = new ImageIcon(getClass().getResource("..//Imagens//logo8150.png"));
	private JLabel lblLogo = new JLabel(imagem);

	private ArrayList<Usuario> usuarios = new ArrayList<>();

	public TelaLogin() {
		setTitle("InovaAcess - Login");
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);

		lblLogin = new JTextField();
		lblLogin.setText("Digite seu email:");
		lblLogin.setBounds(100, 100, 300, 50);

		lblSenha = new JTextField();
		lblSenha.setText("Digite sua senha:");
		lblSenha.setBounds(100, 170, 300, 50);
		lblSenha.setVisible(true);

		lblEntrar = new JButton("Entrar");
		lblEntrar.setBounds(190, 250, 100, 50);
		lblEntrar.setVisible(true);

		lblEntrar.addActionListener(this); // coloca ação no botão no evento actionListener
		lblEntrar.setFont(new Font("Arial", Font.BOLD, 20));
		lblEntrar.setForeground(new Color(20, 20, 20));
		lblEntrar.setBackground(new Color(32, 198, 122));

		// botão cadastrar

		lblCadastrar = new JButton("Cadastro");
		lblCadastrar.setBounds(170, 330, 150, 50);
		lblCadastrar.setVisible(true);

		lblCadastrar.addActionListener(this); // coloca ação no botão no evento actionListener
		lblCadastrar.setFont(new Font("Arial", Font.BOLD, 20));
		lblCadastrar.setForeground(new Color(20, 20, 20));
		lblCadastrar.setBackground(new Color(32, 198, 122));

		// botão cadastrar

		lblListarUsuarios = new JButton("Listar");
		lblListarUsuarios.setBounds(170, 400, 150, 50);
		lblListarUsuarios.setVisible(true);

		lblListarUsuarios.addActionListener(this); // coloca ação no botão no evento actionListener
		lblListarUsuarios.setFont(new Font("Arial", Font.BOLD, 20));
		lblListarUsuarios.setForeground(new Color(20, 20, 20));
		lblListarUsuarios.setBackground(new Color(32, 198, 122));

		// tecla enteraqui faz a ação
		addKeyListener(this);

		// adc a logo na tela
		lblLogo.setVisible(true);
		lblLogo.setBounds(0, 10, 205, 170);

		// add(lblLogo);
		add(lblSenha);
		add(lblLogin);
		add(lblLogo);
		add(lblEntrar);
		add(lblCadastrar);
		add(lblListarUsuarios);
		validate();

	}

	public void abrirTela() {
		// abrir a tela
		Tela t = new Tela();
	}

	// crição cadastro
	public void criarCadastro() {

		Usuario usuario = new Usuario();

		String nome = JOptionPane.showInputDialog("Digite seu nome: ");
		String email = JOptionPane.showInputDialog("Digite um email: ");
		String senha = JOptionPane.showInputDialog("Digite uma senha: ");

		usuario.setNomeUsuario(nome);
		usuario.setEmailUsuario(email);
		usuario.setSenhaUsuario(senha);

		usuarios.add(usuario);

	}

	// pegar a lista de todos os usuarios
	public ArrayList<Usuario> listarUsuarios(ArrayList<Usuario> usuarios) {
		
		for (Usuario usuario : usuarios) {
			JOptionPane.showMessageDialog(null, "EMAIL: "+usuario.getEmailUsuario());
			JOptionPane.showMessageDialog(null, "NOME: "+usuario.getNomeUsuario());
			JOptionPane.showMessageDialog(null, "SENHA: "+usuario.getSenhaUsuario());
		}
		
		return usuarios;
	}

	// validarLogin
	public Tela validarLogin(String e, String s) {
		if (loginPadrao.equals(lblLogin.getText()) && senhaPadrao.equals(lblSenha.getText())) {
			abrirTela();
			setVisible(false);
		} else if (loginPadrao.isEmpty() && senhaPadrao.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Campos vazios, por favor preencha-os", "InovaAcess",
					JOptionPane.WARNING_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Login errado, Faça-o novamente.", "InovaAcess",
					JOptionPane.WARNING_MESSAGE);
		}
		return null;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == lblEntrar) {
			validarLogin(lblLogin.getText(), lblSenha.getText());
		}
		if (e.getSource() == lblCadastrar) {
			criarCadastro();
		}
		if (e.getSource() == lblListarUsuarios) {
			listarUsuarios(usuarios);
		}
	}

	// adicionar a função validarLogin quando clicar na teclaEnter

	private void KeyListener() {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		// quando aperta enter faz validação do login
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			validarLogin(lblLogin.getText(), lblSenha.getText());
		}

		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			// quando aperta esc sai do projeto
			System.exit(0);
		}
	}

}
