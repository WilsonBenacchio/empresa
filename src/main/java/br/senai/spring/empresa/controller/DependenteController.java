package br.senai.spring.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.senai.spring.empresa.model.Dependente;
import br.senai.spring.empresa.model.Funcionario;
import br.senai.spring.empresa.repository.DependenteRepository;
import br.senai.spring.empresa.repository.FuncionarioRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/dependente")
public class DependenteController {
	
	@Autowired
	FuncionarioRepository funcionarioRep;
	
	@Autowired
	DependenteRepository dependenteRep;
	
	@GetMapping("/novo")
	public String novoDep (Model model) {
		
			List<Funcionario> tmp = funcionarioRep.findAll();
			
			model.addAttribute("funcionarios", tmp);
			model.addAttribute("dependente", new Dependente());
			
			return "dependentefrm";
	}
	
	@PostMapping("/gravar")
	public String gravarDep(@Valid Dependente dependente, BindingResult bindingResult) {
		
	    if (bindingResult.hasErrors()) {
	        return "dependentefrm";
	    }

	    dependenteRep.save(dependente);

	    return "redirect:/funcionario/listar";
	}


}
