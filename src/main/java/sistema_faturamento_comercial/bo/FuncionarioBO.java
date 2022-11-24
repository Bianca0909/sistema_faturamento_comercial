package sistema_faturamento_comercial.bo;

import java.util.List;

import sistema_faturamento_comercial.dao.ClienteDAO;
import sistema_faturamento_comercial.dao.FuncionarioDAO;
import sistema_faturamento_comercial.domain.ClienteDomain;
import sistema_faturamento_comercial.domain.FuncionarioDomain;
import sistema_faturamento_comercial.util.NegocioException;

public class FuncionarioBO {

	public String incluirFuncionario(FuncionarioDomain funcionario) throws NegocioException {

        FuncionarioDAO funcionarioDao = new FuncionarioDAO();
        return funcionarioDao.inserirFuncionario(funcionario);
    }

    public List<FuncionarioDomain> listarFuncionarios() throws NegocioException {
        return new FuncionarioDAO().listarFuncionarios();
    }

    public String excluirFuncionario(Integer id) throws NegocioException {
        return new FuncionarioDAO().excluirFuncionario(id);
    }

    public String alterarFuncionario(FuncionarioDomain funcionario) throws NegocioException{
        return new FuncionarioDAO().alterarFuncionario(funcionario);
    }

    public FuncionarioDomain buscarFuncionarioPorId(Integer id) throws NegocioException {
        return new FuncionarioDAO().buscarFuncionarioPorId(id);
    }
}
