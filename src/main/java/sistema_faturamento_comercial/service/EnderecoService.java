package sistema_faturamento_comercial.service;

import java.util.List;

import sistema_faturamento_comercial.bo.EnderecoBO;
import sistema_faturamento_comercial.domain.EnderecoDomain;
import sistema_faturamento_comercial.util.NegocioException;

public class EnderecoService {

	public String inserirEndereco(EnderecoDomain endereco) throws NegocioException {

		EnderecoBO enderecoBo = new EnderecoBO();
		return enderecoBo.incluirEndereco(endereco);
	}

	public List<EnderecoDomain> listarEnderecos() throws NegocioException{
		return new EnderecoBO().listarEnderecos();
	}

	public String excluirEndereco(Integer id) throws NegocioException {
		return new EnderecoBO().excluirEnderecos(id);
	}

	public String alterarEndereco(EnderecoDomain cliente) throws NegocioException {
		return new EnderecoBO().alterarEnderecos(cliente);
	}

	public EnderecoDomain buscarClientePorId(Integer id) throws NegocioException {
		return new EnderecoBO().buscarEnderecosPorId(id);
	}

}
