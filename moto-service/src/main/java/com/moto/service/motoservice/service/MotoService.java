package com.moto.service.motoservice.service;

import com.moto.service.motoservice.entidades.Moto;
import com.moto.service.motoservice.repositorio.MotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoService {
    @Autowired
    private MotoRepository motoRepository;
    public List<Moto> getAll(){
        return motoRepository.findAll();
    }
    public Moto getMotoById(int id){
        Moto buscarMoto= motoRepository.findById(id).orElse(null);
        return buscarMoto;
    }
    public Moto save(Moto moto){
        Moto guardarMoto= motoRepository.save(moto);
        return guardarMoto;
    }
    public List<Moto> byUsuarioId(int usuarioId){
        return motoRepository.findByUsuarioId(usuarioId);
    }
}
