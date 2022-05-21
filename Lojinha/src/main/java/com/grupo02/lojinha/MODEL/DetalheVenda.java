package com.grupo02.lojinha.MODEL;

/**
 *
 * @author rufin
 */
public class DetalheVenda {
    private int idVenda;
    private int idDetalheVenda;
    private Produto Prod;
    private double valor;
    private int quantidade;

    public DetalheVenda() {
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getIdDetalheVenda() {
        return idDetalheVenda;
    }

    public void setIdDetalheVenda(int idDetalheVenda) {
        this.idDetalheVenda = idDetalheVenda;
    }

    public Produto getProd() {
        return Prod;
    }

    public void setProd(Produto Prod) {
        this.Prod = Prod;
    }

  

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
}
