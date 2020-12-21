/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea2_malf;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
            variables.add("$a");
            valores.add(new BigInteger("3"));
            variables.add("$b");
            valores.add(new BigInteger("4"));
            Parser parse = new Parser();
            //if ($n < 2) then
            //while ($i <= $n) do
            /*
            if(parse.parseVariable("$n ")) {
            	System.out.println("TRUE");
            }
            else {
            	System.out.println("FALSE");
            }
            */
            if(!sintaxis.analisisExpresion(expresion)){
                System.out.println("Error de sintaxis");
                //return;
                //arreglar para funcion read y write (ambos dicen error de sintaxis)
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
            if (expresion.contains("read") || expresion.contains("write")) {
            	entradaSalida(expresion);
            }
            for(int i=0; i<variables.size(); i++){
                System.out.println("valor de: "+variables.get(i)+" es "+valores.get(i));
            }
        }
        while(terminar);
      
    }
    
    public static void entradaSalida(String comando) {
    	String [] partes;
    	partes = comando.split(" ");
    	for(int i=0 ; i<partes.length ; i++) {
    		if(partes[i].equals("read")) {
    			String [] caracteres; 
    	    	caracteres = partes[i+1].split("");
    	    	BigInteger valor = leer();
    	    	System.out.println("LEEEEEEER: "+partes[i+1].substring(0, partes[i+1].length()-1));
    	    	variables.add(partes[i+1].substring(0, partes[i+1].length()-1)); //guardamos la variable entre $ y ;
    	    	valores.add(valor); //guardamos el valor de la variable
    		}
    		if(partes[i].equals("write")) {//falta implementacion de funcion de operacion
    			System.out.println("Valor de "+partes[i+1]+" = " +Operacion.operacionWrite(partes[i+1]));
    		}
    	}
    }

    public void write(String comando) {
    	
    }
    
	private static BigInteger leer() {
		Scanner read = new Scanner(System.in);
		String num = "a";
		while(!esNumero(num)) {
			num = read.nextLine();
		}
		BigInteger numero = new BigInteger(num); 
		return numero;
	}
	
	private static boolean esNumero(String cadena){
		if(cadena.length()==0) {
			System.out.println("Solo puede ingresar numeros");
			return false;
		}
		int i=0;
		if (cadena.charAt(0)=='-') {
			if (cadena.length()==1) {
				System.out.println("Solo puede ingresar numeros");
				return false;
			}
			i=1;
		}
		while (i <cadena.length ()) { 
			char c = cadena.charAt(i);
			if(c<'0' || c>'9') {
				System.out.println("Solo puede ingresar numeros");
				return false;
			}
			i++;
		}
		System.out.println("Perfecto "+cadena);
		return true;
	}
	private static int contieneCondicion(String cadena){
		for (int i=0; i <cadena.length (); i++) { 
			char c = cadena.charAt(i);
			switch(c){
            case '<':
                if (cadena.charAt(i+1)=='=') {
                	System.out.println("La condicion es <=");
                	return 3;
                }
                else {
                	System.out.println("La condicion es <");
                }
                return 1;
            case '>':
            	
            	if (cadena.charAt(i+1)=='=') {
            		System.out.println("La condicion es >=");
                	return 4;
                }
            	else {
            		System.out.println("La condicion es >");
            	}
                return 2;
            case '=':
                if (cadena.charAt(i+1)=='=') {
                	System.out.println("La condicion es ==");
                	return 5;
                }
                else {
                	System.out.println("La condicion es =");
                }
                break;
            case '!':
               
                if (cadena.charAt(i+1)=='=') {
                	System.out.println("La condicion es !=");
                	return 6;
                }
                else {
                	 System.out.println("La condicion es !");
                }
                break;
			}
		}
		return 0;
	}
}
