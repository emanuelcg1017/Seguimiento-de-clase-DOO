package fraccionarios;

public class Operaciones {

	public static void main(String[] args) {
		int numeradorNumero1 = 5;
		int denominadorNumero1 = 6;
		int numeradorNumero2 = 7;
		int denominadorNumero2 = 8;
		
		System.out.println("tus numeros son "+ numeradorNumero1+"/"+denominadorNumero1 + " y "+ numeradorNumero2+"/"+denominadorNumero2);
		Suma(numeradorNumero1, denominadorNumero1,numeradorNumero2, denominadorNumero2);
		Resta(numeradorNumero1, denominadorNumero1,numeradorNumero2, denominadorNumero2);
		Multiplicacion(numeradorNumero1, denominadorNumero1,numeradorNumero2, denominadorNumero2);
		Division(numeradorNumero1, denominadorNumero1,numeradorNumero2, denominadorNumero2);

	}
	
	public static void Suma(int numeradorNumero1, int denominadorNumero1,int numeradorNumero2, int denominadorNumero2) {
        
		int resultadoNumerador = numeradorNumero1*denominadorNumero2 + numeradorNumero2*denominadorNumero1;
        int resultadoDenominador = denominadorNumero1*denominadorNumero2;
        System.out.println("la suma de tus fraccionarios es "+resultadoNumerador + "/" + resultadoDenominador);
	}
	
	public static void Resta(int numeradorNumero1, int denominadorNumero1,int numeradorNumero2, int denominadorNumero2) {
        
		int resultadoNumerador = numeradorNumero1*denominadorNumero2 - numeradorNumero2*denominadorNumero1;
        int resultadoDenominador = denominadorNumero1*denominadorNumero2;
        System.out.println("la resta de tus fraccionarios es "+resultadoNumerador + "/" + resultadoDenominador);
	}
	
	public static void Multiplicacion(int numeradorNumero1, int denominadorNumero1,int numeradorNumero2, int denominadorNumero2) {
        
		int resultadoNumerador = numeradorNumero1*numeradorNumero2;
        int resultadoDenominador = denominadorNumero1*denominadorNumero2;
        System.out.println("la multiplicacion de tus fraccionarios es "+resultadoNumerador + "/" + resultadoDenominador);
	}
	
	public static void Division(int numeradorNumero1, int denominadorNumero1,int numeradorNumero2, int denominadorNumero2) {
        
		int resultadoNumerador = numeradorNumero1*denominadorNumero2;
        int resultadoDenominador = numeradorNumero2*denominadorNumero1;
        System.out.println("la division de tus fraccionarios es "+resultadoNumerador + "/" + resultadoDenominador);
	}
}


