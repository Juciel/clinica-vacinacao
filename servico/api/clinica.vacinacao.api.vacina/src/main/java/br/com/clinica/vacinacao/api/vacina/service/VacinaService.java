package br.com.clinica.vacinacao.api.vacina.service;

import br.com.clinica.vacinacao.api.vacina.model.Vacina;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class VacinaService {

    public List<Vacina> listarVacinas() {
        log.info("VacinaService listarVacinas");
        List<Vacina> vacinaList = new ArrayList<>();
        vacinaList.add(Vacina.builder().nome("Teste 3").id(3l).build());
        vacinaList.add(Vacina.builder().nome("Teste 4").id(4l).build());
        return vacinaList;
    }

    public Vacina consultarVacina(Long id) {
        log.info("VacinaService consultarVacina ID = " + id);
        return Vacina.builder().nome("Teste").id(id).build();
    }
}
