package br.com.accenture.banco.teste;

import java.util.List;

import br.com.accenture.banco.dao.AlunoDao;
import br.com.accenture.model.Aluno;

public class TesteAluno {

	AlunoDao dao = new AlunoDao();
	
	public static void main(String[] args) {
		Aluno aluno = new Aluno();
		aluno.setCpf("22222222222");
		aluno.setNome("renato");
		aluno.setEmail("renatojlelis@gmail.com");
		aluno.setSexo(true);
		aluno.setNota(8.0);
		aluno.setPresenca(false);
		aluno.setAprovacao(true);
		aluno.setId_academia(2);
		new TesteAluno().testeExclui(aluno.getCpf());
	}
	
	void testeAdiciona(Aluno aluno) {
		try {
			dao.salvarAluno(aluno);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void testeAltera(Aluno aluno) {
		try {
			dao.alterarAluno(aluno);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void testeConsulta() {
		try {
			List<Aluno> alunos = dao.consultarAlunos();
			for (Aluno aluno : alunos) {
				System.out.println("nome: " + aluno.getNome());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void testeConsulta(String cpf) {
		try {
			Aluno aluno = dao.consultarAluno(cpf);
			System.out.println(aluno.getNome());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void testeExclui(String cpf) {
		try {
			dao.excluirAluno(cpf);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
