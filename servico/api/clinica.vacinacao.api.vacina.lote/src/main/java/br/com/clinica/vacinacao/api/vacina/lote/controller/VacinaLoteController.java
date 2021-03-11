package br.com.clinica.vacinacao.api.vacina.lote.controller;

import br.com.clinica.vacinacao.api.vacina.lote.model.VacinaLote;
import br.com.clinica.vacinacao.api.vacina.lote.service.VacinaLoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class VacinaLoteController implements VacinaLoteApi{

    @Autowired
    private VacinaLoteService vacinaLoteService;

    @Override
    public ResponseEntity<List<VacinaLote>> getVacinaLotes() {
        log.info("Api Endpoint para listar vacinas (INICIO)");
        List<VacinaLote> list = vacinaLoteService.listarVacinaLotes();
        log.info("Api Endpoint para listar vacinas (FIM)");
        return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }

    @Override
    public ResponseEntity<VacinaLote> getVacinaLote(Long id) {
        log.info("Api Endpoint para consultar o vacina (INICIO)");
        VacinaLote vacina = vacinaLoteService.consultarVacinaLote(id);
        log.info("Api Endpoint para consultar o vacina (FIM)");
        return ResponseEntity.status(HttpStatus.CREATED).body(vacina);
    }
}
