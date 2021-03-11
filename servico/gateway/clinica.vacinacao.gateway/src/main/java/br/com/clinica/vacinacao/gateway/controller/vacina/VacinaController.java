package br.com.clinica.vacinacao.gateway.controller.vacina;

import br.com.clinica.vacinacao.gateway.model.Vacina;
import br.com.clinica.vacinacao.gateway.service.VacinaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class VacinaController implements VacinaApi {

    @Autowired
    private VacinaService vacinaService;

    @Override
    public ResponseEntity<List<Vacina>> getVacinas() {
        log.info("Gatway Endpoint para listar vacinas (INICIO)");
        List<Vacina> list = vacinaService.listarVacinas();
        log.info("Gatway Endpoint para listar clientes (FIM)");
        return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }

    @Override
    public ResponseEntity<Vacina> getVacina(Long id) {
        log.info("Gatway Endpoint para consultar o vacina (INICIO)");
        Vacina vacina = vacinaService.consultarVacina(id);
        log.info("Gatway Endpoint para consultar o vacina (FIM)");
        return ResponseEntity.status(HttpStatus.CREATED).body(vacina);
    }
}
