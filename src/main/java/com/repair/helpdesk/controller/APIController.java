package com.repair.helpdesk.controller;

import com.repair.helpdesk.model.BoasVindas;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class APIController {
    @GetMapping
    public ResponseEntity boasVindas(){
        return ResponseEntity.status(HttpStatus.OK).body(BoasVindas.builder()
                .version("1.0.0")
                .appName("Help Desk API")
                .description("Uma api para gerenciar um sistema de controle de chamados."));
    }
}
