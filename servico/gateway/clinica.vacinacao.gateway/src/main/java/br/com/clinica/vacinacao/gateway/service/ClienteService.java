package br.com.clinica.vacinacao.gateway.service;

import br.com.clinica.vacinacao.gateway.model.Cliente;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ClienteService {

    public List<Cliente> listarClientes() {
        log.info("ClienteService listarClientes");
        return null;
    }

    public Cliente consultarCliente(Long id) {
        log.info("ClienteService consultarCliente ID = " + id);
        return Cliente.builder().nome("Teste").id(id).build();
    }
}
