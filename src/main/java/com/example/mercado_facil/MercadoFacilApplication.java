package com.example.mercado_facil;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(title = "Mercado Fácil", description = "Documentação da API de acesso aos endpoints com Swagger"),
        servers = {
                @Server(url = "http://localhost:8080")
        }
)
@SpringBootApplication
public class MercadoFacilApplication {

    public static void main(String[] args) {
        SpringApplication.run(MercadoFacilApplication.class, args);
    }

}
