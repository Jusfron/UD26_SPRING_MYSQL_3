package com.example.demo.dto;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name ="cajeros")
public class Cajero {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "nom_apels")
	private String nomApels;
	
	@OneToMany
	@JoinColumn(name="id")
	private List<Venta> venta;

	public Cajero() {
		super();
	}

	public Cajero(int id, String nomApels, List<Venta> venta) {
		super();
		this.id = id;
		this.nomApels = nomApels;
		this.venta = venta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomApels() {
		return nomApels;
	}

	public void setNomApels(String nomApels) {
		this.nomApels = nomApels;
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
		return "Pieza [id=" + id + ", nombre=" + nomApels + ", venta=" + venta + "]";
	}
	
	

}
