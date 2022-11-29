package sistema_faturamento_comercial.bo;

import java.util.List;

import sistema_faturamento_comercial.dao.CompraDAO;
import sistema_faturamento_comercial.dao.CompraDAO;
import sistema_faturamento_comercial.domain.CompraDomain;
import sistema_faturamento_comercial.domain.CompraDomain;
import sistema_faturamento_comercial.util.NegocioException;

public class CompraBO {

	public void incluirCompra(CompraDomain compra) {

		CompraDAO compraDao = new CompraDAO();
		compraDao.inserirCompra(compra);
	}

	public List<CompraDomain> listarCompras() {
		return new CompraDAO().listarCompras();
	}

	public void excluirCompra(Integer id) {
		 new CompraDAO().excluirCompra(id);
	}

	public void alterarCompra(CompraDomain Compra) {
		 new CompraDAO().alterarCompra(Compra);
	}

	public CompraDomain buscarCompraPorId(Integer id) throws NegocioException {
		return new CompraDAO().buscarCompraPorId(id);
	}
}
