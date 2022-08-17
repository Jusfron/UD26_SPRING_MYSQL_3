package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.MaquinaRegistradoraServiceImpl;
import com.example.demo.dto.MaquinaRegistradora;

@RestController
@RequestMapping("/api")
public class MaquinaRegistradoraController {

	@Autowired
	MaquinaRegistradoraServiceImpl maquinaRegistradoraServiceImpl;
	
	@GetMapping("/maquinaRegistradoras")
	public List<MaquinaRegistradora> listarMaquinaRegistradoras() {
		return maquinaRegistradoraServiceImpl.listarMaquinaRegistradoras();
	}
	
	@PostMapping("/maquinaRegistradoras")
	public MaquinaRegistradora salvarMaquinaRegistradora(@RequestBody MaquinaRegistradora maquinaRegistradora) {
		return maquinaRegistradoraServiceImpl.guardarMaquinaRegistradora(maquinaRegistradora);
	}
	
	@GetMapping("/maquinaRegistradoras/{id}")
	public MaquinaRegistradora maquinaRegistradoraXID(@PathVariable(name="id") int id) {
		
		MaquinaRegistradora MaquinaRegistradora_xid= new MaquinaRegistradora();
		
		MaquinaRegistradora_xid=maquinaRegistradoraServiceImpl.maquinaRegistradoraXID(id);
		
		System.out.println("MaquinaRegistradora XID: "+MaquinaRegistradora_xid);
		
		return MaquinaRegistradora_xid;
	}
	
	@PutMapping("/maquinaRegistradoras/{id}")
	public MaquinaRegistradora actualizarMaquinaRegistradora(@PathVariable(name="id")int id,@RequestBody MaquinaRegistradora maquinaRegistradora) {
		
		MaquinaRegistradora maquinaRegistradora_seleccionado= new MaquinaRegistradora();
		MaquinaRegistradora maquinaRegistradora_actualizado= new MaquinaRegistradora();
		
		maquinaRegistradora_seleccionado= maquinaRegistradoraServiceImpl.maquinaRegistradoraXID(id);
		
		maquinaRegistradora_seleccionado.setPiso(maquinaRegistradora.getPiso());
		
		maquinaRegistradora_actualizado = maquinaRegistradoraServiceImpl.actualizarMaquinaRegistradora(maquinaRegistradora_seleccionado);
		
		System.out.println("La maquinaRegistradora actualizada es: "+ maquinaRegistradora_actualizado);
		
		return maquinaRegistradora_actualizado;
	}
	
	@DeleteMapping("/maquinaRegistradoras/{id}")
	public void eliminarMaquinaRegistradora(@PathVariable(name="id")int id) {
		maquinaRegistradoraServiceImpl.eliminarMaquinaRegistradora(id);
	}
	
}
