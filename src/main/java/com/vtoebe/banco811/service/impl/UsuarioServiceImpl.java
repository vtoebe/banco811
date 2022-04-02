package com.vtoebe.banco811.service.impl;

import com.vtoebe.banco811.dto.UsuarioRequest;
import com.vtoebe.banco811.dto.UsuarioResponse;
import com.vtoebe.banco811.model.Usuario;
import com.vtoebe.banco811.repository.UsuarioRepository;
import com.vtoebe.banco811.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> getAll(String nome) {

        if (nome!= null){
            return usuarioRepository.findByNome(nome);
        } else {
            return usuarioRepository.findAll();
        }

//        return UsuarioResponse.toResponse(usuarioRepository.findAll());
    }

    @Override
    public UsuarioResponse create(UsuarioRequest usuarioRequest) {
        Usuario usuario = new Usuario(usuarioRequest);
        usuarioRepository.save(usuario);
        return new UsuarioResponse(usuario);
    }

    @Override
    public Usuario getById(Integer id) {
        return usuarioRepository.findById(id).orElseThrow();
    }

    @Override
    public Usuario update(UsuarioRequest usuarioRequest, Integer id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow();
        usuario.setNome(usuarioRequest.getNome());
        usuario.setCpf(usuarioRequest.getCpf());
        usuario.setSenha(usuarioRequest.getSenha());

        return usuarioRepository.save(usuario);
    }

    @Override
    public void delete(Integer id) {
        usuarioRepository.delete(usuarioRepository.findById(id).orElseThrow());
    }
}
