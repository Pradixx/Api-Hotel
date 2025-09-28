package com.deigo.hotel.service;

import com.deigo.hotel.infrastructure.entitys.Quarto;
import com.deigo.hotel.infrastructure.entitys.Reserva;
import com.deigo.hotel.infrastructure.repository.QuartoRepository;
import com.deigo.hotel.infrastructure.repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class ReservaService  {

    private final ReservaRepository repository;
    private final QuartoRepository quartoRepository;

    public ReservaService(ReservaRepository repository, QuartoRepository quartoRepository) {
        this.repository = repository;
        this.quartoRepository = quartoRepository;
    }

    private double calcularValorTotal(LocalDate dataEntrada, LocalDate dataSaida, Quarto quarto) {
        if (dataEntrada.isAfter(dataSaida) || dataEntrada.isEqual(dataSaida)) {
            throw new IllegalArgumentException("A data de saída deve ser posterior à data de entrada.");
        }

        long diasEstadia = ChronoUnit.DAYS.between(dataEntrada, dataSaida);
        return diasEstadia * quarto.getValorDiaria();
    }

    private Quarto buscarQuarto(Integer quartoId) {
        return quartoRepository.findById(quartoId)
                .orElseThrow(() -> new RuntimeException("Quarto não encontrado com ID: " + quartoId));
    }

    //POST
    public void salvarReserva(Reserva reserva) {
        repository.saveAndFlush(reserva);
    }

    //GET
    public Reserva buscarReservaPeloId (Integer id) {
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

        LocalDate novaDataEntrada = reserva.getDataEntrada() != null ? reserva.getDataEntrada() : reservaEntity.getDataEntrada();
        LocalDate novaDataSaida = reserva.getDataSaida() != null ? reserva.getDataSaida() : reservaEntity.getDataSaida();

        Integer QuartoId = reserva.getQuartoId() != null ? reserva.getQuartoId().getId_Quarto() : reservaEntity.getQuartoId().getId_Quarto();
        Quarto quartoAtualizado = buscarQuarto(QuartoId);

        double novoValorTotal = calcularValorTotal(novaDataEntrada, novaDataSaida, quartoAtualizado);

        Reserva reservaAtualizado = Reserva.builder()
                .id_reserva(reserva.getId_reserva())
                .quartoId(reserva.getQuartoId())
                .hospedeId(reserva.getHospedeId())
                .dataEntrada(reserva.getDataEntrada() != null ? reserva.getDataEntrada() : reservaEntity.getDataEntrada())
                .dataSaida(reserva.getDataSaida() != null ? reserva.getDataSaida() : reservaEntity.getDataSaida())
                .quantidadePessoas(reserva.getQuantidadePessoas() != null ? reserva.getQuantidadePessoas() : reservaEntity.getQuantidadePessoas())
                .checkin(reserva.isCheckin())
                .checkout(reserva.isCheckout())
                .valorTotal(novoValorTotal)
                .build();

        repository.saveAndFlush(reservaAtualizado);
    }
}
