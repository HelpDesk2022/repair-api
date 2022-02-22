package com.repair.helpdesk.service;

import com.repair.helpdesk.model.Cargo;
import com.repair.helpdesk.model.Usuario;
import com.repair.helpdesk.repository.UsuarioRepository;
import com.repair.helpdesk.request.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class UsuarioService {

    private static final Logger LOGGER = Logger.getLogger(UsuarioService.class.getName());

    @Autowired
    private UsuarioRepository usuarioRepository;

    public ResponseEntity cadastrarUsuario(Usuario usuario) {

        try {
            if (Cargo.getAllCargos().contains(usuario.getCargo().getNome().toUpperCase())) {
                this.usuarioRepository.save(usuario);
                LOGGER.log(Level.INFO, "FOI...");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Response.builder().message("Não existe esse cargo que você deseja cadastrar..").build());
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(Response.builder().message("Usuario criado com sucesso.").build());
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Usuário já existe na base de dados!");
        } catch (Exception e) {
            throw new RuntimeException("Erro ao cadastrar um usuário");
        }
    }

    public ResponseEntity listarUsuarios() {
        try {
            List<Usuario> listaUsuario = this.usuarioRepository.findAll();
            return listaUsuario.isEmpty() ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() : ResponseEntity.status(HttpStatus.OK).body(listaUsuario);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao encontrar os usuários");
        }
    }


}
