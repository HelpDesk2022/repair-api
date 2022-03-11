package com.repair.helpdesk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Chamado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String titulo;

    @NotNull
    private String descricao;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataHoraCriacao;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataHoraFinalizacao;

    @OneToOne(orphanRemoval = true)
    private Status status;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Comentario.class, orphanRemoval = true)
    private List<Comentario> comentarios;

    @NotNull
    @OneToOne(orphanRemoval = true)
    private Usuario usuario;

    @NotNull
    @OneToOne(orphanRemoval = true)
    private Prioridade prioridade;
}
