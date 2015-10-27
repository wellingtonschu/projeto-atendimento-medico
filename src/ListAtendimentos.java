import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class ListAtendimentos {
	List<Atendimentos> lista = new ArrayList<Atendimentos>();
	Menus menu = new Menus();
	
	public ListAtendimentos(List<Atendimentos> list) {
		lista = list;
	}
	
	
	public void inserir(Atendimentos ate){
		lista.add(ate);
	}
	
	
	public void deletar(int cod){
		for (int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getCodigo() == cod)
				lista.remove(i);
		}
	}
	
	public StringBuilder imprimir(){
		StringBuilder builder = new StringBuilder();
		builder.append(menu.imprimeMenu("Atendimentos Cadastrados"));
		for (int i = 0; i < lista.size(); i++) {
			builder.append(lista.get(i).getCodigo());
			builder.append(" - ");
			builder.append("Código do Médico: ");
			builder.append(lista.get(i).getCodigoMedico());
			builder.append(" | Código do Paciente: ");
			builder.append(lista.get(i).getCodigoPaciente());
			builder.append("\n");
		}
		return builder;
	}
	
	public List<Atendimentos> getLista(){
		return lista;
	}
	
	
}
