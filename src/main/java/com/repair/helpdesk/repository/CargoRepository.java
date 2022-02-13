package com.repair.helpdesk.repository;

import com.repair.helpdesk.model.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository extends JpaRepository<Cargo, Long> {
}
