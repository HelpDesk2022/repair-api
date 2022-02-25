package com.repair.helpdesk.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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

    private String dataHoraCriacao;

    private String dataHoraFinalizacao;

    @OneToOne(cascade = CascadeType.PERSIST, orphanRemoval = true)
    private Status status;

    @NotNull
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, targetEntity = Comentario.class, orphanRemoval = true)
    private List<Comentario> comentarios;

    @NotNull
    @OneToOne(cascade = CascadeType.PERSIST, orphanRemoval = true)
    private Usuario usuario;

    @NotNull
    @OneToOne(cascade = CascadeType.PERSIST, orphanRemoval = true)
    private Prioridade prioridade;
}
