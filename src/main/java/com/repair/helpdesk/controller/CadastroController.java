package com.repair.helpdesk.controller;

import com.repair.helpdesk.model.Usuario;
import com.repair.helpdesk.request.Response;
import com.repair.helpdesk.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/usuario")
public class CadastroController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity cadastrarUsuario(@RequestBody @Valid Usuario usuario) {
        try {
            return this.usuarioService.cadastrarUsuario(usuario);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(Response.builder().message(e.getMessage()).build());
        }
    }
}
