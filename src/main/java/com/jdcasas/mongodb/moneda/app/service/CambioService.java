package com.jdcasas.mongodb.moneda.app.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jdcasas.mongodb.moneda.app.domain.response.TipoCambioMonedaResponse;
import com.jdcasas.mongodb.moneda.app.entity.CambioMoneda;
import com.jdcasas.mongodb.moneda.app.infrastructure.IApiTipoCambio;
import com.jdcasas.mongodb.moneda.app.repository.CambioRepository;
import com.jdcasas.mongodb.moneda.app.utils.Utility;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class CambioService implements ICambioService{
	
	@Autowired
	private CambioRepository repository;
	
	@Autowired
	private IApiTipoCambio  apiTipoCambio;
	
	@Override
	 public Mono<TipoCambioMonedaResponse>  covertMoneda(CambioMoneda cambioMoneda) {
		
		return Mono.just(apiTipoCambio.obtenerTipoCambio(cambioMoneda.getMonedaOrigen()))
				.flatMap(res->{
					 System.out.println("Response api "+Utility.objectToJson(res));
					 cambioMoneda.setTipoCambio( res.getRates().get(cambioMoneda.getMonedaDestino()));
					 cambioMoneda.setMontoTipoDeCambio(cambioMoneda.getMonto()*cambioMoneda.getTipoCambio());
					 return  repository.insert(cambioMoneda);
				}).flatMap(x->{
					 System.out.println("Transaction "+x.getId()+"  Monto "+x.getMonto());			 
					 return  Mono.just(TipoCambioMonedaResponse.builder()
					 .monto(x.getMonto())
					 .montoTipoDeCambio(x.getMontoTipoDeCambio())
					 .monedaOrigen(x.getMonedaOrigen())
					 .monedaDestino(x.getMonedaDestino())
					 .tipoCambio(x.getTipoCambio())
					 .build()); 
		 });
	 }
	
	@Override
	public Flux<CambioMoneda> findAll() {
		return repository.findAll();
	}
}

