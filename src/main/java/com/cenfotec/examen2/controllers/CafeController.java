package com.cenfotec.examen2.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cenfotec.examen2.entidades.Cafe;
import com.cenfotec.examen2.entidades.Finca;
import com.cenfotec.examen2.repository.FincaRepository;

@Controller
public class CafeController {
	
	@Autowired
	FincaRepository fincaRepository;
	
	@GetMapping("/tipoCafe/{idFinca}")
	public String insertarCafe(@PathVariable(value = "idFinca")Long idFinca,Model model) {
		model.addAttribute("tipoCafe", new Cafe());
		model.addAttribute(idFinca);

		return "FormTipoCafe";
		
	}
	@PostMapping("/AgregarCafe/{idFinca}")
	public String AgregarTipoCafe(@PathVariable(value = "idFinca")Long idFinca,Cafe cafe) {
		Optional<Finca> finca = fincaRepository.findById(idFinca);
		Finca fincaDatos= finca.get();
		fincaDatos.getTiposCafe().add(cafe);
		fincaRepository.save(fincaDatos);
		return "redirect:/ListaProductores";
	}
	@GetMapping("/listarCafes/{idFinca}")
	public String ListarTiposCafe(@PathVariable(value = "idFinca")Long idFinca,Model model) {
		Optional<Finca> finca = fincaRepository.findById(idFinca);
		Finca fincaDatos= finca.get();
		List<Cafe> tiposCafes =  fincaDatos.getTiposCafe();
		model.addAttribute("lista",tiposCafes);
		return"ListarTiposCafe";
	}

}
