package com.repair.helpdesk.repository;

import com.repair.helpdesk.model.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamadoRepository extends JpaRepository<Chamado, Long> {
}
