package DataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
	public static Connection conexao() throws SQLException{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/quilify?useTimezone=true&serverTimezone=UTC","root","quilifyproj");
			
		}catch(ClassNotFoundException erro) {
			throw new SQLException(erro.getMessage());
			
		}
	}
	

}
