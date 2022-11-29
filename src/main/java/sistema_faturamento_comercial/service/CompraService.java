package sistema_faturamento_comercial.service;

import java.util.List;

import sistema_faturamento_comercial.bo.CompraBO;
import sistema_faturamento_comercial.domain.CompraDomain;
import sistema_faturamento_comercial.util.NegocioException;

public class CompraService {

	
	public void inserirCompra(CompraDomain Compra) throws NegocioException {

		CompraBO CompraBo = new CompraBO();
		 CompraBo.incluirCompra(Compra);
	}

	public List<CompraDomain> listarCompras() throws NegocioException{
		return new CompraBO().listarCompras();
	}

	public void excluirCompra(Integer id) throws NegocioException {
		 new CompraBO().excluirCompra(id);
	}

	public void alterarCompra(CompraDomain Compra) throws NegocioException {
		 new CompraBO().alterarCompra(Compra);
	}

	public CompraDomain buscarCompraPorId(Integer id) throws NegocioException {
		return new CompraBO().buscarCompraPorId(id);
	}
}
