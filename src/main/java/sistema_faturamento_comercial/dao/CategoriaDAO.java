package sistema_faturamento_comercial.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import sistema_faturamento_comercial.config.ConfigConexao;
import sistema_faturamento_comercial.domain.CategoriaDomain;
import sistema_faturamento_comercial.util.NegocioException;

public class CategoriaDAO {

	private String sqlInsert = "INSERT INTO categoria(nome) values(?)";

	public void inserirCategoria(CategoriaDomain categoria) {
		try {
			Connection connection = ConfigConexao.getConexao(); 
			PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert); 

			preparedStatement.setString(1, categoria.getNome()); 
			preparedStatement.execute(); 

		} catch (Exception e) {
			System.err.print(e.getMessage()); 
		}
		JOptionPane.showMessageDialog(null, "Categoria cadastrada com sucesso");
	}

	public void excluirCategoria(Integer id) {

		String sql = "DELETE FROM categoria WHERE id = ?";

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
		JOptionPane.showMessageDialog(null, "Categoria excluída com sucesso");
	}

	public List<CategoriaDomain> listarCategoria() {

		String sql = "SELECT id, nome FROM categoria ORDER BY id";

		PreparedStatement ps = null;
		ResultSet rs = null;

		List<CategoriaDomain> resultado = new ArrayList<CategoriaDomain>();

		try {
			ps = ConfigConexao.getConexao().prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				CategoriaDomain Categoria = new CategoriaDomain(rs.getInt("id"), rs.getString("nome"));
				resultado.add(Categoria);
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

	public void alterarCategoria(CategoriaDomain categoria) {

		String sql = "UPDATE categoria SET nome = ? WHERE id = ?";

		PreparedStatement ps = null;

		try {
			ps = ConfigConexao.getConexao().prepareStatement(sql);

			ps.setString(1, categoria.getNome());
			ps.setInt(2, categoria.getId());
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

		JOptionPane.showMessageDialog(null, "Categoria alterada com sucesso");
	}

	public CategoriaDomain buscarCategoriaPorId(Integer id) throws NegocioException {

		String sql = "SELECT id, nome FROM categoria WHERE id = ?";

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = ConfigConexao.getConexao().prepareStatement(sql);
			ps.setLong(1, id);

			CategoriaDomain categoriaEncontrado = null;

			rs = ps.executeQuery();

			if (rs.next()) {
				categoriaEncontrado = new CategoriaDomain();
				categoriaEncontrado.setId(rs.getInt("id"));
				categoriaEncontrado.setNome(rs.getString("nome"));
			}

			return categoriaEncontrado;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new NegocioException("Erro ao buscar categoria por id");
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
