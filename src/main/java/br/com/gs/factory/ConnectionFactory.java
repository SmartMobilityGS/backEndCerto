package br.com.gs.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
private static Connection conexao;
	
	/**
	 * Obtem uma conexao com o banco de dados
	 * @return Connection conexao com o banco de dados
	 */
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		
		if (conexao == null) {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conexao = DriverManager.getConnection(
					"jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl","rm94528","290191");
		}
		return conexao;
	}
	
	@Override
	protected void finalize() throws Throwable {
		conexao.close();
	}
}
