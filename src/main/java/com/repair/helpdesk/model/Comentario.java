package com.repair.helpdesk.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String descricao;

    @NotNull
    @OneToOne(orphanRemoval = true)
    private Usuario usuarioCriacao;

}
