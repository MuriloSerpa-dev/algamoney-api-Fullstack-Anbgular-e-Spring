package com.algaworks.algamoney.api.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity // Classificamos como Entidade
@Table(name="Categoria")  // Damos o nome da tabela
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Gerado apartir da tabela, toma conta da geracao do ocodigo
        private Long codigo;

        private String nome;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(codigo, categoria.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
