package com.ues.usuarioservice.usuarioservice.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ues.usuarioservice.usuarioservice.entidades.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer > {

}
