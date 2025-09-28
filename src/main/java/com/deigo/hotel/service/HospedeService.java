package com.deigo.hotel.service;

import com.deigo.hotel.infrastructure.entitys.Hospede;
import com.deigo.hotel.infrastructure.repository.HospedeRepository;
import org.springframework.stereotype.Service;

@Service
public class HospedeService {

    private final HospedeRepository repository;

    public HospedeService(HospedeRepository repository) {
        this.repository = repository;
    }

    //POST
    public void salvarHospede(Hospede hospede){
        repository.saveAndFlush(hospede);
    }

    //GET
    public Hospede buscarHospedePeloId(Integer id){
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Id não encontrado"));
    }

    //DELETE
    public void deletarHospedePeloId (Integer id) {
        repository.deleteById(id);
    }

    //PUT
    public void atualizarHospedePeloId(Integer id, Hospede hospede){
        Hospede hospedeEntity = repository.findById(id).orElseThrow( () ->
                new RuntimeException("Id não encontrado"));

        Hospede hospedeAtualizado = Hospede.builder()
                .id_hospede(hospede.getId_hospede())
                .nome(hospede.getNome() != null ? hospede.getNome() : hospedeEntity.getNome())
                .cpf(hospede.getCpf() != null ? hospede.getCpf() : hospedeEntity.getCpf())
                .telefone(hospede.getTelefone() != null ? hospede.getTelefone() : hospedeEntity.getTelefone())
                .email(hospede.getEmail() != null ? hospede.getEmail() : hospedeEntity.getEmail())
                .endereco(hospede.getEndereco() != null ? hospede.getEndereco() : hospedeEntity.getEndereco())
                .vip(hospede.isVip())
                .build();

        repository.saveAndFlush(hospedeAtualizado);
    }
}
