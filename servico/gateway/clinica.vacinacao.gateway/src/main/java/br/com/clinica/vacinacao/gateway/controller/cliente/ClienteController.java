package br.com.clinica.vacinacao.gateway.controller.cliente;

import br.com.clinica.vacinacao.gateway.exceptions.GatewayException;
import br.com.clinica.vacinacao.gateway.model.Cliente;
import br.com.clinica.vacinacao.gateway.model.ErrorMessage;
import br.com.clinica.vacinacao.gateway.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;
import java.util.Objects;

@Slf4j
@RestController
public class ClienteController implements ClienteApi {

    @Autowired
    private ClienteService clienteService;

    @Override
    public ResponseEntity<List<Cliente>> getClientes() {
        log.info("Gatway Endpoint para listar clientes (INICIO)");
        List<Cliente> list = clienteService.listarClientes();
        log.info("Gatway Endpoint para listar clientes (FIM)");
        return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }

    @Override
    public ResponseEntity<Cliente> getCliente(Long id) {
        log.info("Gatway Endpoint para consultar o cliente (INICIO)");
        Cliente cliente = clienteService.consultarCliente(id);
        log.info("Gatway Endpoint para consultar o clientes (FIM)");
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @ExceptionHandler(GatewayException.class)
    public ResponseEntity<ErrorMessage> catchBusinessError(GatewayException e) {
        if(Objects.isNull(e)){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ErrorMessage.builder().
                            status(500).
                            message("Error inesperado!").
                            build());
        }
        if(Objects.nonNull(e.getError())){
            return ResponseEntity.status(e.getError().getStatus()).body(e.getError());
        }
        return getError(e);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorMessage> catchRuntimeError(RuntimeException e) {
        return getError(e);
    }

    private ResponseEntity<ErrorMessage> getError(RuntimeException e) {
        if(e instanceof HttpClientErrorException) {
            return ResponseEntity.status(((HttpClientErrorException) e).getRawStatusCode())
                    .body(ErrorMessage.builder()
                            .status(((HttpClientErrorException) e).getRawStatusCode())
                            .message(((HttpClientErrorException) e).getResponseBodyAsString()).build());
        } else if (e instanceof HttpServerErrorException) {
            return ResponseEntity.status(((HttpServerErrorException) e).getRawStatusCode())
                    .body(ErrorMessage.builder()
                            .status(((HttpServerErrorException) e).getRawStatusCode())
                            .message(((HttpServerErrorException) e).getResponseBodyAsString()).build());
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ErrorMessage.builder().
                            status(500).
                            message("Error inesperado: ".concat(e.getMessage())).
                            build());
        }
    }
}
