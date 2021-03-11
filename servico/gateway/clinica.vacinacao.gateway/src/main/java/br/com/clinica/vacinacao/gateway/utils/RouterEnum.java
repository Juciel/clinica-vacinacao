package br.com.clinica.vacinacao.gateway.utils;

public enum RouterEnum {

    CLIENTE_ID("/api/v1/clinica/vacinacao/cliente?id={id}","Endpoint para consultar o cliente."),
    CLIENTE_LISTA("/api/v1/clinica/vacinacao/clientes","Endpoint para listar os clientes."),

    VACINA_ID("/api/v1/clinica/vacinacao/vacina?id={id}","Endpoint para consultar uma vacina."),
    VACINA_LISTA("/api/v1/clinica/vacinacao/vacinas","Endpoint para listar as vacinas."),

    VACINA_LOTE_ID("/api/v1/clinica/vacinacao/vacina/lote?id={id}","Endpoint para consultar o lote de uma vacina."),
    VACINA_LOTE_LISTA("/api/v1/clinica/vacinacao/vacina/lotes","Endpoint para listar os lotes das Vacinas");

    private String rota;
    private String descricao;

    RouterEnum(String rota, String descricao){
        this.rota = rota;
        this.descricao = descricao;
    }

    public String getRota() {
        return rota;
    }

    public String getDescricao() {
        return descricao;
    }

}
