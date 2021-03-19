package VIEW;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class formularioPrincipalView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					formularioPrincipalView frame = new formularioPrincipalView();
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
	public formularioPrincipalView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 577, 328);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sistema de Gerenciamento de Equipamentos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 561, 52);
		contentPane.add(lblNewLabel);
		
		JButton btnTelaEquipamentos = new JButton("Cadastrar Equipamentos");
		btnTelaEquipamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				formularioEquipamentosView2 objfrmequipamentosview = new formularioEquipamentosView2();
				objfrmequipamentosview.setVisible(true);
		    	
		    	dispose();
			}
		});
		btnTelaEquipamentos.setBounds(158, 89, 268, 23);
		contentPane.add(btnTelaEquipamentos);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		btnSair.setBounds(244, 224, 89, 23);
		contentPane.add(btnSair);
		
		JButton btnManut = new JButton("Cadastrar Pedidos de Manuten\u00E7\u00E3o");
		btnManut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				formularioManutencaoView objfrmmanutview = new formularioManutencaoView();
				objfrmmanutview.setVisible(true);
		    	
		    	dispose();
			}
		});
		btnManut.setBounds(158, 133, 268, 23);
		contentPane.add(btnManut);
	}
}
