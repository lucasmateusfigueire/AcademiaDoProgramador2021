package VIEW;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.UsuarioDAO;
import DTO.UsuarioDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class formularioLoginView extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeUsuario;
	private JPasswordField txtSenhaUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					formularioLoginView frame = new formularioLoginView();
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
	public formularioLoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 389);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome de Usu\u00E1rio");
		lblNewLabel.setBounds(117, 57, 103, 14);
		contentPane.add(lblNewLabel);
		
		txtNomeUsuario = new JTextField();
		txtNomeUsuario.setBounds(117, 82, 147, 20);
		contentPane.add(txtNomeUsuario);
		txtNomeUsuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Senha de Usu\u00E1rio");
		lblNewLabel_1.setBounds(117, 124, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				Logar();
				
			}
		});
		btnLogin.setBounds(117, 201, 70, 23);
		contentPane.add(btnLogin);
		
		txtSenhaUsuario = new JPasswordField();
		txtSenhaUsuario.setBounds(117, 149, 147, 20);
		contentPane.add(txtSenhaUsuario);
	}
	
	private void Logar(){
	
		try {
			String nome_usuario, senha_usuario;
			
			nome_usuario = txtNomeUsuario.getText();
			senha_usuario = txtSenhaUsuario.getText();
			
			UsuarioDTO objusuariodto = new UsuarioDTO();
			objusuariodto.setNome_usuario(nome_usuario);
			objusuariodto.setSenha_usuario(senha_usuario);
			
			UsuarioDAO objuariodao = new UsuarioDAO();
			ResultSet rsusuariodao = objuariodao.autenticacaoUsuario(objusuariodto);
			
		    if (rsusuariodao.next()) {
		    	
		    	//chamar tela que eu quero abrir
		    	formularioPrincipalView objfrmprincipalview = new formularioPrincipalView();
		    	objfrmprincipalview.setVisible(true);
		    	
		    	dispose();
		    	
		    	
				
			} else {				
				//enviar mensagem dizendo incorreto
			    JOptionPane.showMessageDialog(null, "Usuario ou Senha inválida.");

			}
			
			
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "FormularioLoginView" +  erro);
		}
			
			
		
	}
}
