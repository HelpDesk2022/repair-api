package com.repair.helpdesk.controller;

import com.repair.helpdesk.model.Relatorio;
import com.repair.helpdesk.request.Response;
import com.repair.helpdesk.service.RelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/relatorio")
public class RelatorioController {

    @Autowired
    private RelatorioService relatorioService;

    @PostMapping
    public ResponseEntity relatorio(@RequestBody @Valid Relatorio dadosRelatorio) {
        try {
            return this.relatorioService.relatorio(dadosRelatorio);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(Response.builder().message(e.getMessage()).build());
        }
    }
}
