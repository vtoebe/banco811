package com.vtoebe.banco811.controller;

import com.vtoebe.banco811.dto.ContaRequest;
import com.vtoebe.banco811.dto.ContaResponse;
import com.vtoebe.banco811.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    ContaService contaService;

    @PostMapping(path = "/{id}")
    public ContaResponse create(@PathVariable("id") Integer usuarioId, @RequestBody @Valid ContaRequest contaRequest) {
        return contaService.create(usuarioId, contaRequest);
    }
}
