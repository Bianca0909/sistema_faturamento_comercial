package sistema_faturamento_comercial.service;

import java.util.List;

import sistema_faturamento_comercial.bo.ExemploBO;
import sistema_faturamento_comercial.domain.ExemploDomain;
import sistema_faturamento_comercial.util.NegocioException;

public class ExemploService {

	// Exemplo de inserir entidade na camada service
	public String inserirExemplo(ExemploDomain exemplo) {

		ExemploBO exemploBo = new ExemploBO();
		return exemploBo.incluirExemplo(exemplo);
	}

	public List<ExemploDomain> listarExemplo() {
		return new ExemploBO().listarExemplos();
	}

	public String excluirExemplo(Integer id) {
		return new ExemploBO().excluirExemplo(id);
	}

	public String alterarExemplo(ExemploDomain exemplo){
		return new ExemploBO().alterarExemplo(exemplo);
	}
	
	 public ExemploDomain buscarExemploPorId(Integer id) throws NegocioException {
	        return new ExemploBO().buscarExemploPorId(id);
	    }

}
