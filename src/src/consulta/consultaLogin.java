package consulta;
import tabelasBD.TabelaProf;
import tabelasBD.TabelaUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DataSource.DataSource;

public class consultaLogin {
	public boolean checkUsuario(String nomeUsuario, String senhaUsuario) {
		
		boolean checkUsuario = false;
		
		try {
			
			TabelaUsuario tabelaUsuario = new TabelaUsuario();
			Connection connection = DataSource.conexao();
			PreparedStatement ps = null;
			ResultSet rs = null;
			
	
			ps = connection.prepareStatement("SELECT * FROM usuarios WHERE emailUsuario = ? and senhaUsuario = ?");
		    
			 ps.setString(5, tabelaUsuario.getEmailUsuario());
			 ps.setString(9, tabelaUsuario.getSenhaUsuario());
			 
			 rs = ps.executeQuery();
			 
			 if(rs.next()) {
				checkUsuario = true;
			 }
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return checkUsuario;
		
		
		
		
	}
	
	
public boolean checkProf(String nomeProf, String senhaProf) {
		
		boolean checkProf = false;
		
		try {
			
			TabelaProf tabelaProf = new TabelaProf();
			Connection connection = DataSource.conexao();
			PreparedStatement ps = null;
			ResultSet rs = null;
			
	
			ps = connection.prepareStatement("SELECT * FROM prof WHERE emailProf = ? and senhaProf = ?");
		    
			 ps.setString(5, tabelaProf.getEmailProf());
			 ps.setString(9, tabelaProf.getSenhaProf());
			 
			 rs = ps.executeQuery();
			 
			 if(rs.next()) {
				checkProf = true;
			 }
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return checkProf;
		
		
		
		
	}

}

