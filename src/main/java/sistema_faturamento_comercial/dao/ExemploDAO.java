package sistema_faturamento_comercial.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sistema_faturamento_comercial.config.ConfigConexao;
import sistema_faturamento_comercial.domain.ExemploDomain;
import sistema_faturamento_comercial.util.NegocioException;

public class ExemploDAO {

	// Exemplo do sql para inserir a entidade (alterar conforme seus atributos)

	private String sqlInsert = "INSERT INTO exemplo(nome) values(?)";

	public String inserir(ExemploDomain exemplo) {
		try {
			Connection connection = ConfigConexao.getConexao(); // Chama conexão com o database
			PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert); // chama o comando

			preparedStatement.setString(1, exemplo.getNome()); // Seta os dados
			preparedStatement.execute(); // Executa o sql

		} catch (Exception e) {
			System.err.print(e.getMessage()); // Mensagem de erro caso o Try der errado
		}
		return "Exemplo cadastrado com sucesso";
	}

	//Exemplo de exclusão 
	public String excluir(Integer id) {

		String sql = "DELETE FROM exemplo WHERE id = ?";

		PreparedStatement ps = null;

		try {
			ps = ConfigConexao.getConexao().prepareStatement(sql);
			ps.setLong(1, id);

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
		return "Exemplo excluído com sucesso";
	}
	// Exemplo de listagem
	
	public List<ExemploDomain> listarExemplos() {

		String sql = "SELECT id, nome FROM exemplo ORDER BY id";

		PreparedStatement ps = null;
		ResultSet rs = null;

		List<ExemploDomain> resultado = new ArrayList<ExemploDomain>();

		try {
			ps = ConfigConexao.getConexao().prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				ExemploDomain exemplo = new ExemploDomain(rs.getInt("id"), rs.getString("nome"));
				resultado.add(exemplo);
			}
		} catch (SQLException e) {
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

	
	// Exemplo de alteração
	public String alterarColaborador(ExemploDomain exemplo) {

		String sql = "UPDATE exemplo SET nome = ? WHERE id = ?";

		PreparedStatement ps = null;

		try {
			ps = ConfigConexao.getConexao().prepareStatement(sql);
		
			ps.setString(1, exemplo.getNome());
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

		return "Exemplo alterado com sucesso";
	}

	public ExemploDomain buscarExemploPorId(Integer id) throws NegocioException {

		String sql = "SELECT id, nome FROM exemplo WHERE id = ?";

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = ConfigConexao.getConexao().prepareStatement(sql);
			ps.setLong(1, id);

			ExemploDomain exemploEncontrado = null;

			rs = ps.executeQuery();

			if (rs.next()) {
				exemploEncontrado = new ExemploDomain();
				exemploEncontrado.setId(rs.getInt("id"));
				exemploEncontrado.setNome(rs.getString("nome"));
			}

			return exemploEncontrado;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new NegocioException("Erro ao buscar exemplo por id");
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
