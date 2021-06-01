package com.practica.rest.model;

public class Producto {

	private String id;
	private String nombre;

	// Constructores
	public Producto() {

	}

	/**
	 * @param id
	 * @param nombre
	 */
	public Producto(String id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	// Getters y setters
	/**
	 * Devuelve el id del producto
	 * 
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Establece el id del producto
	 * 
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Devuelve el nombre del producto
	 * 
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del producto
	 * 
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
