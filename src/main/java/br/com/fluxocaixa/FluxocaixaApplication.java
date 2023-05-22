package br.com.fluxocaixa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class FluxocaixaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FluxocaixaApplication.class, args);
	}

    @Bean
    ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

}
