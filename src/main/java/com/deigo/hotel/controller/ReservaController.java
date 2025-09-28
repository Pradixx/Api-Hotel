package com.deigo.hotel.controller;

import com.deigo.hotel.infrastructure.entitys.Reserva;
import com.deigo.hotel.service.ReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reserva")
@RequiredArgsConstructor
public class ReservaController {

    private final ReservaService reservaService;

    @PostMapping
    public ResponseEntity<Void> salvarReserva(@RequestBody Reserva reserva){
        reservaService.salvarReserva(reserva);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Reserva> buscarReservaPorId (@RequestParam Integer id){
        return ResponseEntity.ok(reservaService.burcarReservaPeloId(id));
    }

    @DeleteMapping
    public ResponseEntity<Void> DeletarReservaPorId (@RequestParam Integer id){
        reservaService.deletarReservaPeloId(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarUsuarioPorId (@RequestParam Integer id, @RequestBody Reserva reserva) {
        reservaService.atualizarReservaPeloId(id, reserva);
        return ResponseEntity.ok().build();
    }
}
