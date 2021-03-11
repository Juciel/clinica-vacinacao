package br.com.clinica.vacinacao.api.vacina.exceptions;

import br.com.clinica.vacinacao.api.vacina.model.ErrorMessage;

public class NegocioException extends RuntimeException {

    private final ErrorMessage error;

    public NegocioException(Throwable causa, ErrorMessage error) {
        super(causa);
        this.error = error;
    }

    public NegocioException(ErrorMessage error, Throwable causa) {
        super(causa);
        this.error = error;
    }

    public ErrorMessage getError() {
        return error;
    }
}
