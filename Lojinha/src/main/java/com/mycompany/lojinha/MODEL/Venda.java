package com.mycompany.lojinha.MODEL;

/**
 *
 * @author bruno.vrufino
 */
public class Venda {
    private int idVenda;
    private Cliente cli;
    private Produto prod;
    
    public Venda(){
    
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    public Produto getProd() {
        return prod;
    }

    public void setProd(Produto prod) {
        this.prod = prod;
    }
    
    
}
