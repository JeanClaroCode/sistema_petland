package com.petland.atendimento.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petland.atendimento.model.dto.AtendimentoRequestDTO;
import com.petland.atendimento.model.entity.AtendimentoEntity;
import com.petland.atendimento.repository.AtendimentoRepository;


@Service
public class AtendimentoService {
    @Autowired
    private AtendimentoRepository atendimentoRepository;

    public Integer gravar(AtendimentoRequestDTO atendimentoRequestDTO){
        AtendimentoEntity entity = new AtendimentoEntity();
        BeanUtils.copyProperties(atendimentoRequestDTO, entity);
        return atendimentoRepository.save(entity).getId();
    }
}
