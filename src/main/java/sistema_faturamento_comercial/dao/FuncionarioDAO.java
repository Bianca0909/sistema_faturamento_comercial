package sistema_faturamento_comercial.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sistema_faturamento_comercial.config.ConfigConexao;
import sistema_faturamento_comercial.domain.FuncionarioDomain;
import sistema_faturamento_comercial.util.NegocioException;

public class FuncionarioDAO {

	public String inserirFuncionario(FuncionarioDomain funcionario) {
		String sqlInsert = "INSERT INTO funcionario(nome, pis, documento, salario, funcao) VALUES(?, ?, ?, ?, ?)";

		try {
			Connection connection = ConfigConexao.getConexao();
			PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);

			preparedStatement.setString(1, funcionario.getNome());
			preparedStatement.setString(2, funcionario.getPis());
			preparedStatement.setString(3, funcionario.getDocumento());
			preparedStatement.setBigDecimal(4, funcionario.getSalario());
			preparedStatement.setString(5, funcionario.getFuncao());
			preparedStatement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Funcionario cadastrado com sucesso";

	}

	public String excluirFuncionario(Integer id) throws NegocioException {

		String sql = "DELETE FROM funcionario WHERE id = ?";

		PreparedStatement ps = null;

		try {
			ps = ConfigConexao.getConexao().prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return "Funcionário excluído com sucesso";

	}

	public List<FuncionarioDomain> listarFuncionarios() throws NegocioException {
		String sql = "SELECT id, nome, pis, documento, salario, funcao FROM funcionario ORDER BY id";

		PreparedStatement ps = null;
		ResultSet rs = null;
		List<FuncionarioDomain> resultado = new ArrayList<FuncionarioDomain>();
		try {
			ps = ConfigConexao.getConexao().prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {

				FuncionarioDomain funcionario = new FuncionarioDomain(rs.getInt("id"), rs.getString("nome"),
						rs.getString("documento"), rs.getString("pis"), rs.getBigDecimal("salario"),
						rs.getString("funcao"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return resultado;
	}
	
	public String alterarFuncionario(FuncionarioDomain funcionario) throws NegocioException {
		String sql = "UPDATE funcionario SET nome = ?, documento = ?, pis =?, salario = ?, funcao = ? WHERE id =?";
		PreparedStatement ps = null;
		try {
			ps = ConfigConexao.getConexao().prepareStatement(sql);
			
			ps.setString(1, funcionario.getNome());
			ps.setString(2, funcionario.getDocumento());
			ps.setString(3, funcionario.getPis());
			ps.setBigDecimal(4, funcionario.getSalario());
			ps.setString(4, funcionario.getFuncao());
			ps.execute();
			
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return "Funcionário alterado com sucesso";
	}
	
	public FuncionarioDomain buscarFuncionarioPorId(Integer id) throws NegocioException {
		String sql = "SELECT id, nome, pis, documento, salario, funcao FROM funcionario WHERE id = ?";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = ConfigConexao.getConexao().prepareStatement(sql);
			ps.setInt(1, id);

			FuncionarioDomain funcionarioEncontrado = null;
			
			rs = ps.executeQuery();

			if (rs.next()) {
				funcionarioEncontrado = new FuncionarioDomain();
				funcionarioEncontrado.setId(rs.getInt("id"));
				funcionarioEncontrado.setNome(rs.getString("nome"));
				funcionarioEncontrado.setDocumento(rs.getString("documento"));
				funcionarioEncontrado.setPis(rs.getString("pis"));
				funcionarioEncontrado.setSalario(rs.getBigDecimal("salario"));
				funcionarioEncontrado.setFuncao(rs.getString("funcao"));
			}
			
			return funcionarioEncontrado;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new NegocioException("Erro ao buscar funcionário por id");
		} finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
