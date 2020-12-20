package tarea2_malf;

public class Parser {

	public boolean parseSentencias(String sentencia) {//sentencia; sentenciaPrima
		//PARSEAR EL ; PARA ESTABLECER EL LIMITE
		if(parseSentencia(sentencia) && parseSentenciaPrima(sentencia)) {
			return true;
		}
		return false;
	}
	public boolean parseSentenciaPrima(String sentencia) {//sentencias | e
		
		return true;
	}
	public boolean parseSentencia(String sentencia) {
		if (parseExpresion(sentencia) || parseAsignacion(sentencia) || parseWhile(sentencia) || parseIf(sentencia) || parseVacio(sentencia)) {
			return true;
		}
		return false;
		
	}
	private boolean parseExpresion(String sentencia) {//T E_Prima | e
		// TODO Auto-generated method stub
		return false;
	}
	private boolean parseAsignacion(String sentencia) {//Variable = Expresion
		// TODO Auto-generated method stub
		return false;
	}
	private boolean parseVacio(String sentencia) {
		if (sentencia.length()!=0) {
			return false;
		}
		return true;
	}
	
	public boolean parseEp(String sentencia) {
		
		return true;
	}
	
	public boolean parseT(String sentencia) {// F Tprima
		
		return true;
	}
	public boolean parseTp(String sentencia) {// * F T_Prima | / F T_Prima | % F T_Prima | e
		
		return true;
	}
	public boolean parseF(String sentencia) {// Numero | Variable | e
		
		return true;
	}
	public boolean parseVariable(String sentencia) {// $Var
		
		return true;
	}
	public boolean parseVar(String sentencia) {// C Var | e
		
		return true;
	}
	public boolean parseC(String sentencia) {// a...z | A...Z  | CARACT | e
	
		return true;
	}
	public boolean parseNumero(String sentencia) {//D Nprima
		
		return true;
	}
	//////limite- 
	public boolean parseD(char c) {//0...9 || e
            return c > 47 && c < 58;
	}
	public boolean parseNprima(String sentencia) {//Numero | e    
	
            if(sentencia.length() == 0) {
            return true;
        }
        return parseNumero(sentencia);
	}
        
	public boolean parseCaracter(char c ) {//. | , | : | ; | _
		
            return c > 33 && c < 46;
	}
	public boolean parseWrite(String sentencia) {//write Expresion
		
		return true;
	}
	public boolean parseRead(String sentencia) {//read Variable
            String partes [];
            partes = sentencia.split(" ");
            if(existeVariable(partes[3])){
                if (partes[3] != null) {
                    
                } else {
                    System.out.println("Error en la entrada");
                }
            }
		
		return true;
	}
	public boolean parseWhile(String sentencia) {
		//while ($i <= $n) do
		//0123456789012
		int aux=0,iniCondicion=0, finCondicion=0;
		for(int i=0; i<sentencia.length(); i++) {
			if(sentencia.charAt(i)=='w') {
				if(sentencia.charAt(i+1)=='h') {
					if(sentencia.charAt(i+2)=='i') {
						if(sentencia.charAt(i+3)=='l') {
							if(sentencia.charAt(i+4)=='e') {
								if(sentencia.charAt(i+6)=='(') {
									aux =1;
									iniCondicion=i+7;
									i=i+2;
								}
							}
						}
					}
					else {
						return false;
					}
				}
				else {
					return false;
				}
			}
			if(sentencia.charAt(i)==')') {
				//parseamos condicion entre "( )"
				if(!parseCondicion(sentencia.substring(iniCondicion, i))){
					return false;
				}
				if(sentencia.charAt(i+2)=='d'){
					if(sentencia.charAt(i+3)=='o'){
					}
					else {
						return false;
					}
				}
				else {
					return false;
				}
			}
		}
		return true;
	}
	public boolean parseIf(String sentencia) {
		//if ($a <= $b) then
		//0123456789012
		int aux=0,iniCondicion=0, finCondicion=0;
		for(int i=0; i<sentencia.length(); i++) {
			if(sentencia.charAt(i)=='i') {
				if(sentencia.charAt(i+1)=='f') {
					if(sentencia.charAt(i+3)=='(') {
						aux =1;
						iniCondicion=i+4;
						i=i+2;
					}
					else {
						return false;
					}
				}
				else {
					return false;
				}
			}
			if(sentencia.charAt(i)==')') {
				//parseamos condicion entre "( )"
				if(!parseCondicion(sentencia.substring(iniCondicion, i))){
					return false;
				}
				if(sentencia.charAt(i+2)=='t'){
					if(sentencia.charAt(i+3)=='h'){
						if(sentencia.charAt(i+4)=='e'){
							if(sentencia.charAt(i+5)!='n'){
								return false;
							}
						}
						else {
							return false;
						}
					}
					else {
						return false;
					}
				}
				else {
					return false;
				}
			}
		}
		return true;
	}
	
	
	public boolean parseCondicion(String condicion) {//falta condicionarlo con un numero
		String partes [];
		partes = condicion.split(" ");
		if(partes.length==3) {
			if(parseExpresion(partes[0]) && parseCondLogica(partes[1]) && parseExpresion(partes[2])) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	public boolean parseCondLogica(String condicion) {
		if(condicion.equals("<") || condicion.equals(">") || condicion.equals("<=") || condicion.equals(">=") || condicion.equals("==") || condicion.equals("!=")) {
			return true;
		}
		return false;
	}
	
	/*
	 * de momento, no la estoy utilizando
	 */
	public boolean existeVariable(String variable) {
		for(int i=0; i<Tarea2_Malf.variables.size(); i++) {
			if(Tarea2_Malf.variables.get(i).equals(variable)) {
				return true;
			}
		}
		return false;
	}
	
}
