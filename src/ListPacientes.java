import java.util.ArrayList;
import java.util.List;


public class ListPacientes {
	List<Pacientes> lista = new ArrayList<Pacientes>();
	Menus menu = new Menus();
	
	public ListPacientes(List<Pacientes> list) {
		lista = list;
	}
	
	public void setLista(List<Pacientes> lista){
		this.lista = lista;
	}	
	
	public void inserir(Pacientes cli){
		int verifica = 0;
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
	
	public void fazTudo(Pacientes cli, int x){
		Pacientes pac = new Pacientes();
		pac.setCodigo(lista.get(lista.size()-1).getCodigo());
		pac.setNome(lista.get(lista.size()-1).getNome());
		pac.setFone(lista.get(lista.size()-1).getFone());
		pac.setClassificacao(lista.get(lista.size()-1).getClassificacao());
		pac.setStatus(lista.get(lista.size()-1).getStatus());
		lista.add(pac);
		alteraRapido(x);
		lista.get(x).setCodigo(cli.getCodigo());
		lista.get(x).setNome(cli.getNome());
		lista.get(x).setFone(cli.getFone());
		lista.get(x).setClassificacao(cli.getClassificacao());
		lista.get(x).setStatus(cli.getStatus());
	}
	public void alteraRapido(int ponto_de_parada){
		
		for (int i = lista.size()-1; i > ponto_de_parada; i--) {
			lista.get(i).setCodigo(lista.get(i-1).getCodigo());
			lista.get(i).setNome(lista.get(i-1).getNome());
			lista.get(i).setFone(lista.get(i-1).getFone());
			lista.get(i).setClassificacao(lista.get(i-1).getClassificacao());
			lista.get(i).setStatus(lista.get(i-1).getStatus());
		}
	}
	
	
	public void deletar(int cod_paciente){
		for (int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getCodigo() == cod_paciente)
				lista.remove(i);
		}
	}

	public StringBuilder imprimir(){
		StringBuilder builder = new StringBuilder();
		builder.append(menu.imprimeMenu("Pacientes Cadastrados"));
		for (int i = 0; i < lista.size(); i++) {
			if("1".equals(lista.get(i).getStatus())){
				builder.append(lista.get(i).getCodigo());
				builder.append(" - ");
				builder.append("Nome: ");
				builder.append(lista.get(i).getNome());
				builder.append(" | Fone: ");
				builder.append(lista.get(i).getFone());
				builder.append(" | Classificação: ");
				builder.append(lista.get(i).getClassificacao());
				builder.append(" | Status: ");
				builder.append(lista.get(i).getStatus());
				builder.append("\n");
			}
		}
		return builder;
	}
	
	public List<Pacientes> getLista(){
		return lista;
	}
	
	
}
