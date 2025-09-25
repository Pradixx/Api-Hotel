package com.deigo.hotel.service;

import com.deigo.hotel.infrastructure.entitys.Reserva;
import com.deigo.hotel.infrastructure.repository.ReservaRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservaService  {

    private final ReservaRepository repository;

    public ReservaService(ReservaRepository repository) {
        this.repository = repository;
    }

    public void salvarReserva(Reserva reserva) {
        repository.saveAndFlush(reserva);
    }

    public Reserva burcarReservaPeloId (Integer id) {
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Id não encontrado"));
    }

    public void deletearReservaPeloId (Integer id) {
        repository.deleteById(id);
    }

    public void atualizarReservaPeloId (Integer id, Reserva reserva) {
        Reserva reservaEntity = repository.findById(id).orElseThrow(() ->
                new RuntimeException("Reserva não encontrada"));
        Reserva reservaAtualizado = Reserva.builder()
                .build();
    }
}
