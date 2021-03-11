package br.com.clinica.vacinacao.api.vacina.lote.service;

import br.com.clinica.vacinacao.api.vacina.lote.model.VacinaLote;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class VacinaLoteService {

    public List<VacinaLote> listarVacinaLotes() {
        log.info("VacinaLoteService listarVacinaLotes");
        List<VacinaLote> vacinaLoteList = new ArrayList<>();
        vacinaLoteList.add(VacinaLote.builder().nome("Teste 5").id(5l).build());
        vacinaLoteList.add(VacinaLote.builder().nome("Teste 6").id(6l).build());
        return vacinaLoteList;
    }

    public VacinaLote consultarVacinaLote(Long id) {
        log.info("VacinaLoteService consultarVacinaLote ID = " + id);
        return VacinaLote.builder().nome("Teste").id(id).build();
    }
}
