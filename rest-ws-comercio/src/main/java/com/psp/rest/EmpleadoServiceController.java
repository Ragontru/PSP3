package com.psp.rest;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.psp.rest.model.Empleado;

@RestController
public class EmpleadoServiceController {

	private static Map<String, Empleado> empleadoRepo = new HashMap<>();
	static {
		Empleado honey = new Empleado();
		honey.setId("1");
		honey.setName("Honey");
		empleadoRepo.put(honey.getId(), honey);

		Empleado almond = new Empleado();
		almond.setId("2");
		almond.setName("Almond");
		empleadoRepo.put(almond.getId(), almond);
	}

	// @RequestMapping(value = "/empleados/{id}", method = RequestMethod.DELETE)
	@DeleteMapping("/empleados/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") String id) {
		empleadoRepo.remove(id);
		return new ResponseEntity<>("Empleado is deleted successsfully", HttpStatus.OK);
	}

	// @RequestMapping(value = "/empleados/{id}", method = RequestMethod.PUT)
	@PutMapping("/empleados/{id}")
	public ResponseEntity<Object> updateEmpleado(@PathVariable("id") String id, @RequestBody Empleado empleado) {
		empleadoRepo.remove(id);
		empleado.setId(id);
		empleadoRepo.put(id, empleado);
		return new ResponseEntity<>("Empleado is updated successsfully", HttpStatus.OK);
	}

	// @RequestMapping(value = "/empleados", method = RequestMethod.POST)
	@PostMapping("/empleados")
	public ResponseEntity<Object> createEmpleado(@RequestBody Empleado empleado) {
		empleadoRepo.put(empleado.getId(), empleado);
		return new ResponseEntity<>("Empleado is created successfully", HttpStatus.CREATED);
	}

	// @RequestMapping(value = "/empleados")
	@GetMapping(value = "/empleados")
	public ResponseEntity<Object> getEmpleado() {
		return new ResponseEntity<>(empleadoRepo.values(), HttpStatus.OK);
	}

	@GetMapping(value = "/empleados/{id}")
	public ResponseEntity<Object> getEmpleadoById(@PathVariable("id") String id) {
		return new ResponseEntity<>(empleadoRepo.get(id), HttpStatus.OK);
	}
}
