package com.psp.practicaSOAPWS;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.psp.xml.fruteria.Verdura;

@Component
public class VerduraRepository {
	/** Hashmap que guarda las verduras */
	private static final Map<String, Verdura> verduras = new HashMap<>();

	@PostConstruct
	public void initData() {

		// Verduras
		Verdura verdura = new Verdura();
		verdura.setNombre("Cebolla");
		verdura.setVariacion("Blanca");
		verdura.setPrecio(0.6);
		verduras.put(verdura.getNombre(), verdura);

		verdura = new Verdura();
		verdura.setNombre("Cebolla");
		verdura.setVariacion("Morada");
		verdura.setPrecio(1.3);
		verduras.put(verdura.getNombre(), verdura);

		verdura = new Verdura();
		verdura.setNombre("Lechuga");
		verdura.setVariacion("Romana");
		verdura.setPrecio(1.1);
		verduras.put(verdura.getNombre(), verdura);

		verdura = new Verdura();
		verdura.setNombre("Lechuga");
		verdura.setVariacion("Iceberg");
		verdura.setPrecio(1.2);
		verduras.put(verdura.getNombre(), verdura);

		verdura = new Verdura();
		verdura.setNombre("Brócoli");
		verdura.setVariacion("Romanesco");
		verdura.setPrecio(0.7);
		verduras.put(verdura.getNombre(), verdura);

		verdura = new Verdura();
		verdura.setNombre("Brócoli");
		verdura.setVariacion("Verona");
		verdura.setPrecio(1.2);
		verduras.put(verdura.getNombre(), verdura);
		
	}

	public Verdura findVerdura(String nombre) {
		Assert.notNull(nombre, "El nombre de la verdura no puede ser nulo");
		return verduras.get(nombre);
	}
}
