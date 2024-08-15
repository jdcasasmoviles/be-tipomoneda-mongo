package com.jdcasas.mongodb.moneda.app.service;
import com.jdcasas.mongodb.moneda.app.domain.response.TipoCambioMonedaResponse;
import com.jdcasas.mongodb.moneda.app.entity.CambioMoneda;

import reactor.core.publisher.Mono;

public interface ICambioService {

	Mono<TipoCambioMonedaResponse>   covertMoneda(CambioMoneda cambioMoneda);
}
