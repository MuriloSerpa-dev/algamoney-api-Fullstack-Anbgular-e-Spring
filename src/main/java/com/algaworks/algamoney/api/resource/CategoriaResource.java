package com.algaworks.algamoney.api.resource;

import com.algaworks.algamoney.api.model.Categoria;
import com.algaworks.algamoney.api.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // Usado para dizermos que somos um controlador Rest
@RequestMapping("/categorias") // fazendo o mapeamento da aplkicação, quando buscarmos categoria esse motodo que
// vai ser chamado
public class CategoriaResource {
        @Autowired // Como eu não posso instanciar uma Interface "new categoriaRespository" mas o objeto
        // precisa ser injetado , AUTOWIRE quer dizer procure uma classe no caso "CategoriaRespository e ponha aqui
        private CategoriaRepository categoriaRepository;
    @GetMapping // Essa anoatação faz com que a aplicação ja sabia quando buscarmos um GET em categorias vai
    // ser chamado esse metodo
    public List<Categoria> Listar(){
        return categoriaRepository.findAll(); // faz um select * from categoria
    }
}
