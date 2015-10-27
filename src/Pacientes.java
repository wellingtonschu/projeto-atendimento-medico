public class Pacientes {

	private int codigo;
	private String nome;
	private String fone;
	private String classificacao;
	
	public Pacientes(){
		
	}
	public Pacientes(int codigo, String nome, String fone, String classificacao){
		setCodigo(codigo);
		setNome(nome);
		setFone(fone);
		setClassificacao(classificacao);
	}
	public int getCodigo() {
		return codigo;
	}
	public String getFone() {
		return fone;
	}
	public String getNome() {
		return nome;
	}
	public String getClassificacao() {
		return classificacao;
	}
	public void setCodigo(int codigo) {
		if (codigo > 0)
			this.codigo = codigo;
	}
	public void setFone(String fone) {
		if (fone.length() > 0)
			this.fone = fone;
	}
	public void setNome(String nome) {
		if (nome.length() > 0)
			this.nome = nome;
	}
	public void setClassificacao(String classificacao) {
		if (nome.length() > 0)
			this.classificacao = classificacao;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CÃ³digo: ");
		builder.append(codigo);
		builder.append(" | Nome: ");
		builder.append(nome);
		builder.append(" | Fone: ");
		builder.append(fone);
		builder.append(" | Classificação: ");
		builder.append(classificacao);
		return builder.toString();
	}
	
}