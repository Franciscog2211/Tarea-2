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
            System.out.println(""+caracteres[i]);
            if(caracteres[i].equals("$")){
                System.out.println("entre aqui");
                if(i+1<caracteres.length && Character.isLetter(caracteres[i+1].charAt(0))){
                    System.out.println("si es una letra");
                }
                else{
                    System.out.println("no es una letra");
                    return false;
                }
                if(i-1>=0 && Character.isLetter(caracteres[i-1].charAt(0))){
                    System.out.println("no es letra");
                    return false;
                }
            }
        }
        return true;
    }
}
