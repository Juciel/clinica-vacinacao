package br.com.clinica.vacinacao.gateway.service;

import br.com.clinica.vacinacao.gateway.model.Vacina;
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
public class VacinaService {

    @Autowired
    private WebClient webClientVacina;

    public List<Vacina> listarVacinas() {
        log.info("Gatway VacinaService listarVacinas");
        Vacina[] arrayVacina = this.webClientVacina
                .get().uri(RouterEnum.VACINA_LISTA.getRota())
                .retrieve().bodyToMono(Vacina[].class).block();
        List<Vacina> vacinaList = Arrays.stream(arrayVacina).collect(Collectors.toList());
        log.info("Gatway VacinaService listarVacinas Finalizado");
        return vacinaList;
    }

    public Vacina consultarVacina(Long id) {
        log.info("Gatway VacinaService consultarVacina ID = " + id);
        Vacina vacina = this.webClientVacina
                .get().uri(RouterEnum.VACINA_ID.getRota(), id)
                .retrieve().bodyToMono(Vacina.class).block();
        log.info("Gatway VacinaService consultarVacina Finalizado");
        return vacina;
    }
}
