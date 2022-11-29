package sistema_faturamento_comercial.bo;

import java.util.List;

import sistema_faturamento_comercial.dao.CompraProdutoDAO;
import sistema_faturamento_comercial.domain.CompraProdutoDomain;

public class CompraProdutoBO {

	public void incluirCompraProduto(CompraProdutoDomain CompraProduto) {

		CompraProdutoDAO CompraProdutoDao = new CompraProdutoDAO();
		CompraProdutoDao.inserirCompraProduto(CompraProduto);
	}

	public List<CompraProdutoDomain> listarCompraProdutos() {
		return new CompraProdutoDAO().listarCompraProdutos();
	}

	public void excluirCompraProduto(Integer id) {
		 new CompraProdutoDAO().excluirCompraProduto(id);
	}

	public void alterarCompraProduto(CompraProdutoDomain CompraProduto) {
		 new CompraProdutoDAO().alterarCompraProduto(CompraProduto);
	}

}
