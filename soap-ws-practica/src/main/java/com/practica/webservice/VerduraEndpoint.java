package com.practica.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.practica.xml.fruteria.VerduraNombreVarianteRequest;
import com.practica.xml.fruteria.VerduraNombreVarianteResponse;
import com.practica.xml.fruteria.VerduraVariantePrecioRequest;
import com.practica.xml.fruteria.VerduraVariantePrecioResponse;
import com.practica.xml.fruteria.VerduraDetailsRequest;
import com.practica.xml.fruteria.VerduraDetailsResponse;

@Endpoint
public class VerduraEndpoint {
	private static final String NAMESPACE_URI = "http://www.practica.com/xml/fruteria";
	
	private VerduraRepository VerduraRepository;

	@Autowired
	    public VerduraEndpoint(VerduraRepository VerduraRepository) {
	        this.VerduraRepository = VerduraRepository;
	    }

	/**
	 * Recoge el nombre de una verdura y devuelve todos los detalles de ésta
	 * 
	 * @param request
	 * @return
	 */
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "VerduraDetailsRequest")
	@ResponsePayload
	public VerduraDetailsResponse getVerdura(@RequestPayload VerduraDetailsRequest request) {
		VerduraDetailsResponse response = new VerduraDetailsResponse();
		response.setVerdura(VerduraRepository.findVerdura(request.getNombre()));

		return response;
	}
	
	/**
	 * Recoge el nombre de una verdura y devuelve la variante de ésta
	 * 
	 * @param request
	 * @return
	 */
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "VerduraNombreVarianteRequest")
	@ResponsePayload
	public VerduraNombreVarianteResponse getVerduraNombreVariante(@RequestPayload VerduraNombreVarianteRequest request) {
		VerduraNombreVarianteResponse response = new VerduraNombreVarianteResponse();
		response.setVariante(VerduraRepository.findVerdura(request.getNombre()).getVariante());

		return response;
	}
	
	/**
	 * Recoge la variante de una verdura y devuelve el precio de ésta
	 * 
	 * @param request
	 * @return
	 */
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "VerduraVariantePrecioRequest")
	@ResponsePayload
	public VerduraVariantePrecioResponse getVerduraVariantePrecio(@RequestPayload VerduraVariantePrecioRequest request) {
		VerduraVariantePrecioResponse response = new VerduraVariantePrecioResponse();
		response.setPrecio(VerduraRepository.findVerdura(request.getVariante()).getPrecio());

		return response;
	}
}
