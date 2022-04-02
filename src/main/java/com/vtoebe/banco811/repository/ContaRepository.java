package com.vtoebe.banco811.repository;

import com.vtoebe.banco811.enums.TipoContaEnum;
import com.vtoebe.banco811.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {
    List<Conta> findByAgenciaOrderByDataCriacao(Integer agencia);

    List<Conta> findBySaldoLessThan(BigDecimal saldo);
    List<Conta> findBySaldoLessThanEqual(BigDecimal saldo);
    List<Conta> findBySaldoGreaterThan(BigDecimal saldo);
    List<Conta> findBySaldoBetween(BigDecimal saldoInicial, BigDecimal saldoFinal);

    List<Conta> findBySaldoIn(List<BigDecimal> saldo);

    List<Conta> findByTipoContaAndSaldoBetweenOrderBySaldo(TipoContaEnum tipoConta, BigDecimal saldoInicial, BigDecimal saldoFinal);
    List<Conta> findByUsuario_Cpf(String cpf);

    Boolean existsByTipoConta(TipoContaEnum tipoConta);

    @Query("select c from Conta c where " +
            "(c.tipoConta = :tipoConta or c.usuario.cpf = :cpf) or " +
            "(c.tipoConta = :tipoConta or c.saldo = :saldo)")
    List<Conta> findByTipoContaAndAgenciaOrTipoContaAndSaldo(
            @Param("tipoConta") TipoContaEnum tipoConta,
            @Param("cpf") String cpf,
            @Param("saldo") BigDecimal saldo
    );

    @Query(value = "select * from conta c where" +
            "(c.tipo_conta = :tipoConta AND c.data_criacao >= :dataCriacao) OR " +
            "c.saldo = :saldo", nativeQuery = true)
    List<Conta> findByDataCriacaoAndTipoContaOrderBySaldo(
            @Param("dataCriacao")LocalDateTime dataCriacao,
            @Param("tipoConta") TipoContaEnum tipoConta,
            @Param("saldo") BigDecimal saldo
            );
}
