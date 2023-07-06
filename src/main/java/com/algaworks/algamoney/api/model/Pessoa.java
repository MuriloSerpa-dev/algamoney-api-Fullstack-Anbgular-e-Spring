package com.algaworks.algamoney.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.Objects;

@Entity
@Table(name ="Pessoa")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    @NotNull
    @Size(min =3, max = 20)
    private String nome;
    @NotNull
    private boolean ativo;
    @Embedded
    private Endereco endereco;

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

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return ativo == pessoa.ativo && Objects.equals(codigo, pessoa.codigo) && Objects.equals(nome, pessoa.nome) && Objects.equals(endereco, pessoa.endereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nome, ativo, endereco);
    }
}
