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
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<String> variables = new ArrayList<>();
        ArrayList<BigInteger> valores = new ArrayList<>();
        String expresion= "$a = 3";
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
        
    }
    
}
