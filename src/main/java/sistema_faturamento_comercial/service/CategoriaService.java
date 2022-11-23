package sistema_faturamento_comercial.service;

import java.util.List;

import sistema_faturamento_comercial.bo.ClienteBO;
import sistema_faturamento_comercial.domain.ClienteDomain;
import sistema_faturamento_comercial.util.NegocioException;

public class CategoriaService {

	
	public String inserirCategoria(ClienteDomain cliente) throws NegocioException {

		ClienteBO clienteBo = new ClienteBO();
		return clienteBo.incluirCliente(cliente);
	}

	public List<ClienteDomain> listarClientes() throws NegocioException{
		return new ClienteBO().listarClientes();
	}

	public String excluirCliente(Integer id) throws NegocioException {
		return new ClienteBO().excluirCliente(id);
	}

	public String alterarCliente(ClienteDomain cliente) throws NegocioException {
		return new ClienteBO().alterarCliente(cliente);
	}

	public ClienteDomain buscarClientePorId(Integer id) throws NegocioException {
		return new ClienteBO().buscarClientePorId(id);
	}
}
