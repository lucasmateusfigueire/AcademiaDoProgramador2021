package DTO;

public class UsuarioDTO {
	
	private int ID_Usuario;
	private String nome_usuario, senha_usuario;
	
	public int getID_Usuario() {
		return ID_Usuario;
	}
	public void setID_Usuario(int iD_Usuario) {
		ID_Usuario = iD_Usuario;
	}
	public String getNome_usuario() {
		return nome_usuario;
	}
	public void setNome_usuario(String nome_usuario) {
		this.nome_usuario = nome_usuario;
	}
	public String getSenha_usuario() {
		return senha_usuario;
	}
	public void setSenha_usuario(String senha_usuario) {
		this.senha_usuario = senha_usuario;
	}
    
	
}
