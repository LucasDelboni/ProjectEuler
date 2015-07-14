import java.util.ArrayList;
import java.util.List;


public class P50 {
	static List<Integer> primos = new ArrayList<Integer>();
	
	//recebe como parametro o numero maximo que pode chegar
	public static int resposta(int maximo){
		primosConsecutivos(maximo);
		
		//passa de lista para um arranjo de inteiros contendo os numeors primos cnsecutivos
		int aux=0;
		int[] numerosPrimos = new int[primos.size()];
		for(int i : primos){
			numerosPrimos[aux]=i;
			aux++;
		}
		
		
		int resposta = 0;
		int quantidadeResposta =0;
		for(int i=0;i<numerosPrimos.length;i++){
			int atual = 0;
			int quantidadeAtual=0;
			//somatoria de numeros primos consecutivos
			for(int j=i;j<numerosPrimos.length;j++){
				atual = atual +numerosPrimos[j];
				quantidadeAtual++;
				if(atual>maximo){
					break;
				}
				//checa se eh primo e se tem mais numeors primos do que a somatoria anterior
				if(ehPrimo(atual)==true && quantidadeAtual>quantidadeResposta ){
					quantidadeResposta=quantidadeAtual;
					resposta = atual;
				}
			}
		}
		System.out.println(resposta);
		return resposta;

		
	}
	
	//checa se o numero recebido como parametro eh primo
	static boolean ehPrimo(int numero){
		for( int i : primos){
			if(numero%i==0 && numero!=i){
				return false;
			}
		}
		return true;
	}
	
	//cria uma lista de numeros primos consecutivos
	public static void primosConsecutivos(int maximo){
		primos.add(2);
		int proximo = 3;
		
		while(proximo<=maximo){
			if(ehPrimo(proximo)==true){
				primos.add(proximo);
			}
			proximo++;
		}
	}
}
