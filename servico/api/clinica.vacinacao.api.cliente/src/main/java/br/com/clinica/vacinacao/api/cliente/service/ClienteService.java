package br.com.clinica.vacinacao.api.cliente.service;

import br.com.clinica.vacinacao.api.cliente.model.Cliente;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ClienteService {

    public List<Cliente> listarClientes() {
        log.info("ClienteService listarClientes");
        List<Cliente> clienteList = new ArrayList<>();
        clienteList.add(Cliente.builder().nome("Teste 1").id(1l).build());
        clienteList.add(Cliente.builder().nome("Teste 2").id(2l).build());
        return clienteList;
    }

    public Cliente consultarCliente(Long id) {
        log.info("ClienteService consultarCliente ID = " + id);
        return Cliente.builder().nome("Teste").id(id).build();
    }
}
