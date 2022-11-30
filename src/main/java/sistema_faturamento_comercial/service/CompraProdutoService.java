package sistema_faturamento_comercial.service;

import java.util.List;

import sistema_faturamento_comercial.bo.CompraProdutoBO;
import sistema_faturamento_comercial.domain.CompraProdutoDomain;
import sistema_faturamento_comercial.util.NegocioException;

public class CompraProdutoService {

	public void inserirCompraProduto(CompraProdutoDomain CompraProduto) throws NegocioException {

		CompraProdutoBO CompraProdutoBo = new CompraProdutoBO();
		CompraProdutoBo.incluirCompraProduto(CompraProduto);
	}

	public List<CompraProdutoDomain> listarCompraProdutos() throws NegocioException {
		return new CompraProdutoBO().listarCompraProdutos();
	}

	public void excluirCompraProduto(Integer id) throws NegocioException {
		new CompraProdutoBO().excluirCompraProduto(id);
	}

	public void alterarCompraProduto(CompraProdutoDomain CompraProduto) throws NegocioException {
		new CompraProdutoBO().alterarCompraProduto(CompraProduto);
	}

	public CompraProdutoDomain buscarCompraProdutoPorId(Integer id) throws NegocioException {
		return new CompraProdutoBO().buscarCompraProdutoPorId(id);
	}
}
