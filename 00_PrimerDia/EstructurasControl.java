class EstructurasControl{
	
	public static void main(String args[]){
		int cont = 0;
		while(cont < 5){
			System.out.println("Contador while = " + cont);
			cont++;
		}
		
		{
			System.out.println("Esta es una variable con alcance de bloque");
			int varBloque = 1;
			System.out.println(varBloque);
		}
		
		
		
		for(int i = 0; i < 5; i++){
			System.out.println("Contador for = " + i);
		}
		System.out.println(i);
	}
	
}