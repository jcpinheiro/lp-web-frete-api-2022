package edu.ifma.lpweb.freteapi.domain.repository;

import edu.ifma.lpweb.freteapi.domain.model.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    Iterable<Cliente> findByNomeContaining(String nome );
    Page<Cliente> findByNomeContaining(@Param("nome") String nome, Pageable page);
    Optional<Cliente> findByEmail(String email);

}
