package br.com.accenture.banco.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import br.com.accenture.banco.ConnectionFactory;
import br.com.accenture.model.Academia;


public class AcademiaDao {

		public void salvarAcademia(Academia	academia) throws Exception {

			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = null;

			conn.setAutoCommit(false);
			String SQL = "INSERT INTO ACADEMIA (tipo, data_inicio, data_final, hora_inicio, hora_final, sala, predio, status, cpf_instrutor) VALUES (?,?,?,?,?,?,?,?,?)";

			try {

				pstmt = conn.prepareStatement(SQL);
				pstmt.setString(1, academia.getTipo());
				pstmt.setDate(2, new Date(academia.getDataInicio().getTimeInMillis()));
				pstmt.setDate(3, new Date(academia.getDataFinal().getTimeInMillis()));
				pstmt.setString(4, academia.getHoraInicio());
				pstmt.setString(5, academia.getHoraFinal());
				pstmt.setString(6, academia.getSala());
				pstmt.setString(7, academia.getPredio());
				pstmt.setString(8, academia.getStatus());
				pstmt.setString(9, academia.getCpfInstrutor());

				pstmt.executeUpdate();
				conn.commit();
				pstmt.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public Academia consultarAcademia(String tipo) throws Exception {

			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			conn.setAutoCommit(false);

			Academia academia = null;
			String SQL = "SELECT tipo, data_inicio, data_final, hora_inicio, hora_final, sala, predio, status, cpf_instrutor, id_academia "
					+ "FROM ACADEMIA WHERE tipo = ?";

			try {

				pstmt = conn.prepareStatement(SQL);
				pstmt.setString(1, tipo);

				rs = pstmt.executeQuery();

				if (rs.next()) {
					academia = new Academia();
					academia.setTipo(rs.getString("tipo"));
					//montando a data de inicio
					Calendar dataInicio = Calendar.getInstance();
					dataInicio.setTime(rs.getDate("data_inicio"));
					academia.setDataInicio(dataInicio);
					//montando a data final
					Calendar dataFinal = Calendar.getInstance();
					dataFinal.setTime(rs.getDate("data_final"));
					academia.setDataFinal(dataFinal);
					
					academia.setHoraInicio(rs.getString("hora_inicio"));
					academia.setHoraFinal(rs.getString("hora_final"));
					academia.setSala(rs.getString("sala"));
					academia.setPredio(rs.getString("predio"));
					academia.setStatus(rs.getString("status"));
					academia.setCpfInstrutor(rs.getString("cpf_instrutor"));
					academia.setIdAcademia(rs.getInt("id_academia"));
					
				}

				pstmt.close();
				conn.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

			return academia;
		}
		
		public List<Academia> consultarAcademia() throws Exception{
			List<Academia> academias = new ArrayList<>();
			String sql = "SELECT tipo, data_inicio, data_final, hora_inicio, hora_final, sala, predio, status, cpf_instrutor, id_academia "
					+ "FROM ACADEMIA";
			try {
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement psmt = conn.prepareStatement(sql);
				ResultSet rs = psmt.executeQuery();
				while(rs.next()) {
					Academia academia = new Academia();
					academia.setTipo(rs.getString("tipo"));
					
					Calendar dataInicio = Calendar.getInstance();
					dataInicio.setTime(rs.getDate("data_inicio"));
					academia.setDataInicio(dataInicio);
					
					Calendar dataFinal = Calendar.getInstance();
					dataFinal.setTime(rs.getDate("data_final"));
					academia.setDataFinal(dataFinal);
					
					academia.setTipo(rs.getString("tipo"));
					academia.setHoraInicio("hora_inicio");
					academia.setHoraFinal("hora_final");
					academia.setSala(rs.getString("sala"));
					academia.setPredio(rs.getString("predio"));
					academia.setStatus(rs.getString("status"));
					academia.setCpfInstrutor(rs.getString("cpf_instrutor"));
					academia.setIdAcademia(rs.getInt("id_academia"));
					
					academias.add(academia);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return academias;
		}

		public void alterarAcademia(Academia academia) throws Exception {

			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = null;
			conn.setAutoCommit(false);

			String SQL = "UPDATE ACADEMIA SET tipo=?, data_inicio=?, data_final=?, hora_inicio=?, hora_final=?, sala=?, predio=?, status=?, cpf_instrutor=? "
					+ "WHERE id_academia=?";

			try {

				pstmt = conn.prepareStatement(SQL);
				pstmt.setString(1, academia.getTipo());
				pstmt.setDate(2, new Date(academia.getDataInicio().getTimeInMillis()));
				pstmt.setDate(3, new Date(academia.getDataFinal().getTimeInMillis()));
				pstmt.setString(4, academia.getHoraInicio());
				pstmt.setString(5, academia.getHoraFinal());
				pstmt.setString(6, academia.getSala());
				pstmt.setString(7, academia.getPredio());
				pstmt.setString(8, academia.getStatus());
				pstmt.setString(9, academia.getCpfInstrutor());
				pstmt.setInt(10, academia.getIdAcademia());

				pstmt.executeUpdate();
				conn.commit();
				pstmt.close();
				conn.close();

			} catch (Exception e) {
				e.printStackTrace(); // (?)
			}

		}

		public void excluirAcademia(int id_academia) throws Exception {

			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = null;
			conn.setAutoCommit(false);

			String SQL = "DELETE FROM ACADEMIA WHERE id_academia=?";

			try {
				pstmt = conn.prepareStatement(SQL);
				pstmt.setInt(1, id_academia);

				pstmt.executeUpdate();
				conn.commit();
				pstmt.close();
				conn.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
		public void finalizaAcademia(int id_academia) {
			String sql = "UPDATE academia SET status=? WHERE id_academia=?";
			try {
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, "finalizada");
				psmt.setInt(2, id_academia);
				
				psmt.execute();
				psmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public void iniciaAcademia(int id_academia) {
			String sql = "UPDATE academia SET status=? WHERE id_academia=?";
			try {
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, "iniciada");
				psmt.setInt(2, id_academia);
				
				psmt.execute();
				psmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	
