package com.petland.cadastros.model.dto;

import java.time.LocalDate;

import com.petland.cadastros.model.AnimalEspecie;

import lombok.Data;

@Data
public class AnimalRequestDTO {
    private String nome;
    private LocalDate aniversario;
    private AnimalEspecie especie;
    private Integer tutor;
}
