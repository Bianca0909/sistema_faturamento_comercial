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
import sistema_faturamento_comercial.util.NegocioException;

public class CompraDAO {

	private String sqlInsert = "INSERT INTO compra(data, forma_pagamento, endereco_id, cliente_id) VALUES(?, ?, ?, ?)";

	public void inserirCompra(CompraDomain compra) {
		try {
			Connection connection = ConfigConexao.getConexao();
			PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);

			preparedStatement.setDate(1, Date.valueOf(compra.getDataCompra()));
			preparedStatement.setString(2, compra.getFormaPagamento());
			preparedStatement.setInt(3, compra.getEnderecoId());
			preparedStatement.setInt(4, compra.getClienteId());
			preparedStatement.execute();

		} catch (Exception e) {
			System.err.print(e.getMessage());
		}
	}

	public void excluirCompra(Integer id) {

		String sql = "DELETE FROM compra WHERE id = ?";

		PreparedStatement ps = null;

		try {
			ps = ConfigConexao.getConexao().prepareStatement(sql);
			ps.setLong(1, id);

			ps.execute();

			JOptionPane.showMessageDialog(null, "Compra excluída com sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Erro: A compra " + id + " não pode ser excluída com itens ainda vinculados");
//			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();

			}
		}

	}

	public List<CompraDomain> listarCompras() {

		String sql = "SELECT id, data, forma_pagamento, endereco_id, cliente_id FROM compra ORDER BY id";

		PreparedStatement ps = null;
		ResultSet rs = null;

		List<CompraDomain> resultado = new ArrayList<CompraDomain>();

		try {
			ps = ConfigConexao.getConexao().prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				CompraDomain compra = new CompraDomain(rs.getInt("id"), rs.getDate("data").toLocalDate(),
						rs.getString("forma_pagamento"), rs.getInt("endereco_id"), rs.getInt("cliente_id"));
				resultado.add(compra);
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

	public void alterarCompra(CompraDomain compra) {

		String sql = "UPDATE compra SET data = ?, forma_pagamento = ?, endereco_id = ?, cliente_id = ?  WHERE id = ?";

		PreparedStatement ps = null;

		try {
			ps = ConfigConexao.getConexao().prepareStatement(sql);

			ps.setDate(1, Date.valueOf(compra.getDataCompra()));
			ps.setString(2, compra.getFormaPagamento());
			ps.setInt(3, compra.getEnderecoId());
			ps.setInt(4, compra.getClienteId());
			ps.setInt(5, compra.getId());
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

	public CompraDomain buscarCompraPorId(Integer id) throws NegocioException {

		String sql = "SELECT id, data, forma_pagamento, endereco_id, cliente_id FROM compra WHERE id = ?";

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = ConfigConexao.getConexao().prepareStatement(sql);
			ps.setLong(1, id);

			CompraDomain compraEncontrada = null;

			rs = ps.executeQuery();

			if (rs.next()) {
				compraEncontrada = new CompraDomain();
				compraEncontrada.setId(rs.getInt("id"));
				compraEncontrada.setDataCompra(rs.getDate("data").toLocalDate());
				compraEncontrada.setFormaPagamento(rs.getString("forma_pagamento"));
				compraEncontrada.setEnderecoId(rs.getInt("endereco_id"));
				compraEncontrada.setClienteId(rs.getInt("cliente_id"));
			}

			return compraEncontrada;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new NegocioException("Erro ao buscar compra por id");
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
