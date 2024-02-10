package com.moto.service.motoservice.controlador;

import com.moto.service.motoservice.entidades.Moto;
import com.moto.service.motoservice.service.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moto")
public class MotoController {
    @Autowired
    private MotoService motoService;
    @GetMapping
    public ResponseEntity<List<Moto>> ListaMoto(){
       List<Moto> listaMotos=motoService.getAll();
       if(listaMotos.isEmpty()){
           return ResponseEntity.noContent().build();
       }else{
           return ResponseEntity.ok(listaMotos);
       }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Moto> BuscarMoto(@PathVariable("id") int id){
        Moto buscarMoto= motoService.getMotoById(id);
        if(buscarMoto==null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(buscarMoto);
        }
    }
    @PostMapping
    public ResponseEntity<Moto> GuardarMoto(@RequestBody  Moto moto){
        Moto guardarMoto= motoService.save(moto);
        return ResponseEntity.ok(guardarMoto);
    }
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Moto>> ListaUsuarioMotos(@PathVariable("usuarioId")  int usuarioId){
        List<Moto> listaMotos=motoService.byUsuarioId(usuarioId);
        if(listaMotos.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(listaMotos);
        }
    }
}
