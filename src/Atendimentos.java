public class Atendimentos {

	private int codigo;
	private int codigoPaciente;
	private int codigoMedico;

	ListPacientes listaPac = new ListPacientes(ManipXML.PaclerXMLCOM());
	ListMedicos listaMed = new ListMedicos(ManipXML.MedlerXMLCOM());
	
	public Atendimentos(){
		
	}
	public Atendimentos(int codigo, int codigoPaciente, int codigoMedico){
		setCodigo(codigo);
		setCodigoPaciente(codigoPaciente);
		setCodigoMedico(codigoMedico);
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCodigoPaciente() {
		return codigoPaciente;
	}
	public String getCodigoPacienteText() {
		return String.valueOf(codigoPaciente);
	}
	public void setCodigoPaciente(int codigoPaciente) {
		this.codigoPaciente = codigoPaciente;
	}
	public int getCodigoMedico() {
		return codigoMedico;
	}
	public String getCodigoMedicoText() {
		return String.valueOf(codigoMedico);
	}
	public void setCodigoMedico(int codigoMedico) {
		this.codigoMedico = codigoMedico;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("C�digo: ");
		builder.append(codigo);
		builder.append("\nM�dico | C�digo: ");
		builder.append(listaMed.lista.get(codigo).getCodigo());
		builder.append("   -   Nome: ");
		builder.append(listaMed.lista.get(codigo).getNome());
		builder.append("   -   Fone: ");
		builder.append(listaMed.lista.get(codigo).getFone());
		builder.append("\nPaciente | C�digo: ");
		builder.append(listaPac.lista.get(codigo).getCodigo());
		builder.append("   -   Nome: ");
		builder.append(listaPac.lista.get(codigo).getNome());
		builder.append("   -   Fone: ");
		builder.append(listaPac.lista.get(codigo).getFone());
		builder.append("   -   Classifica��o: ");
		builder.append(listaPac.lista.get(codigo).getClassificacao());
		return builder.toString();
	}
	
}