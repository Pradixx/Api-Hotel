package com.deigo.hotel.controller;

import com.deigo.hotel.infrastructure.entitys.Quarto;
import com.deigo.hotel.service.QuartoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quarto")
@RequiredArgsConstructor
public class QuartoController {

    private final QuartoService quartoService;

    @PostMapping
    public ResponseEntity<Void> salvarQuarto(@RequestBody Quarto quarto){
        quartoService.salvarQuarto(quarto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Quarto> buscarQuartoPorId (@RequestParam Integer id){
        return  ResponseEntity.ok(quartoService.buscarQuartoPeloId(id));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarQuartoPorId (@RequestParam Integer id){
        quartoService.deletarQuartoPeloId(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarUsuarioPorId (@RequestParam Integer id, @RequestBody Quarto quarto){
        quartoService.atualizarQuartoPeloId(id, quarto);
        return ResponseEntity.ok().build();
    }
}
