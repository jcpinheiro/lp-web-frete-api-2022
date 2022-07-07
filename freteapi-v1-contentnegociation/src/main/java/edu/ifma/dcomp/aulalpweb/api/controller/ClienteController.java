package edu.ifma.dcomp.aulalpweb.api.controller;


import edu.ifma.dcomp.aulalpweb.domain.model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClienteController {

    @GetMapping("/ola")
    public String ola() {
        return "Olá Mundo!";
    }

    @GetMapping("/clientes")
    public List<Cliente> listar() {
        return List.of(
                new Cliente(1, "Joao", "98 9876-5678"),
                new Cliente(2, "Maria","98 9999-5622")
        );
    }

}
