package com.repair.helpdesk.service;

import com.repair.helpdesk.model.Cargo;
import com.repair.helpdesk.repository.CargoRepository;
import com.repair.helpdesk.request.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class CargoService {

    private static final Logger LOGGER = Logger.getLogger(CargoService.class.getName());

    @Autowired
    private CargoRepository cargoRepository;

    public ResponseEntity cadastrarCargo(Cargo cargo) {
        try {
            this.cargoRepository.save(cargo);
            return ResponseEntity.status(HttpStatus.OK).body(Response.builder().message("Cargo cadastrado com sucesso").build());
        } catch (Exception e) {
            throw new RuntimeException("Erro ao cadastrar um cargo");
        }
    }

    public ResponseEntity listarCargos() {
        try {
            List<Cargo> listaCargo = this.cargoRepository.findAll();
            return listaCargo.isEmpty() ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() : ResponseEntity.status(HttpStatus.OK).body(listaCargo);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar a lista de cargos");
        }
    }
}
