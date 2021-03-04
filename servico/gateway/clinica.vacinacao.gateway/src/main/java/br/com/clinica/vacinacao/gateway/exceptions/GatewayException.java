package br.com.clinica.vacinacao.gateway.exceptions;

import br.com.clinica.vacinacao.gateway.model.ErrorMessage;

public class GatewayException extends RuntimeException {

    private final ErrorMessage error;

    public GatewayException(Throwable causa, ErrorMessage error) {
        super(causa);
        this.error = error;
    }

    public GatewayException(ErrorMessage error, Throwable causa) {
        super(causa);
        this.error = error;
    }

    public ErrorMessage getError() {
        return error;
    }
}
