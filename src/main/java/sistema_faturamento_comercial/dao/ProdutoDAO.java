package sistema_faturamento_comercial.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sistema_faturamento_comercial.config.ConfigConexao;
import sistema_faturamento_comercial.domain.ProdutoDomain;
import sistema_faturamento_comercial.util.NegocioException;

public class ProdutoDAO {

	public String inserirProduto(ProdutoDomain produto) throws NegocioException {

		String sqlInsert = "INSERT INTO produto(nome, descricao, preco, quantidade, marca_id, categoria_id) VALUES(?, ?, ?, ?, ?, ?)";
		
		try {
			Connection connection = ConfigConexao.getConexao();
			PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);

			preparedStatement.setString(1, produto.getNome());
			preparedStatement.setString(2, produto.getDescricao());
			preparedStatement.setBigDecimal(3, produto.getPreco());
			preparedStatement.setInt(4, produto.getQuantidade());
			preparedStatement.setInt(5,produto.getMarcaId());
			preparedStatement.setInt(6,produto.getCategoriaId());
			preparedStatement.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "produto cadastrado com sucesso";
	}

	public String excluirProduto(Integer id) throws NegocioException {

		String sql = "DELETE FROM produto WHERE id = ?";

		PreparedStatement ps = null;
		try {
			ps = ConfigConexao.getConexao().prepareStatement(sql);
			ps.setInt(1, id);
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
		return "produto excluido com sucesso";
	}

	public List<ProdutoDomain> listarProdutos() throws NegocioException {
		String sql = "SELECT * FROM produto ORDER BY id";

		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ProdutoDomain> resultado = new ArrayList<ProdutoDomain>();
		try {
			ps = ConfigConexao.getConexao().prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				ProdutoDomain produto = new ProdutoDomain(rs.getInt("id"), rs.getString("nome"),rs.getString("descricao"),
						rs.getBigDecimal("preco"),rs.getInt("quantidade"),rs.getInt("marca_id"),rs.getInt("categoria_id"));
				resultado.add(produto);
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

	public String alterarProduto(ProdutoDomain produto) throws NegocioException {
		String sql = "UPDATE produto SET nome = ?, descricao = ?, preco = ?, quantidade = ?, marca_id = ?, categoria_id = ? WHERE id = ?";
		PreparedStatement ps = null;
		try {
			ps = ConfigConexao.getConexao().prepareStatement(sql);
			
			ps.setString(1, produto.getNome());
			ps.setString(2, produto.getDescricao());
			ps.setBigDecimal(3, produto.getPreco());
			ps.setInt(4, produto.getQuantidade());
			ps.setInt(5,produto.getMarcaId());
			ps.setInt(6,produto.getCategoriaId());
			ps.setInt(7, produto.getId());
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

		return "produto alterado com sucesso";
	}

	public ProdutoDomain buscarProdutoPorId(Integer id) throws NegocioException {
		String sql = "SELECT * FROM produto WHERE id = ?";

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = ConfigConexao.getConexao().prepareStatement(sql);
			ps.setInt(1, id);

			ProdutoDomain produtoEncontrado = null;

			rs = ps.executeQuery();

			if (rs.next()) {
				produtoEncontrado = new ProdutoDomain(rs.getInt("id"), rs.getString("nome"),rs.getString("descricao"),
						rs.getBigDecimal("preco"),rs.getInt("quantidade"),rs.getInt("marca_id"),rs.getInt("categoria_id"));
			}

			return produtoEncontrado;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new NegocioException("Erro ao buscar produto por id");
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