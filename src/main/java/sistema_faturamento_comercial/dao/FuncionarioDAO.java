package sistema_faturamento_comercial.dao;

import java.math.BigDecimal;
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

//	public List<FuncionarioDomain> listarFuncionarios () throws NegocioException {
//		String sql = "SELECT id, nome, pis, documento, salario, funcao FROM funcionario ORDER BY id";
//		
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		List<FuncionarioDomain> resultado = new ArrayList<FuncionarioDomain>();
//			ps = ConfigConexao.getConexao().prepareStatement(sql);
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				FuncionarioDomain funcionario = new FuncionarioDomain(rs.getInt("id")), rs.getString("nome"), 
//						 rs.getDocumento("documento"), rs.getPis("pis"), BigDecimal.valueOf(rs.getSalario("salario")), rs.getFuncao("funcao"));
//			}
//	}
}
