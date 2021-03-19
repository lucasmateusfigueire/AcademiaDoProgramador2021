package VIEW;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.ScrollPane;

import javax.swing.JScrollPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.EquipamentoDAO;
import DAO.ManutDAO;
import DTO.EquipamentoDTO;
import DTO.ManutDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.DropMode;
import java.awt.Font;
import java.awt.Dimension;


public class formularioManutencaoView extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtTitulo;
	private JTextField txtEquip;
	private JTextField txtData;
	DefaultTableModel model;
	private JTextField txtDescricao;
	private JTable tabelaManut;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					formularioManutencaoView frame = new formularioManutencaoView();
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
	public formularioManutencaoView() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 837, 597);
		contentPane = new JPanel();
		contentPane.setMaximumSize(new Dimension(2147483647, 2147483647));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel.setBounds(10, 52, 46, 14);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(10, 77, 120, 20);
		txtId.setColumns(10);
		
		
		JLabel lblNewLabel_1 = new JLabel("Titulo do Chamado");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(140, 52, 166, 14);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(140, 77, 629, 20);
		txtTitulo.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Descri\u00E7\u00E3o");
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(10, 108, 60, 14);
		
		JLabel lblNewLabel_3 = new JLabel("Nome do Equipamento");
		lblNewLabel_3.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(339, 108, 161, 14);
		
		txtEquip = new JTextField();
		txtEquip.setBounds(339, 133, 236, 20);
		txtEquip.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Data de Abertura");
		lblNewLabel_4.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_4.setBounds(339, 166, 130, 14);
		
		txtData = new JTextField();
		txtData.setBounds(338, 191, 143, 20);
		txtData.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (txtTitulo.getText().length() == 0 || txtData.getText().length() == 0 || txtEquip.getText().length() == 0){
					JOptionPane.showMessageDialog(null, "Faltou preencher algum dado.");
				}
				else {
					cadastrarManut();
				}
				
			}
		});
		btnCadastrar.setBounds(585, 128, 114, 29);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarValoresManut();
			}
		});
		btnPesquisar.setBounds(585, 186, 114, 29);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LimparCampos();
			}
		});
		btnLimpar.setBounds(709, 128, 104, 29);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (txtTitulo.getText().length() == 0 || txtData.getText().length() == 0 || txtEquip.getText().length() == 0){
					JOptionPane.showMessageDialog(null, "Não foi selecionado nenhum registro para excluir.");
				}
				else {
					ExcluirManut();
					ListarValoresManut();
					LimparCampos();
				}
				
				
			}
		});
		btnExcluir.setBounds(709, 186, 104, 29);
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		contentPane.add(txtId);
		contentPane.add(lblNewLabel_1);
		contentPane.add(txtTitulo);
		contentPane.add(lblNewLabel_2);
		contentPane.add(lblNewLabel_3);
		contentPane.add(txtEquip);
		contentPane.add(lblNewLabel_4);
		contentPane.add(txtData);
		contentPane.add(btnCadastrar);
		contentPane.add(btnPesquisar);
		contentPane.add(btnLimpar);
		contentPane.add(btnExcluir);
		
		
		JButton btnCarregar = new JButton("Carregar Campos");
		btnCarregar.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnCarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarregarCampos();
			}
		});
		btnCarregar.setBounds(176, 515, 199, 23);
		contentPane.add(btnCarregar);
		
		JButton btnAlterar = new JButton("Alterar Campos");
		btnAlterar.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (txtTitulo.getText().length() == 0 || txtData.getText().length() == 0 || txtEquip.getText().length() == 0){
					JOptionPane.showMessageDialog(null, "Carregue um registro primeiro para alterar..");
				}
				else {
					AlterarManut();
					ListarValoresManut();
					LimparCampos();
				}
				
				
			}
		});
		btnAlterar.setBounds(10, 515, 130, 23);
		contentPane.add(btnAlterar);
		
		JButton btnNewButton = new JButton("Sair");
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				formularioPrincipalView objfrmprincipalview = new formularioPrincipalView();
		    	objfrmprincipalview.setVisible(true);
		    	
		    	dispose();
			}
		});
		btnNewButton.setBounds(702, 515, 89, 23);
		contentPane.add(btnNewButton);
		
		txtDescricao = new JTextField();
		txtDescricao.setHorizontalAlignment(SwingConstants.LEFT);
		txtDescricao.setBounds(10, 133, 312, 79);
		contentPane.add(txtDescricao);
		txtDescricao.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Cadastro de Manuten\u00E7\u00F5es");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_5.setBounds(0, 0, 813, 37);
		contentPane.add(lblNewLabel_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 223, 801, 283);
		contentPane.add(scrollPane);
		
		tabelaManut = new JTable();
		scrollPane.setViewportView(tabelaManut);
		model = new DefaultTableModel();
		Object[] column = {"Id","Titulo","Equipamento","Data","Descrição"};
		Object[] row = new Object[0];
		model.setColumnIdentifiers(column);
		tabelaManut.setModel(model);
		tabelaManut.setBackground(Color.LIGHT_GRAY);
	}
	
	private void cadastrarManut() {
		
		String  titulo, descricao,nomeequip,data,dataf;
		
		titulo = txtTitulo.getText();
		descricao = txtDescricao.getText();
		nomeequip = txtEquip.getText();
	
		String dia = txtData.getText().substring(0,2);
        String mes = txtData.getText().substring(3,5);
        String ano = txtData.getText().substring(6);
        
        String dataFinal = ano+"-"+mes+"-"+ dia;
        
        ManutDTO manutDTO = new ManutDTO();
        manutDTO.setTitulo_manut(titulo);
        manutDTO.setDescricao_manut(descricao);
        manutDTO.setNomeequip_manut(nomeequip);
        manutDTO.setTitulo_manut(titulo);
        manutDTO.setData_manut(dataFinal);		
        
        ManutDAO manutDAO = new ManutDAO();
        manutDAO.cadastrarManutencao(manutDTO);
		ListarValoresManut();
		LimparCampos();
	}
	
	private void ListarValoresManut() {
		
		try {
		
		ManutDAO objmanutdao = new ManutDAO();
		model.setNumRows(0);
		ArrayList<ManutDTO> lista = objmanutdao.PesquisarManut();
		
			for(int num = 0; num < lista.size(); num++) {
			model.addRow(new Object[] {
				lista.get(num).getID_manut(),
				lista.get(num).getTitulo_manut(),	
				lista.get(num).getNomeequip_manut(),
				lista.get(num).getData_manut()
				});
			
			}
		
		} catch (Exception erro) {
		JOptionPane.showMessageDialog(null, "Listar valores View" + erro);
		}
		
	}
	
	
	private void CarregarCampos() {
		  
		  int setar = tabelaManut.getSelectedRow();
		  txtId.setText(tabelaManut.getModel().getValueAt(setar, 0).toString());
		  txtTitulo.setText(tabelaManut.getModel().getValueAt(setar, 1).toString());
		  txtEquip.setText(tabelaManut.getModel().getValueAt(setar, 2).toString());
		  txtData.setText(tabelaManut.getModel().getValueAt(setar, 3).toString());
		 
		  ManutDTO objmanutdto = new ManutDTO();
		  
		  objmanutdto.getDescricao_manut();  
		  
	  }
	
	
		private void AlterarManut() {
			
		  int idManut;
		  String tituloManut,descricaoManut,nomeequipManut,dataManut;
		  
		 
		  idManut = Integer.parseInt(txtId.getText());
		  tituloManut = txtTitulo.getText();
		  descricaoManut = txtDescricao.getText();
		  nomeequipManut = txtEquip.getText();
		  dataManut = txtData.getText();	  	  
		  
		  ManutDTO objmanutdto = new ManutDTO();
		  
		  objmanutdto.setID_manut(idManut);
		  objmanutdto.setTitulo_manut(tituloManut);
		  objmanutdto.setDescricao_manut(descricaoManut);
		  objmanutdto.setNomeequip_manut(nomeequipManut);
		  objmanutdto.setData_manut(dataManut);
		  
		  ManutDAO objmanutdao = new ManutDAO();
		  objmanutdao.alterarManut(objmanutdto);  
		  
	  }
	  
	  private void LimparCampos() {
		  
		  txtId.setText("");
		  txtTitulo.setText("");
		  txtDescricao.setText("");
		  txtEquip.setText("");
		  txtData.setText("");
		  txtTitulo.requestFocus();
		  
	  }
	  
	  
	  private void ExcluirManut() {
		  
		  int idManut;
		  
		  idManut = Integer.parseInt(txtId.getText());
		  ManutDTO objmanutdto = new ManutDTO();
		  objmanutdto.setID_manut(idManut);
		  
	
		  ManutDAO objmanutdao = new ManutDAO();
		  objmanutdao.excluirManut(objmanutdto);
		 
	  }
	
	
}
