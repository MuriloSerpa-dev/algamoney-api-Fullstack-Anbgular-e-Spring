package com.algaworks.algamoney.api.resource;

import com.algaworks.algamoney.api.model.Categoria;
import com.algaworks.algamoney.api.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // Usado para dizermos que somos um controlador Rest
@RequestMapping("/categorias") // fazendo o mapeamento da aplicação, quando buscarmos categoria esse metodo é que
// vai ser chamado
public class CategoriaResource {
        @Autowired // Como eu não posso instanciar uma Interface "new categoriaRespository" mas o objeto
        // precisa ser injetado , AUTOWIRE quer dizer procure uma classe no caso "CategoriaRespository e ponha aqui
        private CategoriaRepository categoriaRepository;
    @GetMapping // Essa anoatação faz com que a aplicação ja sabia quando buscarmos um GET em categorias vai
    // ser chamado esse metodo
    public List<Categoria> Listar() {
        return categoriaRepository.findAll(); // findAll quer é como se fizessemos um select from
    }

        // return !categorias.isEmpty()?  ResponseEntity.ok(categorias) : ResponseEntity.noContent().build();
        // ResponseEntity é uma entidade de resposta que posso retornar e interrrogação porque não esta deficinada
        // a resposta sera dependente do que estiver vindo na lista de categorias
        // entity se a lista estiver vazia
        // No caso se ela não estiver vazia retorno 200 OK passando as categorias
        // NO caso de estar vazia o retorno sera de 404NotFound build é preciso seer colocado pra poder gerar um response entity
}
