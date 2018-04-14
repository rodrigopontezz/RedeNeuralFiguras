import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
	
	static final int LINHAS_MATRIZ = 5;
	static final int COLUNAS_MATRIZ = 5;
	
	public static void main(String[] args) {
		try {
			/* CRIAÇÃO DE FORMAS, CORES E FIGURAS*/

			List<Forma> listaFormas = new ArrayList<Forma>();;
			List<Cor> listaCores = new ArrayList<Cor>();
			List<Figura> listaFiguras = criarFiguras(listaFormas,listaCores);

			//lerFormasDoArquivo(listaFormas);
			//lerCoresDoArquivo(listaCores);
			//gerarFormasECores(listaFormas,listaCores);
			
			/* GERANDO VETOR DE TARGETS PARA FORMAS E CORES, E CONCATENA TARGETS NA LISTA FIGURAS */
			
			gerarTargets(listaFormas, listaCores, listaFiguras);
			
			/* GERANDO AS MATRIZES DE ESTÍMULOS */
			
			Estimulo estimuloFormas = new Estimulo(Forma.getTotalFormas());
			Estimulo estimuloCores = new Estimulo(Cor.getTotalCores());
			
			/* CRIAÇÃO DA LISTA DE FORMAS E CORES AUXILIAR */
			
			List<Treinavel> lFormas = new ArrayList<>();
			List<Treinavel> lCores = new ArrayList<>();
			
			criarListasAuxiliares(listaFormas,listaCores,lFormas,lCores);
			
			/* CRIAÇÃO DOS NEURÔNIOS */
			
			List<Neuronio> listaNeuroniosForma = new ArrayList<>();
			List<Neuronio> listaNeuroniosCor = new ArrayList<>();
			
			criarNeuronios(estimuloFormas, estimuloCores, lFormas, lCores, listaNeuroniosForma, listaNeuroniosCor);
			
			/* LOOP PARA TREINAMENTO DA REDE NEURAL */
			
			int epoca = 0;
			boolean erro = true;
			
			while (erro) {
				erro = false;
				
				/* TREINANDO RECONHECIMENTO DE FORMAS */
				for (int i = 0; i < Forma.getTotalFormas(); i++) {					//Percorre o dataset
					for (int j = 0; j < listaNeuroniosForma.size(); j++) {			//Percorre os neurônios
						if (listaNeuroniosForma.get(j).aplicarEstimulos(estimuloFormas.getVetorEstimulo(i), i) == true || erro == true) {
							erro = true;
						}
					}
				}
				
				/* TREINANDO RECONHECIMENTO DE CORES */
				
				for (int i = 0; i < Cor.getTotalCores(); i++) {						//Percorre o dataset
					for (int j = 0; j < listaNeuroniosCor.size(); j++) {			//Percorre os neurônios
						if (listaNeuroniosCor.get(j).aplicarEstimulos(estimuloCores.getVetorEstimulo(i), i) == true || erro == true) {
							erro = true;
						}
					}
				}

				System.out.println("Época " + ++epoca);
				System.out.println();
				
				System.out.println("");
				System.out.println("Total de Neurônios p/ Forma: " + listaNeuroniosForma.size());
				System.out.println("");
				System.out.println("LISTA DE NEURÔNIOS");
				System.out.println("");
				int i = 1;
				for(Neuronio neuronio : listaNeuroniosForma) {
					System.out.println("Neurônio " + i++);
					System.out.println("");
					System.out.print("Vetor de pesos: ");
					for(int j = 0; j < estimuloFormas.getQuantidadeEstimulos(); j++) {
						System.out.printf("%.2f ", neuronio.getPesoAt(j));
					}
					System.out.println("");
					System.out.println("");
				}
				
				System.out.println("-------------------------------------");
				System.out.println("");
				System.out.println("Total de Neurônios p/ Cor: " + listaNeuroniosCor.size());
				System.out.println("");
				System.out.println("LISTA DE NEURÔNIOS");
				System.out.println("");
				i = 1;
				for(Neuronio neuronio : listaNeuroniosCor) {
					System.out.println("Neurônio " + i++);
					System.out.println("");
					System.out.print("Vetor de pesos: ");
					for(int j = 0; j < estimuloCores.getQuantidadeEstimulos(); j++) {
						System.out.printf("%.2f ", neuronio.getPesoAt(j));
					}
					System.out.println("");
					System.out.println("");
				}
				System.out.println("______________________________________________________________");
				System.out.println("______________________________________________________________");
				System.out.println("______________________________________________________________");
				System.out.println();
				
				/*int k = 1;
				for(Neuronio neuronio : listaNeuroniosForma) {
					System.out.println("Neurônio " + k++);
					System.out.println("");
					System.out.print("Palpite: ");
					for(int n = 0; n < Forma.getTotalFormas(); n++) {
						System.out.print(neuronio.getPalpiteAt(n) + " ");
					}
									
					System.out.println("");
					System.out.print("Target:  ");
					for(int n = 0; n < Forma.getTotalFormas(); n++) {
						System.out.print(neuronio.getTargetAt(n) + " ");
					}
					
					System.out.println("");
					System.out.println("");
				}
				System.out.println("___________________________________________");
				System.out.println("");
		
				k = 1;
				for(Neuronio neuronio : listaNeuroniosCor) {
					System.out.println("Neurônio " + k++);
					System.out.println("");
					System.out.print("Palpite: ");
					for(int n = 0; n < Cor.getTotalCores(); n++) {
						System.out.print(neuronio.getPalpiteAt(n) + " ");
					}
									
					System.out.println("");
					System.out.print("Target:  ");
					for(int n = 0; n < Cor.getTotalCores(); n++) {
						System.out.print(neuronio.getTargetAt(n) + " ");
					}
					
					System.out.println("");
					System.out.println("");
				}
				System.out.println("___________________________________________");
				System.out.println("");*/

				
				
				if (epoca > 1000) {
					System.out.println("Quantidade de épocas muito alta!");
					System.out.println("Algum neurônio está repetindo um vetor de palpites errado.");
					break;
				}
			}
			

			/* PRINTANDO AS VARIÁVEIS PARA CONFERÊNCIA */
			
			/*System.out.println("LISTA DE FORMAS");
			System.out.println("");
			for(Forma forma : listaFormas) {
				System.out.println("Forma: " + forma.getNome());
				System.out.println("Target da forma: " + forma.getTarget());
				System.out.println("");
			}

			System.out.println("Total de Formas: " + Forma.getTotalFormas());
			System.out.println("");
			System.out.println("");
			
			System.out.println("LISTA DE CORES");
			System.out.println("");
			for(Cor cor : listaCores) {
				System.out.println("Cor: " + cor.getNome());
				System.out.println("Target da cor: " + cor.getTarget());
				System.out.println("");
			}
			
			System.out.println("Total de Cores: " + Cor.getTotalCores());
			System.out.println("");
			System.out.println("");
			
			System.out.println("LISTA DE FIGURAS");
			System.out.println("");
			for(Figura figura : listaFiguras) {
				System.out.println("Figura: " + figura.getForma().getNome() + " " + figura.getCor().getNome());
				System.out.println("Target da figura: " + figura.getTarget());
				System.out.println("");
			}
			
			System.out.println("Total de Figuras: " + Figura.getTotalFiguras());
			
			System.out.println("");
			System.out.println("");
			System.out.println("Total de estímulos p/ Forma (incluindo bias): " + estimuloFormas.getQuantidadeEstimulos());
			System.out.println("");
			System.out.println("MATRIZ DE ESTÍMULOS");
			System.out.println("");
			for (int i = 0; i < Forma.getTotalFormas(); i++) {
				
				double [] vetorEstimulos = estimuloFormas.getVetorEstimulo(i);
				
				for (int j = 0; j < estimuloFormas.getQuantidadeEstimulos(); j++) {
					System.out.print((int) vetorEstimulos[j] + " ");
				}
				System.out.println("");
			}
			
			System.out.println("");
			System.out.println("Total de estímulos p/ Cor (incluindo bias): " + estimuloCores.getQuantidadeEstimulos());
			System.out.println("");
			System.out.println("MATRIZ DE ESTÍMULOS");
			System.out.println("");
			for (int i = 0; i < Cor.getTotalCores(); i++) {
				
				double [] vetorEstimulos = estimuloCores.getVetorEstimulo(i);
				
				for (int j = 0; j < estimuloCores.getQuantidadeEstimulos(); j++) {
					System.out.print((int) vetorEstimulos[j] + " ");
				}
				System.out.println("");
			}
			System.out.println("_____________________________");
			System.out.println("");
			System.out.println("Total de Neurônios p/ Forma: " + listaNeuroniosForma.size());
			System.out.println("");
			System.out.println("LISTA DE NEURÔNIOS");
			System.out.println("");
			int i = 1;
			for(Neuronio neuronio : listaNeuroniosForma) {
				System.out.println("Neurônio " + i++);
				System.out.println("");
				System.out.print("Vetor de pesos: ");
				for(int j = 0; j < estimuloFormas.getQuantidadeEstimulos(); j++) {
					System.out.printf("%.2f ", neuronio.getPesoAt(j));
				}
				System.out.println("");
				System.out.println("");
			}
			
			System.out.println("_____________________________");
			System.out.println("");
			System.out.println("Total de Neurônios p/ Cor: " + listaNeuroniosCor.size());
			System.out.println("");
			System.out.println("LISTA DE NEURÔNIOS");
			System.out.println("");
			i = 1;
			for(Neuronio neuronio : listaNeuroniosCor) {
				System.out.println("Neurônio " + i++);
				System.out.println("");
				System.out.print("Vetor de pesos: ");
				for(int j = 0; j < estimuloCores.getQuantidadeEstimulos(); j++) {
					System.out.printf("%.2f ", neuronio.getPesoAt(j));
				}
				System.out.println("");
				System.out.println("");
			}*/
			
			
			
		} catch (IOException ex) {
			System.out.println("Não foi possível abrir o arquivo figuras.txt.");
			ex.printStackTrace();
		}
	}

	
	public static List<Figura> criarFiguras(List<Forma> listaFormas, List<Cor> listaCores) throws IOException {
		List<Figura> listaFiguras = new ArrayList<Figura>();
		File file = new File(".\\src\\figuras.txt");		
		BufferedReader br = new BufferedReader(new FileReader(file));
					
		String line = null;
		while((line = br.readLine()) != null) {
			Figura figura = new Figura();
			
			/*LEITURA DA FIGURA NO ARQUIVO*/
			
			String nomeForma = line;
			String nomeCor = br.readLine();
			
			/* VERIFICANDO SE A FORMA É REPETIDA */
			
			for(Forma forma : listaFormas) {
				if(forma.getNome().equals(nomeForma)) {
					figura.setForma(forma);
					break;
				}
			}
			
			/* CASO SEJA UMA NOVA FORMA, CRIA NOVO OBJETO */
			
			if(figura.getForma() == null) {
				
				/* POPULANDO A MATRIZ DE CARACTERES */
				
				char [][] matriz = new char[LINHAS_MATRIZ][COLUNAS_MATRIZ];
				for(int i = 0; i < LINHAS_MATRIZ; i++) {
					line = br.readLine();
					for(int j = 0; j < line.length(); j++) {
						matriz[i][j] = line.charAt(j);
					}					
				}
														
				Forma forma = new Forma();
				forma.setNome(nomeForma);
				forma.setMatriz(matriz);
				listaFormas.add(forma);
				figura.setForma(forma);
			} else {
			
				/* CASO SEJA UMA FORMA EXISTENTE, APENAS PERCORRE A MATRIZ */
				
				for(int i = 0; i < LINHAS_MATRIZ; i++) {
					br.readLine();
				}
			}
			
			/* VERIFICA SE A COR É REPETIDA */
			
			for(Cor cor : listaCores) {
				if(cor.getNome().equals(nomeCor)) {
					figura.setCor(cor);
					break;
				}
			}
			
			/* CASO SEJA UMA NOVA COR, CRIA NOVO OBJETO */
			
			if(figura.getCor() == null) {
				Cor cor = new Cor();
				cor.setNome(nomeCor);
				listaCores.add(cor);
				figura.setCor(cor);
			}
			
			listaFiguras.add(figura);
			br.readLine();
		}
		
		br.close();	
		return listaFiguras;
	}
	
	public static void gerarTargets(List<Forma> listaFormas, List<Cor> listaCores, List<Figura> listaFiguras) {
			
		for (int i = 0; i < Forma.getTotalFormas(); i++) {
			listaFormas.get(i).setTargetForma(i);
		}
		
		for (int i = 0; i < Cor.getTotalCores(); i++) {
			listaCores.get(i).setTargetCor(i);
		}
		
		for(Figura figura : listaFiguras) {
			figura.calcularTarget();
		}
	}
	
	public static void criarListasAuxiliares(List<Forma> listaFormas, List<Cor> listaCores, List<Treinavel> lFormas, List<Treinavel> lCores) {
		for (Forma forma : listaFormas) {
			lFormas.add(forma);
		}
		
		for (Cor cor : listaCores) {
			lCores.add(cor);
		}
	}
	
	public static void criarNeuronios(Estimulo estimuloFormas, Estimulo estimuloCores, List<Treinavel> listaFormas, List<Treinavel> listaCores, List<Neuronio> listaNeuroniosForma, List<Neuronio> listaNeuroniosCor) {
		
		for (int i = 0; i < (Forma.getTotalFormas()); i++) {
			listaNeuroniosForma.add(new Neuronio(estimuloFormas.getQuantidadeEstimulos(), Forma.getTotalFormas(), listaFormas, i));
		}
		
		for (int i = 0; i < (Cor.getTotalCores()); i++) {
			listaNeuroniosCor.add(new Neuronio(estimuloCores.getQuantidadeEstimulos(), Cor.getTotalCores(), listaCores, i));
		}
	}
}


	//MSE:  Em = (1/2 *(yi * ti)²)/Somatorio(n)
