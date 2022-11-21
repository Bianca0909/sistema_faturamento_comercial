package sistema_faturamento_comercial.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import sistema_faturamento_comercial.config.ConfigConexao;
import sistema_faturamento_comercial.domain.ClienteDomain;
import sistema_faturamento_comercial.util.NegocioException;

public class ClienteDAO {
	
	
	private String sqlInsert = "INSERT INTO cliente(nome, email, documento, data_nascimento) VALUES(?, ?, ?, ?)";

	public String inserirCliente(ClienteDomain cliente) throws NegocioException {
		try {
			Connection connection = ConfigConexao.getConexao();
			PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
			
			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setString(2, cliente.getEmail());
			preparedStatement.setString(3, cliente.getDocumento());
			preparedStatement.setDate(4, Date.valueOf(cliente.getDataNascimento()));
			preparedStatement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Cliente cadastrado com sucesso";
	}

	public String excluirCliente(Integer id) throws NegocioException{

		String sql = "DELETE FROM cliente WHERE id = ?";

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
		return "Cliente excluido com sucesso";
	}

	public List<ClienteDomain> listarClientes() throws NegocioException {
		String sql = "SELECT id, nome, email, documento, data_nascimento FROM cliente ORDER BY id";

		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ClienteDomain> resultado = new ArrayList<ClienteDomain>();
		try {
			ps = ConfigConexao.getConexao().prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				ClienteDomain cliente = new ClienteDomain(rs.getInt("id"), rs.getString("nome"), rs.getString("email"),
						rs.getString("documento"), rs.getDate("data_nascimento").toLocalDate());
				resultado.add(cliente);
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

	public String alterarCliente(ClienteDomain cliente) throws NegocioException {
		String sql = "UPDATE cliente SET nome = ?, email = ?, documento = ?, data_nascimento = ? WHERE id = ?";
		PreparedStatement ps = null;
		try {
			ps = ConfigConexao.getConexao().prepareStatement(sql);
			
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getEmail());
			ps.setString(3, cliente.getDocumento());
			ps.setDate(4, Date.valueOf(cliente.getDataNascimento()));
			ps.setInt(5, cliente.getId());
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

		return "Cliente alterado com sucesso";
	}

	public ClienteDomain buscarClientePorId(Integer id) throws NegocioException {
		String sql = "SELECT id, nome, email, documento, data_nascimento FROM cliente WHERE id = ?";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = ConfigConexao.getConexao().prepareStatement(sql);
			ps.setInt(1, id);

			ClienteDomain clienteEncontrado = null;
			
			rs = ps.executeQuery();

			if (rs.next()) {
				clienteEncontrado = new ClienteDomain();
				clienteEncontrado.setId(rs.getInt("id"));
				clienteEncontrado.setNome(rs.getString("nome"));
				clienteEncontrado.setEmail(rs.getString("email"));
				clienteEncontrado.setDocumento(rs.getString("documento"));
				clienteEncontrado.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
			}
			
			return clienteEncontrado;
			
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