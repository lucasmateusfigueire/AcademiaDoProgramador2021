package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConexaoDAO {
	
	public Connection ConectarDB() {
		
		//Metodo para conectar com o Banco de Dados MySQL.
		
		
		Connection conn = null;
		
		try {
			
			String url = "jdbc:mysql://localhost:3306/cadastroquip?user=root&password = luca163665";
			conn = DriverManager.getConnection(url);
			
			
		} catch (SQLException erro) {
		   JOptionPane.showMessageDialog(null, "ConexaoDAO" + erro.getMessage());	
		}
		
		return conn;
	}

}
