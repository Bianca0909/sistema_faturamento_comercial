package sistema_faturamento_comercial.bo;

import java.util.List;

import sistema_faturamento_comercial.dao.ExemploDAO;
import sistema_faturamento_comercial.domain.ExemploDomain;
import sistema_faturamento_comercial.util.NegocioException;

public class ExemploBO {

	// Camada BO (Objeto de negócio)
	public String incluirExemplo(ExemploDomain exemplo) {

		ExemploDAO exemploDao = new ExemploDAO();
		return exemploDao.inserir(exemplo);
	}

	public List<ExemploDomain> listarExemplos() {
		return new ExemploDAO().listarExemplos();
	}

	public String excluirExemplo(Integer id) {
		return new ExemploDAO().excluir(id);
	}

	public String alterarExemplo(ExemploDomain exemplo) {
		return new ExemploDAO().alterarColaborador(exemplo);
	}
	
	public ExemploDomain buscarExemploPorId(Integer id) throws NegocioException {
        return new ExemploDAO().buscarExemploPorId(id);
    }
}
