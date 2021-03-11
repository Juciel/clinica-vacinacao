package br.com.clinica.vacinacao.api.vacina.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Vacina {

    private Long id;
    private String nome;
}
