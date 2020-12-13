/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea2_malf;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 *
 * @author ayline
 */
public class Tarea2_Malf {

    /**
     * @param args the command line arguments
     */
    static ArrayList<String> variables = new ArrayList<>();
    static ArrayList<BigInteger> valores = new ArrayList<>();
    
    public static void main(String[] args) {
        // TODO code application logic here
        String expresion= "$a = 3";
        String expresion2= "$b = $a - 5";
        Sintaxis sintaxis = new Sintaxis();
        Semantica semantica = new Semantica();
        Errores errores = new Errores();
        if(!sintaxis.esVariable(expresion)){
            System.out.println("terminar programa");
        }
        else{
            System.out.println("programa sigue");
        }
        Operacion operacion = new Operacion(expresion);
        Operacion operacion2= new Operacion(expresion2);
        System.out.println("el valor de "+variables.get(0)+" es "+valores.get(0));
        System.out.println("el valor de "+variables.get(1)+" es "+valores.get(1));
        
    }
    
}
