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
            if(!sintaxis.esVariable(expresion)){
                System.out.println("terminar programa");
            }
            else{
                System.out.println("programa sigue");
            }
            System.out.println("Cont.Cond: "+contieneCondicion(expresion));
            expresiones.add(expresion);
            if (expresion.contains("read") || expresion.contains("write")) {
            	entradaSalida(expresion);
            }
            Operacion operacion = new Operacion(expresion);
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
    	    	BigInteger var = leer();
    	    	variables.add(partes[i+1].substring(1, partes[i+1].length())); //guardamos la variable entre $ y ;
    	    	valores.add(var); //guardamos el valor de la variable
    		}
    		if(partes[i].equals("write")) {
    			for(int j=0; j<variables.size() ;j++) {
    				System.out.println("-----");
    				if(partes[i+1].substring(1, partes[i+1].length()).equals(variables.get(j))) {
    					System.out.println(variables.get(j)+" = "+valores.get(j));
    				}
    			}
    			
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
