package DataSource;

import java.sql.Connection;

public class MainConexao {

	public static void main(String[] args) {
		try {
			Connection connection = DataSource.conexao();
			System.out.println(connection);
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			
		}
		

	}

}
