package sistema_faturamento_comercial.bo;

import java.util.List;

import sistema_faturamento_comercial.dao.ClienteDAO;
import sistema_faturamento_comercial.domain.ClienteDomain;
import sistema_faturamento_comercial.util.NegocioException;

public class ClienteBO {
	
	public String incluirCliente(ClienteDomain cliente) {

        ClienteDAO clienteDao = new ClienteDAO();
        return clienteDao.inserir(cliente);
    }

    public List<ClienteDomain> listarClientes() {
        return new ClienteDAO().listarClientes();
    }

    public String excluirCliente(Integer id) {
        return new ClienteDAO().excluir(id);
    }

    public String alterar(ClienteDomain cliente) {
        return new ClienteDAO().alterar(cliente);
    }

    public ClienteDomain buscarClientePorId(Integer id) throws NegocioException {
        return new ClienteDAO().buscarClientePorId(id);
    }


}
