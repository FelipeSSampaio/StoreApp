package com.storeapp.StoreApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.storeapp.StoreApp.models.Vestuario;
import com.storeapp.StoreApp.repository.VestuarioRepository;

@Controller
public class VestuarioController {

	@Autowired
	private VestuarioRepository vestuarioREPO;
	
	@RequestMapping(value="/cadastrarVestuario", method=RequestMethod.GET)
	public String form() {
		return "vestuario/formVestuario";
	}
	
	@RequestMapping(value="/cadastrarVestuario", method=RequestMethod.POST)
	public String form(Vestuario vestuario) {
		
		System.out.println(vestuario.toString());
		
		vestuarioREPO.save(vestuario);
		
		return "redirect:/cadastrarVestuario";
	}
	
	@RequestMapping(value="/vestuarios")
	public ModelAndView listaVestuario() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Vestuario> vestuarios = vestuarioREPO.findAll();
		mv.addObject("vestuarios", vestuarios);
		
		return mv;
	}
}
