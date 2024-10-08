package com.jdcasas.mongodb.moneda.app;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

@EnableFeignClients
@SpringBootApplication
public class ApiTipocambioMonedaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiTipocambioMonedaApplication.class, args);
	}

	@Bean
	public Decoder decoder(ObjectMapper objectMapper) {
	    return new JacksonDecoder(objectMapper);
	}

	@Bean
	public Encoder encoder(ObjectMapper objectMapper) {
	    return new JacksonEncoder(objectMapper);
	}
}
