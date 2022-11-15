package sistema_faturamento_comercial.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigConexao {
	public static Connection getConexao() {
		Connection connection = null;
		try {
			String driverName = "com.mysql.cj.jdbc.Driver";
			Class.forName(driverName);
			String serverName = "localhost";    //caminho do servidor do BD
			String mydatabase ="graduacao";        //nome do seu banco de dados
			String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
			String username = "root";        //nome de um usuário de seu BD
			String password = "root";      //sua senha de acesso
			connection = DriverManager.getConnection(url, username, password);
			if (connection != null) {
				System.out.println("STATUS--->Conectado com sucesso!");
			} else {
				System.out.println("STATUS--->Não foi possivel realizar conexão");
			}

			return connection;
		} catch (ClassNotFoundException e) {
			System.out.println("O driver expecificado nao foi encontrado.");
			return null;
		} catch (SQLException e) {
			System.out.println("Nao foi possivel conectar ao Banco de Dados.");
			return null;
		}
	}
}
