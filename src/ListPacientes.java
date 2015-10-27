import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class ListPacientes {
	List<Pacientes> lista = new ArrayList<Pacientes>();
	Menus menu = new Menus();
	
	public ListPacientes(List<Pacientes> list) {
		lista = list;
	}
	
	public void inserir(Pacientes cli){
		int verifica = 0;
		if(verifica_duplicidade(cli.getNome())){
			for(int x = 0; x < lista.size() ; x++){
				if(cli.getClassificacao().equals("Vermelho")){
					if(lista.get(x).getClassificacao().equals("Amarelo")){
						fazTudo(cli, x);
						verifica = 1;
						break;
					}
					if(lista.get(x).getClassificacao().equals("Verde")){
						fazTudo(cli, x);
						verifica = 1;
						break;
					}
					if(lista.get(x).getClassificacao().equals("Azul")){
						fazTudo(cli, x);
						verifica = 1;
						break;
					}
				}
				if(cli.getClassificacao().equals("Amarelo")){
					if(lista.get(x).getClassificacao().equals("Verde")){
						fazTudo(cli, x);
						verifica = 1;
						break;
					}
					if(lista.get(x).getClassificacao().equals("Azul")){
						fazTudo(cli, x);
						verifica = 1;
						break;
					}
				}
				if(cli.getClassificacao().equals("Verde"))
					if(lista.get(x).getClassificacao().equals("Azul")){
						fazTudo(cli, x);
						verifica = 1;
						break;
					}
			}
			if(verifica == 0)
				lista.add(cli);
		}
		
	}
	
	public void fazTudo(Pacientes cli, int x){
		Pacientes pac = new Pacientes();
		pac.setCodigo(lista.get(lista.size()-1).getCodigo());
		pac.setNome(lista.get(lista.size()-1).getNome());
		pac.setFone(lista.get(lista.size()-1).getFone());
		pac.setClassificacao(lista.get(lista.size()-1).getClassificacao());
		lista.add(pac);
		alteraRapido(x);
		lista.get(x).setCodigo(cli.getCodigo());
		lista.get(x).setNome(cli.getNome());
		lista.get(x).setFone(cli.getFone());
		lista.get(x).setClassificacao(cli.getClassificacao());
	}
	public void alteraRapido(int ponto_de_parada){
		
		for (int i = lista.size()-1; i > ponto_de_parada; i--) {
			lista.get(i).setCodigo(lista.get(i-1).getCodigo());
			lista.get(i).setNome(lista.get(i-1).getNome());
			lista.get(i).setFone(lista.get(i-1).getFone());
			lista.get(i).setClassificacao(lista.get(i-1).getClassificacao());
		}
	}
	
	
	public StringBuilder nomeIgual(String texto){
		StringBuilder builder = new StringBuilder();
		String[] parts = texto.split(" ");
		for (int i = 0; i < lista.size(); i++) {
			String[] parts2 = lista.get(i).getNome().split(" ");
			if(parts[0].equals(parts2[0])){
				builder.append(lista.get(i));
				builder.append("\n");
			}
		}
		return builder;
	}
	public StringBuilder sobrenomeIgual(String texto){
		StringBuilder builder = new StringBuilder();
		String[] parts = texto.split(" ");
		for (int i = 0; i < lista.size(); i++) {
			String[] parts2 = lista.get(i).getNome().split(" ");
			if(parts[parts.length-1].equals(parts2[parts2.length-1])){
				builder.append(lista.get(i));
				builder.append("\n");
			}
		}
		return builder;
	}

	public void deletar(int cod_paciente){
		for (int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getCodigo() == cod_paciente)
				lista.remove(i);
		}
	}
	
	public boolean verifica_duplicidade(String texto){
		for (int i = 0; i < lista.size(); i++)
			if(lista.get(i).getNome().equals(texto))
				return false;
		return true;
	}
	
	
	public void alterar(int cod_paciente, int escolha_alteracao, String novo_valor){
		int verifica_paciente = 0;
		for (int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getCodigo() == cod_paciente)
				verifica_paciente = i;
		}

		Pacientes cli = new Pacientes();
		cli.setCodigo(lista.get(verifica_paciente).getCodigo());
		cli.setNome(lista.get(verifica_paciente).getNome());
		cli.setFone(lista.get(verifica_paciente).getFone());
		
		switch (escolha_alteracao) {
		case 1:
			cli.setCodigo(Integer.valueOf(novo_valor));
			break;
		case 2:
			cli.setNome(novo_valor);
			break;
		case 3:
			cli.setFone(novo_valor);
			break;
		default:
			break;
		}
		
		lista.set(verifica_paciente, cli);
	}
	
	public StringBuilder imprimir(){
		StringBuilder builder = new StringBuilder();
		builder.append(menu.imprimeMenu("Pacientes Cadastrados"));
		for (int i = 0; i < lista.size(); i++) {
			builder.append(lista.get(i).getCodigo());
			builder.append(" - ");
			builder.append("Nome: ");
			builder.append(lista.get(i).getNome());
			builder.append(" | Fone: ");
			builder.append(lista.get(i).getFone());
			builder.append(" | Classificação: ");
			builder.append(lista.get(i).getClassificacao());
			builder.append("\n");
		}
		return builder;
	}
	
	public StringBuilder consultar(int escolha, String busca){
		StringBuilder builder = new StringBuilder();
		int verifica_paciente = -1;		
		
		switch (escolha) {
		case 1:
			for (int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCodigo() == Integer.valueOf(busca))
					verifica_paciente = i;
			}
			break;
		case 2:
			for (int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(busca))
					verifica_paciente = i;
			}
			break;
		case 3:
			for (int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getFone().equals(busca))
					verifica_paciente = i;
			}
			break;
		default:
			break;
		}
		
		if(verifica_paciente != -1){
			builder.append(menu.imprimeMenu("Busca Resultante"));
			builder.append(lista.get(verifica_paciente).getCodigo());
			builder.append(" - ");
			builder.append("Nome: ");
			builder.append(lista.get(verifica_paciente).getNome());
			builder.append(" | Fone: ");
			builder.append(lista.get(verifica_paciente).getFone());
			builder.append(" | Classificação: ");
			builder.append(lista.get(verifica_paciente).getClassificacao());
			builder.append("\n");
		}else
			builder.append("Valor Não Encontrado, favor tentar novamente..");
		return builder;
	}
	
	public List<Pacientes> getLista(){
		return lista;
	}
	
	
}
