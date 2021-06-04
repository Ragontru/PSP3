package com.practica.webservice;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import com.practica.xml.fruteria.Verdura;

@Component
public class VerduraRepository {
	private static final Map<String, Verdura> verduras = new HashMap<>();

	@PostConstruct
	public void initData() {

		Verdura verdura = new Verdura();
		verdura.setNombre("Cebolla");
		verdura.setVariante("Morada");
		verdura.setPrecio(0.8);
		verduras.put(verdura.getNombre(), verdura);

		verdura = new Verdura();
		verdura.setNombre("Lechuga");
		verdura.setVariante("Iceberg");
		verdura.setPrecio(1.35);
		verduras.put(verdura.getNombre(), verdura);

		verdura = new Verdura();
		verdura.setNombre("Brócoli");
		verdura.setVariante("Romanesco");
		verdura.setPrecio(0.7);
		verduras.put(verdura.getNombre(), verdura);

		verdura = new Verdura();
		verdura.setNombre("Espinacas");
		verdura.setVariante("Viking");
		verdura.setPrecio(1.5);
		verduras.put(verdura.getNombre(), verdura);

		verdura = new Verdura();
		verdura.setNombre("Boniato");
		verdura.setVariante("Violeta Roja");
		verdura.setPrecio(2.3);
		verduras.put(verdura.getNombre(), verdura);
	}

	/**
	 * Devuelve la verdura que tenga el nombre que coincida con el pasado por parámetro
	 * 
	 * @param nombre
	 * @return
	 */
	public Verdura findVerdura(String nombre) {
		Assert.notNull(nombre, "El nombre de la verdura no puede ser null");
		return verduras.get(nombre);
	}
}
