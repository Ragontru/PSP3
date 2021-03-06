package com.practica.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practica.rest.model.Producto;
import com.practica.rest.model.Seccion;

@RestController
public class SeccionServiceController {

	// Servicio de los productos
	private static Map<String, Producto> productoRepo = new HashMap<>();
	static {

		Producto pollo = new Producto("1", "Pollo");
		Producto cerdo = new Producto("2", "Cerdo");
		Producto ternera = new Producto("3", "Ternera");
		productoRepo.put(pollo.getId(), pollo);
		productoRepo.put(cerdo.getId(), cerdo);
		productoRepo.put(ternera.getId(), ternera);

		Producto pescado = new Producto("4", "Pescado");
		Producto marisco = new Producto("5", "Marisco");
		productoRepo.put(pescado.getId(), pescado);
		productoRepo.put(marisco.getId(), marisco);

		Producto fruta = new Producto("6", "Fruta");
		Producto verdura = new Producto("7", "Verdura");
		productoRepo.put(fruta.getId(), fruta);
		productoRepo.put(verdura.getId(), verdura);
	}

	// Servicio de las secciones
	private static Map<String, Seccion> seccionRepo = new HashMap<>();
	static {

		Seccion carniceria = new Seccion("1", "Carniceria");
		carniceria.getProductos().put(productoRepo.get("1").getId(), productoRepo.get("1"));
		carniceria.getProductos().put(productoRepo.get("2").getId(), productoRepo.get("2"));
		carniceria.getProductos().put(productoRepo.get("3").getId(), productoRepo.get("3"));
		seccionRepo.put(carniceria.getId(), carniceria);

		Seccion pescaderia = new Seccion("2", "Pescaderia");
		pescaderia.getProductos().put(productoRepo.get("4").getId(), productoRepo.get("4"));
		pescaderia.getProductos().put(productoRepo.get("5").getId(), productoRepo.get("5"));
		seccionRepo.put(pescaderia.getId(), pescaderia);

		Seccion fruteria = new Seccion("3", "Fruteria");
		fruteria.getProductos().put(productoRepo.get("6").getId(), productoRepo.get("6"));
		fruteria.getProductos().put(productoRepo.get("7").getId(), productoRepo.get("7"));
		seccionRepo.put(fruteria.getId(), fruteria);
	}

