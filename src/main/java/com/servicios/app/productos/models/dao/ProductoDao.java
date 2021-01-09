package com.servicios.app.productos.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.servicios.app.productos.models.entity.Producto;

//entidad(Producto) y tipo del id de la entidad(Long)
public interface ProductoDao extends CrudRepository<Producto, Long>{

}
