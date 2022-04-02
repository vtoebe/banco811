package com.vtoebe.banco811.dto;

import com.vtoebe.banco811.enums.TipoContaEnum;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
public class ContaRequest {
    private int numero;
    private int agencia;
    private TipoContaEnum tipoConta;
    private BigDecimal saldo;
}
