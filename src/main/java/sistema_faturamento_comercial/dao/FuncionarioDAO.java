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
		String sqlInsert = "INSERT INTO funcionario(nome, pis, documento, salario, funcao, endereco_id) VALUES(?, ?, ?, ?, ?, ?)";

		try {
			Connection connection = ConfigConexao.getConexao();
			PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);

			preparedStatement.setString(1, funcionario.getNome());
			preparedStatement.setString(2, funcionario.getPis());
			preparedStatement.setString(3, funcionario.getDocumento());
			preparedStatement.setBigDecimal(4, funcionario.getSalario());
			preparedStatement.setString(5, funcionario.getFuncao());
			preparedStatement.setInt(6, funcionario.getEndereco());
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
		String sql = "SELECT id, nome, pis, documento, salario, funcao, endereco_id FROM funcionario ORDER BY id";

		PreparedStatement ps = null;
		ResultSet rs = null;
		List<FuncionarioDomain> resultado = new ArrayList<FuncionarioDomain>();
		try {
			ps = ConfigConexao.getConexao().prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {

				FuncionarioDomain funcionario = new FuncionarioDomain(rs.getInt("id"), rs.getString("nome"),
						rs.getString("documento"), rs.getString("pis"), rs.getBigDecimal("salario"),
						rs.getString("funcao"), rs.getInt("endereco_id"));
				resultado.add(funcionario);
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
		String sql = "UPDATE funcionario SET nome = ?, documento = ?, pis =?, salario = ?, funcao = ?, endereco_id =? WHERE id =?";
		PreparedStatement ps = null;
		try {
			ps = ConfigConexao.getConexao().prepareStatement(sql);

			ps.setString(1, funcionario.getNome());
			ps.setString(2, funcionario.getPis());
			ps.setString(3, funcionario.getDocumento());
			ps.setBigDecimal(4, funcionario.getSalario());
			ps.setString(5, funcionario.getFuncao());
			ps.setInt(6, funcionario.getEndereco());
			ps.setInt(7, funcionario.getId());
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
		String sql = "SELECT id, nome, pis, documento, salario, funcao, endereco_id FROM funcionario WHERE id = ?";

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
				funcionarioEncontrado.setEndereco(rs.getInt("endereco_id"));
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
