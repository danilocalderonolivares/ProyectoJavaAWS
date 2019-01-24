package com.cenfotec.examen2.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cenfotec.examen2.entidades.Finca;
import com.cenfotec.examen2.entidades.Productor;
import com.cenfotec.examen2.repository.FincaRepository;
import com.cenfotec.examen2.repository.ProductorRepository;

@Controller
public class FincaController {
	
	@Autowired
	FincaRepository fincaRepository;
	
	@Autowired
	ProductorRepository repo;
	
	
	@GetMapping("/finca/{cedula}")
	public String IngresarDatosFinca(@PathVariable(value = "cedula") Long cedula,Model model){
		model.addAttribute("finca",new Finca());
		model.addAttribute(cedula);
		return "FormFinca";
	}
	@PostMapping("/agregarFinca/{cedula}")
	public String InsertarFinca(@PathVariable(value = "cedula")Long cedula,Finca finca) {
		
		Optional<Productor> productor=repo.findById(cedula);
		Productor productorDatos = productor.get();
		finca.setProductor(productorDatos);
		fincaRepository.save(finca);
		
		return "redirect:/ListaProductores";
	}
	

}
