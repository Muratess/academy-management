package br.com.accenture.banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.accenture.banco.ConnectionFactory;
import br.com.accenture.model.Instrutor;


public class InstrutorDao {

	Connection connection;
	
	public InstrutorDao() {
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void salvarInstrutor(Instrutor instrutor) throws Exception {
		String SQL = "INSERT INTO instrutor (nome, cpf, email, sexo, cargo) VALUES (?,?,?,?,?)";
		
		try {
			PreparedStatement pstmt = this.connection.prepareStatement(SQL);
			pstmt.setString(1, instrutor.getNome());
			pstmt.setString(2, instrutor.getCpf());
			pstmt.setString(3, instrutor.getEmail());
			pstmt.setBoolean(4, instrutor.isSexo());
			pstmt.setString(5, instrutor.getCargo());

			pstmt.executeUpdate();

			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<Instrutor> consultarInstrutor() throws SQLException {
		List<Instrutor> instrutores = new ArrayList<>();
		String sql = "SELECT  nome, cpf, email, sexo, cargo FROM instrutor";
		try {
			PreparedStatement psmt = this.connection.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				Instrutor instrutor = new Instrutor();
				instrutor.setCpf(rs.getString("cpf"));
				instrutor.setNome(rs.getString("nome"));
				instrutor.setEmail(rs.getString("email"));
				instrutor.setSexo(rs.getBoolean("sexo"));
				instrutor.setCargo(rs.getString("cargo"));

				instrutores.add(instrutor);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return instrutores;

	}

	public Instrutor consultarInstrutor(String cpf) throws Exception {
		Instrutor instrutor = null;
		String SQL = "SELECT nome, cpf, email, sexo, cargo FROM instrutor WHERE cpf = ?";

		try {

			PreparedStatement pstmt = this.connection.prepareStatement(SQL);
			pstmt.setString(1, cpf);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				instrutor = new Instrutor();
				instrutor.setNome(rs.getString("nome"));
				instrutor.setCpf(rs.getString("cpf"));
				instrutor.setEmail(rs.getString("email"));
				instrutor.setSexo(rs.getBoolean("sexo"));
				instrutor.setCargo(rs.getString("cargo"));

			}

			pstmt.close();
		} catch (Exception e) {

			System.out.println("Erro na consulta do instrutor." + e.getMessage());

			e.printStackTrace();
		}

		return instrutor;
	}

	public void alterarInstrutor(Instrutor instrutor) throws Exception {

		String SQL = "UPDATE instrutor SET NOME=?, EMAIL=?, SEXO=?, CARGO=? WHERE CPF=?";
		try {

			PreparedStatement pstmt = this.connection.prepareStatement(SQL);
			pstmt.setString(1, instrutor.getNome());
			pstmt.setString(2, instrutor.getEmail());
			pstmt.setBoolean(3, instrutor.isSexo());
			pstmt.setString(4, instrutor.getCargo());
			pstmt.setString(5, instrutor.getCpf());

			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace(); // (?)
		}

	}

	public void excluirInstrutor(String cpf) throws Exception {
		String SQL = "DELETE FROM INSTRUTOR WHERE CPF=?";

		try {
			PreparedStatement pstmt = this.connection.prepareStatement(SQL);
			pstmt.setString(1, cpf);

			pstmt.executeUpdate();
			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
