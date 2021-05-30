package com.psp.practicaSOAPWS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.psp.xml.fruteria.VerduraDetailsRequest;
import com.psp.xml.fruteria.VerduraDetailsResponse;
import com.psp.xml.fruteria.VerduraPrecioRequest;
import com.psp.xml.fruteria.VerduraPrecioResponse;

@Endpoint
public class VerduraEndpoint {
	private static final String NAMESPACE_URI = "http://www.psp.com/xml/fruteria";

	private VerduraRepository VerduraRepository;

	@Autowired
	public VerduraEndpoint(VerduraRepository VerduraRepository) {
		this.VerduraRepository = VerduraRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "VerduraDetailsRequest")
	@ResponsePayload
	public VerduraDetailsResponse getVerdura(@RequestPayload VerduraDetailsRequest request) {
		VerduraDetailsResponse response = new VerduraDetailsResponse();
		response.setVerdura(VerduraRepository.findVerdura(request.getNombre()));

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "VerduraDetailsRequest")
	@ResponsePayload
	public VerduraPrecioResponse getVerdura(@RequestPayload VerduraPrecioRequest request) {
		VerduraPrecioResponse response = new VerduraPrecioResponse();
		response.setPrecio(VerduraRepository.findVerdura(request.getNombre()).getPrecio());

		return response;
	}
}
