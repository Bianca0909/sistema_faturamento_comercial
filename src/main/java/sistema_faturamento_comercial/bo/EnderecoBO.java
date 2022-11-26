package sistema_faturamento_comercial.bo;

import java.util.List;

import sistema_faturamento_comercial.dao.EnderecoDAO;
import sistema_faturamento_comercial.domain.EnderecoDomain;
import sistema_faturamento_comercial.util.NegocioException;

public class EnderecoBO {
	
	public void incluirEndereco(EnderecoDomain endereco) throws NegocioException {

        EnderecoDAO enderecoDao = new EnderecoDAO();
         enderecoDao.inserirEndereco(endereco);
    }

    public List<EnderecoDomain> listarEnderecos() throws NegocioException {
        return new EnderecoDAO().listarEndereços();
    }

    public void excluirEnderecos(Integer id) throws NegocioException {
         new EnderecoDAO().excluirEndereco(id);
    }

    public void alterarEndereco(EnderecoDomain endereco) throws NegocioException{
         new EnderecoDAO().alterarEndereco(endereco);
    }

    public EnderecoDomain buscarEnderecosPorId(Integer id) throws NegocioException {
        return new EnderecoDAO().buscarEnderecoPorId(id);
    }

}
