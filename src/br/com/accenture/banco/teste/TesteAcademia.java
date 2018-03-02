package br.com.accenture.banco.teste;

import java.util.Calendar;
import java.util.List;

import br.com.accenture.banco.dao.AcademiaDao;
import br.com.accenture.model.Academia;

public class TesteAcademia {

	AcademiaDao dao = new AcademiaDao();
	
	public static void main(String[] args) {
		Academia academia = new Academia();
		academia.setStatus("nao comecada");
		academia.setTipo("cobol");
		academia.setDataInicio(Calendar.getInstance());
		academia.setDataFinal(Calendar.getInstance());
		academia.setHoraInicio("18:00");
		academia.setHoraFinal("21:00");
		academia.setSala("Sala 2");
		academia.setPredio("A9");
		academia.setCpfInstrutor("11111111111");
		academia.setIdAcademia(4);
		new TesteAcademia().testeConsulta();
	}
	
	void testeAdiciona(Academia academia) {
		try {
			dao.salvarAcademia(academia);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void testeConsulta() {
		try {
			List<Academia> a = dao.consultarAcademia();
			for (Academia academia : a) {
				System.out.println(academia.getTipo());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void testeConsulta(String tipo) {
		try {
			Academia a = dao.consultarAcademia(tipo);
			System.out.println(a.getIdAcademia());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void testeAltera(Academia academia) {
		try {
			dao.alterarAcademia(academia);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	void testeExclue(int id_academia) {
		try {
			dao.excluirAcademia(id_academia);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
