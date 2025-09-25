package com.deigo.hotel.infrastructure.repository;

import com.deigo.hotel.infrastructure.entitys.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

    @Override
    Optional<Reserva> findById(Integer integer);

    @Transactional
    void deleteById(Integer id);
}
