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
public class Funcionario {
    private int idFunc;
    private String nomeFunc;
    private String telefoneFunc;
    private String celularFunc;
    private String cargo;
    private String login;
    private String senha;
    private EnderecoFuncionario endereco;
    
    public Funcionario(){
    
    }

    public int getIdFunc() {
        return idFunc;
    }
    
    public String getNomeFunc() {
        return nomeFunc;
    }

    public String getTelefoneFunc() {
        return telefoneFunc;
    }

    public String getCelularFunc() {
        return celularFunc;
    }

    public String getCargo() {
        return cargo;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public EnderecoFuncionario getEndereco() {
        return endereco;
    }

    public void setNomeFunc(String nomeFunc) {
        this.nomeFunc = nomeFunc;
    }

    public void setTelefoneFunc(String telefoneFunc) {
        this.telefoneFunc = telefoneFunc;
    }

    public void setCelularFunc(String celularFunc) {
        this.celularFunc = celularFunc;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setEndereco(EnderecoFuncionario endereco) {
        this.endereco = endereco;
    }

    public void setIdFunc(int idFunc) {
        this.idFunc = idFunc;
    }
    
    
    
}
