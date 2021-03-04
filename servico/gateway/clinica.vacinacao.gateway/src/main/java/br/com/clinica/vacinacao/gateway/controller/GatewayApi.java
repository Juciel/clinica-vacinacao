package br.com.clinica.vacinacao.gateway.controller;

import br.com.clinica.vacinacao.gateway.model.Cliente;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Api(value = "API de Ajuizamento", produces = MediaType.APPLICATION_JSON_VALUE)
public interface GatewayApi {

    @ApiOperation(value = "Endpoint para listar os clientes.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Processo realizado com sucesso", response = Cliente.class),
            @ApiResponse(code = 401, message = "Autenticação não realizada / token inválida"),
            @ApiResponse(code = 403, message = "Usuario não possui permissão para acessar esta API"),
            @ApiResponse(code = 404, message = "Recurso não encontrado."),
            @ApiResponse(code = 500, message = "Erro interno do servidor.")
    })
    @GetMapping(value = "/v1/clinica/vacinacao/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Cliente>> getClientes();

    @ApiOperation(value = "Endpoint para consultar o cliente.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Processo realizado com sucesso", response = Cliente.class),
            @ApiResponse(code = 401, message = "Autenticação não realizada / token inválida"),
            @ApiResponse(code = 403, message = "Usuario não possui permissão para acessar esta API"),
            @ApiResponse(code = 404, message = "Recurso não encontrado."),
            @ApiResponse(code = 500, message = "Erro interno do servidor.")
    })
    @GetMapping(value = "/v1/clinica/vacinacao/cliente", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Cliente> getCliente(@RequestParam(value = "id", required = false, defaultValue="0") Long id);
}
