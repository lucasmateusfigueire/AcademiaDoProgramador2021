package DTO;

public class ManutDTO {

	private int ID_manut;
	private String titulo_manut, descricao_manut,nomeequip_manut,data_manut;
	
	public int getID_manut() {
		return ID_manut;
	}
	public void setID_manut(int iD_manut) {
		ID_manut = iD_manut;
	}
	public String getTitulo_manut() {
		return titulo_manut;
	}
	public void setTitulo_manut(String titulo_manut) {
		this.titulo_manut = titulo_manut;
	}
	public String getDescricao_manut() {
		return descricao_manut;
	}
	public void setDescricao_manut(String descricao_manut) {
		this.descricao_manut = descricao_manut;
	}
	public String getNomeequip_manut() {
		return nomeequip_manut;
	}
	public void setNomeequip_manut(String nomeequip_manut) {
		this.nomeequip_manut = nomeequip_manut;
	}
	public String getData_manut() {
		return data_manut;
	}
	public void setData_manut(String data_manut) {
		this.data_manut = data_manut;
	}
	
	
	
}
