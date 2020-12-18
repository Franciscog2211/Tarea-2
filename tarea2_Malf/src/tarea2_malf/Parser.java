package tarea2_malf;

public class Parser {
	
	public boolean parseSentencia(String sentencia) {
		if (!parseE(sentencia) || !parseWhile(sentencia) || !parseIf(sentencia)) {
			return false;
		}
		return true;
		
	}
	public boolean parseE(String sentencia) {
		if(!parseEp(sentencia) && !parseT(sentencia)) {//falta el signo
			return false;
		}
		return true;
	}
	public boolean parseEp(String sentencia) {
		
		return true;
	}
	
	public boolean parseT(String sentencia) {
		
		return true;
	}
	public boolean parseWhile(String sentencia) {
		
		return true;
	}
	public boolean parseIf(String sentencia) {
		int aux=0,iniCondicion=0, finCondicion=0;
		for(int i=0; i<sentencia.length(); i++) {
			if(sentencia.charAt(i)=='i') {
				if(sentencia.charAt(i+1)=='f') {
					if(sentencia.charAt(i+2)=='(') {
						aux =1;
						iniCondicion=i+3;
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
				if(sentencia.charAt(i+2)=='t'){
					if(sentencia.charAt(i+3)=='h'){
						if(sentencia.charAt(i+4)=='e'){
							if(sentencia.charAt(i+5)=='n'){
								finCondicion=i-1;
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
				else {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean parseCondicion(String condicion) {//falta condicionarlo con un numero
		for(int i=0; i<condicion.length(); i++){
			if(condicion.charAt(i)=='<' || condicion.charAt(i)=='>' || (condicion.charAt(i)=='=' && condicion.charAt(i+1)=='=') || condicion.charAt(i)=='!') {
				if(!existeVariable(condicion.substring(0,i-1))) {
					return false;
				}
				if(condicion.charAt(i+1)=='=') {
					if(!existeVariable(condicion.substring(i+3,condicion.length()))) {
						return false;
					}
				}
				else {
					if(!existeVariable(condicion.substring(i+2,condicion.length()))) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public boolean existeVariable(String variable) {
		for(int i=0; i<Tarea2_Malf.variables.size(); i++) {
			if(Tarea2_Malf.variables.get(i).equals(variable)) {
				return true;
			}
		}
		return false;
	}
	
}
