import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class ListMedicos {
	List<Medicos> lista = new ArrayList<Medicos>();
	Menus menu = new Menus();
	
	public ListMedicos(List<Medicos> list) {
		lista = list;
	}
	
	public void inserir(Medicos cli){
		if(verifica_duplicidade(cli.getNome()))
			lista.add(cli);
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
	
	public void deletar(int cod_medico){
		for (int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getCodigo() == cod_medico)
				lista.remove(i);
		}
	}
	
	public boolean verifica_duplicidade(String texto){
		for (int i = 0; i < lista.size(); i++)
			if(lista.get(i).getNome().equals(texto))
				return false;
		return true;
	}
	
	public void alterar(int cod_medico, int escolha_alteracao, String novo_valor){
		int verifica_medico = 0;
		for (int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getCodigo() == cod_medico)
				verifica_medico = i;
		}

		Medicos cli = new Medicos();
		cli.setCodigo(lista.get(verifica_medico).getCodigo());
		cli.setNome(lista.get(verifica_medico).getNome());
		cli.setFone(lista.get(verifica_medico).getFone());
		
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
		
		lista.set(verifica_medico, cli);
	}
	
	public StringBuilder imprimir(){
		StringBuilder builder = new StringBuilder();
		builder.append(menu.imprimeMenu("Medicos Cadastrados"));
		for (int i = 0; i < lista.size(); i++) {
			builder.append(lista.get(i).getCodigo());
			builder.append(" - ");
			builder.append("Nome: ");
			builder.append(lista.get(i).getNome());
			builder.append(" | Fone: ");
			builder.append(lista.get(i).getFone());
			builder.append("\n");
		}
		return builder;
	}
	
	public StringBuilder consultar(int busca){
		StringBuilder builder = new StringBuilder();
		int verifica_medico = -1;		

		for (int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getCodigo() == Integer.valueOf(busca))
				verifica_medico = i;
		}
		
		if(verifica_medico != -1){
			builder.append(lista.get(verifica_medico).getNome());
		}else
			builder.append("Valor Não Encontrado, favor tentar novamente..");
		return builder;
	}
	
	public List<Medicos> getLista(){
		return lista;
	}
	
	
}
