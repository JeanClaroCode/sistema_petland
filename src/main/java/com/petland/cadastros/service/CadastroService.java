package com.petland.cadastros.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petland.cadastros.model.dto.CadastroRequestDTO;
import com.petland.cadastros.model.dto.CadastroResponseDTO;
import com.petland.cadastros.model.entity.CadastroEntity;
import com.petland.cadastros.repository.CadastroRepository;

@Service
public class CadastroService {
    @Autowired
    private CadastroRepository cadastroRepository;

    public Integer gravar(CadastroRequestDTO cadastroRequest){
        CadastroEntity entity = new CadastroEntity();
        BeanUtils.copyProperties(cadastroRequest, entity);
        return cadastroRepository.save(entity).getId();
    }

    public Integer alterar(Integer id, CadastroRequestDTO cadastroRequest){
        CadastroEntity entity = cadastroRepository.findById(id).orElse(null);
        if(entity!=null){
        BeanUtils.copyProperties(cadastroRequest, entity);
        return cadastroRepository.save(entity).getId();
        }
        return null;
        
    }

    public List<CadastroResponseDTO> listar(){
        List<CadastroEntity> entities = cadastroRepository.findAll();
        List<CadastroResponseDTO> response = new ArrayList<>();
        for(CadastroEntity e: entities){
            CadastroResponseDTO res = new CadastroResponseDTO();
            BeanUtils.copyProperties(e, res);
            response.add(res);
        }
        return response;
    }

    public void excluir(Integer id){
        cadastroRepository.deleteById(id);
    }
}
