package com.example.demo.dto;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name ="productos")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "precio")
	private int precio;
	
	@OneToMany
	@JoinColumn(name="id")
	private List<Venta> venta;

	public Producto() {
		super();
	}

	public Producto(int id, String nombre,int precio, List<Venta> venta) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.venta = venta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
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
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", venta=" + venta + "]";
	}
	
	

}
