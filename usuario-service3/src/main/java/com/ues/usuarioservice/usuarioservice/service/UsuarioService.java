package com.ues.usuarioservice.usuarioservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ues.usuarioservice.usuarioservice.configuracion.RestTemplateConfig;
import com.ues.usuarioservice.usuarioservice.entidades.Usuario;
import com.ues.usuarioservice.usuarioservice.feingClient.CarroFeingClient;
import com.ues.usuarioservice.usuarioservice.feingClient.MotoFeingClient;
import com.ues.usuarioservice.usuarioservice.modelos.Carro;
import com.ues.usuarioservice.usuarioservice.modelos.Moto;
import com.ues.usuarioservice.usuarioservice.repositorio.UsuarioRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UsuarioService {
    @Autowired
    private CarroFeingClient carroFeingClient;
    @Autowired
    private MotoFeingClient motoFeingClient;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired

    private RestTemplate restTemplate;
    public List<Usuario> getAll(){
        return usuarioRepository.findAll();
    }
    public Usuario getUsuarioById(int id){
        return usuarioRepository.findById(id).orElse(null);
    }
    public Usuario save(Usuario usuario){
        Usuario usuarioNuevo= usuarioRepository.save(usuario);
        return usuarioNuevo;
    }
    public List<Carro>getCarros(int usuarioId){
        List<Carro>carros= restTemplate.getForObject("http://localhost:8002/carro/usuario/"+usuarioId, List.class);
        return carros;
    }
    public List<Moto>getMotos(int usuarioId){
        List<Moto>motos= restTemplate.getForObject("http://localhost:8003/moto/usuario/"+usuarioId, List.class);
        return motos;
    }
    public Carro saveCarro(int usuarioId, Carro carro){
        carro.setUsuarioId(usuarioId);
        Carro carroNuevo=carroFeingClient.save(carro);
        return carroNuevo;
    }
    public Moto saveMoto(int usuarioId, Moto moto){
        moto.setUsuarioId(usuarioId);
        Moto motoNuevo=this.motoFeingClient.save(moto);
        return motoNuevo;
    }
    public Map<String,Object> getUsuarioAndVehiculo(int usuarioId){
        Map<String,Object> resultado=new HashMap<>();
        Usuario usuario=usuarioRepository.findById(usuarioId).orElse(null);
        if(usuario==null){
            resultado.put("Mensaje","El usuario no existe");
            return resultado;
        }else{
            resultado.put("Usuario",usuario);
            List<Carro> carros=carroFeingClient.getCarros(usuarioId);
            if(carros.isEmpty()){
                resultado.put("carros", "El usuario no tiene carros");
            }else{
                resultado.put("carros",carros);
            }
            return resultado;
        }
    }
    public Map<String,Object> getUsuarioAndMoto(int usuarioId){
        Map<String,Object> resultado=new HashMap<>();
        Usuario usuario=usuarioRepository.findById(usuarioId).orElse(null);
        if(usuario==null){
            resultado.put("Mensaje","El usuario no existe");
            return resultado;
        }else{
            resultado.put("Usuario",usuario);
            List<Moto> motos=motoFeingClient.getMotos(usuarioId);
            if(motos.isEmpty()){
                resultado.put("motos", "El usuario no tiene carros");
            }else{
                resultado.put("motos",motos);
            }
            return resultado;
        }
    }
}
