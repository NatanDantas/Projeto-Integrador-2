/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lojinha.MODEL;

/**
 *
 * @author bruno.vrufino
 */
public class EnderecoFuncionario {
    private String CEP;
    private String Rua;
    private String Numero;
    private String Bairro;
    
    public EnderecoFuncionario(){
    
    }

    public String getCEP() {
        return CEP;
    }

    public String getRua() {
        return Rua;
    }

    public String getNumero() {
        return Numero;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public void setRua(String Rua) {
        this.Rua = Rua;
    }

    public void setNumero(String Numero) {
        this.Numero = Numero;
    }

    public void setBairro(String Bairro) {
        this.Bairro = Bairro;
    }
    
    
}
