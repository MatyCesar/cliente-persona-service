package com.miempresa.clientepersona.repository;

import com.miempresa.clientepersona.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
