package edu.ifma.lpweb.freteapi.domain.service;

import edu.ifma.lpweb.freteapi.domain.exception.NegocioException;
import edu.ifma.lpweb.freteapi.domain.model.Cliente;
import edu.ifma.lpweb.freteapi.domain.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ClienteService {

    private final ClienteRepository repository;

    public Iterable<Cliente> todos() {
        return repository.findAll();
    }

    public Optional<Cliente> buscaPor(Integer id) {
        return repository.findById(id);
    }

    public Iterable<Cliente> buscaPor(String nome) {
        return repository.findByNomeContaining(nome );
    }

    @Transactional
    public Cliente salva(Cliente cliente) {
        boolean emailEmUso = repository
                .findByEmail(cliente.getEmail())
                .stream()
                .anyMatch(clienteExistente -> !Objects.equals(clienteExistente, cliente));

        if (emailEmUso) {
            throw new NegocioException("Já existe um cliente cadastrado com este e-mail.");
        }
        return repository.save(cliente);
    }

    @Transactional
    public void removePelo(Integer id) {
        repository.deleteById(id);
    }

    public boolean naoExisteClienteCom(Integer id ) {
        return !repository.existsById(id );
    }

    public Page<Cliente> buscaPaginada(Pageable page) {
        return repository.findAll(page );

    }

    public Page<Cliente> buscaPor(String nome, Pageable page) {
        return repository.findByNomeContaining(nome, page );
    }
}
