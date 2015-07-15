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
			resultadoDigitos[nDigitos - 1] = numeroDecimal%10;
			numeroDecimal /= 10; 
		}
		return resultadoDigitos;
	}

	public String numeroDecimalARomano(int numeroDecimal){
		int nDigitos = numeroDigitos(numeroDecimal);
		do{
			int[] digitos = digitos(numeroDecimal);
			if ( numeroDecimal >= 3999)
				numeroDecimal = numeroRomanoBarra(numeroDecimal, digitos);
			else
				numeroDecimal = numeroRomano(numeroDecimal, digitos);
		}while (numeroDecimal != 0);
		return resultado;
	}

	public int numeroRomanoBarra(int numeroDecimal, int[] digitos){
		int nDigitos = numeroDigitos(numeroDecimal);
		nDigitos -= 4;
		if( digitos[0] >= 5 && digitos[0] != 9){
			switch(nDigitos){
				case 0: resultado += 'Ṽ';
						numeroDecimal -= 5000;
						break;
				case 1: resultado += 'Ḹ';
						numeroDecimal -= 50000;
						break;
				case 2: resultado += 'Ď';
						numeroDecimal -= 500000;
						break;
			}
		}else if(digitos[0] != 4 && digitos[0] != 9){
			switch(nDigitos){
				case 0: resultado += 'Ī';
						numeroDecimal -= 1000;
						break;
				case 1: resultado += 'Ẋ';
						numeroDecimal -= 10000;
						break;
				case 2: resultado += 'Č';
						numeroDecimal -= 100000;
						break;
				case 3: resultado += 'Ḿ';
						numeroDecimal -= 1000000;
						break;
			}
		}else if(digitos[0] == 4){
			//insertar switch
		}else{
			//caso del 9, insertar switch
		}
		return numeroDecimal;
	}

	public int numeroRomano(int numeroDecimal, int[] digitos){
		return numeroDecimal;
	}
}