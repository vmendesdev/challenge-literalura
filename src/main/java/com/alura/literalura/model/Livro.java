package com.alura.literalura.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String idioma;

    @Column(name = "numero_downloads")
    private Integer numeroDownloads;

    @ManyToMany
    @JoinColumn(name = "autor_id")
    private Autor autor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Integer getNumeroDownloads() {
        return numeroDownloads;
    }

    public void setNumeroDownloads(Integer numeroDownloads) {
        this.numeroDownloads = numeroDownloads;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    // Dois livros serão iguais se tiverem o mesmo título e idioma
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Livro livro)) return false;
        return Objects.equals(titulo, livro.titulo) &&
                Objects.equals(idioma, livro.idioma);
    }
}
