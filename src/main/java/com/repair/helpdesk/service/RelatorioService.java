package com.repair.helpdesk.service;

import com.repair.helpdesk.model.Chamado;
import com.repair.helpdesk.model.Relatorio;
import com.repair.helpdesk.repository.ChamadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RelatorioService {

    @Autowired
    private ChamadoRepository chamadoRepository;

    public ResponseEntity relatorio(Relatorio dadosRelatorio){

        List<Chamado> relatorio;
        List<Chamado> listaChamados = this.chamadoRepository.findAll();

        if(listaChamados.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            if(dadosRelatorio.getIdColaborador() != null) {
                relatorio = listaChamados.stream().filter(chamado -> chamado.getUsuario().getId().equals(dadosRelatorio.getIdColaborador()))
                        .filter(chamado -> transformaStringEmLocalDate(dadosRelatorio.getDataInicial()).isBefore(chamado.getDataHoraCriacao()) && transformaStringEmLocalDate(dadosRelatorio.getDataFinal()).isAfter(chamado.getDataHoraCriacao()))
                        .collect(Collectors.toList());
            } else {
                relatorio = listaChamados.stream()
                        .filter(chamado -> chamado.getDataHoraCriacao().isBefore(transformaStringEmLocalDate(dadosRelatorio.getDataInicial())) && chamado.getDataHoraCriacao().isAfter(transformaStringEmLocalDate(dadosRelatorio.getDataFinal())))
                        .collect(Collectors.toList());
            }
            return ResponseEntity.status(HttpStatus.OK).body(relatorio);
        }
    }

    private LocalDateTime transformaStringEmLocalDate(String data){

        if(data.isEmpty()){
            data = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate ld = LocalDate.parse(data, formatter);
        LocalDateTime ldt = LocalDateTime.of(ld, LocalDateTime.now().toLocalTime());
        return ldt;
    }
}
