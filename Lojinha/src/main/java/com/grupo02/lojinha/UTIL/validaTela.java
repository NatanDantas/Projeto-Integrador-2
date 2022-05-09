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
 *
 * @author rufin
 */
public class validaTela {
    public static ArrayList<String> lstError = new ArrayList<>();
    public static ArrayList<String> getErrorMessages(){
        return lstError;
    }
    
    public static boolean isEmpty(JTextField txt){
        if(txt.getText().equals("")){
            return true;
        }
        return false;
    }
    
    public static void authanticateNumber(JTextField txt){
        try{
            if(isEmpty(txt))
                throw new IllegalArgumentException();
            
            int textValue = Integer.parseInt(txt.getText());
            txt.setBackground(Color.WHITE);
        }catch(NumberFormatException e){
            lstError.add("Texto no campo " + txt.getName() + " não é um numero");
            txt.setBackground(Color.RED);
        }
        catch(IllegalArgumentException e){
            lstError.add("Não a texto no campo " + txt.getName());
            txt.setBackground(Color.RED);
        }
    }
}
