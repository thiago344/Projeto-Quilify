package inserindoDadosBd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DataSource.DataSource;
import tabelasBD.TabelaUsuario;

public class inserindoUsuario {
	public void adicionar(TabelaUsuario tabelaUsuario) throws SQLException {
	
	Connection connection = DataSource.conexao();
	
	String sql = "insert into (idUsuario, nomeUsuario, cpfUsuario, ufUsuario, emailUsuario, celularUsuario, generoUsuario, nascimentoUsuario, senhaUsuario) "
			+ "values(?, ?, ?, ?, ?, ?, ?, ?)";
 try {			
	PreparedStatement ps = connection.prepareStatement(sql);
	
	
	
	ps.setString(2, tabelaUsuario.getNomeUsuario());
	ps.setInt(3, tabelaUsuario.getCpfUsuario());
	ps.setString(4, tabelaUsuario.getUfUsuario());
    ps.setString(5, tabelaUsuario.getEmailUsuario());
    ps.setInt(6, tabelaUsuario.getCelularUsuario());
    ps.setString(7, tabelaUsuario.getGeneroUsuario());
    ps.setString(8, tabelaUsuario.getNascimentoUsuario());
    ps.setString(9, tabelaUsuario.getSenhaUsuario());
	
	// Executa a instrução
	ps.executeUpdate();
 }catch(SQLException e ) {
	 System.out.println("erro"+e);
	 
 }
 
	
}

}
