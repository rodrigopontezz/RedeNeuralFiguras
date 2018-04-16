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

import exception.TreinamentoException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Treinamento {
    
    List<Forma> listaFormas;
    List<Cor> listaCores;
    List<Figura> listaFiguras;
    List<Treinavel> lFormas;
    List<Treinavel> lCores;
    List<Neuronio> listaNeuroniosForma;
    List<Neuronio> listaNeuroniosCor;
    
    Estimulo estimuloFormas;
    Estimulo estimuloCores;
    
    int epoca;
    boolean erro;
    
    public Treinamento(File dataset, String tipoTreino) {
        try {
            /* CRIAÇÃO DE FORMAS, CORES E FIGURAS*/

            this.listaFormas = new ArrayList<>();
            this.listaCores = new ArrayList<>();
            this.listaFiguras = criarFiguras(dataset);

            /* GERANDO VETOR DE TARGETS PARA FORMAS E CORES, E CONCATENA TARGETS NA LISTA FIGURAS */

            gerarTargets();

            /* GERANDO AS MATRIZES DE ESTÍMULOS */

            this.estimuloFormas = new Estimulo(Forma.getTotalFormas());
            this.estimuloCores = new Estimulo(Cor.getTotalCores());

            /* CRIAÇÃO DA LISTA DE FORMAS E CORES AUXILIAR */

            this.lFormas = new ArrayList<>();
            this.lCores = new ArrayList<>();
            criarListasAuxiliares();

            /* CRIAÇÃO DOS NEURÔNIOS */

            this.listaNeuroniosForma = new ArrayList<>();
            this.listaNeuroniosCor = new ArrayList<>();
            criarNeuronios();

            if (tipoTreino.equals("total"))  treinarRedeTotalmente();
            else if (!tipoTreino.equals("iterativo"))  throw new TreinamentoException("Não foi possível executar o treinamento.");
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível ler o dataset em \"" + dataset.toString() + "\"" );
        }
    }

    public void treinarRedeTotalmente() {
        
        this.epoca = 0;
        this.erro = true;

        /* LOOP PARA TREINAMENTO DA REDE NEURAL */
        
        while (this.erro) {
            this.erro = false;

            /* TREINANDO RECONHECIMENTO DE FORMAS */
            for (int i = 0; i < Forma.getTotalFormas(); i++) {					
                    for (int j = 0; j < this.listaNeuroniosForma.size(); j++) {			
                            if (this.listaNeuroniosForma.get(j).aplicarEstimulos(this.estimuloFormas.getVetorEstimulo(i), i) == true || this.erro == true) {
                                    this.erro = true;
                            }
                    }
            }

            /* TREINANDO RECONHECIMENTO DE CORES */
            for (int i = 0; i < Cor.getTotalCores(); i++) {						
                    for (int j = 0; j < this.listaNeuroniosCor.size(); j++) {			
                            if (this.listaNeuroniosCor.get(j).aplicarEstimulos(this.estimuloCores.getVetorEstimulo(i), i) == true || this.erro == true) {
                                    this.erro = true;
                            }
                    }
            }

            /* IMPRIMINDO PALPITE DOS NEUR�NIOS NO CONSOLE */				

            System.out.println();
            System.out.println("+++   ÉPOCA " + ++(this.epoca) + "   +++");
            System.out.println();

            for (Figura figura : this.listaFiguras) {
                    StringBuffer str = new StringBuffer();

                    System.out.println("_____________________");
                    System.out.println();
                    System.out.println("Figura " + (figura.getId()+1) + ": " + figura.getForma().getNome() + " " + figura.getCor().getNome());
                    System.out.println();
                    System.out.println("Os neurônios palpitam: ");
                    System.out.println();
                    System.out.print("FORMAS");
                    for (int i = 0; i < this.listaNeuroniosForma.size(); i++) {


                            System.out.print("	Neurônio " + (i+1) + ":    Eu acho que... ");
                            char ch = this.listaNeuroniosForma.get(i).getPalpiteAt(figura.getForma().getId());

                            if (ch == '1') {
                                    System.out.println("é um(a) " + this.listaFormas.get(i).getNome() + "!");
                            } else {
                                    System.out.println("NÃO É um(a) " + this.listaFormas.get(i).getNome() + "!");
                            }
                            str.append(ch);
                    }

                    System.out.println();

                    System.out.print("CORES");
                    for (int i = 0; i < this.listaNeuroniosCor.size(); i++) {

                            System.out.print("	Neurônio " + (this.listaNeuroniosForma.size()+i+1) + ":    Eu acho que... ");
                            char ch = this.listaNeuroniosCor.get(i).getPalpiteAt(figura.getCor().getId());

                            if (ch == '1') {
                                    System.out.println("é " + this.listaCores.get(i).getNome() + "!");
                            } else {
                                    System.out.println("NÃO É " + this.listaCores.get(i).getNome() + "!");
                            }
                            str.append(ch);
                    }

                    System.out.println();
                    System.out.println();

                    if(figura.getTarget().equals(str.toString())) {
                            System.out.println("Neurônios ACERTARAM o palpite!");
                    } else {
                            System.out.println("Neurônios ERRARAM o palpite!");
                    }
                    System.out.println();
            }

            System.out.println();
            System.out.println("{==============================================================}");
            System.out.println();

            if (epoca > 1000) {
                    System.out.println("Quantidade de épocas muito alta!");
                    System.out.println("Algum neurônio está repetindo um vetor de palpites errado.");
                    break;
            }
        }
    }
    
    public void treinar() {
        
    }
    
    
    /* Este método cria a lista de formas, a lista de cores e lista de figuras, 
     * sem permitir elementos repetidos. Lança a exceção IOException caso não
     * encontre o dataset no caminho indicado.
     */
    public List<Figura> criarFiguras(File dataset) throws IOException {
            List<Figura> listaFiguras = new ArrayList<Figura>();		
            BufferedReader br = new BufferedReader(new FileReader(dataset));

            String line;
            while((line = br.readLine()) != null) {
                    Figura figura = new Figura();

                    /* LEITURA DA FIGURA NO ARQUIVO */

                    String nomeForma = line.split(" ")[0];
                    String nomeCor = line.split(" ")[1];

                    /* VERIFICANDO SE A FORMA É REPETIDA */

                    for(Forma forma : this.listaFormas) {
                            if(forma.getNome().equals(nomeForma)) {
                                    figura.setForma(forma);
                                    break;
                            }
                    }

                    /* CASO SEJA UMA NOVA FORMA, CRIA NOVO OBJETO */

                    if(figura.getForma() == null) {
                            Forma forma = new Forma();
                            forma.setNome(nomeForma);
                            this.listaFormas.add(forma);
                            figura.setForma(forma);
                    }

                    /* VERIFICA SE A COR É REPETIDA */

                    for(Cor cor : this.listaCores) {
                            if(cor.getNome().equals(nomeCor)) {
                                    figura.setCor(cor);
                                    break;
                            }
                    }

                    /* CASO SEJA UMA NOVA COR, CRIA NOVO OBJETO */

                    if(figura.getCor() == null) {
                            Cor cor = new Cor();
                            cor.setNome(nomeCor);
                            this.listaCores.add(cor);
                            figura.setCor(cor);
                    }

                    listaFiguras.add(figura);
            }

            br.close();	
            return listaFiguras;
    }


    /* Método que gera primeiro os targets parciais para as formas e cores,
     * e por fim concatena os targets de forma e cor para gerar os targets
     * das figuras.
     */
    public void gerarTargets() {

            for (int i = 0; i < Forma.getTotalFormas(); i++) {
                    this.listaFormas.get(i).setTargetForma(i);
            }

            for (int i = 0; i < Cor.getTotalCores(); i++) {
                    this.listaCores.get(i).setTargetCor(i);
            }

            for(Figura figura : this.listaFiguras) {
                    figura.calcularTarget();
            }
    }


    /* Método que cria listas auxiliares de formas e cores utilizando a
     * interface Treinavel para que possam ser treinados pelos neurônios. 
     */
    public void criarListasAuxiliares() {
            for (Forma forma : this.listaFormas) {
                    this.lFormas.add(forma);
            }

            for (Cor cor : this.listaCores) {
                    this.lCores.add(cor);
            }
    }


    /* Método que cria duas listas de neurônios, uma especializada em treinar
     * reconhecimento de formas, e outra especializada em reconhecimento de cores.
     */
    public void criarNeuronios() {

            for (int i = 0; i < (Forma.getTotalFormas()); i++) {
                    this.listaNeuroniosForma.add(new Neuronio(this.estimuloFormas.getQuantidadeEstimulos(), Forma.getTotalFormas(), this.lFormas, i));
            }

            for (int i = 0; i < (Cor.getTotalCores()); i++) {
                    this.listaNeuroniosCor.add(new Neuronio(this.estimuloCores.getQuantidadeEstimulos(), Cor.getTotalCores(), this.lCores, i));
            }
    }
    
    public List<Forma> getListaFormas() {
        return this.listaFormas;
    }

    public List<Cor> getListaCores() {
        return this.listaCores;
    }

    public List<Figura> getListaFiguras() {
        return this.listaFiguras;
    }

    public List<Neuronio> getListaNeuroniosForma() {
        return this.listaNeuroniosForma;
    }

    public List<Neuronio> getListaNeuroniosCor() {
        return this.listaNeuroniosCor;
    }

    public Estimulo getEstimuloFormas() {
        return this.estimuloFormas;
    }

    public Estimulo getEstimuloCores() {
        return this.estimuloCores;
    }

    public int getEpoca() {
        return this.epoca;
    }

    public boolean isErro() {
        return this.erro;
    }
}