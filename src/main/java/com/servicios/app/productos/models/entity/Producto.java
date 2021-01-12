package com.servicios.app.productos.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="productos") //es opcional, si no se indica, toma el nombre de la clase
//serializable, para convertir el entity en byte, es opcional
public class Producto implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	private Double precio;
	
	@Column(name = "created_at")
	@Temporal(TemporalType.DATE)
	private Date createdAt;
	
	@Transient //indica que no será mapeado en bd y no es persistente
	private Integer port;
  
	public Long getId() {
		return id;
	};
	
	public void setId(Long id) {
		this.id = id;
	};
	
	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getNombre() {
		return nombre;
	};
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	};
	
	public Double getPrecio() {
		return precio;
	};
	
	public void setPrecio(Double precio) {
		this.precio = precio;
	};
	
	public Date getCreatedAt() {
		return createdAt;
	};
	
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	};
  
	private static final long serialVersionUID = -5878000075397025212L;
}
