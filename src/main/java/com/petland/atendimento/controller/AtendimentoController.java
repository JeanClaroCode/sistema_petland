package com.petland.atendimento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petland.atendimento.model.dto.AtendimentoRequestDTO;
import com.petland.atendimento.service.AtendimentoService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/atendimentos")
@Tag(name = "Atendimento", description = "Cadastro de atendimento")
public class AtendimentoController {

    @Autowired
    private AtendimentoService atendimentoService; 

    @PostMapping()
    public Integer gravar(@RequestBody AtendimentoRequestDTO atendimentoRequestDTO) {
        return atendimentoService.gravar(atendimentoRequestDTO);
    }
}
