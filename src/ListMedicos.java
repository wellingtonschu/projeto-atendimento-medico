import java.util.ArrayList;
import java.util.List;


public class ListMedicos {
	List<Medicos> lista = new ArrayList<Medicos>();
	Menus menu = new Menus();
	
	public ListMedicos(List<Medicos> list) {
		lista = list;
	}
	
	public void inserir(Medicos med){
		lista.add(med);
	}
	
	public void deletar(int cod_medico){
		for (int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getCodigo() == cod_medico)
				lista.remove(i);
		}
	}
	
	public StringBuilder imprimir(){
		StringBuilder builder = new StringBuilder();
		builder.append(menu.imprimeMenu("Médicos Cadastrados"));
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
