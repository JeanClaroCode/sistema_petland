package com.petland.cadastros.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petland.cadastros.model.dto.AnimalRequestDTO;
import com.petland.cadastros.model.dto.AnimalResponseDTO;
import com.petland.cadastros.service.AnimalService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/animais")
@Tag(name = "Animais", description = "Informações de animais")
public class AnimalController {

    @Autowired
    private AnimalService animalService;
    // guarda que tem o papel de não exibir as entidades para as demais
    // camadas

    @GetMapping
    @Operation(summary = "Listagem de animais", description = "Essa função é responsável por listar animais")
    public List<AnimalResponseDTO> get() {
        return animalService.listar();
    }

    @PostMapping()
    @Operation(summary = "Cadastro de Animais", description = "Essa função é responsável cadastrar o animal")
    public Integer gravar(@RequestBody AnimalRequestDTO animalRequest) {
        return animalService.gravar(animalRequest);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Edição de Animais", description = "Essa função é responsável por editar")
    public Integer alterar(@PathVariable("id") Integer id, @RequestBody AnimalRequestDTO animalRequest) {
        return animalService.alterar(id, animalRequest);

    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar Animais", description = "Essa função é responsável por deletar")
    public void deletar(@PathVariable("id") Integer id) {
        animalService.excluir(id);
    }
}
