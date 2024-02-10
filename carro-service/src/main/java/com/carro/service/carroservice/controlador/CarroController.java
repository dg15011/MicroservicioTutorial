package com.carro.service.carroservice.controlador;

import com.carro.service.carroservice.entidades.Carro;
import com.carro.service.carroservice.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carro")
public class CarroController {
    @Autowired
    private CarroService carroService;
    @GetMapping
    public ResponseEntity<List<Carro>> listaCarro(){
        List<Carro> carros=carroService.getAll();
        if(carros.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(carros);
        }
    }
    public ResponseEntity<List<Carro>> listaCarroUsuario(int id){
        List<Carro> carros=carroService.byUsuarioId(id);
        if(carros.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(carros);
        }
    }
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Carro>> ObtenerCarro(@PathVariable("usuarioId") int id){
        List<Carro> buscarUsuario=carroService.byUsuarioId(id);
        if(buscarUsuario==null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(buscarUsuario);
        }
    }

    @PostMapping
    public  ResponseEntity<Carro> guardarCarro(@RequestBody  Carro carro){
        Carro nuevoCarro= carroService.save(carro);
        return  ResponseEntity.ok(nuevoCarro);
    }
}
