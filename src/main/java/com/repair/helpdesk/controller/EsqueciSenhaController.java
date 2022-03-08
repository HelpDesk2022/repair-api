package com.repair.helpdesk.controller;

import com.repair.helpdesk.model.EsqueciSenha;
import com.repair.helpdesk.request.Response;
import com.repair.helpdesk.service.EsqueciSenhaService;
import com.repair.helpdesk.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/esqueciSenha")
public class EsqueciSenhaController {

    @Autowired
    private EsqueciSenhaService esqueciSenhaService;

    @PostMapping
    public ResponseEntity response(@RequestBody @Valid EsqueciSenha esqueciSenha){
        try {
            return this.esqueciSenhaService.esqueciSenha(esqueciSenha);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(Response.builder().message(e.getMessage()).build());
        }
    }
}
