package com.alura.literalura.repository;


import com.alura.literalura.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepositorio extends JpaRepository<Livro, Long> {

    // Verifica se já existe um livro com o mesmo título e idioma
    boolean existsByTituloAndIdioma(String titulo, String idioma);
}