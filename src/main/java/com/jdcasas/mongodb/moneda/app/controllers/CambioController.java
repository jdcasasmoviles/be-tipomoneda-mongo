package com.jdcasas.mongodb.moneda.app.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jdcasas.mongodb.moneda.app.domain.request.TipoCambioMonedaRequest;
import com.jdcasas.mongodb.moneda.app.domain.response.TipoCambioMonedaResponse;
import com.jdcasas.mongodb.moneda.app.entity.CambioMoneda;
import com.jdcasas.mongodb.moneda.app.service.CambioService;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/cambio")
public class CambioController {
	
	@Autowired
	private CambioService service;
	@GetMapping("/prueba")
	public String prueba() {
		return "Hola Monedas";
	}
	
	@PostMapping("/tipoCambio")
	public Mono<TipoCambioMonedaResponse> tipoCambio(@Valid @RequestBody TipoCambioMonedaRequest request) {
		return service.covertMoneda(CambioMoneda.builder()
				.monto(request.getMonto())
				.monedaOrigen(request.getMonedaOrigen())
				.monedaDestino(request.getMonedaDestino())
				.build());
	}
	
	@GetMapping("/findAll")
	public Flux<CambioMoneda>  listaCambios() {
		return service.findAll();
	}
}
