package sistema_faturamento_comercial.service;

import java.util.List;

import sistema_faturamento_comercial.bo.ProdutoBO;
import sistema_faturamento_comercial.domain.ProdutoDomain;
import sistema_faturamento_comercial.util.NegocioException;

public class ProdutoService {

	public String inserirProduto(ProdutoDomain Produto) throws NegocioException {

		ProdutoBO produtoBo = new ProdutoBO();
		return produtoBo.incluirProduto(Produto);
	}

	public List<ProdutoDomain> listarProdutos() throws NegocioException{
		return new ProdutoBO().listarProdutos();
	}

	public String excluirProduto(Integer id) throws NegocioException {
		return new ProdutoBO().excluirProduto(id);
	}

	public String alterarProduto(ProdutoDomain Produto) throws NegocioException {
		return new ProdutoBO().alterarProduto(Produto);
	}

	public ProdutoDomain buscarProdutoPorId(Integer id) throws NegocioException {
		return new ProdutoBO().buscarProdutoPorId(id);
	}

}
