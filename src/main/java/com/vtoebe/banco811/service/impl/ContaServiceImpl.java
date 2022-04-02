package com.vtoebe.banco811.service.impl;

import com.vtoebe.banco811.dto.ContaRequest;
import com.vtoebe.banco811.dto.ContaResponse;
import com.vtoebe.banco811.model.Conta;
import com.vtoebe.banco811.repository.ContaRepository;
import com.vtoebe.banco811.service.ContaService;
import com.vtoebe.banco811.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaServiceImpl implements ContaService {

    @Autowired
    UsuarioService usuarioService;
    @Autowired
    ContaRepository contaRepository;

    @Override
    public ContaResponse create(Integer usuarioId, ContaRequest contaRequest) {
        var usuario = usuarioService.getById(usuarioId);
        Conta conta = new Conta(usuario, contaRequest);
        return new ContaResponse(contaRepository.save(conta));
    }
}
