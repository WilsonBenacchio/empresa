package br.senai.spring.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.senai.spring.empresa.model.Funcionario;
import br.senai.spring.empresa.repository.FuncionarioRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/funcionario")
public class FuncionarioController {
	
	@Autowired
	FuncionarioRepository funcionarioRep;
	
	
	@GetMapping("/listar")
	public String listar(Model model) {
		
		List<Funcionario> funcionarios = funcionarioRep.findAll();
		
		model.addAttribute("funcionarios", funcionarios);
		
		return "/funcionariolst";
		
	}
	
	@GetMapping("/novo")
	public String novo(Funcionario funcionario) {
		
		return "/funcionariofrm";
	}
	
	@PostMapping("/gravar")
	public String gravar(@Valid Funcionario funcionario, BindingResult bindingResult ) {
		
		if (bindingResult.hasErrors()) {
			return "/funcionariofrm";
			
		}
		
		funcionarioRep.save(funcionario);
		
		return "redirect:/funcionario/listar"; 
	}
	
}
