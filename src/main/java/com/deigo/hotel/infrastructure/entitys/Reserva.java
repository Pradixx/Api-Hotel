package com.deigo.hotel.infrastructure.entitys;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

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

    @Column(name = "quartoId")
    private int quartoId;

    @Column(name = "hospedeId")
    private int hospedeId;

    @Column(name = "dataEntrada")
    private Date dataEntrada;

    @Column(name = "dataSaida")
    private Date dataSaida;

    @Column(name = "quantidadePessoas")
    private int quantidadePessoas;

    @Column(name = "checkin")
    private boolean checkin;

    @Column(name = "checkout")
    private boolean checkout;

    @Column(name = "valorTotal")
    private double valorTotal;
}
