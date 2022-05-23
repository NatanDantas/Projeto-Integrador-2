/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo02.lojinha.UTIL;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JTextField;

/**
 * @author NatanDantas
 * @author rufin
 */
public class validaTela {

    /**
     *Criação de uma ArrayList para armazenar os erros de validação de telas
     */
    public static ArrayList<String> lstError = new ArrayList<>();

    /**
     * Método para registrar os erros de validação de tela
     * @return ArrayList - Retorna uma ArrayList com os erros de validação 
     */
    public static ArrayList<String> getErrorMessages(){
        return lstError;
    }
    
    /**
     * Método para verificar se o campo em específico foi preenchido ou não
     * @param txt - <code>JTextField</code>
     * @return boolean - true: Campo vazio; false: Campo preenchido 
     */
    public static boolean isEmpty(JTextField txt){
        if(txt.getText().equals("")){
            return true;
        }
        return false;
    }
    
    /**
     * Método para verificar se o tipo e formato do número digitado em tal campo é válido
     * @param txt - <code>JTextField</code>
     * @return boolean - true: Número válido; false: Número Inválido
     */
    public static boolean authanticateNumber(JTextField txt){
        try{
            if(isEmpty(txt))
                throw new IllegalArgumentException();
            
            long textValue = Long.parseLong(txt.getText());
            txt.setBackground(Color.WHITE);
            return true;
        }catch(NumberFormatException e){         
            txt.setBackground(Color.RED);
            return false;
        }
        catch(IllegalArgumentException e){
            txt.setBackground(Color.RED);
            return false;
        }
    }
}
