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
public class Permissao {

    public enum NomeFuncionalidade {
        VISUALIZAR_CHAMADO,
        EDITAR_CHAMADO,
        COMENTAR_CHAMADO,
        EXCLUIR_CHAMADO
    }

    private static EnumSet<Permissao.NomeFuncionalidade> listaPermissoes =
            EnumSet.of(Permissao.NomeFuncionalidade.VISUALIZAR_CHAMADO,
                    Permissao.NomeFuncionalidade.EDITAR_CHAMADO,
                    Permissao.NomeFuncionalidade.COMENTAR_CHAMADO,
                    Permissao.NomeFuncionalidade.EXCLUIR_CHAMADO);

    public static List<String> getAllPermissoes() {
        return listaPermissoes.stream().map(permissao -> permissao.name().toUpperCase()).collect(Collectors.toList());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String funcionalidade;
}
