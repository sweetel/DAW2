package com.favores.dto;

public class FavorDTO {
    private Long id;
    private String titular;
    private String categoria;
    private String autor;
    private String imagen;
    private String texto;

    // Constructor vacío
    public FavorDTO() {}

    // Constructor con parámetros
    public FavorDTO(Long id, String titular, String categoria, String autor, String imagen, String texto) {
        this.id = id;
        this.titular = titular;
        this.categoria = categoria;
        this.autor = autor;
        this.imagen = imagen;
        this.texto = texto;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
