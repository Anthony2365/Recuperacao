package br.com.senai.veiculos;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.SwingConstants;


public class VeiculoController {
	
	private Scanner tec;
	
	public VeiculoController() {
		tec = new Scanner(System.in);
	}
	
	public int leOpcao() {
		System.out.println("> ");
		return tec.nextInt();
	}
	
	
	public Veiculo cadastarVeiculo() {
		Veiculo veiculo = new Veiculo();
		
		System.out.println("--- CADASTRAR VEICULO ---");
		System.out.println("Informe o Modelo: ");
		tec.nextLine();
		veiculo.setModelo(tec.nextLine());
		
		System.out.println("Informe o ano do carro: ");
		veiculo.setAno(tec.nextInt());
		
		System.out.println("Informe o tipo do combutivel: ");
		veiculo.setTipoCombustivel(tec.nextLine());
		
		System.out.println("Informe a placa: ");
		veiculo.setPlaca(tec.nextInt());
		
		
		
		return veiculo;
	}
	
	public List<Veiculo> listarVeiculos (List<Veiculo>veiculos) {
		
		if(veiculos.isEmpty()) {
			System.out.println("Não possui dados para listar.");
			return null;
		}
		System.out.printf("| %2s | %8s | %10s | %15s | %6s | \n ", 
				"Id" , "Modelo" , "Ano Do Carro" , "Tipo Do Cobustivel" , "Placa" );
		
		for(int i = 0; i < veiculos.size(); i++) {
			System.out.printf("| %2d | %8s | %10d  | %15s | %6d | \n",
					i + 1,
					veiculos.get(i).getModelo(),
					veiculos.get(i).getAno(),
					veiculos.get(i).getTipoCombustivel(),
					veiculos.get(i).getPlaca());
		}
		return veiculos;
	}
	public List<Veiculo> editarVeiculos(List<Veiculo>veiculos) {
		Veiculo veiculo = new Veiculo();
		listarVeiculos(veiculos);
		
		if(veiculos.isEmpty()) {
			return null;
		}
		
		System.out.println("informe o Id do veiculo para editar: ");
		int idVeiculo = tec.nextInt() - 1;
		
		System.out.println("1) Modelo ");
		System.out.println("2) Ano");
		System.out.println("3) Tipo do combustivel");
		System.out.println("4) Placa");
		
		System.out.println("Informe o campo para ser editado: ");
		int Opcao = tec.nextInt();
		
		switch (Opcao) {
		case 1: 
			
			System.out.println("--- EDITAR O VEICULO ---");
			System.out.println("Informe o novo modelo: ");
			veiculo.setModelo(tec.next());
			
			veiculo.setAno(veiculos.get(idVeiculo).getAno());
			veiculo.setTipoCombustivel(veiculos.get(idVeiculo).getTipoCombustivel());
			veiculo.setPlaca(veiculos.get(idVeiculo).getPlaca());
			
			break;
			
			
			
		case 2:
			
			System.out.println("--- EDITAR O ANO ---");
			System.out.println("informe o novo ano: ");
			veiculo.setAno(tec.nextInt());
			
			veiculo.setModelo(veiculos.get(idVeiculo).getModelo());
			veiculo.setTipoCombustivel(veiculos.get(idVeiculo).getTipoCombustivel());
			veiculo.setPlaca(veiculos.get(idVeiculo).getPlaca());
			
			break;
			
			
		case 3: 
			
			System.out.println("--- EDITAR TIPO DO COMBUSTIVEL ---");
			System.out.println("Informe um novo combutivel: ");
			veiculo.setTipoCombustivel(tec.next());
			
			veiculo.setModelo(veiculos.get(idVeiculo).getModelo());
			veiculo.setAno(veiculos.get(idVeiculo).getAno());
			veiculo.setPlaca(veiculos.get(idVeiculo).getPlaca());
			
			break;
			
		case 4 :
			
			System.out.println("--- EDITAR A PLACA ---");
			System.out.println("Informe uma nova placa: ");
			veiculo.setPlaca(tec.nextInt());
			
			veiculo.setModelo(veiculos.get(idVeiculo).getModelo());
			veiculo.setAno(veiculos.get(idVeiculo).getAno());
			veiculo.setTipoCombustivel(veiculos.get(idVeiculo).getTipoCombustivel());
			
			break;
			
			default:
				System.out.println("opção inválida!");
				break;
		}
		
		veiculos.set(idVeiculo, veiculo);
		
		return veiculos;
	}
	
	public void excluirVeiculos(List<Veiculo>veiculos) {
		listarVeiculos(veiculos);
		if(veiculos.isEmpty()) {
			return;
		}
		System.out.println("--- EXCLUIR VEICULOS");
		System.out.println("informe o id do veiculo para excluir: ");
		int idVeiculos = tec.nextInt() - 1;
		if(veiculos.size() <= idVeiculos) {
			
			System.out.println("veiculos não cadastrados.");
		}
		veiculos.remove(idVeiculos);
	}
	public void menu(List<Veiculo>veiculos) {
		System.out.println("1) Cadastrar");
		System.out.println("2) Editar");
		System.out.println("3) Listar ");
		System.out.println("4) Excluir");
		
		System.out.println("informe o campo para ser editado: ");
		Scanner tec = new Scanner(System.in);
		int opcao = tec.nextInt();
		
		switch(opcao) {
		case 1: 
			veiculos.add(cadastarVeiculo());
			
			break;
		case 2:
			editarVeiculos(veiculos);
			
			break;
			
		case 3: 
			listarVeiculos(veiculos);
			break;
			
		case 4:
			excluirVeiculos(veiculos);
			break;
			
		}
	}
	
	}


