package com.servicios.app.productos.models.service;

import java.util.List;

import com.servicios.app.productos.models.entity.Producto;

public interface IProductoService {
	
	public List<Producto> findAll();
	public Producto findById(Long id);
	public Producto addProducto(Producto producto);
	public void deleteById(Long id);

}
