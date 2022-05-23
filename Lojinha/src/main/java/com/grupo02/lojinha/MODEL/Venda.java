package com.grupo02.lojinha.MODEL;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author bruno.vrufino
 */
public class Venda {
    private int idVenda;
    private int idcli;
    private int idfunc;
    private Date data;
    private ArrayList<DetalheVenda> itensVenda;
    private double valorTotal;
    
    public Venda(){
    
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getIdcli() {
        return idcli;
    }

    public void setIdcli(int idcli) {
        this.idcli = idcli;
    }

    public int getIdfunc() {
        return idfunc;
    }

    public void setIdfunc(int idfunc) {
        this.idfunc = idfunc;
    }

    

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public ArrayList<DetalheVenda> getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(ArrayList<DetalheVenda> itensVenda) {
        this.itensVenda = itensVenda;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    
          
}
