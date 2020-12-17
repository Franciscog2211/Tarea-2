/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea2_malf;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

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
    static ArrayList<String> expresiones = new ArrayList<>();
    
    public static void main(String[] args) {
        // TODO code application logic here
        boolean terminar=true;
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido, ingresa las expresiones:\n");
        do{
            String expresion = sc.nextLine();
            Sintaxis sintaxis = new Sintaxis();
            Semantica semantica = new Semantica();
            Errores errores = new Errores();
            if(!sintaxis.analisisExpresion(expresion)){
                System.out.println("Error de sintaxis");
                return;
            }
            else{
                System.out.println("Sin error de sintaxis");
            }
            expresiones.add(expresion);
            if(expresion.contains("+") || expresion.contains("-") || expresion.contains("=") || expresion.contains("*") 
                    || expresion.contains("/") || expresion.contains("%")){
                Operacion operacion = new Operacion();
                if(!(operacion.Operacion(expresion))){
                    return;
                }
            }          
            for(int i=0; i<variables.size(); i++){
                System.out.println("valor de: "+variables.get(i)+" es "+valores.get(i));
            }
        }
        while(terminar);
      
    }
}
