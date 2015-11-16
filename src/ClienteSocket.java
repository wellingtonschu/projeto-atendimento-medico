import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.Scanner;

public class ClienteSocket implements Serializable{
	public static void main(String[] args) throws IOException, ClassNotFoundException {
	
		// Utilizada para leitura do teclado
		Scanner entrada = new Scanner(System.in);

		// Variï¿½vel para armazenar o texto que serï¿½ digitado
		String texto = "";

		// Socket Cliente
		Socket cliente = null;

		// Stream (tubo) de saida de dados
		PrintStream saida = null;
		
		BufferedReader dados = null;
		
		Object saidaObj = null;
		
		//Inicialização das Listas e variáveis
		Scanner in = new Scanner(System.in);
		Menus menu = new Menus();
		Atendimentos ate = new Atendimentos();
		Pacientes pac = new Pacientes();
		Medicos med = new Medicos();
		int escolha = 0;
		
		try{
			// Cria o socket com os parâmetros
			cliente = new Socket("127.0.0.1",7000);
			String texto1 = String.valueOf(cliente.getInetAddress());
			texto1 = texto1.replaceAll("/","");
			System.out.println(texto1);
			dados = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			// Stream de saida de dados
			saida = new PrintStream(cliente.getOutputStream());
			ObjectOutputStream enviaObj = new ObjectOutputStream(saida);
			
			do{
				System.out.println(menu.imprimeMenu("MENU"));
				System.out.println("1 - Realizar Atendimento");
				System.out.println("2 - Cadastrar novo Paciente");
				System.out.println("3 - Cadastrar novo Médico");
				System.out.println("4 - Mostrar Lista");
				System.out.println("0 - Sair do Programa");
				System.out.print("\nValor escolhido: ");
				escolha = in.nextInt();
				
				switch (escolha) {
				case 1:
					saida.println(escolha);
					int medico =0;
					System.out.println(menu.imprimeMenu("REALIZAR ATENDIMENTO"));

					System.out.println("A seguir será mostrado os médicos cadastrados\nPressione enter para continuar...");
					in.nextLine();in.nextLine();
					do{
						texto = dados.readLine();
						System.out.println(texto); 
					}while(dados.ready());
					
					System.out.print("\nDigite o código do Médico que realizará o atendimento: ");
					saida.println(in.nextInt());

					System.out.println(menu.imprimeMenu("ATENDIMENTO REALIZADO"));
					System.out.print("Digite um Código para o Atendimento: ");
					saida.println(in.nextInt());
					
					break;
				case 2:
					saida.println(escolha);
					pac = new Pacientes();
					int q1 = 0;
					int q2 = 0;
					int q3 = 0;
					int q4 = 0;
					System.out.println(menu.imprimeMenu("CADASTRAR NOVO PACIENTE"));
					System.out.print("Código: ");
					pac.setCodigo(in.nextInt());
					in.nextLine();
					System.out.print("Nome: ");
					pac.setNome(in.nextLine());
					System.out.print("Telefone: ");
					pac.setFone(in.nextLine());
					
					System.out.print("Há alguma Fratura? (1 - Sim, 0 - Não)\nR: ");
					q1 = in.nextInt();
					System.out.print("Há alguma Hemorragia? (1 - Sim, 0 - Não)\nR: ");
					q2 = in.nextInt();
					System.out.print("Há alguma Queimadura? (1 - Sim, 0 - Não)\nR: ");
					q3 = in.nextInt();
					System.out.print("Houve Desmaio? (1 - Sim, 0 - Não)\nR: ");
					q4 = in.nextInt();
					if((q1 + q2 + q3 + q4) == 4)
						pac.setClassificacao("Vermelho");
					if((q1 + q2 + q3 + q4) == 3)
						pac.setClassificacao("Amarelo");
					if((q1 + q2 + q3 + q4) == 1 || (q1 + q2 + q3 + q4) == 2)
						pac.setClassificacao("Verde");
					if((q1 + q2 + q3 + q4) == 0)
						pac.setClassificacao("Azul");
					
					enviaObj.writeObject(pac);       
			        System.out.println(dados.readLine());
					menu.esperar();
					break;
				case 3:
					saida.println(escolha);
					med = new Medicos();
					System.out.println(menu.imprimeMenu("CADASTRAR NOVO MÉDICO"));
					System.out.print("Código: ");
					med.setCodigo(in.nextInt());
					in.nextLine();
					System.out.print("Nome: ");
					med.setNome(in.nextLine());
					System.out.print("Telefone: ");
					med.setFone(in.nextLine());
					
					enviaObj.writeObject(med);       
			        System.out.println(dados.readLine());

					menu.esperar();
					break;
				case 4:
					saida.println(escolha);
					System.out.println(menu.imprimeMenu("SELECIONE A LISTA QUE DESEJA VISUALIZAR"));
					System.out.println("1 - Atendimentos");
					System.out.println("2 - Pacientes");
					System.out.println("3 - Médicos");
					System.out.print("\nValor escolhido: ");
					saida.println(in.nextInt());
					do{
						texto = dados.readLine();
						System.out.println(texto); 
					}while(dados.ready());
					menu.esperar();
					break;
				default:
					System.out.println(menu.imprimeMenu("Item não pertence ao Menu, favor digitar Novamente"));
					in.nextLine();
				}
				
			}while(escolha != 0);
			System.out.println(menu.imprimeMenu("Programa Encerrado"));
			saida.println(0);
		}catch(IOException e){
			System.out.println("Algo errado aconteceu");
		}finally{
			// Encerra o socket cliente
			cliente.close();
		}
	}
	
}
