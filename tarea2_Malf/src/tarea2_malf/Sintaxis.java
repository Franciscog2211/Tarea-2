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
    
    public boolean analisisExpresion(String expresion){
        String[] caracteres = expresion.split(" ");
        if(!(caracteres[caracteres.length-1].charAt(caracteres[caracteres.length-1].length()-1)==';')){
            return false;
        }
        for(int i=caracteres.length-1; i>=0; i--){
            if(caracteres[i].contains("$")){
                if(!(caracteres[i].charAt(0)=='$')){
                    return false;
                }
                for(int a=caracteres[i].length()-1;a>0;a--){
                    if(!(Character.isLetterOrDigit(caracteres[i].charAt(a)))){
                        return false;
                    }
                }
            }
            if(!(caracteres[i].contains("$"))){
                int sum=0;
                if(caracteres[i].length()==1 && caracteres[i].equals("+")){
                   sum++;
                }
                if(caracteres[i].length()==1 && caracteres[i].equals("-")){
                   sum++;
                }
                if(caracteres[i].length()==1 && caracteres[i].equals("*")){
                   sum++; 
                }
                if(caracteres[i].length()==1 && caracteres[i].equals("/")){
                   sum++;
                }
                if(caracteres[i].length()==1 && caracteres[i].equals("%")){
                   sum++;
                }
                if(caracteres[i].length()==1 && caracteres[i].equals("=")){
                   sum++;
                }
                if(sum==0){
                    for(int a=caracteres[i].length()-1;a>0;a--){
                        if(!(Character.isDigit(caracteres[i].charAt(a)))){
                            return false;
                        }
                    }
                }     
            }
        }
        return true;
    }
}
