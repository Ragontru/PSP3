package com.practica.webservice;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import com.practica.xml.fruteria.Fruta;

@Component
public class FrutaRepository {
	private static final Map<String, Fruta> frutas = new HashMap<>();

	@PostConstruct
	public void initData() {

		Fruta fruta = new Fruta();
		fruta.setNombre("Fresa");
		fruta.setVariante("Reina de los valles");
		fruta.setPrecio(2.2);
		frutas.put(fruta.getNombre(), fruta);

		fruta = new Fruta();
		fruta.setNombre("Kiwi");
		fruta.setVariante("Verde");
		fruta.setPrecio(3.4);
		frutas.put(fruta.getNombre(), fruta);

		fruta = new Fruta();
		fruta.setNombre("Plátano");
		fruta.setVariante("Macho");
		fruta.setPrecio(0.4);
		frutas.put(fruta.getNombre(), fruta);

		fruta = new Fruta();
		fruta.setNombre("Manzana");
		fruta.setVariante("Golden");
		fruta.setPrecio(1.2);
		frutas.put(fruta.getNombre(), fruta);
		
		fruta = new Fruta();
		fruta.setNombre("Aguacate");
		fruta.setVariante("Bacon");
		fruta.setPrecio(3.6);
		frutas.put(fruta.getNombre(), fruta);
	}

	/**
	 * Devuelve la fruta que tenga el nombre que coincida con el pasado por parámetro
	 * 
	 * @param nombre
	 * @return
	 */
	public Fruta findFruta(String nombre) {
		Assert.notNull(nombre, "El nombre de la fruta no puede ser null");
		return frutas.get(nombre);
	}
}
