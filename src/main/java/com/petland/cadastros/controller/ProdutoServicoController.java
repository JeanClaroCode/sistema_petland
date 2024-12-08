package com.petland.cadastros.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.petland.cadastros.model.ProdutoServico;
import com.petland.cadastros.repository.ProdutoServicoRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/produtos")
@Tag(name = "Produto", description = "Informação de Produtos e Serviços")
public class ProdutoServicoController {

    @Autowired
    private ProdutoServicoRepository produtoServicoRepository;

    @GetMapping()
    @Operation(summary = "Listagem de Produto e Serviço", description = "Essa função é responsável por listar Produtos e Serviços")
    public List<ProdutoServico> listar(){ return produtoServicoRepository.findAll(); }

    @PostMapping()
    @Operation(summary = "Cadastro de Produto e Serviço", description = "Essa função é responsável por cadastrar Produtos e Serviços")
    public Integer gravar(@RequestBody ProdutoServico produtoServico) {
        produtoServicoRepository.save(produtoServico);
        return produtoServico.getId();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Editar Produto e Serviço", description = "Essa função é responsável por editar Produtos e Serviços")
    public Integer alterar(@PathVariable ("id") Integer id, @RequestBody ProdutoServico produtoServico){
        produtoServicoRepository.save(produtoServico);
        return produtoServico.getId();

    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar Produto e Serviço", description = "Essa função é responsável por deletar Produtos e Serviços")
    public void deletar(@PathVariable ("id") Integer id){
        produtoServicoRepository.deleteById(id);
    }

}
