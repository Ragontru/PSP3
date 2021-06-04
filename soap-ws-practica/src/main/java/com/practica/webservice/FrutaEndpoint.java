package com.practica.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.practica.xml.fruteria.FrutaDetailsRequest;
import com.practica.xml.fruteria.FrutaDetailsResponse;
import com.practica.xml.fruteria.FrutaNombreVarianteRequest;
import com.practica.xml.fruteria.FrutaNombreVarianteResponse;
import com.practica.xml.fruteria.FrutaVariantePrecioRequest;
import com.practica.xml.fruteria.FrutaVariantePrecioResponse;

@Endpoint
public class FrutaEndpoint {
	private static final String NAMESPACE_URI = "http://www.practica.com/xml/fruteria";

	private FrutaRepository FrutaRepository;

	@Autowired
	public FrutaEndpoint(FrutaRepository FrutaRepository) {
		this.FrutaRepository = FrutaRepository;
	}

	/**
	 * Recoge el nombre de una fruta y devuelve todos los detalles de ésta
	 * 
	 * @param request
	 * @return
	 */
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "FrutaDetailsRequest")
	@ResponsePayload
	public FrutaDetailsResponse getFruta(@RequestPayload FrutaDetailsRequest request) {
		FrutaDetailsResponse response = new FrutaDetailsResponse();
		response.setFruta(FrutaRepository.findFruta(request.getNombre()));

		return response;
	}

	/**
	 * Recoge el nombre de una fruta y devuelve la variante de ésta
	 * 
	 * @param request
	 * @return
	 */
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "FrutaNombreVarianteRequest")
	@ResponsePayload
	public FrutaNombreVarianteResponse getFrutaNombreVariante(@RequestPayload FrutaNombreVarianteRequest request) {
		FrutaNombreVarianteResponse response = new FrutaNombreVarianteResponse();
		response.setVariante(FrutaRepository.findFruta(request.getNombre()).getVariante());

		return response;
	}
	
	/**
	 * Recoge la variante de una fruta y devuelve el precio de ésta
	 * 
	 * @param request
	 * @return
	 */
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "FrutaVariantePrecioRequest")
	@ResponsePayload
	public FrutaVariantePrecioResponse getFrutaVariantePrecio(@RequestPayload FrutaVariantePrecioRequest request) {
		FrutaVariantePrecioResponse response = new FrutaVariantePrecioResponse();
		response.setPrecio(FrutaRepository.findFruta(request.getVariante()).getPrecio());

		return response;
	}
}
