package com.deigo.hotel.infrastructure.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "quarto")
@Entity

public class Quarto {

    @Column(name = "quarto", unique = true)
    private int quarto;

    @Column(name = "valorDiaria")
    private Double valorDiaria;

    @Column(name = "capacidadeMaxima")
    private int capacidadeMaxima;

    @Column(name = "disponivel")
    private Boolean disponivel;

}
