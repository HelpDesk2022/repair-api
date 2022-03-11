package com.repair.helpdesk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String nomeCompleto;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @NotNull
    @Column(unique = true)
    private String cpf;

    @NotNull
    @OneToOne(cascade = CascadeType.PERSIST)
    private Cargo cargo;

    @NotNull
    private String email;

    @NotNull
    private  String password;
}
