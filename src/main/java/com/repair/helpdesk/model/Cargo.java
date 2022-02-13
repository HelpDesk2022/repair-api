package com.repair.helpdesk.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Cargo {

    public enum NomeCargo {
        GERENTE,
        COORDENADOR,
        ANALISTA,
        ASSISTENTE,
        ESTAGIARIO
    }

    private static EnumSet<NomeCargo> listaCargos =
            EnumSet.of(NomeCargo.GERENTE, NomeCargo.COORDENADOR, NomeCargo.ANALISTA, NomeCargo.ASSISTENTE, NomeCargo.ESTAGIARIO);

    public static List<String> getAllCargos() {
        return listaCargos.stream().map(cargo -> cargo.name().toUpperCase()).collect(Collectors.toList());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;
}
