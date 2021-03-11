package br.com.clinica.vacinacao.gateway.controller.vacina.lote;

import br.com.clinica.vacinacao.gateway.model.VacinaLote;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Api(value = "Gateway API de Lotes de Vacinas", produces = MediaType.APPLICATION_JSON_VALUE)
public interface VacinaLoteApi {

    @ApiOperation(value = "Endpoint para listar os lotes das vacinas.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Processo realizado com sucesso", response = VacinaLote.class),
            @ApiResponse(code = 401, message = "Autenticação não realizada / token inválida"),
            @ApiResponse(code = 403, message = "Usuario não possui permissão para acessar esta API"),
            @ApiResponse(code = 404, message = "Recurso não encontrado."),
            @ApiResponse(code = 500, message = "Erro interno do servidor.")
    })
    @GetMapping(value = "/gateway/v1/clinica/vacinacao/vacina/lotes", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<VacinaLote>> getVacinaLotes();

    @ApiOperation(value = "Endpoint para consultar o lote da vacina.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Processo realizado com sucesso", response = VacinaLote.class),
            @ApiResponse(code = 401, message = "Autenticação não realizada / token inválida"),
            @ApiResponse(code = 403, message = "Usuario não possui permissão para acessar esta API"),
            @ApiResponse(code = 404, message = "Recurso não encontrado."),
            @ApiResponse(code = 500, message = "Erro interno do servidor.")
    })
    @GetMapping(value = "/gateway/v1/clinica/vacinacao/vacina/lote", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<VacinaLote> getVacinaLote(@RequestParam(value = "id", required = false, defaultValue="0") Long id);
}
