package com.example.demo.dto;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name ="maquinas_registradoras")
public class MaquinaRegistradora {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "piso")
	private int piso;
	
	@OneToMany
	@JoinColumn(name="id")
	private List<Venta> venta;

	public MaquinaRegistradora() {
		super();
	}

	public MaquinaRegistradora(int id, int piso, List<Venta> venta) {
		super();
		this.id = id;
		this.piso = piso;
		this.venta = venta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Venta")
	public List<Venta> getVenta() {
		return venta;
	}

	public void setVenta(List<Venta> venta) {
		this.venta = venta;
	}

	@Override
	public String toString() {
		return "Pieza [id=" + id + ", piso=" + piso + ", venta=" + venta + "]";
	}
	
	

}
