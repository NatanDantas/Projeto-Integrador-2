package com.grupo02.lojinha.MODEL;

/**
 *
 * @author bruno.vrufino
 */
public class Cliente {
    private int idCliente;
    private String nomeCli;
    private String telefoneCli;
    private String celularCli;
    private String cpf;
    private String email;
    private Endereco endereco;
    
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
        return cpf;
    }

    public void setCPF(String CPF) {
        this.cpf = CPF;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String Email) {
        this.email = Email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }  
}
