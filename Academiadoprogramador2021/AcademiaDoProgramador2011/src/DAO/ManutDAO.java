package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DTO.EquipamentoDTO;
import DTO.ManutDTO;

public class ManutDAO {
	
	Connection conn;
	PreparedStatement ptsm;
	ResultSet rs;
	ArrayList<ManutDTO> lista = new ArrayList<>();

	public void cadastrarManutencao(ManutDTO objmanutdto) {
		
		String sql = "insert into chamado_manutencao (titulo, descricao, nomeequip,datadochamado) values (?,?,?,?)";
		
		conn = new ConexaoDAO().ConectarDB();
		
		try {
			
			ptsm = conn.prepareStatement(sql);
			
			ptsm.setString(1, objmanutdto.getTitulo_manut());
			ptsm.setString(2, objmanutdto.getDescricao_manut());
			ptsm.setString(3, objmanutdto.getNomeequip_manut());
			ptsm.setString(4, objmanutdto.getData_manut());
			
			ptsm.execute();
			ptsm.close();
			
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso.");

		} catch (Exception erro) {
			
			JOptionPane.showMessageDialog(null, "ManutDAO Cadastrar" + erro);
		}
		
	}
	
     public ArrayList<ManutDTO> PesquisarManut(){
		
		String sql = "select * from chamado_manutencao";
		conn = new ConexaoDAO().ConectarDB();
		
		try {
			
			ptsm = conn.prepareStatement(sql);
			rs = ptsm.executeQuery();
			
			while(rs.next()) {
				ManutDTO objmanutDTO = new ManutDTO();
				objmanutDTO.setID_manut(rs.getInt("id"));
				objmanutDTO.setTitulo_manut(rs.getString("titulo"));
				objmanutDTO.setNomeequip_manut(rs.getString("nomeequip"));
				objmanutDTO.setData_manut(rs.getString("datadochamado"));
				
				lista.add(objmanutDTO);
			}
			
			
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "EquipamentoDAO Pesquisar: " + erro);
		}
		
		return lista;
	}
     
     public void alterarManut(ManutDTO objmanutdto) {
 		
 		String sql = "update chamado_manutencao set titulo = ?, descricao = ?, nomeequip = ?, datadochamado = ? where id = ?";
 		
 		conn = new ConexaoDAO().ConectarDB();
 		
 		try {
 			
 			ptsm = conn.prepareStatement(sql);
 		    
 			
 			
 			ptsm.setString(1, objmanutdto.getTitulo_manut());
 			ptsm.setString(2, objmanutdto.getDescricao_manut());
 			ptsm.setString(3, objmanutdto.getNomeequip_manut());
 			ptsm.setString(4, objmanutdto.getData_manut());
 			ptsm.setInt(5, objmanutdto.getID_manut());
 			
 			ptsm.execute();
 			ptsm.close();
 					
 			
 		} catch (SQLException erro) {
 			JOptionPane.showMessageDialog(null, "ManutDAO Alterar: " + erro);
 		}
 		
 	}
     
     public void excluirManut(ManutDTO objemanutdto) {
 		
 		String sql = "delete from chamado_manutencao where id = ?";
 		
 		conn = new ConexaoDAO().ConectarDB();
 		
 		try {
 			
 			ptsm = conn.prepareStatement(sql);
 			
 			ptsm.setInt(1, objemanutdto.getID_manut());
 			
 			ptsm.execute();
 			ptsm.close();
 				
 		 } catch (SQLException erro) {
 		 	JOptionPane.showMessageDialog(null, "ManutDAO Excluir: " + erro);
 		}
 		
 	}
	
}


