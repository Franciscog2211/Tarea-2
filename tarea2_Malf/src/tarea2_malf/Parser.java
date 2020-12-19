package tarea2_malf;

public class Parser {
	
	public boolean parseSentencia(String sentencia) {
		if (!parseE(sentencia) || !parseWhile(sentencia) || !parseIf(sentencia)) {
			return false;
		}
		return true;
		
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
		System.out.println("A" +sentencia);
		for(int i=0; i<sentencia.length(); i++) {
			if(sentencia.charAt(i)=='w') {
				if(sentencia.charAt(i+1)=='h') {
					if(sentencia.charAt(i+2)=='i') {
						if(sentencia.charAt(i+3)=='l') {
							if(sentencia.charAt(i+4)=='e') {
								if(sentencia.charAt(i+6)=='(') {
									System.out.print("While");
									aux =1;
									iniCondicion=i+7;
									System.out.println("INI CONDICION: "+iniCondicion);
									i=i+2;
								}
							}
						}
						
						System.out.println(" (");
						
					}
					else {
						System.out.println(" ( False");
						return false;
					}
				}
				else {
					return false;
				}
			}
			if(sentencia.charAt(i)==')') {
				//parseamos condicion entre "( )"
				System.out.println("CONDICIONAZO: "+sentencia.substring(iniCondicion, i));
				if(!parseCondicion2(sentencia.substring(iniCondicion, i))){
					return false;
				}
				System.out.println(" )");
				if(sentencia.charAt(i+2)=='d'){
					System.out.println(" t");
					if(sentencia.charAt(i+3)=='o'){
						System.out.println("DO");
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
		System.out.println("A" +sentencia);
		for(int i=0; i<sentencia.length(); i++) {
			if(sentencia.charAt(i)=='i') {
				System.out.println("i - "+i);
				if(sentencia.charAt(i+1)=='f') {
					System.out.println("f");
					if(sentencia.charAt(i+3)=='(') {
						System.out.println(" (");
						aux =1;
						iniCondicion=i+4;
						System.out.println("INI CONDICION: "+iniCondicion);
						i=i+2;
					}
					else {
						System.out.println(" ( False");
						return false;
					}
				}
				else {
					return false;
				}
			}
			if(sentencia.charAt(i)==')') {
				//parseamos condicion entre "( )"
				System.out.println("CONDICIONAZO: "+sentencia.substring(iniCondicion, i));
				if(!parseCondicion2(sentencia.substring(iniCondicion, i))){
					return false;
				}
				System.out.println(" )");
				if(sentencia.charAt(i+2)=='t'){
					System.out.println(" t");
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
	
	
	public boolean parseCondicion2(String condicion) {//falta condicionarlo con un numero
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
	public boolean existeVariable(String variable) {
		for(int i=0; i<Tarea2_Malf.variables.size(); i++) {
			if(Tarea2_Malf.variables.get(i).equals(variable)) {
				return true;
			}
		}
		return false;
	}
	
}
