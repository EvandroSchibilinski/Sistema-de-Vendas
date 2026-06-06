	package com.schibilinski.sistema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.schibilinski.sistema.modelos.Estado;
import com.schibilinski.sistema.repository.EstadoRepository;

@Controller
public class EstadoController {
	@Autowired
	private EstadoRepository estadoRepository;
	
	@GetMapping("/cadastroEstado")
	public ModelAndView cadastrar() {
		
		ModelAndView mv = 
				new ModelAndView("estados/cadastros");
		
		mv.addObject("estado", new Estado());
		return mv;
		
	}
	
	@GetMapping("/ListarEstados")
	public ModelAndView listar() {

	    ModelAndView mv =
	        new ModelAndView("estados/lista");

	    mv.addObject(
	        "estados",
	        estadoRepository.findAll()
	    );

	    return mv;
	}
	@GetMapping("/removerEstado/{id}")
	public ModelAndView excluir(@PathVariable("id") Long id) {
	    estadoRepository.deleteById(id);
	    ModelAndView mv = new ModelAndView("redirect:/ListarEstados");
	    return mv;
	}
	
	@GetMapping("/editarEstado/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
	    ModelAndView mv = new ModelAndView("estados/cadastros");
	    Estado estado = estadoRepository.findById(id).orElse(null);
	    mv.addObject("estado", estado);
	    return mv;
	}
	
	@PostMapping("/salvarEstado")
	public ModelAndView salvar(@ModelAttribute("estado") Estado estado, 
	                           BindingResult result) {
	    estadoRepository.save(estado);
	    ModelAndView mv = new ModelAndView("estados/cadastros");
	    mv.addObject("estado", new Estado());
	    return mv;
	}
	
	

}
