package edu.ifma.lpweb.freteapi.domain.repository;

import edu.ifma.lpweb.freteapi.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    List<Cliente> findByNomeContaining(String nome );

    Optional<Cliente> findByEmail(String email);
}
