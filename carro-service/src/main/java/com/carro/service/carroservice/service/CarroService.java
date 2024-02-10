package com.carro.service.carroservice.service;

import com.carro.service.carroservice.entidades.Carro;
import com.carro.service.carroservice.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {
    @Autowired
    private CarroRepository carroRepository;
    public List<Carro> getAll(){
        List<Carro> listaCarro=carroRepository.findAll();
       return listaCarro;
    }
    public Carro getCarroById(int id){
        Carro buscarCarro=carroRepository.findById(id).orElse(null);
        return buscarCarro;
    }
    public Carro save(Carro carro){
        Carro nuevoCarro= carroRepository.save(carro);
        return nuevoCarro;
    }
    public List<Carro> byUsuarioId(int id){
        List<Carro> listaUsuario= carroRepository.findByUsuarioId(id);
        return listaUsuario;
    }
}
