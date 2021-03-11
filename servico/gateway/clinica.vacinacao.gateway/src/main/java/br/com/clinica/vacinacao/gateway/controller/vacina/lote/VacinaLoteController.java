package br.com.clinica.vacinacao.gateway.controller.vacina.lote;

import br.com.clinica.vacinacao.gateway.model.VacinaLote;
import br.com.clinica.vacinacao.gateway.service.VacinaLoteService;
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
        log.info("Gatway Endpoint para listar lotes das vacinas (INICIO)");
        List<VacinaLote> list = vacinaLoteService.listarVacinaLote();
        log.info("Gatway Endpoint para listar vacinas (FIM)");
        return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }

    @Override
    public ResponseEntity<VacinaLote> getVacinaLote(Long id) {
        log.info("Gatway Endpoint para consultar um lote de uma vacina (INICIO)");
        VacinaLote vacinaLote = vacinaLoteService.consultarVacinaLote(id);
        log.info("Gatway Endpoint para consultar um lote de uma vacina (FIM)");
        return ResponseEntity.status(HttpStatus.CREATED).body(vacinaLote);
    }
}
