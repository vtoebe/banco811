package com.vtoebe.banco811.service;

import com.vtoebe.banco811.dto.UsuarioRequest;
import com.vtoebe.banco811.dto.UsuarioResponse;
import com.vtoebe.banco811.model.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario> getAll(String nome);
    UsuarioResponse create(UsuarioRequest usuarioRequest);
    Usuario getById(Integer id);
    Usuario update(UsuarioRequest usuarioRequest, Integer id);
    void delete(Integer id);
}
