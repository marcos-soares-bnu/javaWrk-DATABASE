package br.com.proway.mysql;

public class Registro {

	public Registro(int codigo, String descricao) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
	}
	int codigo;
	String descricao;

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
