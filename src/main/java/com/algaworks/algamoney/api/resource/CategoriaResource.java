package com.algaworks.algamoney.api.resource;

import com.algaworks.algamoney.api.model.Categoria;
import com.algaworks.algamoney.api.repository.CategoriaRepository;
import jakarta.servlet.Servlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

        @PostMapping
        // quero que retorne um http status 201Created
    public ResponseEntity<Categoria> criar(@Valid @RequestBody Categoria categoria, HttpServletResponse response){ // RequestBody ja consegue pegar, a nova categoria criar
        // e transformar em um objeto
       Categoria categoriaSalva = categoriaRepository.save(categoria); // para salvar no banco de dados usamos
            // usamos a interface com os metodos e usamos o metodo SAVE e passamos a entidade, que objeto deve ser salvo
           URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
                    .buildAndExpand(categoriaSalva.getCodigo()).toUri();
           response.setHeader("Location", uri.toASCIIString());
            // Quando eu crio algum recruso no banco de dados, o rest fala que devemos voltar no headres de resposta
            // para informar como recuperar esse recurso que foi criado no banco de dados
            // Esse metodo e feito para um request ou quando um novo recurso foi criado e para recuperar esse
            // recurso criado
            return ResponseEntity.created(uri).body(categoriaSalva);
            // Definindo o status code, e ja retornamos a categoria salva
        }
        @GetMapping("/{codigo}")
        public ResponseEntity<Categoria> buscarPeloCodigo(@PathVariable Long codigo){
         return categoriaRepository.findById(codigo).map(record -> ResponseEntity.ok().body(record)).
                 orElse(ResponseEntity.notFound().build());
            // Nesse metodo, vamos buscar pelo codigo do Path e conseguimos buscar a categoria
            // pelo codigo
        }
}
