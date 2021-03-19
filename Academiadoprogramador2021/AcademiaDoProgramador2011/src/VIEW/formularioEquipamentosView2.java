package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.EquipamentoDAO;
import DTO.EquipamentoDTO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.Font;

public class formularioEquipamentosView2 extends JFrame {
	private JTable tabelaEquipamentos;
	private JTextField txtNome;
	private JTextField txtPreco;
	private JTextField txtSerie;
	private JTextField txtDateFabri;
	private JTextField txtFabric;
	DefaultTableModel model;
	private JTextField txtCodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					formularioEquipamentosView2 frame = new formularioEquipamentosView2();
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
	public formularioEquipamentosView2() {

		
		setBounds(100, 100, 837, 597);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel.setBounds(109, 48, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 160, 780, 338);
		getContentPane().add(scrollPane);
		
		tabelaEquipamentos = new JTable();
		scrollPane.setViewportView(tabelaEquipamentos);
		model = new DefaultTableModel();
		Object[] column = {"Id","Numero de Série","Nome","Preço","Data de Fabricação", "Fabricante"};
		Object[] row = new Object[0];
		model.setColumnIdentifiers(column);
		tabelaEquipamentos.setModel(model);
		tabelaEquipamentos.setBackground(Color.LIGHT_GRAY);
		
		txtNome = new JTextField();
		txtNome.setBounds(109, 73, 399, 20);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Pre\u00E7o");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(10, 104, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		txtPreco = new JTextField();
		txtPreco.setBounds(10, 129, 103, 20);
		getContentPane().add(txtPreco);
		txtPreco.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Numero de S\u00E9rie");
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(518, 48, 127, 14);
		getContentPane().add(lblNewLabel_2);
		
		txtSerie = new JTextField();
		txtSerie.setBounds(518, 73, 272, 20);
		getContentPane().add(txtSerie);
		txtSerie.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Data de Fabrica\u00E7\u00E3o");
		lblNewLabel_3.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(134, 104, 127, 14);
		getContentPane().add(lblNewLabel_3);
		
		txtDateFabri = new JTextField();
		txtDateFabri.setBounds(134, 129, 103, 20);
		getContentPane().add(txtDateFabri);
		txtDateFabri.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Fabricante");
		lblNewLabel_4.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNewLabel_4.setBounds(268, 104, 78, 14);
		getContentPane().add(lblNewLabel_4);
		
		txtFabric = new JTextField();
		txtFabric.setBounds(268, 129, 250, 20);
		getContentPane().add(txtFabric);
		txtFabric.setColumns(10);
		
		listarValoresEquipamento();
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtNome.getText().length() == 0 || txtPreco.getText().length() == 0 || txtSerie.getText().length() == 0 
				|| txtDateFabri.getText().length() == 0 || txtDateFabri.getText().length() == 0){
					JOptionPane.showMessageDialog(null, "Faltou preencher algum dado.");
				}
				else {
					CadastrarEquipamentos();			
				}
					
 
			}
		});
		btnCadastrar.setBounds(528, 104, 117, 23);
		getContentPane().add(btnCadastrar);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				listarValoresEquipamento();
			}
		});
		btnPesquisar.setBounds(661, 104, 103, 23);
		getContentPane().add(btnPesquisar);
		
		JButton btnSairEquipamentos = new JButton("Sair");
		btnSairEquipamentos.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnSairEquipamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				formularioPrincipalView objfrmprincipalview = new formularioPrincipalView();
		    	objfrmprincipalview.setVisible(true);
		    	
		    	dispose();
				
			}
		});
		btnSairEquipamentos.setBounds(701, 514, 89, 23);
		getContentPane().add(btnSairEquipamentos);
		
		JButton btnCarregarCampos = new JButton("Carregar Campos");
		btnCarregarCampos.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnCarregarCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					CarregarCampos();			
										
			}
			

		});
		btnCarregarCampos.setBounds(10, 514, 145, 23);
		getContentPane().add(btnCarregarCampos);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LimparCampos();

			}
			
			
		});
		btnLimpar.setBounds(528, 127, 117, 23);
		getContentPane().add(btnLimpar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			if (txtNome.getText().length() == 0 || txtPreco.getText().length() == 0 || txtSerie.getText().length() == 0 
				|| txtDateFabri.getText().length() == 0 || txtDateFabri.getText().length() == 0){
				JOptionPane.showMessageDialog(null, "Carregue um registro para alterar.");
				}
				else {
					AlterarEquipamento();
					listarValoresEquipamento();
					LimparCampos();		
				}							
			}
			
		});
		btnAlterar.setBounds(172, 514, 89, 23);
		getContentPane().add(btnAlterar);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(10, 73, 89, 20);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblCodigo = new JLabel("ID");
		lblCodigo.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblCodigo.setBounds(10, 48, 46, 14);
		getContentPane().add(lblCodigo);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (txtNome.getText().length() == 0 || txtPreco.getText().length() == 0 || txtSerie.getText().length() == 0 
				|| txtDateFabri.getText().length() == 0 || txtDateFabri.getText().length() == 0){
					JOptionPane.showMessageDialog(null, "Carregue um registro para excluir.");
				}
				else {
					ExcluirEquipamento();
					listarValoresEquipamento();
					LimparCampos();			
				}			
			}
		});
		btnExcluir.setBounds(661, 127, 103, 23);
		getContentPane().add(btnExcluir);
		
		JLabel lblNewLabel_5 = new JLabel("Cadastro de Equipamentos");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(0, 0, 821, 37);
		getContentPane().add(lblNewLabel_5);

	}
	
	  private void CadastrarEquipamentos() {
		  
		  String  nome, fabricante;
		  String data,dataf;
			
            int serie = Integer.parseInt(txtSerie.getText());
			float preco = Float.parseFloat(txtPreco.getText().replace(",", "."));
			nome = txtNome.getText();
			fabricante = txtFabric.getText();
	        dataf = txtDateFabri.getText();
	        
	        String dia = txtDateFabri.getText().substring(0,2);
	        String mes = txtDateFabri.getText().substring(3,5);
	        String ano = txtDateFabri.getText().substring(6);
	        
	        String dataFinal = ano+"-"+mes+"-"+ dia;
	          
	        
	        EquipamentoDTO equipamentoDTO = new EquipamentoDTO();     
	
	        	equipamentoDTO.setNome(nome);
    			equipamentoDTO.setFabricante(fabricante);
    			equipamentoDTO.setNumserie(serie);
    			equipamentoDTO.setDatafabri(dataFinal);	
    			equipamentoDTO.setPreco(preco);
    			
			
			EquipamentoDAO equipamentoDAO = new EquipamentoDAO();
			equipamentoDAO.cadastrarEquipamentos(equipamentoDTO); 
			
			listarValoresEquipamento();
			LimparCampos();
			
	      
	  }
	
	  private void listarValoresEquipamento() {
		
		try {
			EquipamentoDAO objequipamentodao = new EquipamentoDAO();
			
			DefaultTableModel model = (DefaultTableModel)tabelaEquipamentos.getModel();
			model.setNumRows(0);
			ArrayList<EquipamentoDTO> lista = objequipamentodao.PesquisarEquipamento();
			
				for(int num = 0; num < lista.size(); num++) {
				model.addRow(new Object[] {
					lista.get(num).getId(),
					lista.get(num).getNumserie(),	
					lista.get(num).getNome(),
					lista.get(num).getPreco(),
					lista.get(num).getDatafabri(),
					lista.get(num).getFabricante()
					});
				
				}
			
			} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "Listar valores View" + erro);
			}
	  }
	  
	  private void CarregarCampos() {
		  
		  int setar = tabelaEquipamentos.getSelectedRow();
		  txtCodigo.setText(tabelaEquipamentos.getModel().getValueAt(setar, 0).toString());
		  txtSerie.setText(tabelaEquipamentos.getModel().getValueAt(setar, 1).toString());
		  txtNome.setText(tabelaEquipamentos.getModel().getValueAt(setar, 2).toString());
		  txtPreco.setText(tabelaEquipamentos.getModel().getValueAt(setar, 3).toString());
		  txtDateFabri.setText(tabelaEquipamentos.getModel().getValueAt(setar, 4).toString());
		  txtFabric.setText(tabelaEquipamentos.getModel().getValueAt(setar, 5).toString());	  
		  
	  }
	  
	  private void LimparCampos() {
		  txtSerie.setText("");
		  txtNome.setText("");
		  txtPreco.setText("");
		  txtDateFabri.setText("");
		  txtFabric.setText("");
		  txtSerie.requestFocus();
		  
	  }
	  
	  private void AlterarEquipamento() {
		  int codEquipamento,idEquipamento;
		  String nomeEquipamento,datafabriEquipamento,fabriEquipamento;
		  float precoEquipamento;
		 
		  idEquipamento = Integer.parseInt(txtCodigo.getText());
		  codEquipamento = Integer.parseInt(txtSerie.getText());
		  nomeEquipamento = txtNome.getText();
		  precoEquipamento = Float.parseFloat(txtPreco.getText());
		  datafabriEquipamento = txtDateFabri.getText();
		  fabriEquipamento = txtFabric.getText();
		  	  	  
		  EquipamentoDTO objequipamentodto = new EquipamentoDTO();
		  
		  objequipamentodto.setId(idEquipamento);
		  objequipamentodto.setNumserie(codEquipamento);
		  objequipamentodto.setNome(nomeEquipamento);
		  objequipamentodto.setPreco(precoEquipamento);
		  objequipamentodto.setDatafabri(datafabriEquipamento);
		  objequipamentodto.setFabricante(fabriEquipamento);
		  
		  EquipamentoDAO objequipamentodao = new EquipamentoDAO();
		  objequipamentodao.alterarEquipamento(objequipamentodto);    
		 
	  }
	  
	  private void ExcluirEquipamento() {
		  int idEquipamento;
		  
		  idEquipamento = Integer.parseInt(txtCodigo.getText());
		  EquipamentoDTO objequipamentodto = new EquipamentoDTO();
		  objequipamentodto.setId(idEquipamento);
		  
		  EquipamentoDAO objequipamentodao = new EquipamentoDAO();
		  objequipamentodao.excluirEquipamento(objequipamentodto);
		  
		  
	  }
	  
	  private void textoVazio() {
		  String nome,num,datafabri,fabri,preco;
		  
		  nome = txtNome.getText();
		  num = txtSerie.getText();
		  datafabri = txtDateFabri.getText();
		  fabri = txtFabric.getText();
		  preco = txtPreco.getText();
		  
		  try {
			  
			
		} catch (Exception e) {
			 JOptionPane.showMessageDialog(null, "Campos vazios.");		  	  
		}
		  		  	 	  
		  
	  }
}
