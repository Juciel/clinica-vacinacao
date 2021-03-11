package br.com.clinica.vacinacao.gateway.service;

import br.com.clinica.vacinacao.gateway.model.VacinaLote;
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
public class VacinaLoteService {

    @Autowired
    private WebClient webClientVacinaLote;

    public List<VacinaLote> listarVacinaLote() {
        log.info("Gatway VacinaLoteService listarVacinaLote");
        VacinaLote[] arrayVacinaLote = this.webClientVacinaLote
                .get().uri(RouterEnum.VACINA_LOTE_LISTA.getRota())
                .retrieve().bodyToMono(VacinaLote[].class).block();
        List<VacinaLote> vacinaLoteList = Arrays.stream(arrayVacinaLote).collect(Collectors.toList());
        log.info("Gatway VacinaLoteService listarVacinaLote Finalizado");
        return vacinaLoteList;
    }

    public VacinaLote consultarVacinaLote(Long id) {
        log.info("Gatway VacinaLoteService consultarVacinaLote ID = " + id);
        VacinaLote vacinaLote = this.webClientVacinaLote
                .get().uri(RouterEnum.VACINA_LOTE_ID.getRota(), id)
                .retrieve().bodyToMono(VacinaLote.class).block();
        log.info("Gatway VacinaLoteService consultarVacinaLote Finalizado");
        return vacinaLote;
    }
}
