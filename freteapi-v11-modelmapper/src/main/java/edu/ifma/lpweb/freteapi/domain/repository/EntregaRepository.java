package edu.ifma.lpweb.freteapi.domain.repository;

import edu.ifma.lpweb.freteapi.domain.model.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Integer> {

}