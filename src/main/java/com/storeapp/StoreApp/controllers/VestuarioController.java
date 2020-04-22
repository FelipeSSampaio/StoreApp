package com.storeapp.StoreApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.storeapp.StoreApp.models.Vestuario;
import com.storeapp.StoreApp.repository.VestuarioRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class VestuarioController {

	@Autowired
	private VestuarioRepository vestuarioREPO;
	
	private String mensagem = "";
	private String mensagemErro = "";
	
	@RequestMapping(value="/cadastrarVestuario", method=RequestMethod.GET)
	public String redirecionaCadastrar() {
		return "vestuario/cadastroVestuario";
	}
	
	@RequestMapping(value="/cadastrarVestuario", method=RequestMethod.POST)
	public ModelAndView cadastrar(Vestuario vestuario) {
		ModelAndView mv = new ModelAndView("vestuario/cadastroVestuario");
				
		log.info(vestuario.toString());
		
		try {
			
			vestuarioREPO.save(vestuario);
			
			StringBuffer mensagem = new StringBuffer();
			mensagem.append("</br><i class=\"material-icons \">check_circle</i>");
			mensagem.append("</br>Vestuário cadastrado!</br></br>");
			
			setMensagem(mensagem.toString());
			mv.addObject("mensagem", mensagem);
		}
		catch(Exception e) {
			StringBuffer mensagemErro = new StringBuffer();
			mensagemErro.append("</br><i class=\"material-icons \">error_outline</i>");
			mensagemErro.append("</br>Ocorreu um erro ao tentar cadastrar o vestuário!");
			mensagemErro.append("</br>Tente novamente .. </br></br>");
			
			setMensagemErro(mensagemErro.toString());
			mv.addObject("mensagemErro", mensagemErro);
		}
		
		return mv;
	}
	
	@RequestMapping(value="/listarVestuario")
	public ModelAndView listaVestuario() {
		ModelAndView mv = new ModelAndView("vestuario/listaVestuarios");
		Iterable<Vestuario> vestuarios = vestuarioREPO.findAll();
		mv.addObject("vestuarios", vestuarios);
		
		return mv;
	}
	
	@RequestMapping(value="/excluirVestuario/{codigo}")
	public String excluirVestuario(@PathVariable("codigo") long codigo) {
		
		Vestuario vestuario = vestuarioREPO.findByCodigo(codigo);
		vestuarioREPO.delete(vestuario);
		
		return "redirect:/listarVestuario";
	}
	
	@RequestMapping(value="/editaVestuario/{codigo}")
	public ModelAndView editarVestuario(@PathVariable("codigo") long codigo) {
		ModelAndView mv = new ModelAndView("vestuario/editaVestuario");
		Vestuario vestuario = vestuarioREPO.findByCodigo(codigo);
		mv.addObject("vestuario", vestuario);
		
		return mv;
	}
	
	@RequestMapping(value="/editaVestuario/{codigo}", method=RequestMethod.POST)
	public String editarVestuarioEscolhido(Vestuario vestuario) {
		
		log.info(vestuario.toString());
		
		vestuarioREPO.save(vestuario);
		
		return "redirect:/listarVestuario";
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getMensagemErro() {
		return mensagemErro;
	}

	public void setMensagemErro(String mensagemErro) {
		this.mensagemErro = mensagemErro;
	}

}
