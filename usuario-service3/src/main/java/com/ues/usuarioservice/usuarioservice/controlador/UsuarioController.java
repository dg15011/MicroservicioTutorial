package com.ues.usuarioservice.usuarioservice.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ues.usuarioservice.usuarioservice.configuracion.RestTemplateConfig;
import com.ues.usuarioservice.usuarioservice.entidades.Usuario;
import com.ues.usuarioservice.usuarioservice.modelos.Carro;
import com.ues.usuarioservice.usuarioservice.modelos.Moto;
import com.ues.usuarioservice.usuarioservice.service.UsuarioService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> listaUsuario(){
        List<Usuario> usuarios=usuarioService.getAll();
        if(usuarios.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(usuarios);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> ObtenerUsuario(@PathVariable("id") int id){
        Usuario buscarUsuario= usuarioService.getUsuarioById(id);
        if(buscarUsuario==null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(buscarUsuario);
        }
    }
    @PostMapping
    public  ResponseEntity<Usuario> guardarusuario(@RequestBody  Usuario usuario){
        Usuario nuevoUsuario= usuarioService.save(usuario);
        return  ResponseEntity.ok(nuevoUsuario);
    }

    @GetMapping("/carros/{usuarioId}")
    public ResponseEntity<List<Carro>> listaCarros(@PathVariable("usuarioId") int usuarioId){
      Usuario usuario= usuarioService.getUsuarioById(usuarioId);
      if(usuario==null){
          return ResponseEntity.notFound().build();
      }else{
          List<Carro> listaCarros=usuarioService.getCarros(usuarioId);
          if(listaCarros.isEmpty()){
              return ResponseEntity.noContent().build();
          }else{
              return ResponseEntity.ok(listaCarros);
          }
      }
    }
    @GetMapping("/motos/{usuarioId}")
    public ResponseEntity<List<Moto>> listaMotos(@PathVariable("usuarioId") int usuarioId){
        Usuario usuario= usuarioService.getUsuarioById(usuarioId);
        if(usuario==null){
            return ResponseEntity.notFound().build();
        }else {
            List<Moto> listaMoto = usuarioService.getMotos(usuarioId);
            if (listaMoto.isEmpty()) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.ok(listaMoto);
            }
        }
    }
    @GetMapping("/todos/{usuarioId}")
    public ResponseEntity<Map<String,Object>>listarTodosLosVehiculos(@PathVariable("usuarioId") int usuarioId){
        Map<String,Object> resultado=usuarioService.getUsuarioAndVehiculo(usuarioId);
        return ResponseEntity.ok(resultado);
    }
    @PostMapping("/carro/{usuarioId}")
    public  ResponseEntity<Carro> guardarCarroUsuario(@PathVariable("usuarioId") int usuarioId,@RequestBody  Carro carro){
        Carro nuevoCarro= usuarioService.saveCarro(usuarioId,carro);
        return  ResponseEntity.ok(nuevoCarro);
    }
    @PostMapping("/moto/{usuarioId}")
    public  ResponseEntity<Moto> guardarMotoUsuario(@PathVariable("usuarioId") int usuarioId,@RequestBody  Moto moto){
        Moto nuevoMoto= usuarioService.saveMoto(usuarioId,moto);
        return  ResponseEntity.ok(nuevoMoto);
    }
}
