package br.com.senai.motorista;


import java.util.List;
import java.util.Scanner;

import br.com.senai.veiculos.Veiculo;
import br.com.senai.veiculos.VeiculoController;



public class MotoristaController {
	
	
	
	
	private Scanner tec;
	
	public MotoristaController() {
		tec = new Scanner(System.in);
		
	}
	
	public int leOpcao() {
		System.out.println("> ");
		return tec.nextInt();
	}
	
	
	public Motorista cadastrarMotorista() {
		Motorista motorista = new Motorista();
		
		
		System.out.println("--- CADASTRAR MOTORISTA ---");
		System.out.println("Informe o nome: ");
		tec.nextLine();
		motorista.setNome(tec.nextLine());
		
		System.out.println("Informe a sua idade: ");
		motorista.setIdade(tec.nextInt());
		
		System.out.println("Informe Categoria da habilitação: ");
		tec.nextLine();
		motorista.setCategoriaHabilitacao(tec.nextLine());
		
		System.out.println("informe o veiculo: ");
		motorista.setVeiculo(tec.nextLine());
		
		
		
		return motorista;
	}
	
	public List<Motorista> listarMotoristas(List<Motorista>motoristas){
		
		if(motoristas.isEmpty()) {
			System.out.println("Não possui dados para listar.");
			return null;
		}
		
		System.out.printf(" | %2s | %8s | %4s | %10s | %4s | \n " ,"Id" , "Nome" ,"Idade" , "Categoria da Habilitação" );
		
		
		for(int i = 0; i < motoristas.size(); i++) {
			System.out.printf("| %2d | %8s | %4d | %10s | %4s | \n",
					i + 1, 
					motoristas.get(i).getNome(),
					motoristas.get(i).getIdade(),
					motoristas.get(i).getCategoriaHabilitacao(),
					motoristas.get(i).getVeiculo());
			
			
		}
		
		return motoristas;
 }
	public List<Motorista> editarMotoristas(List<Motorista> motoristas) {
		Motorista motorista = new Motorista();
		listarMotoristas(motoristas);
		
		if(motoristas.isEmpty()) {
			return null;
		}
		
		System.out.println("Informe o Id do Motorista para editar:");
		int idMotorista = tec.nextInt() -1;
		
		System.out.println("1) Nome do Motorista: ");
		System.out.println("2) Idade: ");
		System.out.println("3) Categoria da Habilitação: ");
		System.out.println("4) Veiculo: ");
		
		System.out.println("Informe o campo para ser editado: ");
		int Opcao = tec.nextInt();
		
		switch (Opcao) {
		case 1: 
			
			System.out.println("--- EDITAR O NOME ---");
			System.out.println("informe o novo nome: ");
			motorista.setNome(tec.next());
			
			motorista.setIdade(motoristas.get(idMotorista).getIdade());
			motorista.setCategoriaHabilitacao(motoristas.get(idMotorista).getCategoriaHabilitacao());
			motorista.setVeiculo(motoristas.get(idMotorista).getVeiculo());
			
			break;
			
		case 2 : 
			System.out.println("--- EDITAR IDADE ---");
			System.out.println("informe o nova idade: ");
			motorista.setIdade(tec.nextInt());
			
			motorista.setNome(motoristas.get(idMotorista).getNome());
			motorista.setCategoriaHabilitacao(motoristas.get(idMotorista).getCategoriaHabilitacao());
			motorista.setVeiculo(motoristas.get(idMotorista).getVeiculo());
			
			break; 
			
		case 3 :
			System.out.println("--- EDITAR CATEGORIA DA HABILITAÇÃO --- ");
			System.out.println("Informe uma nova categotia da habilitação: ");
			motorista.setCategoriaHabilitacao(tec.nextLine());
			
			motorista.setNome(motoristas.get(idMotorista).getNome());
			motorista.setIdade(motoristas.get(idMotorista).getIdade());
			motorista.setVeiculo(motoristas.get(idMotorista).getVeiculo());
			
			break;
			
		case 4 : 
			
			System.out.println("--- EDITAR VEICULO ---");
			System.out.println("informe um novo nome do veiculo: ");
			motorista.setVeiculo(tec.nextLine());
			
			motorista.setNome(motoristas.get(idMotorista).getNome());
			motorista.setIdade(motoristas.get(idMotorista).getIdade());
			motorista.setCategoriaHabilitacao(motoristas.get(idMotorista).getCategoriaHabilitacao());
			
			break; 
			
			default : 
				System.out.println("opção inválida!");
				break;
			
		}
		motoristas.set(idMotorista, motorista);
		
		return motoristas;
	}
	
	public void excluirMotorista(List<Motorista>motoristas) {
		listarMotoristas(motoristas);
		if(motoristas.isEmpty()) {
			return;
		}
		System.out.println("--- EXCLUIR MOTORISTA ---");
		System.out.println("informe o id da pessoa para excluir: ");
		int idMotorista = tec.nextInt() -1;
		
		if(motoristas.size() <= idMotorista) {
			System.out.println("Veiculo não cadastrado.");
			return;
		}
		motoristas.remove(idMotorista);
	}
	
	public void menu(List<Motorista> motoristas) {
		System.out.println("1) Cadastrar ");
		System.out.println("2) Editar ");
		System.out.println("3) Listar ");
		System.out.println("4) Excluir ");
		
		System.out.println("Informe o campo para ser editado: ");
		Scanner tec = new Scanner(System.in);
		int opcao = tec.nextInt();
		
		
		switch(opcao) {
		
		case 1: 
			motoristas.add(cadastrarMotorista());
			break;
			
		case 2:
			editarMotoristas(motoristas);
			break;
			
		case 3:
			listarMotoristas(motoristas);
			break;
			
		case 4: 
			excluirMotorista(motoristas);
		}
		
		
		
	}
	
}
