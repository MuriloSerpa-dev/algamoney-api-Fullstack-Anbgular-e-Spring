package com.algaworks.algamoney.api.repository;

import com.algaworks.algamoney.api.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    // Criamos a categoria de interface que extends JpaRepository que ja vem com varios metodos
    // e a implementação quem vai da SpringDataJpa que com isso ja ganhamos varios metodos
    // colocamos esses parametros que é preciso dizer pra ele que é pra trabalhar em cima do metodo
   // configuramos o tipo da chave primaria
}
