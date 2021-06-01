package com.practica.rest.model;

import java.util.HashMap;

public class Seccion {

	private String id;
	private String nombreSeccion;
	public HashMap<String, Producto> productos;

	// Constructores
	public Seccion() {

	}

	/**
	 * @param id
	 * @param nombreSeccion
	 */
	public Seccion(String id, String nombreSeccion) {
		super();
		this.id = id;
		this.nombreSeccion = nombreSeccion;
		this.productos = new HashMap<>();
	}

	// Getters y setters
	/**
	 * Devuelve el id de la sección del supermercado
	 * 
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Establece el id de la sección del supermercado
	 * 
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Devuelve el nombre de la sección del supermercado
	 * 
	 * @return the nombreSeccion
	 */
	public String getNombreSeccion() {
		return nombreSeccion;
	}

	/**
	 * Establece el nombre de la sección del supermercado
	 * 
	 * @param nombreSeccion the nombreSeccion to set
	 */
	public void setNombreSeccion(String nombreSeccion) {
		this.nombreSeccion = nombreSeccion;
	}

	/**
	 * Devuelve una coleccion de los productos de la sección del supermercado
	 * 
	 * @return
	 */
	public HashMap<String, Producto> getProductos() {
		return productos;
	}

	/**
	 * Establece una colección de los productos de la sección del supermercado
	 * 
	 * @param productos
	 */
	public void setProductos(HashMap<String, Producto> productos) {
		this.productos = productos;
	}

	/**
	 * Añade un producto a la colección de la sección del supermercado
	 * 
	 * @param producto
	 */
	public void nuevoProducto(Producto producto) {
		this.productos.put(producto.getId(), producto);
	}

	/**
	 * Elimina un producto a la colección de la sección del supermercado
	 * 
	 * @param idProd
	 */
	public void eliminaProducto(String idProd) {
		this.productos.remove(idProd);
	}

}
