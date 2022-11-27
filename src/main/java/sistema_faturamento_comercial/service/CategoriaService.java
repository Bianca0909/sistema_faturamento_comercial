package sistema_faturamento_comercial.service;

import java.util.List;

import sistema_faturamento_comercial.bo.CategoriaBO;
import sistema_faturamento_comercial.domain.CategoriaDomain;
import sistema_faturamento_comercial.util.NegocioException;

public class CategoriaService {

	
	public void inserirCategoria(CategoriaDomain Categoria) throws NegocioException {

		CategoriaBO CategoriaBo = new CategoriaBO();
		 CategoriaBo.incluirCategoria(Categoria);
	}

	public List<CategoriaDomain> listarCategorias() throws NegocioException{
		return new CategoriaBO().listarCategorias();
	}

	public void excluirCategoria(Integer id) throws NegocioException {
		 new CategoriaBO().excluirCategoria(id);
	}

	public void alterarCategoria(CategoriaDomain Categoria) throws NegocioException {
		 new CategoriaBO().alterarCategoria(Categoria);
	}

	public CategoriaDomain buscarCategoriaPorId(Integer id) throws NegocioException {
		return new CategoriaBO().buscarCategoriaPorId(id);
	}
}
