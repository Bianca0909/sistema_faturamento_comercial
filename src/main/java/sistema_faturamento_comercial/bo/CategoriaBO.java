package sistema_faturamento_comercial.bo;

import java.util.List;

import sistema_faturamento_comercial.dao.CategoriaDAO;
import sistema_faturamento_comercial.domain.CategoriaDomain;
import sistema_faturamento_comercial.util.NegocioException;

public class CategoriaBO {

	public void incluirCategoria(CategoriaDomain categoria) {

		CategoriaDAO CategoriaDao = new CategoriaDAO();
		 CategoriaDao.inserirCategoria(categoria);
	}

	public List<CategoriaDomain> listarCategorias() {
		return new CategoriaDAO().listarCategoria();
	}

	public void excluirCategoria(Integer id) {
		 new CategoriaDAO().excluirCategoria(id);
	}

	public void alterarCategoria(CategoriaDomain categoria) {
		 new CategoriaDAO().alterarCategoria(categoria);
	}

	public CategoriaDomain buscarCategoriaPorId(Integer id) throws NegocioException {
		return new CategoriaDAO().buscarCategoriaPorId(id);
	}
}
