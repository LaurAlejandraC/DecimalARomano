public class pruebas{
	public static void main(String [] args){
		decimalARomano conversion = new decimalARomano();

		//Primera prueba
		String str1 = new String("MDLXXXVIII");
		String str2 = conversion.numeroDecimalARomano(1588);
		System.out.println((str1.equals(str2))?"Primera prueba correcta":"Primera prueba incorrecta");

		str1 = new String("ĪṼ");
		str2 = conversion.numeroDecimalARomano(4000);
		System.out.println((str1.equals(str2))?"Segunda prueba correcta":"Segunda prueba incorrecta");

		str1 = new String("ẊẊĪẊ");
		str2 = conversion.numeroDecimalARomano(29000);
		System.out.println((str1.equals(str2))?"Tercera prueba correcta":"Tercera prueba incorrecta");

		str1 = new String("XV");
		str2 = conversion.numeroDecimalARomano(15);
		System.out.println((str1.equals(str2))?"Cuarta prueba correcta":"Cuarta prueba incorrecta");

		str1 = new String("ḾḾḾĎḸẊẊẊMMDLXXXVIII");
		str2 = conversion.numeroDecimalARomano(3582588);
		System.out.println((str1.equals(str2))?"Quinta prueba correcta":"Quinta prueba incorrecta");

		str1 = new String("El número máximo es 3999999");
		str2 = conversion.numeroDecimalARomano(4000000);
		System.out.println((str1.equals(str2))?"Sexta prueba correcta":"Sexta prueba incorrecta");
	}
}