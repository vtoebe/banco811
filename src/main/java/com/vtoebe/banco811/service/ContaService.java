package com.vtoebe.banco811.service;

import com.vtoebe.banco811.dto.ContaRequest;
import com.vtoebe.banco811.dto.ContaResponse;

public interface ContaService {

    ContaResponse create(Integer usuarioId, ContaRequest contaRequest);
}
