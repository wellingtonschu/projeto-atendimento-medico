public class Clientes {

	private int codigo;
	private String nome;
	private String email;
	private String fone;
	
	public Clientes(){
		
	}
	public Clientes(int codigo, String nome, String email, String fone){
		setCodigo(codigo);
		setNome(nome);
		setEmail(email);
		setFone(fone);
	}
	public int getCodigo() {
		return codigo;
	}
	public String getEmail() {
		return email;
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
	public void setEmail(String email) {
		if (email.length() > 0)
			this.email = email;
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
		builder.append(" | E-mail: ");
		builder.append(email);
		builder.append(" | Fone: ");
		builder.append(fone);
		return builder.toString();
	}
	
}