package com.deigo.hotel.infrastructure.entitys;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "quarto")
@Entity

public class Quarto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_Quarto;

    @Column(name = "quarto", unique = true)
    private int quarto;

    @Column(name = "valorDiaria")
    private Double valorDiaria;

    @Column(name = "capacidadeMaxima")
    private int capacidadeMaxima;

    @Column(name = "disponivel")
    private boolean disponivel;

}
