package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.MaquinaRegistradora;

public interface IMaquinaRegistradoraService {

	public List<MaquinaRegistradora> listarMaquinaRegistradoras();
	
	public MaquinaRegistradora guardarMaquinaRegistradora(MaquinaRegistradora maquinaRegistradora);
	
	public MaquinaRegistradora maquinaRegistradoraXID(int id);
	
	public MaquinaRegistradora actualizarMaquinaRegistradora(MaquinaRegistradora maquinaRegistradora);
	
	public void eliminarMaquinaRegistradora(int id);
	
}
