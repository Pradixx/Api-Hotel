package com.deigo.hotel.infrastructure.repository;

import com.deigo.hotel.infrastructure.entitys.Hospede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface HospedeRepository extends JpaRepository<Hospede, Integer> {
    @Override
    Optional<Hospede> findById(Integer integer);

    @Transactional
    void deleteById(Integer id);
}
