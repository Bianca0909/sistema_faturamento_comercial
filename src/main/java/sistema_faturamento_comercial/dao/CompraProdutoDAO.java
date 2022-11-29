package sistema_faturamento_comercial.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import sistema_faturamento_comercial.config.ConfigConexao;
import sistema_faturamento_comercial.domain.CompraDomain;
import sistema_faturamento_comercial.domain.CompraProdutoDomain;
import sistema_faturamento_comercial.util.NegocioException;

public class CompraProdutoDAO {

	private String sqlInsert = "INSERT INTO compra_produto(compra_id, produto_id, quantidade) VALUES(?, ?, ?, ?)";

	public void inserirCompraProduto(CompraProdutoDomain compraProduto) {
		try {
			Connection connection = ConfigConexao.getConexao(); 
			PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert); 

			preparedStatement.setInt(1, compraProduto.getCompraId());
			preparedStatement.setInt(2, compraProduto.getProdutoId());
			preparedStatement.setInt(3, compraProduto.getQuantidade());
			
			preparedStatement.execute(); 

		} catch (Exception e) {
			System.err.print(e.getMessage()); 
		}
	}

	public void excluirCompraProduto(Integer id) {

		String sql = "DELETE FROM compra_produto WHERE id = ?";

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
	}

	public List<CompraProdutoDomain> listarCompraProdutos() {

		String sql = "SELECT id, compra_id, produto_id, quantidade FROM compra_produto ORDER BY id";

		PreparedStatement ps = null;
		ResultSet rs = null;

		List<CompraProdutoDomain> resultado = new ArrayList<CompraProdutoDomain>();

		try {
			ps = ConfigConexao.getConexao().prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				CompraProdutoDomain compraProduto = new CompraProdutoDomain(rs.getInt("id"), rs.getInt("compra_id"), 
						rs.getInt("produto_id"), rs.getInt("quantidade"));
				resultado.add(compraProduto);
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

	public void alterarCompraProduto(CompraProdutoDomain compraProduto) {

		String sql = "UPDATE compra SET compra_id = ?, produto_id = ?, quantidade = ? WHERE id = ?";

		PreparedStatement ps = null;

		try {
			ps = ConfigConexao.getConexao().prepareStatement(sql);

			ps.setInt(1, compraProduto.getCompraId());
			ps.setInt(2, compraProduto.getProdutoId());
			ps.setInt(3, compraProduto.getQuantidade());
			ps.setInt(4, compraProduto.getId());
			ps.execute();
			
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

		JOptionPane.showMessageDialog(null, "Compra alterada com sucesso");
	}
	
}
