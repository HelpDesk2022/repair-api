package com.repair.helpdesk.repository;

import com.repair.helpdesk.model.Chamado;
import com.repair.helpdesk.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Chamado findByCpf(String cpf);
}
