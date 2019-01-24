package com.cenfotec.examen2.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cenfotec.examen2.entidades.Direccion;
import com.cenfotec.examen2.entidades.Finca;
import com.cenfotec.examen2.entidades.Productor;
import com.cenfotec.examen2.repository.DireccionRepository;
import com.cenfotec.examen2.repository.FincaRepository;
import com.cenfotec.examen2.repository.ProductorRepository;

import javassist.expr.NewArray;

@Controller
public class ProductorController {
	@Autowired
	ProductorRepository repo;
	
	@Autowired
	DireccionRepository direccionRepo;
	
	@Autowired
	FincaRepository fincaRepository;

	@GetMapping("/index")
	public String Index(Model model) {
		model.addAttribute("Titulo", "Productor");
		model.addAttribute("productor", new Productor());
		model.addAttribute("direccion", new Direccion());
		return "Index";
	}

	@PostMapping("/form")
	public String CrearProductor(Productor productor,Direccion direccion) {
		direccionRepo.save(direccion);
		productor.setDireccion(direccion);
		repo.save(productor);
		
		
		return "redirect:/ListaProductores";

	}

	@GetMapping("/ListaProductores")
	public String ListarProductores(Model model) {
		model.addAttribute("titulo", "Lista de Productores");
		model.addAttribute("listaProductores", repo.findAll());
		return "ListaProductores";
	}
	
	@GetMapping("/verInformacion/{cedula}")
	private String VerInformacionProductor(@PathVariable(value = "cedula") Long cedula,Model model) {
		
		Optional<Productor> productor=repo.findById(cedula);
		Productor productoDatosVista = productor.get();
		List<Finca> fincas =fincaRepository.findAll();
		List<Finca> fincasProductor = new ArrayList<Finca>();
		fincasProductor =  productoDatosVista.getFincas();
		model.addAttribute("datosProductor", productoDatosVista);
		
		
		return"VerInformacion";

	}
	@GetMapping("/buscarProductor")
	public String buscarProductorPorNombre(Model model) {
		model.addAttribute("productor", new Productor());
		return "BusquedaProductor";
	}
	@PostMapping("/PostBusquedaProductor")
	public String BuscarProductor(Productor productor,Model model) {
		List<Productor> productoresBusqueda = new ArrayList<Productor>();
		productoresBusqueda = repo.findBynombreProductorContaining(productor.getNombreProductor());
		model.addAttribute("resultado", productoresBusqueda);
		
		return"BusquedaProductor";
	}
}
