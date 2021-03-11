package br.com.clinica.vacinacao.gateway.service;

import br.com.clinica.vacinacao.gateway.model.Cliente;
import br.com.clinica.vacinacao.gateway.utils.RouterEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ClienteService {

    @Autowired
    private WebClient webClientCliente;

    public List<Cliente> listarClientes() {
        log.info("Gatway ClienteService listarClientes");
        Cliente[] arrayCliente = this.webClientCliente
                .get().uri(RouterEnum.CLIENTE_LISTA.getRota())
                .retrieve().bodyToMono(Cliente[].class).block();
        List<Cliente> clienteList = Arrays.stream(arrayCliente).collect(Collectors.toList());
        log.info("Gatway ClienteService listarClientes Finalizado");
        return clienteList;
    }

    public Cliente consultarCliente(Long id) {
        log.info("Gatway ClienteService consultarCliente ID = " + id);
        Cliente cliente = this.webClientCliente
                .get().uri(RouterEnum.CLIENTE_ID.getRota(), id)
                .retrieve().bodyToMono(Cliente.class).block();
        log.info("Gatway ClienteService consultarCliente Finalizado");
        return cliente;
    }
}
