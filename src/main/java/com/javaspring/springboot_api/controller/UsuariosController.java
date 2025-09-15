package com.javaspring.springboot_api.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import com.javaspring.springboot_api.model.Usuarios;
import com.javaspring.springboot_api.repository.UsuariosRepository;

/*
CRUD - Create, Read, Update, Delete
Create - POST
READ - GET
UPDATE - PUT
DELETE - DELETE
*/

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    private final UsuariosRepository repository;

    public UsuariosController(UsuariosRepository repository) {
        this.repository = repository;
    }

    //CREATE
    @PostMapping
    public Usuarios criar(@RequestBody Usuarios usuario) {
        return repository.save(usuario);
    }

    //READ (todos)
    @GetMapping
    public List<Usuarios> listar() {
        return repository.findAll();
    }

    //READ (um por id)
    @GetMapping("/{id}")
    public Usuarios buscar(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    //UPDATE
    @PutMapping("/{id}")
    public Usuarios atualizar(@PathVariable Long id, @RequestBody Usuarios novoUsuario) {
        return repository.findById(id).map(usuario -> {
            usuario.setNome(novoUsuario.getNome());
            usuario.setEmail(novoUsuario.getEmail());
            usuario.setSenha(novoUsuario.getSenha());
            return repository.save(usuario);
        }).orElse(null);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
