package com.psp.practicaSOAPWS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.psp.xml.fruteria.FrutaDetailsRequest;
import com.psp.xml.fruteria.FrutaDetailsResponse;
import com.psp.xml.fruteria.FrutaPrecioRequest;
import com.psp.xml.fruteria.FrutaPrecioResponse;

@Endpoint
public class FrutaEndpoint {
	private static final String NAMESPACE_URI = "http://www.psp.com/xml/fruteria";

	private FrutaRepository FrutaRepository;

	@Autowired
	public FrutaEndpoint(FrutaRepository FrutaRepository) {
		this.FrutaRepository = FrutaRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "FrutaDetailsRequest")
	@ResponsePayload
	public FrutaDetailsResponse getFruta(@RequestPayload FrutaDetailsRequest request) {
		FrutaDetailsResponse response = new FrutaDetailsResponse();
		response.setFruta(FrutaRepository.findFruta(request.getNombre()));

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "FrutaDetailsRequest")
	@ResponsePayload
	public FrutaPrecioResponse getFruta(@RequestPayload FrutaPrecioRequest request) {
		FrutaPrecioResponse response = new FrutaPrecioResponse();
		response.setPrecio(FrutaRepository.findFruta(request.getNombre()).getPrecio());

		return response;
	}
}
