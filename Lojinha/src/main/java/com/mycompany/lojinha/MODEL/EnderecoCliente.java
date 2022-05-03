package com.mycompany.lojinha.MODEL;

/**
 *
 * @author bruno.vrufino
 */
public class EnderecoCliente {
    private String CEP;
    private String Rua;
    private String Numero;
    private String Bairro;
    
    public EnderecoCliente(){
    
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getRua() {
        return Rua;
    }

    public void setRua(String Rua) {
        this.Rua = Rua;
    }

    public String getNumero() {
        return Numero;
    }

    public void setNumero(String Numero) {
        this.Numero = Numero;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String Bairro) {
        this.Bairro = Bairro;
    }
    
    
}
