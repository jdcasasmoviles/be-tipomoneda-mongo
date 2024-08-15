package com.jdcasas.mongodb.moneda.app.repository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.jdcasas.mongodb.moneda.app.entity.CambioMoneda;

public interface CambioRepository extends ReactiveMongoRepository<CambioMoneda,String>{

}
