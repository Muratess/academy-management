package br.com.accenture.banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.com.accenture.banco.ConnectionFactory;
import br.com.accenture.model.Aluno;

@Repository
public class AlunoDao {

	Connection connection;

	public AlunoDao() {
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public void salvarAluno(Aluno aluno) throws Exception {
		String SQL = "INSERT INTO aluno (nome, cpf, email, sexo, nota, presenca, aprovacao, id_academia) VALUES (?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = this.connection.prepareStatement(SQL);
			pstmt.setString(1, aluno.getNome());
			pstmt.setString(2, aluno.getCpf());
			pstmt.setString(3, aluno.getEmail());
			pstmt.setBoolean(4, aluno.isSexo());
			pstmt.setDouble(5, aluno.getNota());
			pstmt.setBoolean(6, aluno.isPresenca());
			pstmt.setBoolean(7, aluno.isAprovacao());
			pstmt.setInt(8, aluno.getId_academia());

			pstmt.executeUpdate();

			pstmt.close();

		} catch (Exception e) {

			System.out.println("Erro na prepara��o da instru��o SQL." + e.getMessage());

			e.printStackTrace();

		}

	}

	public Aluno consultarAluno(String cpf) throws Exception {

		Aluno aluno = null;
		String SQL = "SELECT nome, cpf, email, sexo, nota, presenca, aprovacao, id_academia FROM aluno WHERE cpf = ?";

		try {

			PreparedStatement pstmt = this.connection.prepareStatement(SQL);
			pstmt.setString(1, cpf);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				aluno = new Aluno();
				aluno.setNome(rs.getString("nome"));
				aluno.setCpf(rs.getString("cpf"));
				aluno.setEmail(rs.getString("email"));
				aluno.setSexo(rs.getBoolean("sexo"));
				aluno.setNota(rs.getInt("nota"));
				aluno.setPresenca(rs.getBoolean("presenca"));
				aluno.setAprovacao(rs.getBoolean("aprovacao"));
				aluno.setId_academia(rs.getInt("id_academia"));
			}

			pstmt.close();

		} catch (Exception e) {

			System.out.println("Erro na consulta do aluno." + e.getMessage());

			e.printStackTrace();
		}

		return aluno;
	}

	public List<Aluno> consultarAlunos() throws Exception {
		List<Aluno> alunos = new ArrayList<>();
		String sql = "SELECT nome, cpf, email, sexo, nota, presenca, aprovacao, id_academia FROM aluno";
		try {
			PreparedStatement psmt = this.connection.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				Aluno aluno = new Aluno();
				aluno.setCpf(rs.getString("cpf"));
				aluno.setNome(rs.getString("nome"));
				aluno.setEmail(rs.getString("email"));
				aluno.setSexo(rs.getBoolean("sexo"));
				aluno.setNota(rs.getDouble("nota"));
				aluno.setPresenca(rs.getBoolean("presenca"));
				aluno.setAprovacao(rs.getBoolean("aprovacao"));
				aluno.setId_academia(rs.getInt("id_academia"));
				alunos.add(aluno);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return alunos;
	}

	public void alterarAluno(Aluno aluno) throws Exception {
		String SQL = "UPDATE aluno SET nome=?, email=?, sexo=?, nota=?, presenca=?, aprovacao=?, id_academia=? WHERE CPF=?";
		try {

			PreparedStatement pstmt = this.connection.prepareStatement(SQL);
			pstmt.setString(1, aluno.getNome());
			pstmt.setString(2, aluno.getEmail());
			pstmt.setBoolean(3, aluno.isSexo());
			pstmt.setDouble(4, aluno.getNota());
			pstmt.setBoolean(5, aluno.isPresenca());
			pstmt.setBoolean(6, aluno.isAprovacao());
			pstmt.setInt(7, aluno.getId_academia());
			pstmt.setString(8, aluno.getCpf());

			pstmt.executeUpdate();
			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace(); // (?)
		}

	}

	public void excluirAluno(String cpf) throws Exception {
		String SQL = "DELETE FROM ALUNO WHERE CPF=?";
		try {
			PreparedStatement pstmt = this.connection.prepareStatement(SQL);
			pstmt.setString(1, cpf);

			pstmt.executeUpdate();
			pstmt.close();

		} catch (Exception e) {

			System.out.println("Erro na exclus�o do aluno." + e.getMessage());

			e.printStackTrace();
		}

	}

	public Map<Integer, String> listaAcademia() {
		String sql = "Select id_academia, tipo from academia";
		Map<Integer, String> map = new HashMap<>();
		try {
			PreparedStatement psmt = this.connection.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				map.put(rs.getInt("id_academia"), rs.getString("tipo"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;

	}

}
