package sistema_faturamento_comercial.application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Application {

	public static void main(String[] args) {

		// Exemplo de instanciação na classe main para teste de conexão com banco de
		// dados
		// Testar tudo aqui antes de fazer o JFrame

//		ExemploDomain exemploDomain = new ExemploDomain();
//		exemploDomain.setNome("exemplo");
//
//		new ExemploService().inserirExemplo(exemploDomain);
//
//		try {
//			ExemploDomain exemplo = new ExemploService().buscarExemploPorId(2);
//			JOptionPane.showMessageDialog(null, "Exemplo encontrado: " + exemplo.getId() + exemplo.getNome());
//		} catch (NegocioException e) {
//			e.printStackTrace();
//		}

//		
//		ClienteDomain clienteDomain = new ClienteDomain();
//		clienteDomain.setNome("nome");
//		clienteDomain.setEmail("email");
//		clienteDomain.setDocumento("documento");
//		clienteDomain.setDataNascimento(data);
//		new ClienteService().inserirCliente(clienteDomain);
	
//	try {
//		new ClienteService().excluirCliente(2);
//	} catch (NegocioException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	
//	List<ClienteDomain> clientes;
//	try {
//		clientes = new ClienteService().listarClientes();
//		for(ClienteDomain clienteDomain: clientes) {
//			System.out.println("Id: "+ clienteDomain.getId()+ "| Nome: " + clienteDomain.getNome() + "| Email: " + clienteDomain.getEmail() 
//			+ "|Documento: " + clienteDomain.getDocumento() + "|Data de nascimento: " + clienteDomain.getDataNascimento());
//		}
//	} catch (NegocioException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//
	
//	
//	
//	ClienteDomain cliente;
//	try {
//		cliente = new ClienteService().buscarClientePorId(5);
//		cliente.setDataNascimento(data);
//		
//		 new ClienteService().alterarCliente(cliente);
//		JOptionPane.showMessageDialog(null, "Cliente encontrado: " + cliente.getDataNascimento());
//	} catch (NegocioException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}

//		String strFormatoBr = "20/10/2020";
//		SimpleDateFormat formatoBr = new SimpleDateFormat("dd-MM-yyyy");
//		SimpleDateFormat formatoEua = new SimpleDateFormat("MM-dd-yyyy");
//		
//		try {
//			Date data = formatoEua.parse(strFormatoBr);
//			System.out.println(data);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dateString = date.format(formatter);
		System.out.println(dateString);
		
		
	}
}
