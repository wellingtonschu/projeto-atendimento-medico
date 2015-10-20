import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class ListClientes {
	List<Clientes> lista = new ArrayList<Clientes>();
	Menus menu = new Menus();
	
	public ListClientes(List<Clientes> list) {
		lista = list;
	}
	
	public void geraHTML(){
		FileWriter arq;
		try {
			arq = new FileWriter("html/index.html");
			PrintWriter gravarArq = new PrintWriter(arq); 
			gravarArq.append("<!DOCTYPE html>");
			gravarArq.append("<html lang='en'>");
			gravarArq.append("<head>");
			gravarArq.append("	<meta charset='UTF-8'>");
			gravarArq.append("	<title>XML - Exercício LP1</title>");
			gravarArq.append("	 <!-- Bootstrap -->");
			gravarArq.append("    <link href='css/bootstrap.min.css' rel='stylesheet'>");
			gravarArq.append("    <link rel='stylesheet' href='css/estilo.css'>");
			gravarArq.append("</head>");
			gravarArq.append("<body>");
			gravarArq.append("    <div class='col-md-10 col-md-offset-1'>");
			gravarArq.append("    	<div class='jumbotron'>");
			gravarArq.append("    		<h1>XML - Exercício LP1</h1>");
			gravarArq.append("    	</div>");
			gravarArq.append("    	");
			gravarArq.append("    	<div class='row tabela-topo'>");
			gravarArq.append("	    	<div class='col-md-2'>");
			gravarArq.append("	    		<p class='titulo'>Código</p>");
			gravarArq.append("	    	</div>");
			gravarArq.append("	    	<div class='col-md-4'>");
			gravarArq.append("	    		<p class='titulo'>Nome</p>");
			gravarArq.append("	    	</div>");
			gravarArq.append("	    	<div class='col-md-3'>");
			gravarArq.append("	    		<p class='titulo'>E-mail</p>");
			gravarArq.append("	    	</div>");
			gravarArq.append("	    	<div class='col-md-3'>");
			gravarArq.append("	    		<p class='titulo'>Fone</p>");
			gravarArq.append("	    	</div>");
			gravarArq.append("    	</div>");
			gravarArq.append("");
			gravarArq.append("    	");
			for (int i = 0; i < lista.size(); i++){
				if(i < lista.size() -1)
					gravarArq.append("    	<div class='row tabela-meio'>");
				else
					gravarArq.append("    	<div class='row tabela-fim'>");
			gravarArq.append("	    	<div class='col-md-2'>");
			gravarArq.append("	    		<p class='conteudo'>");
			
			//imprime os códigos dos clientes
			gravarArq.append(String.valueOf(lista.get(i).getCodigo()));
			gravarArq.append("</p>");
			
			
			gravarArq.append("	    	</div>");
			gravarArq.append("	    	<div class='col-md-4'>");
			gravarArq.append("	    		<p class='conteudo'>");
			
			//imprime os nomes dos clientes
			gravarArq.append(lista.get(i).getNome());
			gravarArq.append("</p>");
			
			
			gravarArq.append("	    	</div>");
			gravarArq.append("	    	<div class='col-md-3'>");
			gravarArq.append("	    		<p class='conteudo'>");
			
			//imprime os emails dos clientes
			gravarArq.append(lista.get(i).getEmail());
			gravarArq.append("</p>");
			
			
			gravarArq.append("	    	</div>");
			gravarArq.append("	    	<div class='col-md-3'>");
			gravarArq.append("	    		<p class='conteudo'>");
			
			//imprime os fones dos clientes
			gravarArq.append(lista.get(i).getFone());
			gravarArq.append("</p>");

			
			gravarArq.append("	    	</div>");
			gravarArq.append("    	</div>");
			gravarArq.append("");
			}
			gravarArq.append("");
			gravarArq.append("    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->");
			gravarArq.append("    <script src='https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js'></script>");
			gravarArq.append("    <!-- Include all compiled plugins (below), or include individual files as needed -->");
			gravarArq.append("    <script src='js/bootstrap.min.js'></script>");
			gravarArq.append("	");
			gravarArq.append("</body>");
			gravarArq.append("</html>");
			arq.close();
			
			File file = new File("html/index.html");
			Desktop.getDesktop().edit(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	public void inserir(Clientes cli){
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
	public StringBuilder dominioIgual(String texto){
		StringBuilder builder = new StringBuilder();
		String[] parts = texto.split("@");
		for (int i = 0; i < lista.size(); i++) {
			String[] parts2 = lista.get(i).getEmail().split("@");
			if(parts[parts.length-1].equals(parts2[parts2.length-1])){
				builder.append(lista.get(i));
				builder.append("\n");
			}
		}
		return builder;
	}

	public void deletar(int cod_cliente){
		for (int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getCodigo() == cod_cliente)
				lista.remove(i);
		}
	}
	
	public boolean verifica_duplicidade(String texto){
		for (int i = 0; i < lista.size(); i++)
			if(lista.get(i).getNome().equals(texto))
				return false;
		return true;
	}
	
	public void alterar(int cod_cliente, int escolha_alteracao, String novo_valor){
		int verifica_cliente = 0;
		for (int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getCodigo() == cod_cliente)
				verifica_cliente = i;
		}

		Clientes cli = new Clientes();
		cli.setCodigo(lista.get(verifica_cliente).getCodigo());
		cli.setNome(lista.get(verifica_cliente).getNome());
		cli.setEmail(lista.get(verifica_cliente).getEmail());
		cli.setFone(lista.get(verifica_cliente).getFone());
		
		switch (escolha_alteracao) {
		case 1:
			cli.setCodigo(Integer.valueOf(novo_valor));
			break;
		case 2:
			cli.setNome(novo_valor);
			break;
		case 3:
			cli.setEmail(novo_valor);
			break;
		case 4:
			cli.setFone(novo_valor);
			break;
		default:
			break;
		}
		
		lista.set(verifica_cliente, cli);
	}
	
	public StringBuilder imprimir(){
		StringBuilder builder = new StringBuilder();
		builder.append(menu.imprimeMenu("Clientes Cadastrados"));
		for (int i = 0; i < lista.size(); i++) {
			builder.append(lista.get(i).getCodigo());
			builder.append(" - ");
			builder.append("Nome: ");
			builder.append(lista.get(i).getNome());
			builder.append(" | E-mail: ");
			builder.append(lista.get(i).getEmail());
			builder.append(" | Fone: ");
			builder.append(lista.get(i).getFone());
			builder.append("\n");
		}
		return builder;
	}
	
	public StringBuilder consultar(int escolha, String busca){
		StringBuilder builder = new StringBuilder();
		int verifica_cliente = -1;		
		
		switch (escolha) {
		case 1:
			for (int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getCodigo() == Integer.valueOf(busca))
					verifica_cliente = i;
			}
			break;
		case 2:
			for (int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getNome().equals(busca))
					verifica_cliente = i;
			}
			break;
		case 3:
			for (int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getEmail().equals(busca))
					verifica_cliente = i;
			}
			break;
		case 4:
			for (int i = 0; i < lista.size(); i++) {
				if(lista.get(i).getFone().equals(busca))
					verifica_cliente = i;
			}
			break;
		default:
			break;
		}
		
		if(verifica_cliente != -1){
			builder.append(menu.imprimeMenu("Busca Resultante"));
			builder.append(lista.get(verifica_cliente).getCodigo());
			builder.append(" - ");
			builder.append("Nome: ");
			builder.append(lista.get(verifica_cliente).getNome());
			builder.append(" | E-mail: ");
			builder.append(lista.get(verifica_cliente).getEmail());
			builder.append(" | Fone: ");
			builder.append(lista.get(verifica_cliente).getFone());
			builder.append("\n");
		}else
			builder.append("Valor Não Encontrado, favor tentar novamente..");
		return builder;
	}
	
	public List<Clientes> getLista(){
		return lista;
	}
	
	
}