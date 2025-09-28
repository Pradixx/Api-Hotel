package com.deigo.hotel.service;

import com.deigo.hotel.infrastructure.entitys.Quarto;
import com.deigo.hotel.infrastructure.repository.HospedeRepository;
import com.deigo.hotel.infrastructure.repository.QuartoRepository;
import org.springframework.stereotype.Service;

@Service
public class QuartoService {

    private final QuartoRepository repository;

    public QuartoService(QuartoRepository repository) {
        this.repository = repository;
    }

    //POST
    public void salvarQuarto(Quarto quarto){
        repository.saveAndFlush(quarto);
    }

    //GET
    public Quarto buscarQuartoPeloId(Integer id){
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Id não encontrado"));
    }

    //DELETE


    //PUT
}
