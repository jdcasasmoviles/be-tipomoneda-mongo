package com.jdcasas.mongodb.moneda.app.infrastructure;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jdcasas.mongodb.moneda.app.infrastructure.model.apitipocambio.TipoCambioResponse;

@FeignClient(value = "productsBlocking", url = "https://open.er-api.com")
public interface IApiTipoCambio {
	
	  @RequestMapping(method = RequestMethod.GET, value = "/v6/latest/{rate}", produces = "application/json")
	  TipoCambioResponse    obtenerTipoCambio(@PathVariable String rate);
}

