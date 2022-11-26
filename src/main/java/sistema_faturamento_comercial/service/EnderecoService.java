package sistema_faturamento_comercial.service;

import java.util.List;

import sistema_faturamento_comercial.bo.EnderecoBO;
import sistema_faturamento_comercial.domain.EnderecoDomain;
import sistema_faturamento_comercial.util.NegocioException;

public class EnderecoService {

	public void inserirEndereco(EnderecoDomain endereco) throws NegocioException {

		EnderecoBO enderecoBo = new EnderecoBO();
		 enderecoBo.incluirEndereco(endereco);
	}

	public List<EnderecoDomain> listarEnderecos() throws NegocioException{
		return new EnderecoBO().listarEnderecos();
	}

	public void excluirEndereco(Integer id) throws NegocioException {
		 new EnderecoBO().excluirEnderecos(id);
	}

	public void alterarEndereco(EnderecoDomain cliente) throws NegocioException {
		 new EnderecoBO().alterarEndereco(cliente);
	}

	public EnderecoDomain buscarEnderecoPorId(Integer id) throws NegocioException {
		return new EnderecoBO().buscarEnderecosPorId(id);
	}

}
