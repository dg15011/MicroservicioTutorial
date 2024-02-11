package com.ues.usuarioservice.usuarioservice.feingClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.ues.usuarioservice.usuarioservice.modelos.Carro;
import com.ues.usuarioservice.usuarioservice.modelos.Moto;

import java.util.List;

@FeignClient(name = "moto-service",url = "http://localhost:8003")
@RequestMapping("/moto")
public interface MotoFeingClient {
    @PostMapping()
    public Moto save(@RequestBody Moto moto);
    @GetMapping("usuario/{usuarioId}")
    public List<Moto> getMotos(@PathVariable("usuarioId") int usuarioId);
}
