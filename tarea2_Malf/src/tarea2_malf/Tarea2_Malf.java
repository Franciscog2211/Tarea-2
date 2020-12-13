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
        String expresion= "$fib1 = 1";
        String expresion2= "$fib2 = 0";
        String expresion3= "$i = 2";
        String expresion4= "$act = $fib1 + $fib2";
        String expresion5= "$fib2 = $fib1";
        String expresion6= "$fib1 = $act";
        String expresion7= "$i = $i + 1";
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
        Operacion operacion3= new Operacion(expresion3);
        Operacion operacion4 = new Operacion(expresion4);
        Operacion operacion5= new Operacion(expresion5);
        Operacion operacion6= new Operacion(expresion6);
        Operacion operacion7= new Operacion(expresion7);
        for(int i=0; i<variables.size();i++){
            System.out.println("el valor de "+variables.get(i)+" es "+valores.get(i));
        }
        
        
    }
    
}
