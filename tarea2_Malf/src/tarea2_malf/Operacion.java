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
public class Operacion {
    String expresion;
    String[] caracteres;

    public Operacion(String expresion) {
        this.expresion = expresion;
        this.caracteres = expresion.split(" ");
        BigInteger resultado;
        if(caracteres[0].contains("$")){
            if(!Tarea2_Malf.variables.contains(caracteres[0])){
               Tarea2_Malf.variables.add(caracteres[0]);
               Tarea2_Malf.valores.add(BigInteger.ZERO);
            }          
        }
        if(caracteres[1].contains("=")){
            //ASIGNACION DE VALOR, EN CASO DE SER OTRA VARIABLE O SER DIGITO
            if(3==caracteres.length && caracteres[2].contains("$")){
                int n=Tarea2_Malf.variables.indexOf(caracteres[2]);
                int iV=Tarea2_Malf.variables.indexOf(caracteres[0]);
                if(n>=0){
                    Tarea2_Malf.valores.set(iV,Tarea2_Malf.valores.get(n));
                }
                else{
                    System.out.println("No se encontro la variable");
                }
            }
            if(3==caracteres.length && Character.isDigit(caracteres[2].charAt(0))){
                int iV=Tarea2_Malf.variables.indexOf(caracteres[0]);
                Tarea2_Malf.valores.set(iV,BigInteger.valueOf(Integer.parseInt(caracteres[2])));
                System.out.println("valor: "+Integer.parseInt(caracteres[2]));
            }
            //EN CASO DE OPERACIONES
            if(5==caracteres.length){
                //CASO DE LA SUMA
                BigInteger valor1= new BigInteger("0");
                BigInteger valor2= new BigInteger("0");
                if(caracteres[2].contains("$")){
                    int n=Tarea2_Malf.variables.indexOf(caracteres[2]);
                    System.out.println("n: "+n);
                    if(n>=0){
                        valor1=Tarea2_Malf.valores.get(n);
                    }
                    else{
                        System.out.println("No se encontro la variable");
                    }
                }
                if(Character.isDigit(caracteres[2].charAt(0))){
                    valor1=BigInteger.valueOf(Integer.parseInt(caracteres[2]));
                }
                if(caracteres[4].contains("$")){
                    int n=Tarea2_Malf.variables.indexOf(caracteres[4]);
                    if(n>=0){
                        valor2=Tarea2_Malf.valores.get(n);
                    }
                    else{
                        System.out.println("No se encontro la variable");
                    }
                }
                if(Character.isDigit(caracteres[4].charAt(0))){
                    valor2=BigInteger.valueOf(Integer.parseInt(caracteres[4]));
                }
                int iV=Tarea2_Malf.variables.indexOf(caracteres[0]);
                if(iV>=0){
                    if(caracteres[3].equals("+")){
                        Tarea2_Malf.valores.set(iV, suma(valor1,valor2));
                    }
                    if(caracteres[3].equals("-")){
                        Tarea2_Malf.valores.set(iV, resta(valor1,valor2));
                    }
                    if(caracteres[3].equals("*")){
                        Tarea2_Malf.valores.set(iV, multiplicacion(valor1,valor2));
                    }
                    if(caracteres[3].equals("/")){
                        Tarea2_Malf.valores.set(iV, division(valor1,valor2));
                    }
                    if(caracteres[3].equals("%")){
                        Tarea2_Malf.valores.set(iV, resto(valor1,valor2));
                    }
                }   
            }         
        }
    }
    
    public BigInteger asignacion(BigInteger variable){
        return variable;
    }
    
    public BigInteger suma(BigInteger valor1, BigInteger valor2){
        BigInteger resultado;
        return resultado=valor1.add(valor2);
    }
    
    public BigInteger resta(BigInteger valor1, BigInteger valor2){
        BigInteger resultado;
        return resultado=valor1.subtract(valor2);
    }
    
    public BigInteger division(BigInteger valor1, BigInteger valor2){
        BigInteger resultado;
        return resultado=valor1.divide(valor2);
    }
    
    public BigInteger multiplicacion(BigInteger valor1, BigInteger valor2){
        BigInteger resultado;
        return resultado=valor1.multiply(valor2);
    }
  
    public BigInteger resto(BigInteger valor1, BigInteger valor2){
        BigInteger resultado;
        return resultado=valor1.remainder(valor2);
    }
}
