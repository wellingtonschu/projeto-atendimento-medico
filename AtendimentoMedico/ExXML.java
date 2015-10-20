import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ExXML {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Menus menu = new Menus();
		ListClientes lista = new ListClientes(ManipXML.lerXMLCOM());
		Clientes cli = new Clientes();
		int escolha = 0;
		int opcao_alterar = 0;
		int cod_cliente = 0;
		do{
			System.out.println(menu.imprimeMenu("MENU"));
			System.out.println("1 - Cadastrar Novo Cliente");
			System.out.println("2 - Consultar Cliente");	
			System.out.println("3 - Listar Todos os Clientes");
			System.out.println("4 - Alterar Cliente");
			System.out.println("5 - Excluir Cliente");
			System.out.println("6 - Retornar Clientes com mesmo Nome");
			System.out.println("7 - Retornar Clientes com mesmo Sobrenome");
			System.out.println("8 - Retornar Clientes com mesmo Domínio");
			System.out.println("0 - Sair do Programa");
			System.out.print("\nValor escolhido: ");
			escolha = in.nextInt();
			
			switch (escolha) {
			case 1:
				cli = new Clientes();
				System.out.println(menu.imprimeMenu("Cadastro de Cliente"));
				System.out.print("Código: ");
				cli.setCodigo(in.nextInt());
				in.nextLine();
				System.out.print("Nome: ");
				cli.setNome(in.nextLine());
				System.out.print("E-mail: ");
				cli.setEmail(in.nextLine());
				System.out.print("Telefone: ");
				cli.setFone(in.nextLine());
				lista.inserir(cli);
				break;
			case 2:
				System.out.println(menu.imprimeMenu("Clientes Cadastrados"));
				System.out.println(lista.imprimir());
				System.out.println("Pressione enter para continuar...");
				in.nextLine();in.nextLine();
				System.out.println(menu.imprimeMenu("Atributo a ser Pesquisado"));
				System.out.println("1 - Buscar Código");
				System.out.println("2 - Buscar Nome");
				System.out.println("3 - Buscar E-mail");
				System.out.println("4 - Buscar Telefone");
				System.out.print("\nValor escolhido: ");
				opcao_alterar = in.nextInt();
				in.nextLine();
				
				switch (opcao_alterar) {
				case 1:
					System.out.print("Digite o Código: ");
					break;
				case 2:
					System.out.print("Digite o Nome: ");
					break;
				case 3:
					System.out.print("Digite o E-mail: ");
					break;
				case 4:
					System.out.print("Digite o Fone: ");
					break;
				default:
					
					break;
				}
				System.out.println(lista.consultar(opcao_alterar, in.nextLine()));
				System.out.println("Pressione enter para continuar...");
				in.nextLine();
				break;
			case 3:
				System.out.println(lista.imprimir());
				System.out.println("Pressione enter para continuar...");
				in.nextLine();
				in.nextLine();
				break;
			case 4:
				System.out.println(menu.imprimeMenu("Alteração de Cliente"));
				System.out.println("\nQual Cliente Deseja Alterar? ");
				System.out.println(lista.imprimir());
				System.out.print("Código escolhido: ");
				cod_cliente = in.nextInt();
				
				
				System.out.println(menu.imprimeMenu("Atributo a ser Alterado"));
				System.out.println("1 - Alterar Código");
				System.out.println("2 - Alterar Nome");
				System.out.println("3 - Alterar E-mail");
				System.out.println("4 - Alterar Telefone");
				System.out.print("\nValor escolhido: ");
				opcao_alterar = in.nextInt();
				in.nextLine();
				
				switch (opcao_alterar) {
				case 1:
					System.out.print("Digite o novo Código: ");
					lista.alterar(cod_cliente, opcao_alterar, in.nextLine());
					break;
				case 2:
					System.out.print("Digite o novo Nome: ");
					lista.alterar(cod_cliente, opcao_alterar, in.nextLine());
					break;
				case 3:
					System.out.print("Digite o novo E-mail: ");
					lista.alterar(cod_cliente, opcao_alterar, in.nextLine());
					break;
				case 4:
					System.out.print("Digite o novo Fone: ");
					lista.alterar(cod_cliente, opcao_alterar, in.nextLine());
					break;
				default:
					break;
				}
				break;
			case 5:
				System.out.println(menu.imprimeMenu("Excluir Cliente"));
				System.out.println("\nQual Cliente Deseja Excluir? ");
				System.out.println(lista.imprimir());
				System.out.print("Código escolhido: ");
				cod_cliente = in.nextInt();
				lista.deletar(cod_cliente);
				break;
			case 6:
				in.nextLine();
				System.out.println(menu.imprimeMenu("Listar Nomes Iguais"));
				System.out.print("\nDigite o nome que deseja buscar: ");
				System.out.println(lista.nomeIgual(in.nextLine()));
				System.out.println("Pressione enter para continuar...");
				in.nextLine();
				break;
			case 7:
				in.nextLine();
				System.out.println(menu.imprimeMenu("Listar Sobrenomes Iguais"));
				System.out.print("\nDigite o sobrenome que deseja buscar: ");
				System.out.println(lista.sobrenomeIgual(in.nextLine()));
				System.out.println("Pressione enter para continuar...");
				in.nextLine();
				break;
			case 8:
				in.nextLine();
				System.out.println(menu.imprimeMenu("Listar Domínios Iguais"));
				System.out.print("\nDigite o domínio que deseja buscar: ");
				System.out.println(lista.dominioIgual(in.nextLine()));
				System.out.println("Pressione enter para continuar...");
				in.nextLine();
				break;
				
			default:
				System.out.println(menu.imprimeMenu("Item não pertence ao Menu, favor digitar Novamente"));
				in.nextLine();
			}
		}while(escolha != 0);
		System.out.println(menu.imprimeMenu("Programa Encerrado"));
		
		ManipXML.gravarXMLCliente(lista.getLista());

		lista.geraHTML();
		/*
		List<Clientes>list = ManipXML.lerXMLCOM();
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			Clientes element = (Clientes) iter.next();
			System.out.println(element.toString() + "\n---");	
		}
		*/
	}
}