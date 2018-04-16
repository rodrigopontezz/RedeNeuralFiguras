package modelo;

/*   Aplicação para treinamento de Rede Neural Perceptron para identificação de
 *   formas e cores a partir de dataset textual.
 * 
 * 	 Alunos:		Rodrigo Pontes 	(Ciências da Computação)
 * 				Luana Quelhas 	(Ciências da Computação)
 * 				Diego Assis 	(Ciências da Computação)
 * 				Hiero Bartholo	(Ciências da Computação)
 * 
 *	 Disciplina:	Inteligência Artificial I
 * 
 *	 Professor:		Márcio Piva
 * 
 *	 @version 1.1
 * 	 GitHub: https://github.com/rodrigopontezz/RedeNeuralFiguras
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Treinamento {
	
	static final int LINHAS_MATRIZ = 5;
	static final int COLUNAS_MATRIZ = 5;
	
	public static void main(String[] args) {
		try {
			/* CRIA��O DE FORMAS, CORES E FIGURAS*/

			List<Forma> listaFormas = new ArrayList<Forma>();;
			List<Cor> listaCores = new ArrayList<Cor>();
			List<Figura> listaFiguras = criarFiguras(listaFormas,listaCores);
			
			/* GERANDO VETOR DE TARGETS PARA FORMAS E CORES, E CONCATENA TARGETS NA LISTA FIGURAS */
			
			gerarTargets(listaFormas, listaCores, listaFiguras);
			
			/* GERANDO AS MATRIZES DE EST�MULOS */
			
			Estimulo estimuloFormas = new Estimulo(Forma.getTotalFormas());
			Estimulo estimuloCores = new Estimulo(Cor.getTotalCores());
			
			/* CRIA��O DA LISTA DE FORMAS E CORES AUXILIAR */
			
			List<Treinavel> lFormas = new ArrayList<>();
			List<Treinavel> lCores = new ArrayList<>();
			
			criarListasAuxiliares(listaFormas,listaCores,lFormas,lCores);
			
			/* CRIA��O DOS NEUR�NIOS */
			
			List<Neuronio> listaNeuroniosForma = new ArrayList<>();
			List<Neuronio> listaNeuroniosCor = new ArrayList<>();
			
			criarNeuronios(estimuloFormas, estimuloCores, lFormas, lCores, listaNeuroniosForma, listaNeuroniosCor);
			
			/* LOOP PARA TREINAMENTO DA REDE NEURAL */
			
			int epoca = 0;
			boolean erro = true;
			
			while (erro) {
				erro = false;
				
				/* TREINANDO RECONHECIMENTO DE FORMAS */
				for (int i = 0; i < Forma.getTotalFormas(); i++) {					
					for (int j = 0; j < listaNeuroniosForma.size(); j++) {			
						if (listaNeuroniosForma.get(j).aplicarEstimulos(estimuloFormas.getVetorEstimulo(i), i) == true || erro == true) {
							erro = true;
						}
					}
				}
				
				/* TREINANDO RECONHECIMENTO DE CORES */
				
				for (int i = 0; i < Cor.getTotalCores(); i++) {						
					for (int j = 0; j < listaNeuroniosCor.size(); j++) {			
						if (listaNeuroniosCor.get(j).aplicarEstimulos(estimuloCores.getVetorEstimulo(i), i) == true || erro == true) {
							erro = true;
						}
					}
				}

				/* IMPRIMINDO PALPITE DOS NEUR�NIOS NO CONSOLE */				
				
				System.out.println();
				System.out.println("+++   �POCA " + ++epoca + "   +++");
				System.out.println();
				
				for (Figura figura : listaFiguras) {
					StringBuffer str = new StringBuffer();
					
					System.out.println("_____________________");
					System.out.println();
					System.out.println("Figura " + (figura.getId()+1) + ": " + figura.getForma().getNome() + " " + figura.getCor().getNome());
					System.out.println();
					System.out.println("Os neur�nios palpitam: ");
					System.out.println();
					System.out.print("FORMAS");
					for (int i = 0; i < listaNeuroniosForma.size(); i++) {
						
						
						System.out.print("	Neur�nio " + (i+1) + ":    Eu acho que... ");
						char ch = listaNeuroniosForma.get(i).getPalpiteAt(figura.getForma().getId());
						
						if (ch == '1') {
							System.out.println("� um(a) " + listaFormas.get(i).getNome() + "!");
						} else {
							System.out.println("N�O � um(a) " + listaFormas.get(i).getNome() + "!");
						}
						str.append(ch);
					}
					
					System.out.println();
										
					System.out.print("CORES");
					for (int i = 0; i < listaNeuroniosCor.size(); i++) {
						
						System.out.print("	Neur�nio " + (listaNeuroniosForma.size()+i+1) + ":    Eu acho que... ");
						char ch = listaNeuroniosCor.get(i).getPalpiteAt(figura.getCor().getId());
						
						if (ch == '1') {
							System.out.println("� " + listaCores.get(i).getNome() + "!");
						} else {
							System.out.println("N�O � " + listaCores.get(i).getNome() + "!");
						}
						str.append(ch);
					}
					
					System.out.println();
					System.out.println();
									
					if(figura.getTarget().equals(str.toString())) {
						System.out.println("Neur�nios ACERTARAM o palpite!");
					} else {
						System.out.println("Neur�nios ERRARAM o palpite!");
					}
					System.out.println();
				}
				
				System.out.println();
				System.out.println("{==============================================================}");
				System.out.println();
			
				if (epoca > 1000) {
					System.out.println("Quantidade de �pocas muito alta!");
					System.out.println("Algum neur�nio est� repetindo um vetor de palpites errado.");
					break;
				}
			}			
			
		} catch (IOException ex) {
			System.out.println("N�o foi poss�vel abrir o arquivo figuras.txt.");
		}
	}

	
	/* Este m�todo cria a lista de formas, a lista de cores e lista de figuras, 
	 * sem permitir elementos repetidos. Lan�a a exce��o IOException caso n�o
	 * encontre o arquivo no caminho indicado.
	 */
	public static List<Figura> criarFiguras(List<Forma> listaFormas, List<Cor> listaCores) throws IOException {
		List<Figura> listaFiguras = new ArrayList<Figura>();
		File file = new File(".\\src\\dataset\\figuras.txt");		
		BufferedReader br = new BufferedReader(new FileReader(file));
					
		String line;
		while((line = br.readLine()) != null) {
			Figura figura = new Figura();
			
			/* LEITURA DA FIGURA NO ARQUIVO */
			
			String nomeForma = line;
			String nomeCor = br.readLine();
			
			/* VERIFICANDO SE A FORMA � REPETIDA */
			
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
			
			/* VERIFICA SE A COR � REPETIDA */
			
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
	
	
	/* M�todo que gera primeiro os targets parciais para as formas e cores,
	 * e por fim concatena os targets de forma e cor para gerar os targets
	 * das figuras.
	 */
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
	
	
	/* M�todo que cria listas auxiliares de formas e cores utilizando a
	 * interface Treinavel para que possam ser treinados pelos neur�nios. 
	 */
	public static void criarListasAuxiliares(List<Forma> listaFormas, List<Cor> listaCores, List<Treinavel> lFormas, List<Treinavel> lCores) {
		for (Forma forma : listaFormas) {
			lFormas.add(forma);
		}
		
		for (Cor cor : listaCores) {
			lCores.add(cor);
		}
	}
	
	
	/* M�todo que cria duas listas de neur�nios, uma especializada em treinar
	 * reconhecimento de formas, e outra especializada em reconhecimento de cores.
	 */
	public static void criarNeuronios(Estimulo estimuloFormas, Estimulo estimuloCores, List<Treinavel> listaFormas, List<Treinavel> listaCores, List<Neuronio> listaNeuroniosForma, List<Neuronio> listaNeuroniosCor) {
		
		for (int i = 0; i < (Forma.getTotalFormas()); i++) {
			listaNeuroniosForma.add(new Neuronio(estimuloFormas.getQuantidadeEstimulos(), Forma.getTotalFormas(), listaFormas, i));
		}
		
		for (int i = 0; i < (Cor.getTotalCores()); i++) {
			listaNeuroniosCor.add(new Neuronio(estimuloCores.getQuantidadeEstimulos(), Cor.getTotalCores(), listaCores, i));
		}
	}
}