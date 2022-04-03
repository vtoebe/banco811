package com.vtoebe.banco811.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter @Setter
public class UsuarioRequest {

    @NotNull @NotEmpty @Size(message = "must have 11 digits", min = 11, max = 11)
    private String cpf;

    @NotNull @NotEmpty
    private String nome;

    @NotNull @NotEmpty @Size(min = 8, message = "must have at least 8 digits")
    private String senha;
}
