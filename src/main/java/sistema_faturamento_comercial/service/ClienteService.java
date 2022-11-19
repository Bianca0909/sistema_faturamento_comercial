package sistema_faturamento_comercial.service;

import java.util.List;

import sistema_faturamento_comercial.bo.ClienteBO;
import sistema_faturamento_comercial.domain.ClienteDomain;
import sistema_faturamento_comercial.util.NegocioException;

public class ClienteService {

	public String inserirCliente(ClienteDomain cliente) {

		ClienteBO clienteBo = new ClienteBO();
		return clienteBo.incluirCliente(cliente);
	}

	public List<ClienteDomain> listarClientes() {
		return new ClienteBO().listarClientes();
	}

	public void excluirCliente(Integer id) {
		new ClienteBO().excluirCliente(id);
	}

	public String alterarCliente(ClienteDomain cliente) {
		return new ClienteBO().alterar(cliente);
	}

	public ClienteDomain buscarClientePorId(Integer id) throws NegocioException {
		return new ClienteBO().buscarClientePorId(id);
	}

}
