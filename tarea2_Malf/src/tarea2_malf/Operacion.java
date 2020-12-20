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

    public Operacion() {
    }

    
    public boolean Operacion(String expresion) {
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
            if(4==caracteres.length && caracteres[2].contains("$")){
                int n=Tarea2_Malf.variables.indexOf(caracteres[2]);
                int iV=Tarea2_Malf.variables.indexOf(caracteres[0]);
                if(n>=0){
                    Tarea2_Malf.valores.set(iV,Tarea2_Malf.valores.get(n));
                }
                else{
                    System.out.println("No se encontro la variable");
                    return false;
                }
            }
            if(4==caracteres.length && Character.isDigit(caracteres[2].charAt(0))){
                int iV=Tarea2_Malf.variables.indexOf(caracteres[0]);
                Tarea2_Malf.valores.set(iV,BigInteger.valueOf(Integer.parseInt(caracteres[2])));
            }
            //EN CASO DE OPERACIONES
            else{
                ArrayList<String> salida= new ArrayList<>();
                for(int a=caracteres.length-1; a>=2; a--){
                    BigInteger valor= new BigInteger("0");
                    if(caracteres[a].contains("$")){
                        int n=Tarea2_Malf.variables.indexOf(caracteres[a]);
                        if(n>=0){
                            valor=Tarea2_Malf.valores.get(n);
                            salida.add(String.valueOf(valor));
                        }
                        else{
                            System.out.println("No se encontro la variable");
                            return false;
                        }
                    }
                    if(Character.isDigit(caracteres[a].charAt(0))){
                        valor=BigInteger.valueOf(Integer.parseInt(caracteres[a]));
                        salida.add(String.valueOf(valor));
                    }
                    if(caracteres[a].equals("+")){
                        salida.add("+");
                    }
                    if(caracteres[a].equals("-")){
                        salida.add("-");
                    }
                    if(caracteres[a].equals("*")){
                        salida.add("*");
                    }
                    if(caracteres[a].equals("/")){
                        salida.add("/");
                    }
                    if(caracteres[a].equals("%")){
                        salida.add("%");
                    }
                    if(salida.size()==3){
                        String valor1= salida.get(0);
                        String valor2= salida.get(2);
                        BigInteger resultado1;
                        int sum=0;
                        if(salida.size()==3 && salida.get(1).equals("+")){
                            resultado1=suma(BigInteger.valueOf(Integer.parseInt(valor1)),BigInteger.valueOf(Integer.parseInt(valor2)));
                            salida.removeAll(salida);
                            salida.add(String.valueOf(resultado1));
                        }
                        if(salida.size()==3 && salida.get(1).equals("-")){
                            resultado1=resta(BigInteger.valueOf(Integer.parseInt(valor1)),BigInteger.valueOf(Integer.parseInt(valor2)));
                            salida.removeAll(salida);
                            salida.add(String.valueOf(resultado1));
                        }
                        if(salida.size()==3 && salida.get(1).equals("*")){
                            resultado1=multiplicacion(BigInteger.valueOf(Integer.parseInt(valor1)),BigInteger.valueOf(Integer.parseInt(valor2)));
                            salida.removeAll(salida);
                            salida.add(String.valueOf(resultado1));
                        }
                        if(salida.size()==3 && salida.get(1).equals("/")){
                            resultado1=division(BigInteger.valueOf(Integer.parseInt(valor1)),BigInteger.valueOf(Integer.parseInt(valor2)));
                            salida.removeAll(salida);
                            salida.add(String.valueOf(resultado1));
                        }
                        if(salida.size()==3 && salida.get(1).equals("%")){
                            resultado1=resto(BigInteger.valueOf(Integer.parseInt(valor1)),BigInteger.valueOf(Integer.parseInt(valor2)));
                            salida.removeAll(salida);
                            salida.add(String.valueOf(resultado1));
                        }
                    }
                }
                int iV=Tarea2_Malf.variables.indexOf(caracteres[0]);
                Tarea2_Malf.valores.set(iV,BigInteger.valueOf(Integer.parseInt(salida.get(0))));
            }
        }
        return true;
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
