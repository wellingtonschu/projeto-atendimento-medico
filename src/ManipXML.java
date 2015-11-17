import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

public class ManipXML{

	final static String LOCALHOST = "xml/";
	
	
	public static boolean gravarXMLPaciente(List<Pacientes> lista){		//
		// Cria o elemento que ser� o root
		Element config = new Element("Pacientes");

		//define config como root
		Document documento = new Document(config);

		Element titulo = new Element("titulo");
		titulo.setText("Cadastro de Pacientes");

		Element data = new Element("data");
		data.setText(DataUtil.DataHoraForStringPadraoH(new Date()));
		
		config.addContent(titulo);
		config.addContent(data);
		
		for (int x = 0; x < lista.size(); x++){
			Element paciente = new Element("paciente");
			
			paciente.setAttribute("codigo", String.valueOf(lista.get(x).getCodigo()));
			
			Element nome = new Element("nome");
			nome.setText(lista.get(x).getNome());

			Element fone = new Element("fone");
			fone.setText(lista.get(x).getFone());
			
			Element classificacao = new Element("classificacao");
			classificacao.setText(lista.get(x).getClassificacao());
			
			Element status = new Element("status");
			status.setText(lista.get(x).getStatus());
						
			paciente.addContent(nome);
			paciente.addContent(fone);
			paciente.addContent(classificacao);
			paciente.addContent(status);
			config.addContent(paciente);			
		}

		//classe respons�vel para imprimir / gerar o xml
		XMLOutputter xout = new XMLOutputter();	
		try {
			//criando o arquivo de saida
			BufferedWriter arquivo = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(LOCALHOST +  "pacientes" + ".xml"),"UTF-8"));
			//imprimindo o xml no arquivo
			xout.output(documento, arquivo);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean gravarXMLMedico(List<Medicos> lista){		//
		// Cria o elemento que ser� o root
		Element config = new Element("Medicos");

		//define config como root
		Document documento = new Document(config);

		Element titulo = new Element("titulo");
		titulo.setText("Cadastro de Medicos");

		Element data = new Element("data");
		data.setText(DataUtil.DataHoraForStringPadraoH(new Date()));
		
		config.addContent(titulo);
		config.addContent(data);
		
		for (int x = 0; x < lista.size(); x++){
			Element medico = new Element("medico");
			
			medico.setAttribute("codigo", String.valueOf(lista.get(x).getCodigo()));
			
			Element nome = new Element("nome");
			nome.setText(lista.get(x).getNome());

			Element fone = new Element("fone");
			fone.setText(lista.get(x).getFone());
						
			medico.addContent(nome);
			medico.addContent(fone);
			config.addContent(medico);			
		}

		//classe respons�vel para imprimir / gerar o xml
		XMLOutputter xout = new XMLOutputter();	
		try {
			//criando o arquivo de saida
			BufferedWriter arquivo = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(LOCALHOST +  "medicos" + ".xml"),"UTF-8"));
			//imprimindo o xml no arquivo
			xout.output(documento, arquivo);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean gravarXMLAtendimento(List<Atendimentos> lista){		//
		// Cria o elemento que ser� o root
		Element config = new Element("Atendimentos");

		//define config como root
		Document documento = new Document(config);

		Element titulo = new Element("titulo");
		titulo.setText("Cadastro de Atendimentos");

		Element data = new Element("data");
		data.setText(DataUtil.DataHoraForStringPadraoH(new Date()));
		
		config.addContent(titulo);
		config.addContent(data);
		
		for (int x = 0; x < lista.size(); x++){
			Element atendimento = new Element("atendimento");
			
			atendimento.setAttribute("codigo", String.valueOf(lista.get(x).getCodigo()));
			
			Element codigoMedico = new Element("codigoMedico");
			codigoMedico.setText(lista.get(x).getCodigoMedicoText());

			Element codigoPaciente = new Element("codigoPaciente");
			codigoPaciente.setText(lista.get(x).getCodigoPacienteText());
						
			atendimento.addContent(codigoMedico);
			atendimento.addContent(codigoPaciente);
			config.addContent(atendimento);			
		}

		//classe respons�vel para imprimir / gerar o xml
		XMLOutputter xout = new XMLOutputter();	
		try {
			//criando o arquivo de saida
			BufferedWriter arquivo = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(LOCALHOST +  "atendimentos" + ".xml"),"UTF-8"));
			//imprimindo o xml no arquivo
			xout.output(documento, arquivo);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static List<Pacientes> PaclerXMLCOM(){
		List<Pacientes> listaPac = new ArrayList<Pacientes>();
		Document doc = null;
		SAXBuilder builder = new SAXBuilder();	
		try { 
			doc = builder.build(LOCALHOST + "pacientes" + ".xml");
		} catch (Exception e) {
			e.printStackTrace();
		}            
		Element config = doc.getRootElement();
		List lista = config.getChildren("paciente");
		
		for (Iterator iter = lista.iterator(); iter.hasNext();) {
			Element element = (Element) iter.next();
			Pacientes pac = new Pacientes();
			pac.setCodigo(Integer.parseInt(element.getAttributeValue("codigo")));
			pac.setNome(element.getChildText("nome"));
			pac.setFone(element.getChildText("fone"));
			pac.setClassificacao((element.getChildText("classificacao")));
			pac.setStatus((element.getChildText("status")));
			listaPac.add(pac);
		}
		return listaPac;
	}	
	public static List<Medicos> MedlerXMLCOM(){
		List<Medicos> listaMed = new ArrayList<Medicos>();
		Document doc = null;
		SAXBuilder builder = new SAXBuilder();	
		try { 
			doc = builder.build(LOCALHOST + "medicos" + ".xml");
		} catch (Exception e) {
			e.printStackTrace();
		}            
		Element config = doc.getRootElement();
		List lista = config.getChildren("medico");
		
		for (Iterator iter = lista.iterator(); iter.hasNext();) {
			Element element = (Element) iter.next();
			Medicos med = new Medicos();
			med.setCodigo(Integer.parseInt(element.getAttributeValue("codigo")));
			med.setNome(element.getChildText("nome"));
			med.setFone(element.getChildText("fone"));
			listaMed.add(med);
		}
		return listaMed;
	}
	public static List<Atendimentos> AtelerXMLCOM(){
		List<Atendimentos> listaAte = new ArrayList<Atendimentos>();
		Document doc = null;
		SAXBuilder builder = new SAXBuilder();	
		try { 
			doc = builder.build(LOCALHOST + "atendimentos" + ".xml");
		} catch (Exception e) {
			e.printStackTrace();
		}            
		Element config = doc.getRootElement();
		List lista = config.getChildren("atendimento");
		
		for (Iterator iter = lista.iterator(); iter.hasNext();) {
			Element element = (Element) iter.next();
			Atendimentos ate = new Atendimentos();
			ate.setCodigo(Integer.parseInt(element.getAttributeValue("codigo")));
			ate.setCodigoMedico(Integer.parseInt(element.getChildText("codigoMedico")));
			ate.setCodigoPaciente(Integer.parseInt(element.getChildText("codigoPaciente")));
			listaAte.add(ate);
		}
		return listaAte;
	}	
}