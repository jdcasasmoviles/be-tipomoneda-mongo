package com.jdcasas.mongodb.moneda.app.entity;
import java.io.Serializable;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Document(collection="changes")
public class CambioMoneda implements Serializable {
	
	 private static final long serialVersionUID = 1L;
	@Id
	private String   id;
	
	@NotNull
	private Float   monto;

	@NotNull
	private String monedaOrigen;

	@NotNull
	private String monedaDestino;
	
	@NotNull
	private Float tipoCambio;
	
	@NotNull
	private Float montoTipoDeCambio;
	

	
}

