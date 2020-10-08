package inserindoDadosBd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DataSource.DataSource;
import tabelasBD.Professor;

public class ProfessorDao {
	
	public boolean checkProf(String nomeProf, String senhaProf) {

		boolean checkProf = false;

		try {

			Professor tabelaProf = new Professor();
			Connection connection = DataSource.conexao();
			PreparedStatement ps = null;
			ResultSet rs = null;

			ps = connection.prepareStatement("SELECT * FROM prof WHERE emailProf = ? and senhaProf = ?");

			ps.setString(5, tabelaProf.getEmailProf());
			ps.setString(9, tabelaProf.getSenhaProf());

			rs = ps.executeQuery();

			if (rs.next()) {
				checkProf = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return checkProf;

	}

	public void adicionar(Professor tabelaProf) throws SQLException {

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
		} catch (SQLException e) {
			System.out.println("Erro" + e);

		}

	}
}
