package sistema_faturamento_comercial.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import sistema_faturamento_comercial.config.ConfigConexao;
import sistema_faturamento_comercial.domain.EnderecoDomain;
import sistema_faturamento_comercial.util.NegocioException;

public class EnderecoDAO {

	public void inserirEndereco(EnderecoDomain endereco) throws NegocioException {

		String sqlInsert = "INSERT INTO endereco(pais, estado, cidade, cep, bairro, rua, numero, complemento) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			Connection connection = ConfigConexao.getConexao();
			PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);

			preparedStatement.setString(1, endereco.getPais());
			preparedStatement.setString(2, endereco.getEstado());
			preparedStatement.setString(3, endereco.getCidade());
			preparedStatement.setString(4, endereco.getCep());
			preparedStatement.setString(5, endereco.getBairro());
			preparedStatement.setString(6, endereco.getRua());
			preparedStatement.setLong(7, endereco.getNumero());
			preparedStatement.setString(8, endereco.getComplemento());
			preparedStatement.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Endereço cadastrado com sucesso");
	}

	public void excluirEndereco(Integer id) throws NegocioException {

		String sql = "DELETE FROM endereco WHERE id =?";

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
		 JOptionPane.showMessageDialog(null, "Endereço excluido com sucesso");
	}

	public List<EnderecoDomain> listarEndereços() throws NegocioException {
		String sql = "SELECT id, pais, estado, cidade, cep, bairro, rua, numero, complemento FROM endereco ORDER BY id";

		PreparedStatement ps = null;
		ResultSet rs = null;
		List<EnderecoDomain> resultado = new ArrayList<EnderecoDomain>();
		try {
			ps = ConfigConexao.getConexao().prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				EnderecoDomain endereco = new EnderecoDomain(rs.getInt("id"), rs.getString("pais"),
						rs.getString("estado"), rs.getString("cidade"), rs.getString("cep"), rs.getString("bairro"), rs.getString("rua"),
						rs.getLong("numero"), rs.getString("complemento"));
				resultado.add(endereco);
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

	public void alterarEndereco(EnderecoDomain endereco) throws NegocioException {
		String sql = "UPDATE endereco SET pais = ?, estado = ?, cidade = ?, cep = ?, bairro = ?, rua = ?, numero = ?, complemento =? WHERE id =?";
		PreparedStatement ps = null;
		try {
			ps = ConfigConexao.getConexao().prepareStatement(sql);

			ps.setString(1, endereco.getPais());
			ps.setString(2, endereco.getEstado());
			ps.setString(3, endereco.getCidade());
			ps.setString(4, endereco.getCep());
			ps.setString(5, endereco.getBairro());
			ps.setString(6, endereco.getRua());
			ps.setLong(7, endereco.getNumero());
			ps.setString(8, endereco.getComplemento());
			ps.setInt(9, endereco.getId());
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

		 JOptionPane.showMessageDialog(null, "Endereço alterado com sucesso");
	}

	public EnderecoDomain buscarEnderecoPorId(Integer id) throws NegocioException {
		String sql = "SELECT id, pais, estado, cidade, cep, bairro, rua, numero, complemento FROM endereco WHERE id = ?";

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = ConfigConexao.getConexao().prepareStatement(sql);
			ps.setInt(1, id);

			EnderecoDomain enderecoEncontrado = null;

			rs = ps.executeQuery();

			if (rs.next()) {
				enderecoEncontrado = new EnderecoDomain();
				enderecoEncontrado.setId(rs.getInt("id"));
				enderecoEncontrado.setPais(rs.getString("pais"));
				enderecoEncontrado.setEstado(rs.getString("estado"));
				enderecoEncontrado.setCidade(rs.getString("cidade"));
				enderecoEncontrado.setCep(rs.getString("cep"));
				enderecoEncontrado.setBairro(rs.getString("bairro"));
				enderecoEncontrado.setRua(rs.getString("rua"));
				enderecoEncontrado.setNumero(rs.getLong("numero"));
				enderecoEncontrado.setComplemento(rs.getString("complemento"));
			}
			return enderecoEncontrado;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new NegocioException("Erro ao buscar endereço por id");
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
