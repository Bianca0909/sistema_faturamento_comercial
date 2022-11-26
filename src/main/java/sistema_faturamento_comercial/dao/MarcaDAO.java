package sistema_faturamento_comercial.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import sistema_faturamento_comercial.config.ConfigConexao;
import sistema_faturamento_comercial.domain.MarcaDomain;
import sistema_faturamento_comercial.util.NegocioException;

public class MarcaDAO {

	private String sqlInsert = "INSERT INTO marca(nome) values(?)";

	public void inserirMarca(MarcaDomain marca) {
		try {
			Connection connection = ConfigConexao.getConexao(); // Chama conexão com o database
			PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert); // chama o comando

			preparedStatement.setString(1, marca.getNome()); // Seta os dados
			preparedStatement.execute(); // Executa o sql

		} catch (Exception e) {
			System.err.print(e.getMessage()); // Mensagem de erro caso o Try der errado
		}
		JOptionPane.showMessageDialog(null, "Marca cadastrada com sucesso");
	}

	// Exemplo de exclusão
	public void excluirMarca(Integer id) {

		String sql = "DELETE FROM marca WHERE id = ?";

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
		JOptionPane.showMessageDialog(null,  "Marca excluída com sucesso");
	}
	// Exemplo de listagem

	public List<MarcaDomain> listarMarca() {

		String sql = "SELECT id, nome FROM marca ORDER BY id";

		PreparedStatement ps = null;
		ResultSet rs = null;

		List<MarcaDomain> resultado = new ArrayList<MarcaDomain>();

		try {
			ps = ConfigConexao.getConexao().prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				MarcaDomain marca = new MarcaDomain(rs.getInt("id"), rs.getString("nome"));
				resultado.add(marca);
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
	public void alterarMarca(MarcaDomain marca) {

		String sql = "UPDATE marca SET nome = ? WHERE id = ?";

		PreparedStatement ps = null;

		try {
			ps = ConfigConexao.getConexao().prepareStatement(sql);

			ps.setString(1, marca.getNome());
			ps.setInt(2, marca.getId());
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

		JOptionPane.showMessageDialog(null,  "Marca alterada com sucesso");
	}

	public MarcaDomain buscarMarcaPorId(Integer id) throws NegocioException {

		String sql = "SELECT id, nome FROM marca WHERE id = ?";

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = ConfigConexao.getConexao().prepareStatement(sql);
			ps.setLong(1, id);

			MarcaDomain marcaEncontrado = null;

			rs = ps.executeQuery();

			if (rs.next()) {
				marcaEncontrado = new MarcaDomain();
				marcaEncontrado.setId(rs.getInt("id"));
				marcaEncontrado.setNome(rs.getString("nome"));
			}

			return marcaEncontrado;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new NegocioException("Erro ao buscar marca por id");
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
