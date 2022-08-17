package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.ProductoServiceImpl;
import com.example.demo.dto.Producto;

@RestController
@RequestMapping("/api")
public class ProductoController {

	@Autowired
	ProductoServiceImpl productoServiceImpl;
	
	@GetMapping("/productos")
	public List<Producto> listarProductos() {
		return productoServiceImpl.listarProductos();
	}
	
	@PostMapping("/productos")
	public Producto salvarProducto(@RequestBody Producto producto) {
		return productoServiceImpl.guardarProducto(producto);
	}
	
	@GetMapping("/productos/{id}")
	public Producto productoXID(@PathVariable(name="id") int id) {
		
		Producto Producto_xid= new Producto();
		
		Producto_xid=productoServiceImpl.productoXID(id);
		
		System.out.println("Producto XID: "+Producto_xid);
		
		return Producto_xid;
	}
	
	@PutMapping("/productos/{id}")
	public Producto actualizarProducto(@PathVariable(name="id")int id,@RequestBody Producto producto) {
		
		Producto producto_seleccionado= new Producto();
		Producto producto_actualizado= new Producto();
		
		producto_seleccionado= productoServiceImpl.productoXID(id);
		
		producto_seleccionado.setNombre(producto.getNombre());
		producto_seleccionado.setPrecio(producto.getPrecio());
		
		producto_actualizado = productoServiceImpl.actualizarProducto(producto_seleccionado);
		
		System.out.println("La producto actualizada es: "+ producto_actualizado);
		
		return producto_actualizado;
	}
	
	@DeleteMapping("/productos/{id}")
	public void eliminarProducto(@PathVariable(name="id")int id) {
		productoServiceImpl.eliminarProducto(id);
	}
	
}
