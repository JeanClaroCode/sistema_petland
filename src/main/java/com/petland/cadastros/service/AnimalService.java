package com.petland.cadastros.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petland.cadastros.model.dto.AnimalRequestDTO;
import com.petland.cadastros.model.dto.AnimalResponseDTO;
import com.petland.cadastros.model.entity.AnimalEntity;
import com.petland.cadastros.repository.AnimalRepository;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public Integer gravar(AnimalRequestDTO animalRequest){
        AnimalEntity entity = new AnimalEntity();
        BeanUtils.copyProperties(animalRequest, entity);
        return animalRepository.save(entity).getId();
    }

    public Integer alterar(Integer id, AnimalRequestDTO animalRequest){
        AnimalEntity entity = animalRepository.findById(id).orElse(null);
        if(entity!=null){
        BeanUtils.copyProperties(animalRequest, entity);
        return animalRepository.save(entity).getId();
        }
        return null;
        
    }

    public List<AnimalResponseDTO> listar(){
        List<AnimalEntity> entities = animalRepository.findAll();
        List<AnimalResponseDTO> response = new ArrayList<>();
        for(AnimalEntity e: entities){
            AnimalResponseDTO res = new AnimalResponseDTO();
            BeanUtils.copyProperties(e, res);
            response.add(res);
        }
        return response;
    }

    public void excluir(Integer id){
        animalRepository.deleteById(id);
    }
}
