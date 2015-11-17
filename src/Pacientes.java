import java.io.Serializable;

public class Pacientes implements Serializable{

	private int codigo;
	private String nome;
	private String fone;
	private String classificacao;
	private String status;
	
	public Pacientes(){
		
	}
	public Pacientes(int codigo, String nome, String fone, String classificacao, String status){
		setCodigo(codigo);
		setNome(nome);
		setFone(fone);
		setClassificacao(classificacao);
		setStatus(status);
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
	public String getStatus(){
		return status;
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
	public void setStatus(String status){
		if(status.equals("1") || status.equals("0"))
			this.status = status;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Código: ");
		builder.append(codigo);
		builder.append(" | Nome: ");
		builder.append(nome);
		builder.append(" | Fone: ");
		builder.append(fone);
		builder.append(" | Classificação: ");
		builder.append(classificacao);
		builder.append(" | Status: ");
		builder.append(status);
		return builder.toString();
	}
	
}