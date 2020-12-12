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
        for(int i=0; i<caracteres.length; i++){
            if(caracteres[i].contains("$")){
               // BigInteger variable;
            }
            if(caracteres[i].contains("=")){
                //analizar despues del igual y asignar
              //  variable=asignacion(variable2);
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
