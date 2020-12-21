package tarea2_malf;

public class Parser {

	public boolean parseSentencias(String sentencias) {//sentencia; sentenciaPrima
		int aux=0;
		for(int i=0; i<sentencias.length(); i++) {
			if(sentencias.charAt(i)==';') {
				aux = i;
				break;
			}
		}
		String sentencia1 = sentencias.substring(0,aux);
		String sentencia2 = sentencias.substring(aux+1, sentencias.length());
		if(parseSentencia(sentencia1) && parseSentenciaPrima(sentencia2)) {
			return true;
		}
		return false;
	}
	public boolean parseSentenciaPrima(String sentencia) {//sentencias | e
		if(parseSentencias(sentencia)||parseVacio(sentencia)){
			return true;
		}
		return false;
	}
	public boolean parseSentencia(String sentencia) {
		if (parseExpresion(sentencia) || parseAsignacion(sentencia) || parseWhile(sentencia) || parseIf(sentencia) || parseVacio(sentencia)) {
			return true;
		}
		return false;
		
	}
	private boolean parseExpresion(String sentencia) {//T E_Prima | e
		String partes [] = sentencia.split(" ");
		if((parseT(partes[0]) && parseEp(sentencia.substring(partes[0].length(), sentencia.length()))) || parseVacio(sentencia)) {
			return true;
		}
		return false;
	}
	private boolean parseAsignacion(String sentencia) {//Variable = Expresion
		String partes [] = sentencia.split(" ");
		if(parseVariable(partes[0]) && partes[1]=="=" && parseExpresion(partes[2])) {
			return true;
		}
		return false;
	}
	private boolean parseVacio(String sentencia) {
		if (sentencia.length()!=0) {
			return false;
		}
		return true;
	}
	
	public boolean parseEp(String sentencia) {//+T E_Prima | -T E_Prima | e

            if(sentencia.charAt(0) == '+'){
                parseT(Character.toString(sentencia.charAt(1)));
                String E_prima = " ";
                for (int i = 2; i < sentencia.length()-1; i++) {
                    E_prima += sentencia.charAt(i);
                    
                }
                return parseEp(E_prima);
                
                
            }
            else if(sentencia.charAt(0) == '-'){
                parseT(Character.toString(sentencia.charAt(1)));
                String E_prima = " ";
                for (int i = 2; i < sentencia.length()-1; i++) {
                    E_prima += sentencia.charAt(i);
                    
                }
                return parseEp(E_prima);
            }
            
            return false;
	}
	
	public boolean parseT(String sentencia) {// F Tprima             /////PROBLEMAAAAAAAS
		if(parseF(Character.toString(sentencia.charAt(1))) && parseTp(sentencia.substring(1,sentencia.length()))){
                    return true;
                }
		return false;
	}
	public boolean parseTp(String sentencia) {// * F T_Prima | / F T_Prima | % F T_Prima | e /////PROBLEMAAAAAAAS
		
                if(sentencia.charAt(0) == '*'){
                    parseT(Character.toString(sentencia.charAt(1)));
                    String E_prima = " ";
                    for (int i = 2; i < sentencia.length()-1; i++) {
                        E_prima += sentencia.charAt(i);
                    
                    }
                return parseTp(E_prima);
                }
                else if(sentencia.charAt(0) == '/'){
                    parseT(Character.toString(sentencia.charAt(1)));
                    String E_prima = " ";
                    for (int i = 2; i < sentencia.length()-1; i++) {
                        E_prima += sentencia.charAt(i);
                    
                    }
                return parseTp(E_prima);
                }
                else if(sentencia.charAt(0) == '%'){
                    parseT(Character.toString(sentencia.charAt(1)));
                    String E_prima = " ";
                    for (int i = 2; i < sentencia.length()-1; i++) {
                        E_prima += sentencia.charAt(i);
                    
                }
                return parseTp(E_prima);
            }
            
            return false;
	}
	public boolean parseF(String sentencia) {// Numero | Variable | e
		if(parseNumero(sentencia) || parseVariable(sentencia) || parseVacio(sentencia)) {
			System.out.println("ParseF");
			return true;
		}
		return false;
	}
	public boolean parseVariable(String sentencia) {// $Var
		System.out.println("Inicio ParseVariable "+sentencia);
		if(sentencia.charAt(0)=='$' && parseVar(sentencia.substring(1,sentencia.length()))) {
			System.out.println("ParseVariable");
			return true;
		}
		return false;
	}
	public boolean parseVar(String sentencia) {// C Var | e
		System.out.println("IniParseVar"+sentencia);
		String partes [] = sentencia.split(" ");
		if(  (parseC(partes[0]) && (partes[1].length()==0 || parseVar(sentencia.substring(partes[0].length(), sentencia.length()))) || parseVacio(sentencia)) ) {
			System.out.println("ParseVar");
			return true;
		}
		return false;
	}
	public boolean parseC(String sentencia) {// a...z | A...Z  | CARACT | e
		if((sentencia.charAt(0)>'a'&& sentencia.charAt(0)<'z')
				|| (sentencia.charAt(0)>'A'&&sentencia.charAt(0)<'Z')
				|| parseCaracter(sentencia.charAt(0)) || parseVacio(sentencia)) {
			System.out.println("ParseC");
			return true;
			
		}
		return false;
	}
	public boolean parseNumero(String sentencia) {//D Nprima
		if(parseD(sentencia.substring(0,1)) && parseNprima(sentencia.substring(1,sentencia.length()))) {
			System.out.println("ParseNumero");
			return true;
		}
		return false;
	}
	//////limite- 

	public boolean parseD(String sentencia) {//0...9 || e
		if(sentencia.charAt(0)>='0' && sentencia.charAt(0)<='9') {
			System.out.println("ParseD");
			return true;
		}
		return false;
	}
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
