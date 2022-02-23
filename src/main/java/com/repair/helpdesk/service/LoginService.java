package com.repair.helpdesk.service;

import com.repair.helpdesk.model.Login;
import com.repair.helpdesk.model.Usuario;
import com.repair.helpdesk.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class LoginService {
    private static final Logger LOGGER = Logger.getLogger(UsuarioService.class.getName());

    @Autowired
    private UsuarioRepository usuarioRepository;

    public ResponseEntity login(Login login) {
        try {
            List<Usuario> listaUsuario = this.usuarioRepository.findAll();

            Optional<Usuario> loginRealizado = listaUsuario.stream().filter(u -> u.getEmail().equals(login.getEmail()) &&
                    u.getPassword().equals(login.getPassword())).findFirst();

            return loginRealizado.isPresent() ? ResponseEntity.status(HttpStatus.OK).body("Login realizado com sucesso") :
                    ResponseEntity.status(HttpStatus.OK).body("Email ou senha inválida");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.OK).body("Não existe esse usuário");
        }
    }
}