	// Controladores de las secciones
	/**
	 * M??todo que elimina la secci??n
	 * 
	 * @param id
	 * @return Secci??n eliminada correctamente si existe
	 */
	@DeleteMapping("/secciones/{idSec}")
	public ResponseEntity<Object> deleteSeccion(@PathVariable("idSec") String idSec) {

		if (seccionRepo.get(idSec) != null) {
			seccionRepo.remove(idSec);
			return new ResponseEntity<>("La secci??n ha sido eliminada correctamente", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("La secci??n indicada no existe", HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * M??todo que modifica los datos de la secci??n especificada
	 * 
	 * @param id
	 * @param seccion
	 * @return Secci??n modificada correctamente
	 */

	@PutMapping("/secciones/{idSec}")
	public ResponseEntity<Object> updateSeccion(@PathVariable("idSec") String idSec, @RequestBody Seccion seccion) {

		if (seccionRepo.get(idSec) != null) {
			HashMap<String, Producto> productos = seccionRepo.get(idSec).getProductos();
			seccionRepo.remove(idSec);
			seccion.setId(idSec);
			seccion.setProductos(productos);
			seccionRepo.put(idSec, seccion);
			return new ResponseEntity<>("La secci??n se ha actualizado correctamente", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("La secci??n indicada no existe", HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * M??todo que crea una secci??n nueva
	 * 
	 * @param seccion
	 * @return Secci??n creada correctamente
	 */
	@PostMapping("/secciones")
	public ResponseEntity<Object> createSeccion(@RequestBody Seccion seccion) {

		if (seccion.getId() != null && seccionRepo.get(seccion.getId()) == null) {
			seccionRepo.put(seccion.getId(), seccion);
			return new ResponseEntity<>("La secci??n se ha creado correctamente", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("No ha sido posible crear la secci??n", HttpStatus.NOT_FOUND);
		}

	}

	/**
	 * M??todo que devuelve los datos de todas las secciones
	 * 
	 * @return Datos de todas las secciones
	 */
	@GetMapping("/secciones")
	public ResponseEntity<Object> getSeccion() {

		if (seccionRepo.isEmpty()) {
			return new ResponseEntity<>("No hay secciones", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(seccionRepo.values(), HttpStatus.OK);
		}

	}

	/**
	 * M??todo que devuelve los datos de la secci??n seleccionada
	 * 
	 * @param id
	 * @return Datos de una secci??n espec??fica
	 */
	@GetMapping("/secciones/{idSec}")
	public ResponseEntity<Object> getSeccionById(@PathVariable("idSec") String idSec) {

		if (!seccionRepo.isEmpty() && seccionRepo.get(idSec) != null) {
			return new ResponseEntity<>(seccionRepo.get(idSec), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("No existe la secci??n indicada", HttpStatus.NOT_FOUND);
		}

	}

	// Controladores de los productos
	/**
	 * 
	 * @param idSec
	 * @param idProd
	 * @return Si se puede eliminar o no el producto indicado
	 */
	@DeleteMapping("/secciones/{idSec}/productos/{idProd}")
	public ResponseEntity<Object> delete(@PathVariable("idSec") String idSec, @PathVariable("idProd") String idProd) {

		if (productoRepo.get(idProd) != null && seccionRepo.get(idSec).getProductos().containsKey(idProd)) {
			productoRepo.remove(idProd);
			seccionRepo.get(idSec).eliminaProducto(idProd);
			return new ResponseEntity<>("El producto ha sido eliminado correctamente", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("El producto no se ha eliminado porque no se encuentra en la secci??n indicada",
					HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * 
	 * @param idSec
	 * @param idProd
	 * @param producto
	 * @return Si se actualiza o no un producto de la secci??n
	 */
	@PutMapping("/secciones/{idSec}/productos/{idProd}")
	public ResponseEntity<Object> updateProducto(@PathVariable("idSec") String idSec,
			@PathVariable("idProd") String idProd, @RequestBody Producto producto) {

		if (productoRepo.get(idProd) != null && seccionRepo.get(idSec).getProductos().containsKey(idProd)
				&& productoRepo.containsKey(idProd)) {
			productoRepo.remove(idProd);
			seccionRepo.get(idSec).getProductos().remove(idProd);
			producto.setId(idProd);
			productoRepo.put(idProd, producto);
			seccionRepo.get(idSec).getProductos().put(idProd, producto);
			return new ResponseEntity<>("El producto se ha actualizado correctamente", HttpStatus.OK);
		} else {
			return new ResponseEntity<>(
					"El producto no se ha actualizado porque no se encuentra en la secci??n indicada",
					HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * M??todo que crea un producto en una secci??n
	 * 
	 * @param idSec
	 * @param producto
	 * @return Producto creado correctamente
	 */
	@PostMapping("/secciones/{idSec}/productos")
	public ResponseEntity<Object> createProducto(@PathVariable("idSec") String idSec, @RequestBody Producto producto) {

		if (producto.getId() != null && productoRepo.get(producto.getId()) == null && seccionRepo.containsKey(idSec)) {
			productoRepo.put(producto.getId(), producto);
			seccionRepo.get(idSec).nuevoProducto(producto);
			return new ResponseEntity<>("El producto se ha creado correctamente", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("El producto se ha podido crear", HttpStatus.NOT_FOUND);
		}

	}

	/**
	 * M??todo que muestra los datos de todos los productos de una secci??n
	 * 
	 * @param idSec
	 * @return Datos de todos los productos de una secci??n
	 */
	@GetMapping("/secciones/{idSec}/productos")
	public ResponseEntity<Object> getProductos(@PathVariable("idSec") String idSec) {
		if (!seccionRepo.containsKey(idSec) || seccionRepo.get(idSec).getProductos().isEmpty()) {
			return new ResponseEntity<>("Esta secci??n no existe o no contiene productos", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(seccionRepo.get(idSec).getProductos().values(), HttpStatus.OK);
		}

	}

	/**
	 * M??todo que muestra los datos de un producto de una secci??n en particular
	 * 
	 * @param idSec
	 * @param idProd
	 * @return Datos de un producto espec??fico en una secci??n en particular
	 */
	@GetMapping("/secciones/{idSec}/productos/{idProd}")
	public ResponseEntity<Object> getProductoById(@PathVariable("idSec") String idSec,
			@PathVariable("idProd") String idProd) {
		if (seccionRepo.get(idSec) != null && seccionRepo.get(idSec).getProductos().containsKey(idProd)) {
			return new ResponseEntity<>(productoRepo.get(idProd), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Esta secci??n no existe o no contiene productos", HttpStatus.NOT_FOUND);
		}
	}
}
