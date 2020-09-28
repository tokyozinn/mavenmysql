package mavenpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexaoDB {
	
	private static final String USUARIO = "root";
	private static final String SENHA = "";
	
	private static final String HOST = "localhost:3306";
	private static final String DATABASE = "unip";
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://" + HOST + "/" + DATABASE + "?useTimezone=true&serverTimezone=UTC";
			Properties props = new Properties();
			props.setProperty("user", USUARIO);
			props.setProperty("password", SENHA);
			
			return DriverManager.getConnection(url, props);
		} catch(ClassNotFoundException e) {
			throw new ClassCastException("Driver JDBC do MySQL não localizado: " + e.getMessage());
		} catch (SQLException e) {
			throw new SQLException("Não foi possível conectar com o banco de dados: " + e.getMessage());
		}
	}

}
