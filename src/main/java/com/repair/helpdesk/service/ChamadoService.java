package com.repair.helpdesk.service;

import com.repair.helpdesk.model.Chamado;
import com.repair.helpdesk.repository.ChamadoRepository;
import com.repair.helpdesk.request.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class ChamadoService {

    private static final Logger LOGGER = Logger.getLogger(CargoService.class.getName());

    @Autowired
    private ChamadoRepository chamadoRepository;

    public ResponseEntity cadastroChamado(Chamado chamado) {
        try {
            this.chamadoRepository.save(chamado);
            return ResponseEntity.status(HttpStatus.OK).body(Response.builder().message("Chamado cadastrado com sucesso").build());
        } catch (Exception e) {
            throw new RuntimeException("Erro ao cadastrar um chamado");
        }
    }

    public ResponseEntity listarChamados() {
        try {
            List<Chamado> listaChamado = this.chamadoRepository.findAll();
            return listaChamado.isEmpty() ? ResponseEntity.status(HttpStatus.OK).body(listaChamado) : ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar os chamados");
        }
    }

    public ResponseEntity deletarChamado(Chamado chamado) {
        try {
            this.chamadoRepository.delete(chamado);
            return ResponseEntity.status(HttpStatus.OK).body(Response.builder().message("Chamado deletado com sucesso").build());
        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar um chamado");
        }
    }

    public ResponseEntity atualizarChamado(Long id, Chamado chamado) {
        try {
            Optional<Chamado> chamadoEncontrado = this.chamadoRepository.findById(id);
            if (chamadoEncontrado.isPresent()) {
                chamado.setId(id);
                this.chamadoRepository.save(chamado);
                return ResponseEntity.status(HttpStatus.OK).body(Response.builder().message("Chamado atualizado com sucesso").build());
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Response.builder().message("Esse chamado não existe").build());
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar um chamado");
        }
    }
}
