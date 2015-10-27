import java.util.Scanner;

public class ExXML {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Menus menu = new Menus();
		ListAtendimentos listaAte = new ListAtendimentos(ManipXML.AtelerXMLCOM());
		ListPacientes listaPac = new ListPacientes(ManipXML.PaclerXMLCOM());
		ListMedicos listaMed = new ListMedicos(ManipXML.MedlerXMLCOM());
		Atendimentos ate = new Atendimentos();
		Pacientes pac = new Pacientes();
		Medicos med = new Medicos();
		int escolha = 0;
		do{
			System.out.println(menu.imprimeMenu("MENU"));
			System.out.println("1 - Realizar Atendimento");
			System.out.println("2 - Cadastrar novo Paciente");
			System.out.println("3 - Cadastrar novo Médico");
			System.out.println("4 - Mostrar Tudo");
			System.out.println("0 - Sair do Programa");
			System.out.print("\nValor escolhido: ");
			escolha = in.nextInt();
			
			switch (escolha) {
			case 1:
				int medico =0;
				ate = new Atendimentos();
				System.out.println(menu.imprimeMenu("REALIZAR ATENDIMENTO"));

				System.out.println("A seguir será mostrado os médicos cadastrados\nPressione enter para continuar...");
				in.nextLine();in.nextLine();
				System.out.println(listaMed.imprimir());
				System.out.print("\nDigite o código do Médico que realizará o atendimento: ");
				medico = in.nextInt();
				System.out.println(menu.imprimeMenu("ATENDIMENTO REALIZADO"));
				System.out.println("O paciente " + listaPac.lista.get(0).getNome() + " foi atendido pelo médico " + listaMed.consultar(medico));
				System.out.print("Digite o Código do Atendimento: ");
				ate.setCodigo(in.nextInt());
				ate.setCodigoMedico(medico);
				ate.setCodigoPaciente(listaPac.lista.get(0).getCodigo());
				listaAte.inserir(ate);
				listaPac.deletar(listaPac.lista.get(0).getCodigo());
				break;
			case 2:
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
				System.out.println((q1+q2+q3+q4));
				if((q1 + q2 + q3 + q4) == 4)
					pac.setClassificacao("Vermelho");
				if((q1 + q2 + q3 + q4) == 3)
					pac.setClassificacao("Amarelo");
				if((q1 + q2 + q3 + q4) == 1 || (q1 + q2 + q3 + q4) == 2)
					pac.setClassificacao("Verde");
				if((q1 + q2 + q3 + q4) == 0)
					pac.setClassificacao("Azul");
				
				listaPac.inserir(pac);
				
				
				break;
			case 3:
				med = new Medicos();
				System.out.println(menu.imprimeMenu("CADASTRAR NOVO MÉDICO"));
				System.out.print("Código: ");
				med.setCodigo(in.nextInt());
				in.nextLine();
				System.out.print("Nome: ");
				med.setNome(in.nextLine());
				System.out.print("Telefone: ");
				med.setFone(in.nextLine());
				listaMed.inserir(med);
				break;
			case 4:
				System.out.println(listaAte.imprimir());
				System.out.println("Pressione enter para continuar...");
				in.nextLine();in.nextLine();
				System.out.println(listaMed.imprimir());
				System.out.println("Pressione enter para continuar...");
				in.nextLine();
				System.out.println(listaPac.imprimir());
				System.out.println("Pressione enter para continuar...");
				in.nextLine();
				break;
			default:
				System.out.println(menu.imprimeMenu("Item não pertence ao Menu, favor digitar Novamente"));
				in.nextLine();
			}
		}while(escolha != 0);
		System.out.println(menu.imprimeMenu("Programa Encerrado"));

		ManipXML.gravarXMLPaciente(listaPac.getLista());
		ManipXML.gravarXMLMedico(listaMed.getLista());
		ManipXML.gravarXMLAtendimento(listaAte.getLista());
	}
}