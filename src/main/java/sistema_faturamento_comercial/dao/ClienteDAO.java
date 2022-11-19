package sistema_faturamento_comercial.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import sistema_faturamento_comercial.config.ConfigConexao;
import sistema_faturamento_comercial.domain.ClienteDomain;

public class ClienteDAO {
 
	private String sqlInsert = "INSERT INTO cliente(nome, email, documento, data_nascimento) VALUES(?, ?, ?, ?)";
	
//	public String inserir(ClienteDomain cliente) { 
//		try {
//			Connection connection = ConfigConexao.getConexao(); 
//			PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
//			
//			preparedStatement.setString(1, cliente.getNome());
//			preparedStatement.setString(2, cliente.getEmail());
//			preparedStatement.setString(3, cliente.getDocumento());
//return null;			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
