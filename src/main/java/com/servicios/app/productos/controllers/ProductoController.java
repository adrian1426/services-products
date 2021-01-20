package com.servicios.app.productos.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.servicios.app.productos.models.entity.Producto;
import com.servicios.app.productos.models.service.IProductoService;

@RestController //transforma en json las respuestas
public class ProductoController {
	
	@Autowired
	private Environment env;
	
	@Value("${server.port}")
	private Integer port;

	@Autowired
	private IProductoService productoService;
	
	@GetMapping("/productos")
	public List<Producto> getProducts () {
		return productoService.findAll().stream().map(producto->{
			//producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			producto.setPort(port);
			return producto;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/productos/{id}")
	public Producto getProductById(@PathVariable Long id) {
		Producto producto=productoService.findById(id);
		//producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		producto.setPort(port);
		return producto;
	}
	
	@PostMapping("/productos")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto addProduct(@RequestBody Producto producto) {
		return productoService.addProducto(producto);
	}
	
}
