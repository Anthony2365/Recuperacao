package br.com.senai.Programa;

import java.util.ArrayList;
import java.util.List;

import br.com.senai.motorista.Motorista;
import br.com.senai.motorista.MotoristaController;
import br.com.senai.veiculos.Veiculo;
import br.com.senai.veiculos.VeiculoController;

public class ProgramaPrincipal {

	public static void main(String[] args) {
		
		List<Motorista> motoristas = new ArrayList<Motorista>();
		List<Veiculo>veiculos = new ArrayList<Veiculo>();
		
		
		MotoristaController motoristaController = new MotoristaController();
		VeiculoController veiculoController = new VeiculoController();
		
		boolean sair = false;
		
		
		do {
			System.out.println("\n--- MENU ---");
			System.out.println("1) Motorista");
			System.out.println("2) Veiculo");
			System.out.println("3) Sair do Sistema");
			System.out.println("Informe o campo para ser editado: ");
			int opcao = motoristaController.leOpcao();
			
			switch(opcao){
			
			case 1 : 
				motoristaController.menu(motoristas);
				break;
				
			case 2 :
				veiculoController.menu(veiculos);
				break;
				
				
			case 3 : 
				sair = true;
				break;
				default:
					System.out.println("opção invalida");
			     }
			
	
				
				
			}while(!sair);
		
		System.out.println("Sistema finalizado!");
	}
	

}
