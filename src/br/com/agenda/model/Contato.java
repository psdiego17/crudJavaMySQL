package br.com.agenda.model;

import java.util.Date;

public class Contato {
	private int id;
	private String nome;
	private int idade;
	private Date dataCadastro;

	public Contato() {
		super();
	}

	public Contato(int id, String nome, int idade, Date dataCadastro) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.dataCadastro = dataCadastro;
	}

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

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Override
	public String toString() {
		String s = "";
		
		s += "[id= " + this.getId() + ", nome= " + this.getNome() + 
				", idade= " + this.getIdade() + ", dataCadastro= " + this.getDataCadastro() + "]";
		
		return s;
	}
	
	
}
