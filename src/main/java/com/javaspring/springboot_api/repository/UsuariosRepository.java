package com.javaspring.springboot_api.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.javaspring.springboot_api.model.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
    List<Usuarios> findByNomeContaining(String nome);
}
