
package com.vtoebe.banco811.repository;

import com.vtoebe.banco811.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    List<Usuario> findByNome(String nome);
    List<Usuario> findByNomeContaining(String nome);
    List<Usuario> findByNomeLike(String pattern);   // String pattern = "a%b%c";

    List<Usuario> findByNomeAndCpf(String nome, String cpf);

    List<Usuario> findByNomeIs(String nome);
    List<Usuario> findByNomeIsNot(String nome);

    List<Usuario> findByNomeIsNull();
    List<Usuario> findByNomeIsNotNull();

//    List<Usuario> findByAtivoTrue();

    List<Usuario> findByCpfStartingWith(String cpf);
    List<Usuario> findByCpfEndingWith(String cpf);

    List<Usuario> findByDataCriacao(LocalDateTime dataCriacao);
    List<Usuario> findByDataCriacaoAfter(LocalDateTime dataCriacao);
    List<Usuario> findByDataCriacaoAfterAndNomeAndCpf(LocalDateTime dataCriacao, String nome, String cpf);

    List<Usuario> findByNomeStartingWithOrderByNome(String nome);
}
