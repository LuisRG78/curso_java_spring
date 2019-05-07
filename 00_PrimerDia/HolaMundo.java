class HolaMundo{
	
	public static void main(String args[]){
		System.out.println("Hola Mundo");
		
		for (int i = 0; i < args.length; i++){
			System.out.println("Arg " + i + " = " +args[i]);
		}
		System.out.println("Numero de argumentos: " + args.length);
		
		int entero = 20;
		float decimal = 1234567890123456789f;
		double doblePrecision = 1234567890123456789D;
		long enteroLargo = 1234567890123456789L;
		byte unByte = -128;
		String texto = "Hola caracola";
		char caracter = 'Z';
		
		System.out.println("entero = " + entero);
		System.out.println("decimal = " + decimal);
		System.out.println("double = " + doblePrecision);
		System.out.println("enteroLargo = " + enteroLargo);
		System.out.println("texto = " + texto);
		System.out.println("caracter = " + caracter);
		
		
	}
	
}

	
	