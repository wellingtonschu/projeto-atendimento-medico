import java.util.ArrayList;
import java.util.List;


public class ListAtendimentos {
	List<Atendimentos> lista = new ArrayList<Atendimentos>();
	Menus menu = new Menus();
	
	ListPacientes listaPac = new ListPacientes(ManipXML.PaclerXMLCOM());
	ListMedicos listaMed = new ListMedicos(ManipXML.MedlerXMLCOM());
	
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
			builder.append("Nome do Médico: ");
			for (int j = 0; j < lista.size(); j++) {
				for (int j2 = 0; j2 < listaMed.lista.size(); j2++) {
					if(listaMed.lista.get(j2).getCodigo() == lista.get(j).getCodigoMedico())
						builder.append(listaMed.lista.get(j2).getNome());
				}
			}
			builder.append(" | Nome do Paciente: ");
			for (int j = 0; j < lista.size(); j++) {
				for (int j2 = 0; j2 < listaMed.lista.size(); j2++) {
					if(listaPac.lista.get(j2).getCodigo() == lista.get(j).getCodigoPaciente())
						builder.append(listaPac.lista.get(j2).getNome());
				}
			}
			builder.append("\n");
		}
		return builder;
	}
	
	public List<Atendimentos> getLista(){
		return lista;
	}
	
	
}
