package DTO;

import java.sql.Date;

public class EquipamentoDTO {
	
	private String nome, fabricante;
	private int numserie;
	private float preco;
	private String datafabri;
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public int getNumserie() {
		return numserie;
	}
	public void setNumserie(int numserie) {
		this.numserie = numserie;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public String getDatafabri() {
		return datafabri;
	}
	public void setDatafabri(String datafabri) {
		this.datafabri = datafabri;
	}
	
	

}
