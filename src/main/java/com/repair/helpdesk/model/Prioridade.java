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
@Builder
@Getter
@Setter
@Entity
public class Prioridade {

    public enum NomePrioridade {
        ALTO,
        MEDIA,
        BAIXO
    }

    private static EnumSet<Prioridade.NomePrioridade> listaPrioridades =
            EnumSet.of(Prioridade.NomePrioridade.ALTO,
                    Prioridade.NomePrioridade.MEDIA,
                    Prioridade.NomePrioridade.BAIXO);

    public static List<String> getAllPriodades() {
        return listaPrioridades.stream().map(prioridade -> prioridade.name().toUpperCase()).collect(Collectors.toList());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String nome;

}
