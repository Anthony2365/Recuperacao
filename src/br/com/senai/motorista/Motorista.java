package br.com.senai.motorista;

import br.com.senai.veiculos.Veiculo;

public class Motorista extends Veiculo{
	
	private String nome;
	private int idade;
	private String categoriaHabilitacao;
	private  String Veiculo ;
	
	
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
	public String getCategoriaHabilitacao() {
		return categoriaHabilitacao;
	}
	public void setCategoriaHabilitacao(String categoriaHabilitacao) {
		this.categoriaHabilitacao = categoriaHabilitacao;
	}
	public String getVeiculo() {
		return Veiculo;
	}
	public void setVeiculo(String veiculo) {
		Veiculo = veiculo;
	}
	
	
	
	
}
