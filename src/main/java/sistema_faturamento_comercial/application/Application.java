package sistema_faturamento_comercial.application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import sistema_faturamento_comercial.domain.FuncionarioDomain;
import sistema_faturamento_comercial.service.FuncionarioService;
import sistema_faturamento_comercial.util.NegocioException;

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
	
	List<FuncionarioDomain> funcionarios;
	try {
		funcionarios = new FuncionarioService().listarFuncionarios();
		for(FuncionarioDomain funcionarioDomain: funcionarios) {
			System.out.println("Id: "+ funcionarioDomain.getId());
		}
	} catch (NegocioException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
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
//		LocalDate date = LocalDate.now();
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//		String dateString = date.format(formatter);
//		System.out.println(dateString);
		
	}
}
