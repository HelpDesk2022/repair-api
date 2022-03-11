package com.repair.helpdesk.controller;

import com.repair.helpdesk.model.Chamado;
import com.repair.helpdesk.request.Response;
import com.repair.helpdesk.service.ChamadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/chamado")
public class ChamadoController {

    @Autowired
    private ChamadoService chamadoService;

    @PostMapping
    public ResponseEntity cadastrarChamado(@RequestBody @Valid Chamado dadosChamado) {
        try {
            return this.chamadoService.cadastroChamado(dadosChamado);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(Response.builder().message(e.getMessage()).build());
        }
    }

    @GetMapping
    public ResponseEntity listaChamados() {
        try {
            return this.chamadoService.listarChamados();
        } catch (Exception e) {
            return ResponseEntity.status(400).body(Response.builder().message(e.getMessage()).build());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarChamado(@RequestParam("id") Long id) {
        try {
            return this.chamadoService.deletarChamado(Chamado.builder().id(id).build());
        } catch (Exception e) {
            return ResponseEntity.status(400).body(Response.builder().message(e.getMessage()).build());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizarChamado(@RequestParam("id") Long id, @RequestBody @Valid Chamado atualizacaoChamado) {
        try {
            return this.chamadoService.atualizarChamado(id, atualizacaoChamado);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(Response.builder().message(e.getMessage()).build());
        }
    }

}
