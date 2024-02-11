package com.ues.usuarioservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableFeignClients
@SpringBootApplication
public class UsuarioService3Application {

	public static void main(String[] args) {
		SpringApplication.run(UsuarioService3Application.class, args);
	}

}
