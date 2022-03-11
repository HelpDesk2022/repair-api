package com.repair.helpdesk.controller;

import com.repair.helpdesk.model.Login;
import com.repair.helpdesk.request.Response;
import com.repair.helpdesk.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid Login login) {
        try {
            return this.loginService.login(login);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(Response.builder().message(e.getMessage()).build());
        }
    }
}
