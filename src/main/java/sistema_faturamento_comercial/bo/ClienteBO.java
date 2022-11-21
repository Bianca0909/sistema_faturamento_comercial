package sistema_faturamento_comercial.bo;

import java.util.List;

import sistema_faturamento_comercial.dao.ClienteDAO;
import sistema_faturamento_comercial.domain.ClienteDomain;
import sistema_faturamento_comercial.util.NegocioException;

public class ClienteBO {
	
	public String incluirCliente(ClienteDomain cliente) throws NegocioException {

        ClienteDAO clienteDao = new ClienteDAO();
        return clienteDao.inserirCliente(cliente);
    }

    public List<ClienteDomain> listarClientes() throws NegocioException {
        return new ClienteDAO().listarClientes();
    }

    public String excluirCliente(Integer id) throws NegocioException {
        return new ClienteDAO().excluirCliente(id);
    }

    public String alterarCliente(ClienteDomain cliente) throws NegocioException{
        return new ClienteDAO().alterarCliente(cliente);
    }

    public ClienteDomain buscarClientePorId(Integer id) throws NegocioException {
        return new ClienteDAO().buscarClientePorId(id);
    }


}
