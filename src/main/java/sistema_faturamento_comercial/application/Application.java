package sistema_faturamento_comercial.application;

import java.sql.Date;
import java.time.LocalDate;

import sistema_faturamento_comercial.domain.ClienteDomain;
import sistema_faturamento_comercial.service.ClienteService;

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
		LocalDate data =  LocalDate.now();
		
		ClienteDomain clienteDomain = new ClienteDomain();
		clienteDomain.setNome("nome");
		clienteDomain.setEmail("email");
		clienteDomain.setDocumento("documento");
		clienteDomain.setDataNascimento(data);
		new ClienteService().inserirCliente(clienteDomain);

		
	}

	
}
