package com.deigo.hotel.infrastructure.entitys;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "hospede")
@Entity

public class Hospede {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf", unique = true)
    private String cpf;

    @Column(name = "telefone", unique = true)
    private String telefone;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "vip")
    private Boolean vip;
}
