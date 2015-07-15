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
		resultadoDigitos = new int[nDigitos-1];
		for(int i = 0; i < nDigitos; i++){
			resultadoDigitos[nDigitos - 1] = numeroDecimal%10;
			numeroDecimal /= 10; 
		}
		return resultadoDigitos;
	}

	public String numeroDecimalARomano(int numeroDecimal){
		int nDigitos = numeroDigitos(numeroDecimal);
		do{
			if ( numeroDecimal >= 3999)
				numeroDecimal = numeroRomanoBarra(numeroDecimal);
			else
				numeroDecimal = numeroRomano(numeroDecimal);
			return resultado;
		}while (numeroDecimal != 0);
	}

	public int numeroRomanoBarra(int numeroDecimal){
		return numeroDecimal;
	}

	public int numeroRomano(int numeroDecimal){
		return numeroDecimal;
	}
}