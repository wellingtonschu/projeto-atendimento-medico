import java.io.Serializable;

public class Medicos implements Serializable{

	private int codigo;
	private String nome;
	private String fone;
	
	public Medicos(){
		
	}
	public Medicos(int codigo, String nome, String fone){
		setCodigo(codigo);
		setNome(nome);
		setFone(fone);
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
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Código: ");
		builder.append(codigo);
		builder.append(" | Nome: ");
		builder.append(nome);
		builder.append(" | Fone: ");
		builder.append(fone);
		return builder.toString();
	}
	
}