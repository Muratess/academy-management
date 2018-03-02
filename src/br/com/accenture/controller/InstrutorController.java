package br.com.accenture.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.accenture.banco.dao.InstrutorDao;
import br.com.accenture.model.Instrutor;

@Controller
public class InstrutorController {
	
	private InstrutorDao dao;
	
	public InstrutorController() {
		this.dao = new InstrutorDao();
	}
	
	@RequestMapping("listaInstrutor")
	public String listaInstrutor(Model model) {
		try {
			model.addAttribute("instrutores", dao.consultarInstrutor());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "instrutor/lista-instrutor";
	}
	
	
	@RequestMapping("novoInstrutor")
	public String novoInstrutor() {
		return "instrutor/formulario-instrutor";
	}
	
	@RequestMapping("adicionaInstrutor")
	public String adicionaInstrutor(Instrutor instrutor) {
		try {
			dao.salvarInstrutor(instrutor);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:listaInstrutor";
	}
	
	
	@RequestMapping("mostraForm")
	public String mostra(Model model, Instrutor instrutor) {
		try {
			model.addAttribute("instrutor",dao.consultarInstrutor(instrutor.getCpf()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "instrutor/formulario-altera-instrutor";
	}
	
	@RequestMapping("alteraInstrutor")
	public String alteraInstrutor(Instrutor instrutor) {
		try {
			dao.alterarInstrutor(instrutor);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:listaInstrutor";
	}
	
	@RequestMapping("removeIntrutor")
	public String removeInstrutor(Instrutor instrutor) {
		try {
			dao.excluirInstrutor(instrutor.getCpf());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:listaInstrutor";
	}


}
