import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServidorSocket implements Serializable{

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// Sockets
		// Cria o Servidor e seta como nulo
		ServerSocket servidor = null; 

		// Cria uma conexï¿½o para atender o cliente e seta como nulo
		Socket conexao = null;

		// Entrada de Dados
		BufferedReader entrada = null;

		//Inicialização das Listas e variáveis
		Scanner in = new Scanner(System.in);
		Menus menu = new Menus();
		ListAtendimentos listaAte = new ListAtendimentos(ManipXML.AtelerXMLCOM());
		ListPacientes listaPac = new ListPacientes(ManipXML.PaclerXMLCOM());
		ListMedicos listaMed = new ListMedicos(ManipXML.MedlerXMLCOM());
		int escolha = 0;

		StringBuilder out = new StringBuilder();
		
		try{

			/* Cria o ServerSocket na porta 7000 se estiver disponï¿½vel
			 * Lembrar de nï¿½o utilizar portas abaixo de 1024, 
			 * estas sï¿½o utilizadas pelo sistema
			 */
			servidor = new ServerSocket(7000);

			/* Aguarda uma conexï¿½o na porta especificada e retorna 
			 * o socket que irï¿½ comunicar com o cliente
			 */
			conexao = servidor.accept();

			//Cria um BufferedReader para o canal da stream de entrada de dados do socket conexao
			entrada = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
			//Object entradaObj= new ObjectInputStream(conexao.getInputStream());
			PrintStream saida = new PrintStream(conexao.getOutputStream());

			InputStream conectaObj = conexao.getInputStream();
			ObjectInputStream recebeObj = new ObjectInputStream(conectaObj);
			
			//Aguarda por algum dado e imprime a linha recebida quando recebe
			do {
				listaAte = new ListAtendimentos(ManipXML.AtelerXMLCOM());
				listaPac = new ListPacientes(ManipXML.PaclerXMLCOM());
				listaMed = new ListMedicos(ManipXML.MedlerXMLCOM());
				String texto = entrada.readLine();
				
				switch (Integer.valueOf(texto)) {
				case 1:
					System.out.println("Monstrando Lista de Médicos por 5 segundos...");
					saida.println(listaMed.imprimir());
					
					
					String medico = entrada.readLine();
					
					
					Atendimentos ate = new Atendimentos();;
					for (int i = 0; i < listaMed.lista.size(); i++) {
						if(listaMed.lista.get(i).getCodigo() == Integer.valueOf(medico))
							ate.setCodigoMedico(listaMed.lista.get(i).getCodigo());
					}
					for (int i = 0; i < listaPac.lista.size(); i++) {
						if(listaPac.lista.get(i).getStatus().equals("1")){
							ate.setCodigoPaciente(listaPac.lista.get(i).getCodigo());
							System.out.println("O paciente " + listaPac.lista.get(i).getNome() + " foi atendido pelo médico " + listaMed.consultar(Integer.valueOf(medico)));
							saida.println("O paciente " + listaPac.lista.get(i).getNome() + " foi atendido pelo médico " + listaMed.consultar(Integer.valueOf(medico)));
							break;
						}
					}
					ate.setCodigo(Integer.valueOf(entrada.readLine()));
					listaAte.inserir(ate);
					for (int i = 0; i < listaPac.lista.size(); i++) {
						if(listaPac.lista.get(i).getStatus().equals("1")){
							listaPac.lista.get(i).setStatus("0");
							break;
						}
					}
					break;
				case 2:
					Pacientes pac = (Pacientes) recebeObj.readObject();
					if (pac != null) {
						listaPac.inserir(pac);
					}			
					System.out.println("Novo Cliente Cadastrado");
					saida.println("Paciente Cadastrado com Sucesso!");
					break;
				case 3:
					Medicos med = (Medicos) recebeObj.readObject();
					if (med != null) {
						listaMed.inserir(med);
						System.out.println(listaMed.imprimir());
					}			
					System.out.println("Novo Médico Cadastrado");
					saida.println("Médico Cadastrado com Sucesso!");
					break;
				case 4:
					switch (Integer.valueOf(entrada.readLine())) {
					case 1:
						System.out.println("Monstrando Lista de Atendimentos por 5 segundos...");
						saida.println(listaAte.imprimir());
						break;
					case 2:
						System.out.println("Monstrando Lista de Pacientes por 5 segundos...");
						saida.println(listaPac.imprimir());
						break;
					case 3:
						System.out.println("Monstrando Lista de Médicos por 5 segundos...");
						saida.println(listaMed.imprimir());
						break;
					default:
						break;
					}
					break;
				default:
					break;
				}
				if (Integer.valueOf(texto) == 0){
					break;
				}
				ManipXML.gravarXMLPaciente(listaPac.getLista());
				ManipXML.gravarXMLMedico(listaMed.getLista());
				ManipXML.gravarXMLAtendimento(listaAte.getLista());
			}while(!"0".equals(entrada.toString()));
			System.out.println(menu.imprimeMenu("O Cliente Desconectou"));
			    
		}catch(IOException e){
			System.out.println("Algo errado aconteceu");
		}finally{
			// Encerro o socket de comunicaï¿½ï¿½o
			conexao.close();

			//Encerro o ServerSocket
			servidor.close();	
		}
	}
}