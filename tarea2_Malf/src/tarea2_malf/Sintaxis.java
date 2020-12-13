/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea2_malf;

/**
 *
 * @author ayline
 */
public class Sintaxis {
    
    public boolean esVariable(String variable){
        String[] caracteres = variable.split("");
        for(int i=0; i<caracteres.length; i++){
            if(caracteres[i].equals("$")){
                if(!(i+1<caracteres.length && Character.isLetter(caracteres[i+1].charAt(0)))){
                    return false;
                }
                if(i-1>=0 && Character.isLetter(caracteres[i-1].charAt(0))){
                    return false;
                }
            }
        }
        return true;
    }
}
