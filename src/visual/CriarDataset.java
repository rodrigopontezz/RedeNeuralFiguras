/*	 Form que permite a criação de um novo dataset.
 * 
 *	 @version 2.0
 * 	 GitHub: https://github.com/rodrigopontezz/RedeNeuralFiguras
 */

package visual;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;

public class CriarDataset extends javax.swing.JDialog {

    public CriarDataset(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        /* Radio Button Group - Formas */
        btnGroupFormas.add(rbtnTriangulo);
        btnGroupFormas.add(rbtnQuadrado);
        btnGroupFormas.add(rbtnCirculo);
        btnGroupFormas.add(rbtnTrapezio);
        btnGroupFormas.add(rbtnCoracao);
        btnGroupFormas.add(rbtnEstrela);
        
        /* Radio Button Group - Cores */
        btnGroupCores.add(rbtnAzul);
        btnGroupCores.add(rbtnVerde);
        btnGroupCores.add(rbtnRosa);
        btnGroupCores.add(rbtnPreto);
        btnGroupCores.add(rbtnAmarelo);
        btnGroupCores.add(rbtnVermelho);
        
        /* Adicionando a cor de fundo*/
        this.getContentPane().setBackground(new java.awt.Color(255, 254, 240));
        
        /* Adicionando Ícone à janela */
        URL caminhoImagem = this.getClass().getClassLoader().getResource("favicon.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminhoImagem);
        setIconImage(iconeTitulo);
        
        /* Lista de figuras */
        listFiguras.setModel(new DefaultListModel<>());
        
        this.setTitle("Criar Dataset");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupFormas = new javax.swing.ButtonGroup();
        btnGroupCores = new javax.swing.ButtonGroup();
        lblNomeDataset = new javax.swing.JLabel();
        txfNomeDataset = new javax.swing.JTextField();
        lblExtensao = new javax.swing.JLabel();
        btnFinalizarDataset = new javax.swing.JButton();
        lblSelecioneForma = new javax.swing.JLabel();
        lblImgTriangulo = new javax.swing.JLabel();
        lblImgQuadrado = new javax.swing.JLabel();
        lblImgCirculo = new javax.swing.JLabel();
        lblImgTrapezio = new javax.swing.JLabel();
        lblImgCoracao = new javax.swing.JLabel();
        lblImgEstrela = new javax.swing.JLabel();
        rbtnTriangulo = new javax.swing.JRadioButton();
        rbtnQuadrado = new javax.swing.JRadioButton();
        rbtnCirculo = new javax.swing.JRadioButton();
        rbtnTrapezio = new javax.swing.JRadioButton();
        rbtnCoracao = new javax.swing.JRadioButton();
        rbtnEstrela = new javax.swing.JRadioButton();
        lblSelecioneCor = new javax.swing.JLabel();
        lblImgAzul = new javax.swing.JLabel();
        lblImgVerde = new javax.swing.JLabel();
        lblImgRosa = new javax.swing.JLabel();
        lblImgPreto = new javax.swing.JLabel();
        lblImgAmarelo = new javax.swing.JLabel();
        lblImgVermelho = new javax.swing.JLabel();
        rbtnAzul = new javax.swing.JRadioButton();
        rbtnVerde = new javax.swing.JRadioButton();
        rbtnRosa = new javax.swing.JRadioButton();
        rbtnPreto = new javax.swing.JRadioButton();
        rbtnAmarelo = new javax.swing.JRadioButton();
        rbtnVermelho = new javax.swing.JRadioButton();
        lblDataset = new javax.swing.JLabel();
        scrollPaneFiguras = new javax.swing.JScrollPane();
        listFiguras = new javax.swing.JList<>();
        btnAdicionarFigura = new javax.swing.JButton();
        btnRemoverFigura = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        lblNomeDataset.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNomeDataset.setText("Nome do Dataset");

        txfNomeDataset.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txfNomeDataset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfNomeDatasetActionPerformed(evt);
            }
        });

        lblExtensao.setText(".txt");

        btnFinalizarDataset.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnFinalizarDataset.setText("Criar Dataset");
        btnFinalizarDataset.setMaximumSize(new java.awt.Dimension(120, 25));
        btnFinalizarDataset.setMinimumSize(new java.awt.Dimension(120, 25));
        btnFinalizarDataset.setPreferredSize(new java.awt.Dimension(120, 25));
        btnFinalizarDataset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarDatasetActionPerformed(evt);
            }
        });

        lblSelecioneForma.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSelecioneForma.setText("Selecione uma forma:");

        lblImgTriangulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/formaTriangulo.png"))); // NOI18N
        lblImgTriangulo.setMaximumSize(new java.awt.Dimension(103, 100));
        lblImgTriangulo.setMinimumSize(new java.awt.Dimension(103, 100));

        lblImgQuadrado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/formaQuadrado.png"))); // NOI18N
        lblImgQuadrado.setMaximumSize(new java.awt.Dimension(103, 100));
        lblImgQuadrado.setMinimumSize(new java.awt.Dimension(103, 100));

        lblImgCirculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/formaCirculo.png"))); // NOI18N

        lblImgTrapezio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/formaTrapezio.png"))); // NOI18N

        lblImgCoracao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/formaCoracao.png"))); // NOI18N

        lblImgEstrela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/formaEstrela.png"))); // NOI18N

        rbtnTriangulo.setText("Triângulo");

        rbtnQuadrado.setText("Quadrado");

        rbtnCirculo.setText("Círculo");

        rbtnTrapezio.setText("Trapézio");
        rbtnTrapezio.setToolTipText("");

        rbtnCoracao.setText("Coração");

        rbtnEstrela.setText("Estrela");

        lblSelecioneCor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSelecioneCor.setText("Selecione uma cor:");

        lblImgAzul.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/corAzul.png"))); // NOI18N

        lblImgVerde.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/corVerde.png"))); // NOI18N

        lblImgRosa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/corRosa.png"))); // NOI18N

        lblImgPreto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/corPreto.png"))); // NOI18N

        lblImgAmarelo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/corAmarelo.png"))); // NOI18N

        lblImgVermelho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/corVermelho.png"))); // NOI18N

        rbtnAzul.setText("Azul");
        rbtnAzul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnAzulActionPerformed(evt);
            }
        });

        rbtnVerde.setText("Verde");
        rbtnVerde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnVerdeActionPerformed(evt);
            }
        });

        rbtnRosa.setText("Rosa");
        rbtnRosa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnRosaActionPerformed(evt);
            }
        });

        rbtnPreto.setText("Preto");
        rbtnPreto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnPretoActionPerformed(evt);
            }
        });

        rbtnAmarelo.setText("Amarelo");
        rbtnAmarelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnAmareloActionPerformed(evt);
            }
        });

        rbtnVermelho.setText("Vermelho");
        rbtnVermelho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnVermelhoActionPerformed(evt);
            }
        });

        lblDataset.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblDataset.setText("Dataset:");

        listFiguras.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        listFiguras.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scrollPaneFiguras.setViewportView(listFiguras);

        btnAdicionarFigura.setText("Adicionar Figura");
        btnAdicionarFigura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarFiguraActionPerformed(evt);
            }
        });

        btnRemoverFigura.setText("Remover Figura");
        btnRemoverFigura.setMaximumSize(new java.awt.Dimension(120, 25));
        btnRemoverFigura.setMinimumSize(new java.awt.Dimension(120, 25));
        btnRemoverFigura.setPreferredSize(new java.awt.Dimension(120, 25));
        btnRemoverFigura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverFiguraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblImgTrapezio)
                                    .addGap(18, 18, 18)
                                    .addComponent(rbtnTrapezio)
                                    .addGap(73, 73, 73)
                                    .addComponent(lblImgPreto))
                                .addComponent(lblImgRosa)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblImgQuadrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(rbtnQuadrado)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblImgVerde))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblImgTriangulo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(rbtnTriangulo)
                                    .addGap(71, 71, 71)
                                    .addComponent(lblImgAzul))
                                .addComponent(lblImgAmarelo)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(68, 68, 68)
                                    .addComponent(rbtnEstrela)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblImgVermelho)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblImgCirculo)
                                .addGap(18, 18, 18)
                                .addComponent(rbtnCirculo)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbtnAzul)
                            .addComponent(rbtnVerde)
                            .addComponent(rbtnPreto)
                            .addComponent(rbtnRosa)
                            .addComponent(rbtnAmarelo)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNomeDataset)
                                .addGap(31, 31, 31)
                                .addComponent(txfNomeDataset, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblSelecioneForma))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblExtensao))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblImgCoracao)
                        .addGap(18, 18, 18)
                        .addComponent(rbtnCoracao))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblImgEstrela)
                        .addGap(226, 226, 226)
                        .addComponent(rbtnVermelho))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(lblSelecioneCor)))
                .addGap(13, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(scrollPaneFiguras, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnAdicionarFigura)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnRemoverFigura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btnFinalizarDataset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblDataset))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeDataset)
                    .addComponent(txfNomeDataset, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(lblExtensao)
                    .addComponent(btnFinalizarDataset, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rbtnVermelho)
                        .addGap(12, 12, 12))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSelecioneForma)
                            .addComponent(lblSelecioneCor)
                            .addComponent(lblDataset))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(scrollPaneFiguras)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnAdicionarFigura, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnRemoverFigura, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(16, 16, 16)
                                                .addComponent(rbtnTriangulo))
                                            .addComponent(lblImgAzul)
                                            .addComponent(lblImgTriangulo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(35, 35, 35)
                                                .addComponent(rbtnQuadrado))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(lblImgVerde))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addComponent(rbtnAzul)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(28, 28, 28)
                                                .addComponent(lblImgQuadrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(43, 43, 43)
                                                .addComponent(rbtnVerde)))))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(34, 34, 34)
                                                .addComponent(rbtnCirculo))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(rbtnRosa)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(45, 45, 45)
                                                .addComponent(rbtnTrapezio)
                                                .addGap(45, 45, 45))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(rbtnPreto)
                                                .addGap(47, 47, 47)))
                                        .addComponent(rbtnAmarelo))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblImgCirculo)
                                            .addComponent(lblImgRosa))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblImgPreto)
                                            .addComponent(lblImgTrapezio))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(34, 34, 34)
                                                .addComponent(rbtnCoracao))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblImgAmarelo)
                                                    .addComponent(lblImgCoracao))))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblImgEstrela)
                                            .addComponent(lblImgVermelho)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(rbtnEstrela)
                                                .addGap(10, 10, 10)))))))))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txfNomeDatasetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfNomeDatasetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfNomeDatasetActionPerformed

    private void rbtnAzulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnAzulActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnAzulActionPerformed

    private void rbtnVerdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnVerdeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnVerdeActionPerformed

    private void rbtnRosaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnRosaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnRosaActionPerformed

    private void rbtnPretoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnPretoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnPretoActionPerformed

    private void rbtnAmareloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnAmareloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnAmareloActionPerformed

    private void rbtnVermelhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnVermelhoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnVermelhoActionPerformed

    private void btnRemoverFiguraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverFiguraActionPerformed
        int selected = listFiguras.getSelectedIndex();
        
        if (selected >= 0) {
            DefaultListModel model = (DefaultListModel) listFiguras.getModel();
            model.remove(selected);
        } else {
            WarningWindow form = new WarningWindow(null, true, "Nenhum item na lista foi selecionado!");
        }
    }//GEN-LAST:event_btnRemoverFiguraActionPerformed

    private void btnFinalizarDatasetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarDatasetActionPerformed
        String nomeDataset = txfNomeDataset.getText();
        
        boolean invalido = checaInvalido(nomeDataset);
        DefaultListModel model = (DefaultListModel) listFiguras.getModel();
        
        StringBuilder nomeArquivo = new StringBuilder();
        nomeArquivo.append(nomeDataset);
        nomeArquivo.append(".txt");
        
        File file = new File(".\\src\\dataset\\" + nomeArquivo.toString());
        
        if(nomeDataset.equals("")) {
            WarningWindow form = new WarningWindow(null, true, "Escolha um nome para o dataset!");
        } else if (nomeDataset.charAt(0) > 47 && nomeDataset.charAt(0) < 58) {
            WarningWindow form = new WarningWindow(null, true, "O nome do dataset não pode começar com números!");
        } else if (invalido) {
            WarningWindow form = new WarningWindow(null, true, "O nome do dataset possui um ou mais caracteres inválidos!");
        } else if (model.getSize() == 0) {
            WarningWindow form = new WarningWindow(null, true, "O dataset está vazio!");
        } else if (file.exists()) {
            WarningWindow form = new WarningWindow(null, true, "Já existe um dataset com este nome!");
        } else {
            try (PrintWriter arquivo = new PrintWriter (new BufferedWriter (new FileWriter(file)))) {
                int tam = model.getSize(); 
                for (int i = 0; i < tam; i++) {
                    if(i == tam-1) {
                        arquivo.print(model.remove(0).toString());
                    } else {
                        arquivo.println(model.remove(0).toString());
                    }
                }
                
                this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
                WarningWindow form = new WarningWindow(null, true, "O dataset \"" + nomeArquivo.toString() + "\" foi criado com sucesso!");
            } catch(IOException ex) {
                ExceptionWindow form = new ExceptionWindow(null, true, "Erro: Não foi possível criar o dataset \"" + nomeArquivo.toString() + "\".");
            } catch (Exception ex) {
                ExceptionWindow form = new ExceptionWindow(null, true, "Erro inesperado.");
            }
        }
    }//GEN-LAST:event_btnFinalizarDatasetActionPerformed

    private void btnAdicionarFiguraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarFiguraActionPerformed
        String strForma = obterBotaoSelecionado(btnGroupFormas);
        String strCor = obterBotaoSelecionado(btnGroupCores);
        
        if (strForma == null) {
            WarningWindow form = new WarningWindow(null, true, "Nenhuma forma selecionada!");
        } else if (strCor == null) {
            WarningWindow form = new WarningWindow(null, true, "Nenhuma cor selecionada!");
        } else {
            DefaultListModel model = (DefaultListModel) listFiguras.getModel();
            model.add(model.getSize(), strForma + " " + strCor);
        }
    }//GEN-LAST:event_btnAdicionarFiguraActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CriarDataset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CriarDataset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CriarDataset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CriarDataset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                CriarDataset dialog = new CriarDataset(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    /*  Método que verifica qual botão está selecionado em um ButtonGroop e retorna
     *  uma String contendo o texto desse botão.
     */
    public String obterBotaoSelecionado(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }
    
    /*  Método que checa se uma string possui carateres inválidos para nome de arquivo.
     */
    public boolean checaInvalido(String str) {
        char [] invalidos = {'\'', '/', '|', '<', '>', '*', ':', '"', '.', ',', '_'};
        
        for (int i = 0; i < invalidos.length; i++) {
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == invalidos[i]) return true;
            }
        }
        return false;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarFigura;
    private javax.swing.JButton btnFinalizarDataset;
    private javax.swing.ButtonGroup btnGroupCores;
    private javax.swing.ButtonGroup btnGroupFormas;
    private javax.swing.JButton btnRemoverFigura;
    private javax.swing.JLabel lblDataset;
    private javax.swing.JLabel lblExtensao;
    private javax.swing.JLabel lblImgAmarelo;
    private javax.swing.JLabel lblImgAzul;
    private javax.swing.JLabel lblImgCirculo;
    private javax.swing.JLabel lblImgCoracao;
    private javax.swing.JLabel lblImgEstrela;
    private javax.swing.JLabel lblImgPreto;
    private javax.swing.JLabel lblImgQuadrado;
    private javax.swing.JLabel lblImgRosa;
    private javax.swing.JLabel lblImgTrapezio;
    private javax.swing.JLabel lblImgTriangulo;
    private javax.swing.JLabel lblImgVerde;
    private javax.swing.JLabel lblImgVermelho;
    private javax.swing.JLabel lblNomeDataset;
    private javax.swing.JLabel lblSelecioneCor;
    private javax.swing.JLabel lblSelecioneForma;
    private javax.swing.JList<String> listFiguras;
    private javax.swing.JRadioButton rbtnAmarelo;
    private javax.swing.JRadioButton rbtnAzul;
    private javax.swing.JRadioButton rbtnCirculo;
    private javax.swing.JRadioButton rbtnCoracao;
    private javax.swing.JRadioButton rbtnEstrela;
    private javax.swing.JRadioButton rbtnPreto;
    private javax.swing.JRadioButton rbtnQuadrado;
    private javax.swing.JRadioButton rbtnRosa;
    private javax.swing.JRadioButton rbtnTrapezio;
    private javax.swing.JRadioButton rbtnTriangulo;
    private javax.swing.JRadioButton rbtnVerde;
    private javax.swing.JRadioButton rbtnVermelho;
    private javax.swing.JScrollPane scrollPaneFiguras;
    private javax.swing.JTextField txfNomeDataset;
    // End of variables declaration//GEN-END:variables
}
