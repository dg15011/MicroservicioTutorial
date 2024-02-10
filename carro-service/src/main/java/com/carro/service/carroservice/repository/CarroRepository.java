package com.carro.service.carroservice.repository;

import com.carro.service.carroservice.entidades.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarroRepository extends JpaRepository<Carro,Integer> {
     List<Carro> findByUsuarioId(int usuarioid);
}
