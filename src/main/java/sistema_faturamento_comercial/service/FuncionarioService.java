package sistema_faturamento_comercial.service;

import java.util.List;

import sistema_faturamento_comercial.bo.ClienteBO;
import sistema_faturamento_comercial.bo.FuncionarioBO;
import sistema_faturamento_comercial.domain.ClienteDomain;
import sistema_faturamento_comercial.domain.FuncionarioDomain;
import sistema_faturamento_comercial.util.NegocioException;

public class FuncionarioService {

	public String inserirFuncionario(FuncionarioDomain funcionario) throws NegocioException {

		FuncionarioBO funcionarioBo = new FuncionarioBO();
		return funcionarioBo.incluirFuncionario(funcionario);
	}

	public List<FuncionarioDomain> listarFuncionarios() throws NegocioException{
		return new FuncionarioBO().listarFuncionarios();
	}

	public String excluirFuncionario(Integer id) throws NegocioException {
		return new FuncionarioBO().excluirFuncionario(id);
	}

	public String alterarCliente(FuncionarioDomain funcionario) throws NegocioException {
		return new FuncionarioBO().alterarFuncionario(funcionario);
	}

	public FuncionarioDomain buscarFuncionarioPorId(Integer id) throws NegocioException {
		return new FuncionarioBO().buscarFuncionarioPorId(id);
	}
}
