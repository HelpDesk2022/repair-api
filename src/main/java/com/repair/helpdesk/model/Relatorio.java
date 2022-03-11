package com.repair.helpdesk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Relatorio {
    @NotNull
    private Long idColaborador;
    @NotNull
    private String dataInicial;
    @NotNull
    private String dataFinal;
}
