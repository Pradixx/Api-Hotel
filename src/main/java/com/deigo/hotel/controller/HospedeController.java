package com.deigo.hotel.controller;

import com.deigo.hotel.infrastructure.entitys.Hospede;
import com.deigo.hotel.service.HospedeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hospede")
@RequiredArgsConstructor
public class HospedeController {

    private final HospedeService hospedeService;

    @PostMapping
    public ResponseEntity<Void> salvarHospede(@RequestBody Hospede hospede){
        hospedeService.salvarHospede(hospede);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Hospede> buscarHospedePorId (@RequestParam Integer id){
        return ResponseEntity.ok(hospedeService.buscarHospedePeloId(id));
    }

    @DeleteMapping
    public ResponseEntity<Void> DeletarHospedePorId (@RequestParam Integer id){
        hospedeService.deletarHospedePeloId(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarUsuarioPeloId (@RequestParam Integer id, @RequestBody Hospede hospede){
        hospedeService.atualizarHospedePeloId(id, hospede);
        return ResponseEntity.ok().build();
    }
}
