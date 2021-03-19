package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DTO.EquipamentoDTO;

public class EquipamentoDAO {

	Connection conn;
	PreparedStatement ptsm;
	ResultSet rs;
	ArrayList<EquipamentoDTO> lista = new ArrayList<>();
	 
	public void cadastrarEquipamentos(EquipamentoDTO objequipamentodto) {
		
		String sql = "insert into equipamentos (nome, preço, numserie,datafabricacao, fabricante) values (?,?,?,?,?)";
		
		conn = new ConexaoDAO().ConectarDB();
		
		try {
			
			ptsm = conn.prepareStatement(sql);
			ptsm.setString(1, objequipamentodto.getNome());
			ptsm.setFloat(2, objequipamentodto.getPreco());
			ptsm.setInt(3, objequipamentodto.getNumserie());
			ptsm.setString(4, objequipamentodto.getDatafabri());
			ptsm.setString(5, objequipamentodto.getFabricante());
			
			ptsm.execute();
			ptsm.close();
			
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso.");

		} catch (Exception erro) {
			
			JOptionPane.showMessageDialog(null, "EquipamentoDAO Cadastrar" + erro);
		}
		
	}
	
	
	public ArrayList<EquipamentoDTO> PesquisarEquipamento(){
		
		String sql = "select * from equipamentos";
		conn = new ConexaoDAO().ConectarDB();
		
		try {
			
			ptsm = conn.prepareStatement(sql);
			rs = ptsm.executeQuery();
			
			while(rs.next()) {
				EquipamentoDTO objequipamentoDto = new EquipamentoDTO();
				objequipamentoDto.setId(rs.getInt("id"));
				objequipamentoDto.setNumserie(rs.getInt("numserie")); 
				objequipamentoDto.setNome(rs.getString("nome")); 
				objequipamentoDto.setFabricante(rs.getString("fabricante")); 
				objequipamentoDto.setDatafabri(rs.getString("datafabricacao"));
				objequipamentoDto.setPreco(rs.getFloat("preço"));
				
				lista.add(objequipamentoDto);
				
			}
			
			
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "EquipamentoDAO Pesquisar: " + erro);
		}
		
		return lista;
	}
	
	public void alterarEquipamento(EquipamentoDTO objequipamentodto) {
		
		String sql = "update equipamentos set numserie = ?, nome = ?, preço = ?, datafabricacao = ?, fabricante = ? where id = ?";
		
		conn = new ConexaoDAO().ConectarDB();
		
		try {
			
			ptsm = conn.prepareStatement(sql);
		    
			
			
			ptsm.setInt(1, objequipamentodto.getNumserie());
			ptsm.setString(2, objequipamentodto.getNome());
			ptsm.setFloat (3, objequipamentodto.getPreco());
			ptsm.setString(4, objequipamentodto.getDatafabri());
			ptsm.setString(5, objequipamentodto.getFabricante());
			ptsm.setInt(6, objequipamentodto.getId());
			
			ptsm.execute();
			ptsm.close();
					
			
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "EquipamentoDAO Alterar: " + erro);
		}
		
	}
	
	public void excluirEquipamento(EquipamentoDTO objeequipamentodto) {
		
		String sql = "delete from equipamentos where id = ?";
		
		conn = new ConexaoDAO().ConectarDB();
		
		try {
			
			ptsm = conn.prepareStatement(sql);
			
			ptsm.setInt(1, objeequipamentodto.getId());
			
			ptsm.execute();
			ptsm.close();
				
			
			
			
		 } catch (SQLException erro) {
		 	JOptionPane.showMessageDialog(null, "EquipamentoDAO Excluir: " + erro);
		}
		
	}
	
}
