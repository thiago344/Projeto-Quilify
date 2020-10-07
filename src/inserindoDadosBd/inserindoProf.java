package inserindoDadosBd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DataSource.DataSource;
import tabelasBD.TabelaProf;

public class inserindoProf {
	public void adicionar(TabelaProf tabelaProf) throws SQLException {
		
		Connection connection = DataSource.conexao();
		
		String sql = "insert into (idProf, nomeProf, cpfProf,ufProf, emailProf, celularProf, generoProf, nascimentoProf, senhaProf) "
				+ "values(?, ?, ?, ?, ?, ?, ?, ?, ? )";
     try {			
		PreparedStatement ps = connection.prepareStatement(sql);
		
		
		
		ps.setString(2, tabelaProf.getNomeProf());
		ps.setInt(3, tabelaProf.getCpfProf());
		ps.setString(4, tabelaProf.getUfProf());
	    ps.setString(5, tabelaProf.getEmailProf());
	    ps.setInt(6, tabelaProf.getCelularProf());
	    ps.setString(7, tabelaProf.getGeneroProf());
	    ps.setString(8, tabelaProf.getNascimentoProf());
	    ps.setString(9, tabelaProf.getSenhaProf());
		// Executa a instrução
		ps.executeUpdate();
     }catch(SQLException e) {
    	 System.out.println("Erro"+e);
    	 
     }
		
}
}
