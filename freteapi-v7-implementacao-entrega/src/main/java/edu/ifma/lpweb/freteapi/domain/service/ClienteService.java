package edu.ifma.lpweb.freteapi.domain.service;

import edu.ifma.lpweb.freteapi.domain.exception.NegocioException;
import edu.ifma.lpweb.freteapi.domain.model.Cliente;
import edu.ifma.lpweb.freteapi.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.repository = clienteRepository;
    }

    public List<Cliente> todos() {
        return repository.findAll();
    }

    public Optional<Cliente> buscaPor(Integer id) {
        return repository.findById(id);
    }

    public List<Cliente> buscaPor(String nome) {
        return repository.findByNomeContaining(nome );
    }

    @Transactional
    public Cliente salva(Cliente cliente) {
        boolean emailEmUso = repository
                .findByEmail(cliente.getEmail())
                .stream()
                .anyMatch(clienteExistente -> !clienteExistente.equals(cliente));

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

}
