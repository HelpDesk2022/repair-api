package com.repair.helpdesk.service;

import com.repair.helpdesk.model.EsqueciSenha;
import com.repair.helpdesk.model.Login;
import com.repair.helpdesk.model.Usuario;
import com.repair.helpdesk.repository.UsuarioRepository;
import com.repair.helpdesk.request.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class EsqueciSenhaService {
    private static final Logger LOGGER = Logger.getLogger(UsuarioService.class.getName());

    @Autowired
    private UsuarioRepository usuarioRepository;

    public ResponseEntity esqueciSenha(EsqueciSenha esqueciSenha){

        try{
            List<Usuario> listaUsuario = this.usuarioRepository.findAll();

            Optional<Usuario> loginRealizado = listaUsuario.stream().filter(u -> u.getEmail().equals(esqueciSenha.getEmail())).findFirst();

            return loginRealizado.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(Response.builder().message("Email enviado").build()) :
                    ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Response.builder().message("Email não encontrado").build());

        }catch (Exception e){
            e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Response.builder().message("Email não encontrado").build());
        }
    }



}
