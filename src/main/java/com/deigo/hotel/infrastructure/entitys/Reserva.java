package com.deigo.hotel.infrastructure.entitys;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "reserva")
@Entity

public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_reserva;

    @ManyToOne
    @JoinColumn(name = "quarto_Id")
    private Quarto quartoId;

    @ManyToOne
    @JoinColumn(name = "hospede_Id")
    private Hospede hospedeId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(name = "dataEntrada")
    private LocalDate dataEntrada;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(name = "dataSaida")
    private LocalDate dataSaida;

    @Column(name = "quantidadePessoas")
    private Integer quantidadePessoas;

    @Column(name = "checkin")
    private boolean checkin;

    @Column(name = "checkout")
    private boolean checkout;

    @Column(name = "valorTotal")
    private double valorTotal;
}
