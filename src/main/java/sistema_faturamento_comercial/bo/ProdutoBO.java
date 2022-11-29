package sistema_faturamento_comercial.bo;

import java.util.List;

import sistema_faturamento_comercial.dao.ProdutoDAO;
import sistema_faturamento_comercial.domain.ProdutoDomain;
import sistema_faturamento_comercial.util.NegocioException;

public class ProdutoBO {
	
	public String incluirProduto(ProdutoDomain Produto) throws NegocioException {

        ProdutoDAO produtoDao = new ProdutoDAO();
        return produtoDao.inserirProduto(Produto);
    }

    public List<ProdutoDomain> listarProdutos() throws NegocioException {
        return new ProdutoDAO().listarProdutos();
    }

    public String excluirProduto(Integer id) throws NegocioException {
        return new ProdutoDAO().excluirProduto(id);
    }

    public String alterarProduto(ProdutoDomain Produto) throws NegocioException{
        return new ProdutoDAO().alterarProduto(Produto);
    }

    public ProdutoDomain buscarProdutoPorId(Integer id) throws NegocioException {
        return new ProdutoDAO().buscarProdutoPorId(id);
    }


}
