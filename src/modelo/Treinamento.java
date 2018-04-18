/*	 Implementação da classe que centraliza o treinamento da rede neural.
 * 
 *	 @version 2.0
 * 	 GitHub: https://github.com/rodrigopontezz/RedeNeuralFiguras
 */

package modelo;

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
    
    public Treinamento(File dataset) {
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
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível ler o dataset em \"" + dataset.toString() + "\"" );
        }
    }
    
    
    public boolean treinar() {
        
        this.erro = false;
        this.epoca++;

        /* UMA ITERAÇÃO DE TREINO PARA RECONHECIMENTO DE FORMAS */
        for (int i = 0; i < Forma.getTotalFormas(); i++) {					
                for (int j = 0; j < this.listaNeuroniosForma.size(); j++) {			
                        if (this.listaNeuroniosForma.get(j).aplicarEstimulos(this.estimuloFormas.getVetorEstimulo(i), i) == true || this.erro == true) {
                                this.erro = true;
                        }
                }
        }

        /* UMA ITERAÇÃO DE TREINO PARA RECONHECIMENTO DE CORES */
        for (int i = 0; i < Cor.getTotalCores(); i++) {						
                for (int j = 0; j < this.listaNeuroniosCor.size(); j++) {			
                        if (this.listaNeuroniosCor.get(j).aplicarEstimulos(this.estimuloCores.getVetorEstimulo(i), i) == true || this.erro == true) {
                                this.erro = true;
                        }
                }
        }
        
        return this.erro;
        
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

    public int getEpoca() {
        return this.epoca;
    }
}