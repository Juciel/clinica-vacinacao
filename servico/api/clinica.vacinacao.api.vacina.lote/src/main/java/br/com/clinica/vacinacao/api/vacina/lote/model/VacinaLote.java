package br.com.clinica.vacinacao.api.vacina.lote.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VacinaLote {

    private Long id;
    private String nome;
}
