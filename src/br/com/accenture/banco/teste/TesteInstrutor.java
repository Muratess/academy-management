package br.com.accenture.banco.teste;

import java.sql.SQLException;
import java.util.List;

import br.com.accenture.banco.dao.InstrutorDao;
import br.com.accenture.model.Instrutor;

public class TesteInstrutor {

	InstrutorDao dao = new InstrutorDao();
	
	public static void main(String[] args) {
		Instrutor instrutor = new Instrutor();
		instrutor.setCpf("11111111111");
		instrutor.setNome("test");
		instrutor.setEmail("teste@teste.com");
		instrutor.setSexo(false);
		instrutor.setCargo("diretor");
		
		new TesteInstrutor().testeAdiciona(instrutor);
	}
	
	void testeAdiciona(Instrutor instrutor) {
		try {
			dao.salvarInstrutor(instrutor);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void testeAltera(Instrutor instrutor) {
		try {
			dao.alterarInstrutor(instrutor);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void testeLista() {
		try {
			List<Instrutor> instrutores = dao.consultarInstrutor();
			for (Instrutor instrutor : instrutores) {
				System.out.println("Nome: " + instrutor.getNome());
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void testeListaPorCpf(Instrutor i) {
		try {
			Instrutor instrutor = dao.consultarInstrutor(i.getCpf());
			System.out.println(instrutor.getCpf());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void testeRemove(String cpf) {
		try {
			dao.excluirInstrutor(cpf);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
