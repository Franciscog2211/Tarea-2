package tarea2_malf;

public class Parser {
	
	public boolean parseSentencia(String sentencia) {
		if (parseWhile(sentencia) || parseIf(sentencia)) {
			return true;
		}
		return false;
		
	}
	public boolean parseE(String sentencia) {
		//if(!parseEp(sentencia) && !parseT(sentencia)) {//falta el signo
			//return false;
		//}
		return true;
	}
	public boolean parseEp(String sentencia) {
		
		return true;
	}
	
	public boolean parseT(String sentencia) {
		
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
			if(parseE(partes[0]) && parseCondLogica(partes[1]) && parseE(partes[2])) {
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
