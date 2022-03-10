package com.repair.helpdesk.controller;

import com.repair.helpdesk.model.Cargo;
import com.repair.helpdesk.request.Response;
import com.repair.helpdesk.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/cargo")
public class CargoController {

    @Autowired
    private CargoService cargoService;

    @PostMapping
    public ResponseEntity cadastrarCargo(@RequestBody @Valid Cargo dadosCargo) {
        try {
            return this.cargoService.cadastrarCargo(dadosCargo);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(Response.builder().message(e.getMessage()).build());
        }
    }

    @GetMapping
    public ResponseEntity listarCargos() {
        try {
            return this.cargoService.listarCargos();
        } catch (Exception e) {
            return ResponseEntity.status(400).body(Response.builder().message(e.getMessage()).build());
        }
    }
}
