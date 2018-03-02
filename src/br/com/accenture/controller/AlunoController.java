package br.com.accenture.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.accenture.banco.dao.AlunoDao;
import br.com.accenture.model.Aluno;

@Controller
public class AlunoController {

	private final AlunoDao dao;

	public AlunoController(AlunoDao dao){
		this.dao = new AlunoDao();
	}
	
	
	@RequestMapping("novoAluno")
	public String formAluno(){		
		return "aluno/formulario-aluno";
	}
	
	
	@RequestMapping("adicionaAluno")
	public String adicionaAluno(Aluno aluno){
		try {
			dao.salvarAluno(aluno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:listaAluno";
	}
	
	@RequestMapping("listaAluno")
	public String lista(Model model){
		try {
			model.addAttribute("alunos",dao.consultarAlunos());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "aluno/lista-alunos";
	}
	
	@RequestMapping("mostraFormulario")
	public String mostra(Model model, Aluno aluno){
		try {
			model.addAttribute("aluno",dao.consultarAluno(aluno.getCpf()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "aluno/formulario-altera-aluno";
	}

	
	@RequestMapping("alteraAluno")
	public String alteraAluno(Aluno aluno) {
		try {
			dao.alterarAluno(aluno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:listaAluno";
	}
	
	
}
