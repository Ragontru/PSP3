package com.psp.practicaSOAPWS;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import com.psp.xml.fruteria.Fruta;
import com.psp.xml.fruteria.Verdura;

@Component
public class FruteriaRepository {
	/** Hashmap que guarda las frutas */
	private static final Map<String, Fruta> frutas = new HashMap<>();

	/** Hashmap que guarda las verduras */
	private static final Map<String, Verdura> verduras = new HashMap<>();
	
	@PostConstruct
	public void initData() {

		// Frutas
		Fruta fruta = new Fruta();
		fruta.setNombre("Fresa");
		fruta.setVariacion("Tudla");
		fruta.setPrecio(2.4);
		frutas.put(fruta.getNombre(), fruta);
		
		fruta = new Fruta();
		fruta.setNombre("Fresa");
		fruta.setVariacion("Reina de los valles");
		fruta.setPrecio(3.3);
		frutas.put(fruta.getNombre(), fruta);

		fruta = new Fruta();
		fruta.setNombre("Kiwi");
		fruta.setVariacion("Verde");
		fruta.setPrecio(1.9);
		frutas.put(fruta.getNombre(), fruta);
		
		fruta = new Fruta();
		fruta.setNombre("Kiwi");
		fruta.setVariacion("Hayward");
		fruta.setPrecio(2.9);
		frutas.put(fruta.getNombre(), fruta);

		fruta = new Fruta();
		fruta.setNombre("Plátano");
		fruta.setVariacion("Macho");
		fruta.setPrecio(0.7);
		frutas.put(fruta.getNombre(), fruta);
		
		fruta = new Fruta();
		fruta.setNombre("Plátano");
		fruta.setVariacion("Enano gigante");
		fruta.setPrecio(1.2);
		frutas.put(fruta.getNombre(), fruta);
		
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

	public Fruta findFruta(String nombre) {
		Assert.notNull(nombre, "El nombre de la fruta no puede ser nulo");
		return frutas.get(nombre);
	}
	
	public Verdura findVerdura(String nombre) {
		Assert.notNull(nombre, "El nombre de la verdura no puede ser nulo");
		return verduras.get(nombre);
	}
}