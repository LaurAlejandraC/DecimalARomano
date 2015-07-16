import java.util.Arrays;

public class decimalARomano{

	String resultado = new String("");

	public int numeroDigitos(int numeroDecimal){
		int resultadoNDigitos = 0;
		do{
			numeroDecimal /= 10;
			resultadoNDigitos++; 
		}while(numeroDecimal != 0);
		return resultadoNDigitos;
	}

	public int[] digitos(int numeroDecimal){
		int[] resultadoDigitos;
		int nDigitos = numeroDigitos(numeroDecimal);
		resultadoDigitos = new int[nDigitos];
		for(int i = 0; i < nDigitos; i++){
			resultadoDigitos[i] = numeroDecimal%10;
			numeroDecimal /= 10; 
		}
		return resultadoDigitos;
	}

	public String numeroDecimalARomano(int numeroDecimal){
		if ( numeroDecimal > 3999999 )
			return new String( "El número máximo es 3999999");
		resultado = "";
		int nDigitos;
		int[] digitos;
		do{
			nDigitos = numeroDigitos(numeroDecimal);
			digitos = digitos(numeroDecimal);
			if ( numeroDecimal >= 3999)
				numeroDecimal = numeroRomanoBarra(numeroDecimal, digitos);
			else
				numeroDecimal = numeroRomano(numeroDecimal, digitos);
		}while (numeroDecimal != 0);
		return resultado;
	}

	public int numeroRomanoBarra(int numeroDecimal, int[] digitos){
		int nDigitos = numeroDigitos(numeroDecimal);
		/* Primer caso: el primer digito del número es mayor que 5 pero diferente de nuevo, en cuyo caso tendremos el símbolo que representa 
			5000, 50000 o 500000 dependiendo de cuál sea la cantidad de dígitos que tenga el número */
		if( digitos[nDigitos - 1] >= 5 && digitos[nDigitos - 1] != 9 ){
			switch(nDigitos){
				case 4: resultado += 'Ṽ';
						numeroDecimal -= 5000;
						break;
				case 5: resultado += 'Ḹ';
						numeroDecimal -= 50000;
						break;
				case 6: resultado += 'Ď';
						numeroDecimal -= 500000;
						break;
			}
		}
		/* Segundo caso: el primer digito del número es menor que 5 pero diferente de 4 y de 0, en cuyo caso se añadirá el símbolo que representa
			 1000, 10000, 100000 o 1000000*/
		else if( digitos[nDigitos - 1] < 5 && digitos[nDigitos - 1] != 4 && digitos[nDigitos - 1] != 0 ){
			switch(nDigitos){
				case 4: resultado += 'Ī';
						numeroDecimal -= 1000;
						break;
				case 5: resultado += 'Ẋ';
						numeroDecimal -= 10000;
						break;
				case 6: resultado += 'Č';
						numeroDecimal -= 100000;
						break;
				case 7: resultado += 'Ḿ';
						numeroDecimal -= 1000000;
						break;
			}
		}
		/* Tercer caso: el primer digito del número es 4, en cuyo caso se añadirá el símbolo que representa 4000, 40000 o 400000*/
		else if( digitos[nDigitos - 1] == 4 ){
			switch(nDigitos){
				case 4: resultado = resultado.concat("ĪṼ");
						numeroDecimal -= 4000;
						break;
				case 5: resultado = resultado.concat("ẊḸ");
						numeroDecimal -= 40000;
						break;
				case 6: resultado = resultado.concat("ČĎ");
						numeroDecimal -= 400000;
						break;
			}
		}
		/* Cuarto caso: el primer digito del número es 9, en cuyo caso se añadirá el símbolo que representa 9000, 90000 o 900000*/
		else if( digitos[nDigitos - 1] == 9 ){
			switch(nDigitos){
				case 4: resultado = resultado.concat("ĪẊ");
						numeroDecimal -= 9000;
						break;
				case 5: resultado = resultado.concat("ẊČ");
						numeroDecimal -= 90000;
						break;
				case 6: resultado = resultado.concat("ČḾ");
						numeroDecimal -= 900000;
						break;
			}
		}
		return numeroDecimal;
	}

	public int numeroRomano(int numeroDecimal, int[] digitos){
		int nDigitos = numeroDigitos(numeroDecimal);
		/* Primer caso: el primer digito del número es un número mayor que 5 pero diferente de 9, se añadirá el símbolo que representa
			5, 50 o 500*/
		if ( digitos[nDigitos - 1] >= 5 && digitos[nDigitos - 1] != 9 ){
			switch( nDigitos ){
				case 1: resultado += 'V';
						numeroDecimal -= 5;
						break;
				case 2: resultado += 'L';
						numeroDecimal -= 50;
						break;
				case 3: resultado += 'D';
						numeroDecimal -= 500;
						break;
			}
		}
		/* Segundo caso: el primer digito es un número menor de 5, diferente de 4 y 0, se añadirá el símbolo que representa 1, 10, 100 o 1000*/ 
		else if ( digitos[nDigitos - 1] < 5 && digitos[nDigitos - 1] != 4 && digitos[nDigitos - 1] != 0 ){
			switch(nDigitos){
				case 1: resultado += 'I';
						numeroDecimal -= 1;
						break;
				case 2: resultado += 'X';
						numeroDecimal -= 10;
						break;
				case 3: resultado += 'C';
						numeroDecimal -= 100;
						break;
				case 4: resultado += 'M';
						numeroDecimal -= 1000;
						break;
			}
		}
		/* Tercer caso: el primer digito del número es 4, en cuyo caso se añade el símbolo que representa 4, 40 o 400 */
		else if ( digitos[nDigitos - 1] == 4 ) {
			switch(nDigitos){
				case 1: resultado = resultado.concat("IV");
						numeroDecimal -= 4;
						break;
				case 2: resultado = resultado.concat("XL");
						numeroDecimal -= 40;
						break;
				case 3: resultado = resultado.concat("CD");
						numeroDecimal -= 400;
						break;
			}
		}
		/* Tercer digito: el primer digito del número es 9, en cuyo caso se añade el símbolo que representa 9, 90 o 900*/
		else if( digitos[nDigitos - 1] == 9 ){
			switch(nDigitos){
				case 1: resultado = resultado.concat("IX");
						numeroDecimal -= 9;
						break;
				case 2: resultado = resultado.concat("XC");
						numeroDecimal -= 90;
						break;
				case 3: resultado = resultado.concat("CM");
						numeroDecimal -= 900;
						break;
			}
		}
		return numeroDecimal;
	}
}