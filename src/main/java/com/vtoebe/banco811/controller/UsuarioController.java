package com.vtoebe.banco811.controller;

import com.vtoebe.banco811.dto.UsuarioRequest;
import com.vtoebe.banco811.dto.UsuarioResponse;
import com.vtoebe.banco811.model.Usuario;
import com.vtoebe.banco811.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> getAll(@RequestParam (required = false) String nome) {
        return usuarioService.getAll(nome);
    }

    @PostMapping
    public UsuarioResponse create(@RequestBody UsuarioRequest usuarioRequest) {
        return usuarioService.create(usuarioRequest);
    }

    @GetMapping(path = "/{id}")
    public Usuario getById(@PathVariable("id") Integer id){
        return usuarioService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public Usuario update(@PathVariable Integer id, @RequestBody UsuarioRequest usuarioRequest){ return usuarioService.update(usuarioRequest, id); }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Integer id){usuarioService.delete(id);}


}
