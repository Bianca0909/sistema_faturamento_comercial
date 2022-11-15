package sistema_faturamento_comercial.application;

import java.util.List;

import javax.swing.JOptionPane;

import sistema_faturamento_comercial.domain.ExemploDomain;
import sistema_faturamento_comercial.service.ExemploService;
import sistema_faturamento_comercial.util.NegocioException;

public class Application {

	public static void main(String[] args) {

		// Exemplo de instanciação na classe main para teste de conexão com banco de
		// dados
		// Testar tudo aqui antes de fazer o JFrame
		ExemploDomain exemploDomain = new ExemploDomain();
		exemploDomain.setNome("exemplo");

		new ExemploService().inserirExemplo(exemploDomain);

		try {
			ExemploDomain exemplo = new ExemploService().buscarExemploPorId(2);
			JOptionPane.showMessageDialog(null, "Exemplo encontrado: " + exemplo.getId() + exemplo.getNome());
		} catch (NegocioException e) {
			e.printStackTrace();
		}
	}

}
