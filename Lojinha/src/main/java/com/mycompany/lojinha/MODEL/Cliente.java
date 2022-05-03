package com.mycompany.lojinha.MODEL;

/**
 *
 * @author bruno.vrufino
 */
public class Cliente {
    private int idCliente;
    private String nomeCli;
    private String telefoneCli;
    private String celularCli;
    private String CPF;
    private String Email;
    private EnderecoCliente endereco;
    
    public Cliente(){
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCli() {
        return nomeCli;
    }

    public void setNomeCli(String nomeCli) {
        this.nomeCli = nomeCli;
    }

    public String getTelefoneCli() {
        return telefoneCli;
    }

    public void setTelefoneCli(String telefoneCli) {
        this.telefoneCli = telefoneCli;
    }

    public String getCelularCli() {
        return celularCli;
    }

    public void setCelularCli(String celularCli) {
        this.celularCli = celularCli;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public EnderecoCliente getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoCliente endereco) {
        this.endereco = endereco;
    }
    
    
}
