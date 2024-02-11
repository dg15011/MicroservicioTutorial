package com.ues.usuarioservice.usuarioservice.feingClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.ues.usuarioservice.usuarioservice.modelos.Carro;

import java.util.List;

@FeignClient(name = "carro-service",url = "http://localhost:8002")
@RequestMapping("/carro")
public interface CarroFeingClient {
    @PostMapping()
    public Carro save(@RequestBody Carro carro);
    @GetMapping("usuario/{usuarioId}")
    public List<Carro> getCarros(@PathVariable("usuarioId") int usuarioId);
}
