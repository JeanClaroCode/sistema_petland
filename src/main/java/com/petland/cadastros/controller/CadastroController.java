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

import com.petland.cadastros.model.dto.CadastroRequestDTO;
import com.petland.cadastros.model.dto.CadastroResponseDTO;
import com.petland.cadastros.service.CadastroService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/cadastros")
@Tag(name = "Cadastro", description = "Cadastros de Clientes e Animal")
public class CadastroController {
    @Autowired
    private CadastroService cadastroService;

    @GetMapping
    @Operation(summary = "Listagem de Cadastros", description = "Essa função é responsável por listar cadastros")
    public List<CadastroResponseDTO> get(){
        return cadastroService.listar();
    }
    
    @PostMapping()
    @Operation(summary = "Cadastro de Cliente", description = "Essa função é responsável por cadastrar Clientes")
    public Integer gravar(@RequestBody CadastroRequestDTO cadastroRequestDTO) {
        return cadastroService.gravar(cadastroRequestDTO);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Editar cadastro de Cliente", description = "Essa função é responsável por editar cadastro de clientes")
    public Integer alterar(@PathVariable ("id") Integer id, @RequestBody CadastroRequestDTO cadastroRequestDTO){
        return cadastroService.alterar(id, cadastroRequestDTO);

    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar cadastro de cliente", description = "Essa função é responsável por deletar cadastro de clientes")
    public void deletar(@PathVariable ("id") Integer id){
        cadastroService.excluir(id);
    }
}
