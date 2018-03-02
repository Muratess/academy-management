package br.com.accenture.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.accenture.banco.dao.AcademiaDao;

@Controller
public class AcademiaController {

	private AcademiaDao dao;
	
	public AcademiaController() {
		dao = new AcademiaDao();
	}
	
	@RequestMapping("listaAcademia")
	public String listaAcademia(Model model) {
		try {
			model.addAttribute("academias",dao.consultarAcademia());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "lista-academia";
	}
	
}
