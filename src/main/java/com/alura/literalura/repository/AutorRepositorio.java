package com.alura.literalura.repository;


import com.alura.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AutorRepositorio extends JpaRepository<Autor, Long> {

    // Busca um autor por nome e ano de nascimento
    Optional<Autor> findByNomeAndAnoNascimento(String nome, Integer anoNascimento);
}