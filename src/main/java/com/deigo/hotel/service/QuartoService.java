package com.deigo.hotel.service;

import com.deigo.hotel.infrastructure.entitys.Quarto;
import com.deigo.hotel.infrastructure.repository.HospedeRepository;
import com.deigo.hotel.infrastructure.repository.QuartoRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
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
    public void deletarQuartoPeloId (Integer id) {
        repository.deleteById(id);
    }

    //PUT
    public void atualizarQuartoPeloId (Integer id, Quarto quarto){
        Quarto quartoEntity = repository.findById(id).orElseThrow(() ->
                new RuntimeException("Quarto não encontrado"));

        Quarto quartoAtualizado = Quarto.builder()
                .id_Quarto(quarto.getId_Quarto())
                .quarto(quarto.getQuarto())
                .valorDiaria(quarto.getValorDiaria())
                .capacidadeMaxima(quarto.getCapacidadeMaxima())
                .disponivel(quarto.isDisponivel())
                .build();

        repository.saveAndFlush(quartoAtualizado);
    }
}
