package com.repair.helpdesk.model;

import lombok.*;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class EsqueciSenha {

    @NotNull
    private String email;

}
