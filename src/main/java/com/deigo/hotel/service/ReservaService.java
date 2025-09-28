package com.deigo.hotel.service;

import com.deigo.hotel.infrastructure.entitys.Reserva;
import com.deigo.hotel.infrastructure.repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class ReservaService  {

    private final ReservaRepository repository;

    public ReservaService(ReservaRepository repository) {
        this.repository = repository;
    }

    //POST
    public void salvarReserva(Reserva reserva) {
        repository.saveAndFlush(reserva);
    }

    //GET
    public Reserva burcarReservaPeloId (Integer id) {
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Id não encontrado"));
    }

    //DELETE
    public void deletarReservaPeloId (Integer id) {
        repository.deleteById(id);
    }

    //PUT
    public void atualizarReservaPeloId (Integer id, Reserva reserva) {
        Reserva reservaEntity = repository.findById(id).orElseThrow(() ->
                new RuntimeException("Reserva não encontrada"));

        LocalDate dataEntrada = reserva.getDataEntrada() != null ? reserva.getDataEntrada() : reservaEntity.getDataEntrada();
        LocalDate dataSaida = reserva.getDataSaida() != null ? reserva.getDataSaida() : reservaEntity.getDataSaida();

        final double precoDiaria = 300.00;
        long diasEstadia = ChronoUnit.DAYS.between(dataEntrada, dataSaida);
        double valorTotal = diasEstadia * precoDiaria;

        Reserva reservaAtualizado = Reserva.builder()
                .id_reserva(reserva.getId_reserva())
                .quartoId(reserva.getQuartoId())
                .hospedeId(reserva.getHospedeId())
                .dataEntrada(reserva.getDataEntrada() != null ? reserva.getDataEntrada() : reservaEntity.getDataEntrada())
                .dataSaida(reserva.getDataSaida() != null ? reserva.getDataSaida() : reservaEntity.getDataSaida())
                .quantidadePessoas(reserva.getQuantidadePessoas() != null ? reserva.getQuantidadePessoas() : reservaEntity.getQuantidadePessoas())
                .checkin(reserva.isCheckin())
                .checkout(reserva.isCheckout())
                .valorTotal(valorTotal)
                .build();

        repository.saveAndFlush(reservaAtualizado);
    }
}
