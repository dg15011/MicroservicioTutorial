package com.ues.usuarioservice.usuarioservice.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    @Bean
    //comunicar los microservicios
    public RestTemplate restTemplate (){
        return new RestTemplate();
    }
}
