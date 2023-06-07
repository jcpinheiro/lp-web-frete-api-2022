package edu.ifma.lpweb.freteapi.domain.repository;

import edu.ifma.lpweb.freteapi.domain.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
    List<Cidade> findByNomeContaining(String nome );
}
