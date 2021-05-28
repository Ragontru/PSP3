package com.psp.practicaSOAPWS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.psp.xml.fruteria.FrutaDetailsRequest;
import com.psp.xml.fruteria.FrutaDetailsResponse;

@Endpoint
public class FruteriaEndpoint {
	private static final String NAMESPACE_URI = "http://www.psp.com/xml/fruteria";

	private FruteriaRepository FruteriaRepository;

	@Autowired
	public FruteriaEndpoint(FruteriaRepository FruteriaRepository) {
		this.FruteriaRepository = FruteriaRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "FrutaDetailsRequest")
	@ResponsePayload
	public FrutaDetailsResponse getFruta(@RequestPayload FrutaDetailsRequest request) {
		FrutaDetailsResponse response = new FrutaDetailsResponse();
		response.setFruta(FruteriaRepository.findFruta(request.getNombre()));

		return response;
	}
}
