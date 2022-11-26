package sistema_faturamento_comercial.bo;

import java.util.List;

import sistema_faturamento_comercial.dao.MarcaDAO;
import sistema_faturamento_comercial.domain.MarcaDomain;
import sistema_faturamento_comercial.util.NegocioException;

public class MarcaBO {
	// Camada BO (Objeto de negócio)
	public void incluirMarca(MarcaDomain Marca) {

		MarcaDAO MarcaDao = new MarcaDAO();
		 MarcaDao.inserirMarca(Marca);
	}

	public List<MarcaDomain> listarMarcas() {
		return new MarcaDAO().listarMarca();
	}

	public void excluirMarca(Integer id) {
		 new MarcaDAO().excluirMarca(id);
	}

	public void alterarMarca(MarcaDomain Marca) {
		 new MarcaDAO().alterarMarca(Marca);
	}

	public MarcaDomain buscarMarcaPorId(Integer id) throws NegocioException {
		return new MarcaDAO().buscarMarcaPorId(id);
	}
}
