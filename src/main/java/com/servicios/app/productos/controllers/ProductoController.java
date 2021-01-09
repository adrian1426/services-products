package com.servicios.app.productos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.servicios.app.productos.models.entity.Producto;
import com.servicios.app.productos.models.service.IProductoService;

@RestController //transforma en json las respuestas
public class ProductoController {

	@Autowired
	private IProductoService productoService;
	
	@GetMapping("/productos")
	public List<Producto> getProducts () {
		return productoService.findAll();
	}
	
	@GetMapping("/productos/{id}")
	public Producto getProductById(@PathVariable Long id) {
		return productoService.findById(id);
	}
}
