package com.grupo02.lojinha.MODEL;

/**
 *
 * @author rufin
 */
public class Produto {
    private int idProd;
    private String nmProd;
    private String descricao;
    private int qtde;
    private Double valor;

    public Produto() {
    }

    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    public String getNmProd() {
        return nmProd;
    }

    public void setNmProd(String nmProd) {
        this.nmProd = nmProd;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    
    
}
