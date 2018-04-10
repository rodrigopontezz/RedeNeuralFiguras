import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		List<Figura> listaFiguras;
		List<Forma> listaFormas = new ArrayList<Forma>();;
		List<Cor> listaCores = new ArrayList<Cor>();;
		List<Neuronio> listaNeuronios;
		Estimulo estimulos;
		
		listaFiguras = criarFiguras(listaFormas,listaCores);
		
		//int [] palpite;
	}
	
	
	public static List<Figura> criarFiguras(List<Forma> listaFormas, List<Cor> listaCores) {
		List<Figura> listaFiguras = new ArrayList<Figura>();
		
		//while(!EOF) {
			Figura figura = new Figura();
			
			/*LEITURA DA FIGURA NO ARQUIVO*/
			
			String nomeForma = "";
			String nomeCor = "";
			char [][] matriz;
			//nomeForma = readNomeForma;
			//nomeCor = readNomeCor;
			//matriz = readMatrizFromFile
		
			
			/* VERIFICANDO SE A FORMA É REPETIDA */
			
			//foreach(listaFormas) {
				int i = 0;
				if(listaFormas.get(i).getNome() == nomeForma) {
					figura.setForma(listaFormas.get(i));
					//break;
				}
			//}
			
			/* CASO SEJA UMA NOVA FORMA, CRIA NOVO OBJETO */
			
			if(figura.getForma() == null) {
				Forma forma = new Forma();
				forma.setNome(nomeForma);
				//forma.setMatriz(matriz);
				listaFormas.add(forma);
				figura.setForma(forma);
			}
			
			/* VERIFICA SE A COR É REPETIDA */
						
			//foreach(listaCores) {
				//i
				if(listaCores.get(i).getNome() == nomeCor) {
					figura.setCor(listaCores.get(i));
					//break;
				}
			//}
					
			/* CASO SEJA UMA NOVA COR, CRIA NOVO OBJETO */
					
			if(figura.getCor() == null) {
				Cor cor = new Cor();
				cor.setNome(nomeCor);
				listaCores.add(cor);
				figura.setCor(cor);
			}
				
			listaFiguras.add(figura);
		//}

		return listaFiguras;
	}
	
	public static void gerarTargetsParciais(List<Forma> listaFormas, List<Cor> listaCores) {
		//TO-DO
	}
	
	public static List<Neuronio> criarNeuronios() {
		List<Neuronio> listaNeuronios = new ArrayList<Neuronio>();
		
		//TO-DO
		
		return listaNeuronios;
	}
	
	public static String palpitesToString(int [] palpites) {
		StringBuilder palpite = new StringBuilder();
		
		//TO-DO
		
		return palpite.toString();
	}
	
	public static boolean checarErro() {
		//TO-DO
		
		return false;
	}
}


	
	//MSE:  Em = (1/2 *(yi * ti)²)/Somatorio(n)
	
	/*final int quantidadeNeuronios = 10;   //quantidade de formas + quantidade de cores
	final int quantidadeEstimulos = 3;
	final int tamanhoDataset = 4;
	
	
	
	Forma f1 = new Forma("000000000");
	
	Float[][] estimulos = {{1f, 0f, 0f}, //3 estimulos, o primeiro sendo o bias
		        {1f, 0f, 1f},
		        {1f, 1f, 0f},
		        {1f, 1f, 1f}};

    Float[][] pesos = new Float[quantidadeEstimulos][quantidadeNeuronios];

    for (int i = 0; i < quantidadeEstimulos; i++) {
        for (int j = 0; j < quantidadeNeuronios; j++) {
            pesos[i][j] = 1f;
        }
    }

    String matriz = "";
    Float taxaAprendizado = 0.5f, y;
    Float[] somatorio = new Float[10];
    for (int i = 0; i < quantidadeNeuronios; i++) {
        somatorio[i] = 0f;
    }
    boolean erro = true;

    //Loop para identificar erro
    while (erro) {
        erro = false;

        for (int i = 0; i < tamanhoDataset; i++) {
            for (int j = 0; j < quantidadeEstimulos; j++) {
                
            	//Loop para identificar o resultado de cada neurônio após receber um estímulo
            	for (int k = 0; k < quantidadeNeuronios; k++) {
                    somatorio[k] += estimulos[i][j] * pesos[j][k];
                }
                
            	//Função degrau para arredondar os resultados obtidos para 0 ou 1
                for (int k = 0; k < quantidadeNeuronios; k++) {
                    if (somatorio[k] > 0) {
                        somatorio[k] = 1f;
                    } else {
                        somatorio[k] = 0f;
                    }
                }
                
                Integer auxiliar;

                for (int k = 0; k < quantidadeNeuronios; k++) {
                    auxiliar = somatorio[k].intValue();
                    matriz +=  auxiliar.toString();
                }
                System.out.println(matriz);
            }

            //if (matriz.equals)   CONTINUAR
        }

    }*/