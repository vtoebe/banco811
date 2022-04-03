package com.vtoebe.banco811.dto;

import javax.validation.constraints.NotNull;
import com.vtoebe.banco811.enums.TipoContaEnum;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
public class ContaRequest {

    @NotNull
    private int numero;

    @NotNull
    private int agencia;

    @NotNull
    private TipoContaEnum tipoConta;

    @NotNull
    private BigDecimal saldo;
}
