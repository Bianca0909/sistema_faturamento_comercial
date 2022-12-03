package sistema_faturamento_comercial.service;

import java.util.List;

import javax.swing.JOptionPane;

import sistema_faturamento_comercial.bo.ProdutoBO;
import sistema_faturamento_comercial.domain.ProdutoDomain;
import sistema_faturamento_comercial.util.NegocioException;

public class ProdutoService {

	public String inserirProduto(ProdutoDomain produto) throws NegocioException {
 
		ProdutoBO produtoBo = new ProdutoBO();
		return produtoBo.incluirProduto(produto);
	}

	public List<ProdutoDomain> listarProdutos() throws NegocioException{
		return new ProdutoBO().listarProdutos();
	}

	public String excluirProduto(Integer id) throws NegocioException {
		return new ProdutoBO().excluirProduto(id);
	}

	public String alterarProduto(ProdutoDomain produto) throws NegocioException {
		return new ProdutoBO().alterarProduto(produto);
	}

	public ProdutoDomain buscarProdutoPorId(Integer id) throws NegocioException {
		return new ProdutoBO().buscarProdutoPorId(id);
	}

	public void decrementaQuantidade(ProdutoDomain produto, Integer quantidadeVendida) throws NegocioException {
		Integer quantidadeAtual;

		quantidadeAtual = produto.getQuantidade() - quantidadeVendida;
		produto.setQuantidade(quantidadeAtual);
	}

	public void acrescentaQuantidade(ProdutoDomain produto, Integer quantidadeVendida) throws NegocioException {
		Integer quantidadeAtual;

		quantidadeAtual = produto.getQuantidade() + quantidadeVendida;
		produto.setQuantidade(quantidadeAtual);

	}
}
