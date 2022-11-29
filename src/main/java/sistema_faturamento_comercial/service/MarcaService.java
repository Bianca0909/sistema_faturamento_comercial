package sistema_faturamento_comercial.service;

import java.util.List;

import sistema_faturamento_comercial.bo.MarcaBO;
import sistema_faturamento_comercial.domain.MarcaDomain;
import sistema_faturamento_comercial.util.NegocioException;

public class MarcaService {

	// Marca de inserir entidade na camada service
	public void inserirMarca(MarcaDomain Marca) {

		MarcaBO MarcaBo = new MarcaBO();
		MarcaBo.incluirMarca(Marca);
	}

	public List<MarcaDomain> listarMarcas() throws NegocioException {
		return new MarcaBO().listarMarcas();
	}

	public void excluirMarca(Integer id) throws NegocioException {
		new MarcaBO().excluirMarca(id);
	}

	public void alterarMarca(MarcaDomain Marca) throws NegocioException {
		new MarcaBO().alterarMarca(Marca);
	}

	public MarcaDomain buscarMarcaPorId(Integer id) throws NegocioException {
		return new MarcaBO().buscarMarcaPorId(id);
	}

}
