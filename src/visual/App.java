package visual;


import exception.InitException;
import exception.TreinamentoException;
import javax.swing.JOptionPane;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import exception.WindowException;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import modelo.Cor;
import modelo.Figura;
import modelo.Forma;
import modelo.Treinamento;


public class App extends javax.swing.JFrame {

    List<javax.swing.JLabel> listaLblTextoFiguras;
    List<javax.swing.JLabel> listaLblFiguras;
    List<javax.swing.JLabel> listaLblReconhece;
    List<javax.swing.JLabel> listaLblNeuronios;
    List<javax.swing.JLabel> listaLblResposta;
    
    Treinamento treinador;
    
    /**
     * Creates new form Principal
     */
    public App() {
        initComponents();
        
        /* Gerenciando o visual */
        this.getContentPane().setBackground(new java.awt.Color(255, 254, 240));        
        
        /* Adicionando Ícone à janela */
        try {
            URL caminhoImagem = this.getClass().getClassLoader().getResource("favicon.png");
            Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminhoImagem);
            setIconImage(iconeTitulo);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar o ícone \"favicon.png\".");
        }
        
        this.listaLblFiguras = new ArrayList<>();
        this.listaLblFiguras.add(lblFigura1);
        this.listaLblFiguras.add(lblFigura2);
        this.listaLblFiguras.add(lblFigura3);
        this.listaLblFiguras.add(lblFigura4);
        this.listaLblFiguras.add(lblFigura5);
        this.listaLblFiguras.add(lblFigura6);
        this.listaLblFiguras.add(lblFigura7);
        this.listaLblFiguras.add(lblFigura8);
        this.listaLblFiguras.add(lblFigura9);
        this.listaLblFiguras.add(lblFigura10);
        
        for(javax.swing.JLabel label : listaLblFiguras) {
            label.setText("");
            label.setVisible(false);
            label.setEnabled(false);
        }

        this.listaLblNeuronios = new ArrayList<>();
        this.listaLblNeuronios.add(lblNeuronio1);
        this.listaLblNeuronios.add(lblNeuronio2);
        this.listaLblNeuronios.add(lblNeuronio3);
        this.listaLblNeuronios.add(lblNeuronio4);
        this.listaLblNeuronios.add(lblNeuronio5);
        this.listaLblNeuronios.add(lblNeuronio6);
        this.listaLblNeuronios.add(lblNeuronio7);
        this.listaLblNeuronios.add(lblNeuronio8);
        this.listaLblNeuronios.add(lblNeuronio9);
        this.listaLblNeuronios.add(lblNeuronio10);
        this.listaLblNeuronios.add(lblNeuronio11);
        this.listaLblNeuronios.add(lblNeuronio12);
        
        for(javax.swing.JLabel label : listaLblNeuronios) {
            label.setText("");
            label.setVisible(false);
        }
        
        this.listaLblReconhece = new ArrayList<>();
        this.listaLblReconhece.add(lblReconhece1);
        this.listaLblReconhece.add(lblReconhece2);
        this.listaLblReconhece.add(lblReconhece3);
        this.listaLblReconhece.add(lblReconhece4);
        this.listaLblReconhece.add(lblReconhece5);
        this.listaLblReconhece.add(lblReconhece6);
        this.listaLblReconhece.add(lblReconhece7);
        this.listaLblReconhece.add(lblReconhece8);
        this.listaLblReconhece.add(lblReconhece9);
        this.listaLblReconhece.add(lblReconhece10);
        this.listaLblReconhece.add(lblReconhece11);
        this.listaLblReconhece.add(lblReconhece12);
        
        for(javax.swing.JLabel label : listaLblReconhece) {
            label.setText("");
            label.setVisible(false);
        }
        
        this.listaLblTextoFiguras = new ArrayList<>();
        this.listaLblTextoFiguras.add(lblTextoFigura1);
        this.listaLblTextoFiguras.add(lblTextoFigura2);
        this.listaLblTextoFiguras.add(lblTextoFigura3);
        this.listaLblTextoFiguras.add(lblTextoFigura4);
        this.listaLblTextoFiguras.add(lblTextoFigura5);
        this.listaLblTextoFiguras.add(lblTextoFigura6);
        this.listaLblTextoFiguras.add(lblTextoFigura7);
        this.listaLblTextoFiguras.add(lblTextoFigura8);
        this.listaLblTextoFiguras.add(lblTextoFigura9);
        this.listaLblTextoFiguras.add(lblTextoFigura10);
        
        for(javax.swing.JLabel label : listaLblTextoFiguras) {
            label.setText("");
            label.setEnabled(false);
            label.setVisible(false);
        }
        
        this.listaLblResposta = new ArrayList<>();
        this.listaLblResposta.add(lblResposta1);
        this.listaLblResposta.add(lblResposta2);
        this.listaLblResposta.add(lblResposta3);
        this.listaLblResposta.add(lblResposta4);
        this.listaLblResposta.add(lblResposta5);
        this.listaLblResposta.add(lblResposta6);
        this.listaLblResposta.add(lblResposta7);
        this.listaLblResposta.add(lblResposta8);
        this.listaLblResposta.add(lblResposta9);
        this.listaLblResposta.add(lblResposta10);
        this.listaLblResposta.add(lblResposta11);
        this.listaLblResposta.add(lblResposta12);
        
        for(javax.swing.JLabel label : listaLblResposta) {
            label.setText("");
            label.setVisible(false);
        }
        
        this.lblAvisoDataset.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDialogo = new javax.swing.JLabel();
        cmbBoxDataset = new javax.swing.JComboBox<>();
        btnParar = new javax.swing.JButton();
        btnEscolher = new javax.swing.JButton();
        btnProximaEpoca = new javax.swing.JButton();
        lblDataset = new javax.swing.JLabel();
        separador = new javax.swing.JSeparator();
        lblFigura1 = new javax.swing.JLabel();
        lblFigura2 = new javax.swing.JLabel();
        lblFigura3 = new javax.swing.JLabel();
        lblFigura4 = new javax.swing.JLabel();
        lblFigura5 = new javax.swing.JLabel();
        lblFigura6 = new javax.swing.JLabel();
        lblFigura7 = new javax.swing.JLabel();
        lblFigura8 = new javax.swing.JLabel();
        lblFigura9 = new javax.swing.JLabel();
        lblFigura10 = new javax.swing.JLabel();
        lblAvisoDataset = new javax.swing.JLabel();
        lblNeuronio1 = new javax.swing.JLabel();
        lblNeuronio2 = new javax.swing.JLabel();
        lblNeuronio3 = new javax.swing.JLabel();
        lblNeuronio4 = new javax.swing.JLabel();
        lblNeuronio5 = new javax.swing.JLabel();
        lblNeuronio6 = new javax.swing.JLabel();
        lblNeuronio7 = new javax.swing.JLabel();
        lblNeuronio8 = new javax.swing.JLabel();
        lblNeuronio9 = new javax.swing.JLabel();
        lblNeuronio10 = new javax.swing.JLabel();
        lblNeuronio11 = new javax.swing.JLabel();
        lblNeuronio12 = new javax.swing.JLabel();
        lblReconhece1 = new javax.swing.JLabel();
        lblReconhece2 = new javax.swing.JLabel();
        lblReconhece3 = new javax.swing.JLabel();
        lblReconhece4 = new javax.swing.JLabel();
        lblReconhece5 = new javax.swing.JLabel();
        lblReconhece6 = new javax.swing.JLabel();
        lblReconhece7 = new javax.swing.JLabel();
        lblReconhece8 = new javax.swing.JLabel();
        lblReconhece9 = new javax.swing.JLabel();
        lblReconhece10 = new javax.swing.JLabel();
        lblReconhece11 = new javax.swing.JLabel();
        lblReconhece12 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        lblResposta1 = new javax.swing.JLabel();
        lblResposta2 = new javax.swing.JLabel();
        lblResposta3 = new javax.swing.JLabel();
        lblResposta4 = new javax.swing.JLabel();
        lblResposta5 = new javax.swing.JLabel();
        lblResposta6 = new javax.swing.JLabel();
        lblResposta7 = new javax.swing.JLabel();
        lblResposta8 = new javax.swing.JLabel();
        lblResposta9 = new javax.swing.JLabel();
        lblResposta10 = new javax.swing.JLabel();
        lblResposta11 = new javax.swing.JLabel();
        lblResposta12 = new javax.swing.JLabel();
        lblTextoFigura1 = new javax.swing.JLabel();
        lblTextoFigura2 = new javax.swing.JLabel();
        lblTextoFigura3 = new javax.swing.JLabel();
        lblTextoFigura4 = new javax.swing.JLabel();
        lblTextoFigura5 = new javax.swing.JLabel();
        lblTextoFigura6 = new javax.swing.JLabel();
        lblTextoFigura7 = new javax.swing.JLabel();
        lblTextoFigura8 = new javax.swing.JLabel();
        lblTextoFigura9 = new javax.swing.JLabel();
        lblTextoFigura10 = new javax.swing.JLabel();
        lblContaEpocas = new javax.swing.JLabel();
        barraMenu = new javax.swing.JMenuBar();
        menuTreinamento = new javax.swing.JMenu();
        subMenuIniciar = new javax.swing.JMenuItem();
        subMenuParar = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        subMenuSair = new javax.swing.JMenuItem();
        menuDataset = new javax.swing.JMenu();
        subMenuCriarDataset = new javax.swing.JMenuItem();
        subMenuDeletarDataset = new javax.swing.JMenuItem();
        menuAjuda = new javax.swing.JMenu();
        subMenuComoUsar = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        subMenuSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Perceptron - Reconhecimento de Figuras");
        setMinimumSize(new java.awt.Dimension(960, 720));
        setResizable(false);

        lblDialogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/balaoDialogoPadrao.png"))); // NOI18N

        cmbBoxDataset.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbBoxDataset.setEnabled(false);

        btnParar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnParar.setText("Parar");
        btnParar.setEnabled(false);
        btnParar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPararActionPerformed(evt);
            }
        });

        btnEscolher.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEscolher.setText("Escolher");
        btnEscolher.setEnabled(false);
        btnEscolher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEscolherActionPerformed(evt);
            }
        });

        btnProximaEpoca.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnProximaEpoca.setText("Próxima Época");
        btnProximaEpoca.setEnabled(false);
        btnProximaEpoca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProximaEpocaActionPerformed(evt);
            }
        });

        lblDataset.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblDataset.setText("DATASET:");

        lblFigura1.setText("jLabel1");
        lblFigura1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFigura1MouseClicked(evt);
            }
        });

        lblFigura2.setText("jLabel1");
        lblFigura2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFigura2MouseClicked(evt);
            }
        });

        lblFigura3.setText("jLabel1");
        lblFigura3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFigura3MouseClicked(evt);
            }
        });

        lblFigura4.setText("jLabel1");
        lblFigura4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFigura4MouseClicked(evt);
            }
        });

        lblFigura5.setText("jLabel1");
        lblFigura5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFigura5MouseClicked(evt);
            }
        });

        lblFigura6.setText("jLabel1");
        lblFigura6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFigura6MouseClicked(evt);
            }
        });

        lblFigura7.setText("jLabel1");
        lblFigura7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFigura7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblFigura7MouseEntered(evt);
            }
        });

        lblFigura8.setText("jLabel1");
        lblFigura8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFigura8MouseClicked(evt);
            }
        });
        lblFigura8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lblFigura8KeyPressed(evt);
            }
        });

        lblFigura9.setText("jLabel1");
        lblFigura9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFigura9MouseClicked(evt);
            }
        });

        lblFigura10.setText("jLabel1");
        lblFigura10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFigura10MouseClicked(evt);
            }
        });

        lblAvisoDataset.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblAvisoDataset.setText("<html>Dataset muito grande,<br>figuras excedentes não<br> serão exibidas</html>");

        lblNeuronio1.setText("jLabel1");

        lblNeuronio2.setText("jLabel1");

        lblNeuronio3.setText("jLabel1");

        lblNeuronio4.setText("jLabel1");

        lblNeuronio5.setText("jLabel1");

        lblNeuronio6.setText("jLabel1");

        lblNeuronio7.setText("jLabel1");

        lblNeuronio8.setText("jLabel1");

        lblNeuronio9.setText("jLabel1");

        lblNeuronio10.setText("jLabel1");

        lblNeuronio11.setText("jLabel1");

        lblNeuronio12.setText("jLabel1");

        lblReconhece1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblReconhece1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblReconhece1.setText("jLabel1");

        lblReconhece2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblReconhece2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblReconhece2.setText("jLabel1");

        lblReconhece3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblReconhece3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblReconhece3.setText("jLabel1");

        lblReconhece4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblReconhece4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblReconhece4.setText("jLabel1");

        lblReconhece5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblReconhece5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblReconhece5.setText("jLabel1");

        lblReconhece6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblReconhece6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblReconhece6.setText("jLabel1");

        lblReconhece7.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblReconhece7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblReconhece7.setText("jLabel1");

        lblReconhece8.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblReconhece8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblReconhece8.setText("jLabel1");

        lblReconhece9.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblReconhece9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblReconhece9.setText("jLabel1");

        lblReconhece10.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblReconhece10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblReconhece10.setText("jLabel1");

        lblReconhece11.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblReconhece11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblReconhece11.setText("jLabel1");

        lblReconhece12.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblReconhece12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblReconhece12.setText("jLabel1");

        lblResposta1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblResposta1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblResposta1.setText("jLabel1");

        lblResposta2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblResposta2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblResposta2.setText("jLabel1");

        lblResposta3.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblResposta3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblResposta3.setText("jLabel1");

        lblResposta4.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblResposta4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblResposta4.setText("jLabel1");

        lblResposta5.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblResposta5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblResposta5.setText("jLabel1");

        lblResposta6.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblResposta6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblResposta6.setText("jLabel1");

        lblResposta7.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblResposta7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblResposta7.setText("jLabel1");

        lblResposta8.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblResposta8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblResposta8.setText("jLabel1");

        lblResposta9.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblResposta9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblResposta9.setText("jLabel1");

        lblResposta10.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblResposta10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblResposta10.setText("jLabel1");

        lblResposta11.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblResposta11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblResposta11.setText("jLabel1");

        lblResposta12.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblResposta12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblResposta12.setText("jLabel1");

        lblTextoFigura1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblTextoFigura1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTextoFigura1.setText("jLabel1");
        lblTextoFigura1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTextoFigura1MouseClicked(evt);
            }
        });

        lblTextoFigura2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblTextoFigura2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTextoFigura2.setText("jLabel1");
        lblTextoFigura2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTextoFigura2MouseClicked(evt);
            }
        });

        lblTextoFigura3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblTextoFigura3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTextoFigura3.setText("jLabel1");
        lblTextoFigura3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTextoFigura3MouseClicked(evt);
            }
        });

        lblTextoFigura4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblTextoFigura4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTextoFigura4.setText("jLabel1");
        lblTextoFigura4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTextoFigura4MouseClicked(evt);
            }
        });

        lblTextoFigura5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblTextoFigura5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTextoFigura5.setText("jLabel1");
        lblTextoFigura5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTextoFigura5MouseClicked(evt);
            }
        });

        lblTextoFigura6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblTextoFigura6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTextoFigura6.setText("jLabel1");
        lblTextoFigura6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTextoFigura6MouseClicked(evt);
            }
        });

        lblTextoFigura7.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblTextoFigura7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTextoFigura7.setText("jLabel1");
        lblTextoFigura7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTextoFigura7MouseClicked(evt);
            }
        });

        lblTextoFigura8.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblTextoFigura8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTextoFigura8.setText("jLabel1");
        lblTextoFigura8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTextoFigura8MouseClicked(evt);
            }
        });

        lblTextoFigura9.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblTextoFigura9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTextoFigura9.setText("jLabel1");
        lblTextoFigura9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTextoFigura9MouseClicked(evt);
            }
        });

        lblTextoFigura10.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblTextoFigura10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTextoFigura10.setText("jLabel1");
        lblTextoFigura10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTextoFigura10MouseClicked(evt);
            }
        });

        lblContaEpocas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblContaEpocas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblContaEpocas.setText("ÉPOCA: 0");

        menuTreinamento.setText("Treinamento");
        menuTreinamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTreinamentoActionPerformed(evt);
            }
        });

        subMenuIniciar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        subMenuIniciar.setText("Iniciar Rede");
        subMenuIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuIniciarActionPerformed(evt);
            }
        });
        menuTreinamento.add(subMenuIniciar);

        subMenuParar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        subMenuParar.setText("Parar Rede");
        subMenuParar.setEnabled(false);
        subMenuParar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuPararActionPerformed(evt);
            }
        });
        menuTreinamento.add(subMenuParar);
        menuTreinamento.add(jSeparator2);

        subMenuSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        subMenuSair.setText("Sair");
        subMenuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuSairActionPerformed(evt);
            }
        });
        menuTreinamento.add(subMenuSair);

        barraMenu.add(menuTreinamento);

        menuDataset.setText("Dataset");
        menuDataset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDatasetActionPerformed(evt);
            }
        });

        subMenuCriarDataset.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        subMenuCriarDataset.setText("Criar Dataset");
        subMenuCriarDataset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuCriarDatasetActionPerformed(evt);
            }
        });
        menuDataset.add(subMenuCriarDataset);

        subMenuDeletarDataset.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        subMenuDeletarDataset.setText("Excluir Dataset");
        subMenuDeletarDataset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuDeletarDatasetActionPerformed(evt);
            }
        });
        menuDataset.add(subMenuDeletarDataset);

        barraMenu.add(menuDataset);

        menuAjuda.setText("Ajuda");

        subMenuComoUsar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F11, 0));
        subMenuComoUsar.setText("Como Utilizar");
        subMenuComoUsar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuComoUsarActionPerformed(evt);
            }
        });
        menuAjuda.add(subMenuComoUsar);
        menuAjuda.add(jSeparator1);

        subMenuSobre.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F12, 0));
        subMenuSobre.setText("Sobre");
        subMenuSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuSobreActionPerformed(evt);
            }
        });
        menuAjuda.add(subMenuSobre);

        barraMenu.add(menuAjuda);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblDialogo, javax.swing.GroupLayout.PREFERRED_SIZE, 919, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addComponent(lblDataset)
                        .addGap(30, 30, 30)
                        .addComponent(cmbBoxDataset, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnEscolher, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 919, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblResposta1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblReconhece1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNeuronio1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNeuronio2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblReconhece2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblResposta2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNeuronio3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblReconhece3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblResposta3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNeuronio4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblReconhece4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblResposta4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNeuronio5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblReconhece5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblResposta5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNeuronio6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblReconhece6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblResposta6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNeuronio7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblReconhece7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblResposta7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNeuronio8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblReconhece8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblResposta8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNeuronio9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblReconhece9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblResposta9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNeuronio10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblReconhece10, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblResposta10, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNeuronio12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblReconhece11, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblResposta11, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblReconhece12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblResposta12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNeuronio11, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTextoFigura1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblFigura1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblFigura2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTextoFigura2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblFigura3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTextoFigura3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblFigura4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTextoFigura4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblFigura5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTextoFigura5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblFigura6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTextoFigura6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblFigura7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTextoFigura7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblFigura8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTextoFigura8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblFigura9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTextoFigura9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblFigura10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTextoFigura10, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lblAvisoDataset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 919, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblContaEpocas, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(btnProximaEpoca, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnParar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblDialogo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEscolher, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbBoxDataset, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDataset))
                .addGap(18, 18, 18)
                .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProximaEpoca, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnParar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblContaEpocas, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(lblAvisoDataset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTextoFigura1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTextoFigura2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTextoFigura3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTextoFigura4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTextoFigura5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTextoFigura6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTextoFigura7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTextoFigura8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTextoFigura9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTextoFigura10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFigura3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFigura4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFigura5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFigura6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFigura7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFigura8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFigura9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFigura10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFigura2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFigura1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblReconhece1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblReconhece2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblReconhece3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblReconhece4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblReconhece5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblReconhece6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblReconhece7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblReconhece8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblReconhece9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblReconhece10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblReconhece11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblReconhece12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNeuronio1)
                    .addComponent(lblNeuronio2)
                    .addComponent(lblNeuronio3)
                    .addComponent(lblNeuronio4)
                    .addComponent(lblNeuronio5)
                    .addComponent(lblNeuronio6)
                    .addComponent(lblNeuronio7)
                    .addComponent(lblNeuronio8)
                    .addComponent(lblNeuronio9)
                    .addComponent(lblNeuronio10)
                    .addComponent(lblNeuronio11)
                    .addComponent(lblNeuronio12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblResposta1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblResposta2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblResposta3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblResposta4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblResposta5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblResposta6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblResposta7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblResposta8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblResposta9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblResposta10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblResposta11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblResposta12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(138, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void subMenuSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuSobreActionPerformed
        JOptionPane.showMessageDialog(null, "\nRede Neural Perceptron para reconhecimento de figuras a\npartir de um dataset textual.\n\n" 
                                            + "Projeto desenvolvido para a disciplina Inteligência Artificial I        \n"
                                            + "Curso: Ciências da Computação (UNISANTOS)\n"
                                            + "Professor: Márcio Piva\n\n"  
                                            + "Desenvolvedores:\n\nRodrigo Pontes\nLuana Quelhas\nDiego Assis\nHiero Bartholo\n\n"
                                            + "Versão 2.0\n(04/2018)");
    }//GEN-LAST:event_subMenuSobreActionPerformed

    private void subMenuComoUsarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuComoUsarActionPerformed
        JOptionPane.showMessageDialog(null, "\n               ESCOLHA UM DATASET\n\n"
                                             + "+ Escolha um dataset pré-definido, ou\n+ Crie o seu próprio dataset\n\n"
                                             + "               INICIE O TREINAMENTO\n\n"
                                             + "+ Escolha entre pular para o resultado final, ou  \n+ Assista o treinamento a cada iteração\n\n");
                                             
    }//GEN-LAST:event_subMenuComoUsarActionPerformed

    private void subMenuIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuIniciarActionPerformed
        menuDataset.setEnabled(false);
        
        subMenuIniciar.setEnabled(false);
        subMenuParar.setEnabled(true);
        subMenuCriarDataset.setEnabled(false);
        subMenuDeletarDataset.setEnabled(false);
        
        cmbBoxDataset.setEnabled(true);        
        adicionarDatasetsNaComboBox();
        
        btnParar.setEnabled(true);
        btnEscolher.setEnabled(true);
        
        mudaBalaoDialogo("balaoDialogoEscolha.png");
    }//GEN-LAST:event_subMenuIniciarActionPerformed

    private void subMenuCriarDatasetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuCriarDatasetActionPerformed
        FormCriarDataset formDataset = new FormCriarDataset(this, true);
    }//GEN-LAST:event_subMenuCriarDatasetActionPerformed

    private void subMenuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuSairActionPerformed
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_subMenuSairActionPerformed

    private void subMenuDeletarDatasetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuDeletarDatasetActionPerformed
        try {
            DeletarDataset formDeletar = new DeletarDataset(this, true);
        } catch (WindowException ex) {
            JOptionPane.showMessageDialog(null, "Não há nenhum dataset personalizado para excluir!");
        }
    }//GEN-LAST:event_subMenuDeletarDatasetActionPerformed

    private void menuTreinamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTreinamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuTreinamentoActionPerformed

    private void subMenuPararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuPararActionPerformed
        menuDataset.setEnabled(true);
        
        subMenuIniciar.setEnabled(true);
        subMenuParar.setEnabled(false);
        subMenuCriarDataset.setEnabled(true);
        subMenuDeletarDataset.setEnabled(true);
        
        cmbBoxDataset.removeAllItems();
        cmbBoxDataset.setEnabled(false);
        
        btnEscolher.setEnabled(false);
        btnParar.setEnabled(false);
        btnProximaEpoca.setEnabled(false);

        lblAvisoDataset.setVisible(false);
        lblContaEpocas.setText("ÉPOCA: 0");
        
        Figura.setTotalFiguras(0);
        Forma.setTotalFormas(0);
        Cor.setTotalCores(0);
        
        for(javax.swing.JLabel label : listaLblFiguras) {
            label.setVisible(false);
            label.setEnabled(false);
        }
        
        for(javax.swing.JLabel label : listaLblNeuronios) {
            label.setVisible(false);
        }
        
        for(javax.swing.JLabel label : listaLblReconhece) {
            label.setText("");
            label.setVisible(false);
        }
        
        for(javax.swing.JLabel label : listaLblTextoFiguras) {
            label.setText("");
            label.setEnabled(false);
            label.setVisible(false);
        }
                
         for(javax.swing.JLabel label : listaLblResposta) {
            label.setText("");
            label.setVisible(false);
        }
        
        mudaBalaoDialogo("balaoDialogoPadrao.png");
    }//GEN-LAST:event_subMenuPararActionPerformed

    private void btnPararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPararActionPerformed
        subMenuPararActionPerformed(evt);
    }//GEN-LAST:event_btnPararActionPerformed

    private void btnEscolherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEscolherActionPerformed
        File dataset = new File(".\\src\\dataset\\" + cmbBoxDataset.getSelectedItem().toString());
        
        cmbBoxDataset.setEnabled(false);
        
        btnEscolher.setEnabled(false);
        btnProximaEpoca.setEnabled(true);
        
        mudaBalaoDialogo("balaoDialogoIniciarTreinamento.png");
        
        /* descobrir qual método de treinamento */

        try {
            
            treinador = new Treinamento(dataset);
            

            for(int i = 0; i < Figura.getTotalFiguras() && i < 10; i++) {

                //Pega as imagens de forma e cor para desenhá-las no form
                String pathForma = ".\\src\\imagens\\forma" + tirarAcentos(treinador.getListaFiguras().get(i).getForma().getNome()) + ".png";
                String pathCor = ".\\src\\imagens\\cor" + tirarAcentos(treinador.getListaFiguras().get(i).getCor().getNome()) + ".png";

                try {
                    //Carrega as imagens
                    BufferedImage image = ImageIO.read(new File(pathCor));
                    BufferedImage image2 = ImageIO.read(new File(pathForma));
                    int w = image2.getWidth();
                    int h = image2.getHeight();

                    //Obtém o Graphics2D da imagem 1 (fundo), para desenhar sobre ela
                    Graphics2D graphics = image.createGraphics();
                    graphics.drawImage(image2, 0, 0, w, h, null);
                    graphics.dispose(); //Libera os recursos ocupados pela "Caneta"

                    //Use esse ImageIcon para desenhar no form
                    ImageIcon icon = new ImageIcon(image);
                    //icon.paintIcon(lblTeste, graphics, 50, 50);
                    listaLblFiguras.get(i).setIcon(icon);
                    
                    listaLblTextoFiguras.get(i).setText("<html><center>" +treinador.getListaFiguras().get(i).getForma().getNome() + "<br>" + treinador.getListaFiguras().get(i).getCor().getNome());
                    listaLblTextoFiguras.get(i).setEnabled(true);
                    listaLblTextoFiguras.get(i).setVisible(true);
                    listaLblFiguras.get(i).setVisible(true);
                    listaLblFiguras.get(i).setEnabled(true);

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Não foi possível encontrar as imagens do projeto.\n\n"
                            + "Baixe o projeto funcional na íntegra em:\n"
                            + "https://github.com/rodrigopontezz/RedeNeuralFiguras\n");
                }
            }                

            if (Figura.getTotalFiguras() > 10)  lblAvisoDataset.setVisible(true);

            for (int i = 0; i < (Forma.getTotalFormas()+Cor.getTotalCores()) ; i++) {
                ImageIcon icon = new ImageIcon(".\\src\\imagens\\neuronioAzul.png");
                listaLblNeuronios.get(i).setIcon(icon);
                listaLblNeuronios.get(i).setVisible(true);

                if (i < Forma.getTotalFormas())  listaLblReconhece.get(i).setText("<html><center>Reconhece<br>" + treinador.getListaFormas().get(i).getNome());
                else  listaLblReconhece.get(i).setText("<html><center>Reconhece<br>" + treinador.getListaCores().get(i-Forma.getTotalFormas()).getNome());

                listaLblReconhece.get(i).setVisible(true);
            }
        } catch (TreinamentoException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            btnPararActionPerformed(evt);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnEscolherActionPerformed

    private void menuDatasetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDatasetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuDatasetActionPerformed

    private void lblFigura1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFigura1MouseClicked
         mudaNeuronios(0);
    }//GEN-LAST:event_lblFigura1MouseClicked

    private void btnProximaEpocaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProximaEpocaActionPerformed
        boolean resultado = this.treinador.treinar();
        lblContaEpocas.setText("ÉPOCA: " + this.treinador.getEpoca());
        mudaNeuronios(0);
       
        
        if (resultado) {
            mudaBalaoDialogo("balaoDialogoNeuroniosErraram.png");
        } else {
            btnProximaEpoca.setEnabled(false);
            mudaBalaoDialogo("balaoDialogoNeuroniosAcertaram.png");
        }
    }//GEN-LAST:event_btnProximaEpocaActionPerformed

    private void lblTextoFigura1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTextoFigura1MouseClicked
        mudaNeuronios(0);
    }//GEN-LAST:event_lblTextoFigura1MouseClicked

    private void lblFigura2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFigura2MouseClicked
        mudaNeuronios(1);
    }//GEN-LAST:event_lblFigura2MouseClicked

    private void lblTextoFigura2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTextoFigura2MouseClicked
         mudaNeuronios(1);
    }//GEN-LAST:event_lblTextoFigura2MouseClicked

    private void lblTextoFigura3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTextoFigura3MouseClicked
         mudaNeuronios(2);
    }//GEN-LAST:event_lblTextoFigura3MouseClicked

    private void lblFigura3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFigura3MouseClicked
         mudaNeuronios(2);
    }//GEN-LAST:event_lblFigura3MouseClicked

    private void lblTextoFigura4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTextoFigura4MouseClicked
         mudaNeuronios(3);
    }//GEN-LAST:event_lblTextoFigura4MouseClicked

    private void lblFigura4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFigura4MouseClicked
         mudaNeuronios(3);
    }//GEN-LAST:event_lblFigura4MouseClicked

    private void lblTextoFigura5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTextoFigura5MouseClicked
         mudaNeuronios(4);
    }//GEN-LAST:event_lblTextoFigura5MouseClicked

    private void lblFigura5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFigura5MouseClicked
         mudaNeuronios(4);
    }//GEN-LAST:event_lblFigura5MouseClicked

    private void lblTextoFigura6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTextoFigura6MouseClicked
         mudaNeuronios(5);
    }//GEN-LAST:event_lblTextoFigura6MouseClicked

    private void lblFigura6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFigura6MouseClicked
         mudaNeuronios(5);
    }//GEN-LAST:event_lblFigura6MouseClicked

    private void lblTextoFigura7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTextoFigura7MouseClicked
         mudaNeuronios(6);
    }//GEN-LAST:event_lblTextoFigura7MouseClicked

    private void lblFigura7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFigura7MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lblFigura7MouseEntered

    private void lblFigura7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFigura7MouseClicked
         mudaNeuronios(6);
    }//GEN-LAST:event_lblFigura7MouseClicked

    private void lblTextoFigura8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTextoFigura8MouseClicked
         mudaNeuronios(7);
    }//GEN-LAST:event_lblTextoFigura8MouseClicked

    private void lblFigura8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblFigura8KeyPressed
         
    }//GEN-LAST:event_lblFigura8KeyPressed

    private void lblTextoFigura9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTextoFigura9MouseClicked
         mudaNeuronios(8);
    }//GEN-LAST:event_lblTextoFigura9MouseClicked

    private void lblFigura9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFigura9MouseClicked
         mudaNeuronios(8);
    }//GEN-LAST:event_lblFigura9MouseClicked

    private void lblTextoFigura10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTextoFigura10MouseClicked
         mudaNeuronios(9);
    }//GEN-LAST:event_lblTextoFigura10MouseClicked

    private void lblFigura10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFigura10MouseClicked
         mudaNeuronios(9);
    }//GEN-LAST:event_lblFigura10MouseClicked

    private void lblFigura8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFigura8MouseClicked
         mudaNeuronios(7);
    }//GEN-LAST:event_lblFigura8MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            verificaArquivosNecessarios();
            
            /* Set the Nimbus look and feel */
            //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
            /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
             * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
             */
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>
            //</editor-fold>

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {

                @Override
                public void run() {
                    App form = new App();
                    form.setLocationRelativeTo(null);
                    form.setVisible(true);
                }
            });
        } catch (IOException | InitException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage()
                    + "\n\nBaixe o projeto funcional na íntegra em:\n"
                    + "https://github.com/rodrigopontezz/RedeNeuralFiguras\n");
        }
    }
    
    public static void verificaArquivosNecessarios() throws IOException, InitException {
        File file = new File(".\\src\\dataset");
        if (!file.exists())  throw new InitException("Diretório src/dataset não encontrado.");
        
        file = new File(".\\src\\imagens");
        if (!file.exists())  throw new InitException("Diretório src/imagens não encontrado.");
        
        int check = 0;
        
        for (File fileEntry : file.listFiles()) {
            if (fileEntry.getName().equals("balaoDialogoEscolha.png") ||
                    fileEntry.getName().equals("balaoDialogoIniciarTreinamento.png") ||
                    fileEntry.getName().equals("balaoDialogoNeuroniosAcertaram.png") ||
                    fileEntry.getName().equals("balaoDialogoNeuroniosErraram.png") ||
                    fileEntry.getName().equals("balaoDialogoPadrao.png") ||
                    fileEntry.getName().equals("corAmarelo.png") ||
                    fileEntry.getName().equals("corAzul.png") ||
                    fileEntry.getName().equals("corPreto.png") ||
                    fileEntry.getName().equals("corRosa.png") ||
                    fileEntry.getName().equals("corVerde.png") ||
                    fileEntry.getName().equals("corVermelho.png") ||
                    fileEntry.getName().equals("formaCirculo.png") ||
                    fileEntry.getName().equals("formaCoracao.png") ||
                    fileEntry.getName().equals("formaEstrela.png") ||
                    fileEntry.getName().equals("formaQuadrado.png") ||
                    fileEntry.getName().equals("formaTrapezio.png") ||
                    fileEntry.getName().equals("formaTriangulo.png")) check++;
        }
        
        if (check != 17) throw new InitException("Diretório src/imagens está corrompido.");
        
        file = new File(".\\src\\dataset\\figuras.txt");
        
        PrintWriter pw = new PrintWriter(new FileWriter(file));
        
        pw.println("Triângulo Amarelo");
        pw.println("Círculo Azul");
        pw.println("Estrela Amarelo");
        pw.println("Coração Vermelho");
        pw.println("Trapézio Preto");
        pw.println("Triângulo Rosa");
        pw.println("Círculo Vermelho");
        pw.print("Quadrado Verde");
        pw.close();
    }
    
    public void adicionarDatasetsNaComboBox() {
        File folder = new File(".\\src\\dataset");
        
        if (folder.listFiles().length <  3) {
            JOptionPane.showMessageDialog(null, "Não foi possível acessar os arquivos de dataset.\n\n"
                    + "Baixe o projeto funcional na íntegra em:\n"
                    + "https://github.com/rodrigopontezz/RedeNeuralFiguras\n");
            throw new WindowException();
        } else {
            for (final File fileEntry : folder.listFiles()) {
                if (fileEntry.isFile()) {
                    String nomeDataset = fileEntry.getName();
                    
                    if (!nomeDataset.equals("formas.txt") && !nomeDataset.equals("cores.txt")) {
                        cmbBoxDataset.addItem(nomeDataset);
                    }
                }
            }
        }
    }
    
    public void mudaBalaoDialogo(String nomeImagem) {
        ImageIcon icon = new ImageIcon(".\\src\\imagens\\" + nomeImagem);
        lblDialogo.setIcon(icon);
    }
    
    public static String tirarAcentos(String str) {
        String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD); 
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("");
    }

    public void mudaNeuronios (int figura) {
        int palpiteForma = treinador.getListaFiguras().get(figura).getForma().getId();
        int palpiteCor = treinador.getListaFiguras().get(figura).getCor().getId();
        
        int i = 0;
        for (javax.swing.JLabel label : listaLblResposta) {
            if (i < Forma.getTotalFormas()) {
                
                if (treinador.getListaNeuroniosForma().get(i).getPalpiteAt(palpiteForma) == '1') {
                    label.setText("<html><center>É<br>" + treinador.getListaFormas().get(i).getNome() + "!");
                } else {
                    label.setText("<html><center>Não é<br>" + treinador.getListaFormas().get(i).getNome() + "...");
                }
                
                if (treinador.getListaNeuroniosForma().get(i).acertouPalpite(palpiteForma)) {
                    ImageIcon icon = new ImageIcon(".\\src\\imagens\\neuronioVerde.png");
                    listaLblNeuronios.get(i).setIcon(icon);
                } else {
                    ImageIcon icon = new ImageIcon(".\\src\\imagens\\neuronioVermelho.png");
                    listaLblNeuronios.get(i).setIcon(icon);
                }
            }
            else if ((i - Forma.getTotalFormas()) < Cor.getTotalCores()) {
                if (treinador.getListaNeuroniosCor().get(i - Forma.getTotalFormas()).getPalpiteAt(palpiteCor) == '1') {
                    label.setText("<html><center>É<br>" + treinador.getListaCores().get(i - Forma.getTotalFormas()).getNome() + "!");
                } else {
                    label.setText("<html><center>Não é<br>" + treinador.getListaCores().get(i - Forma.getTotalFormas()).getNome() + "...");
                }
                
                if (treinador.getListaNeuroniosCor().get((i-Forma.getTotalFormas())).acertouPalpite(palpiteCor)) {
                    ImageIcon icon = new ImageIcon(".\\src\\imagens\\neuronioVerde.png");
                    listaLblNeuronios.get(i).setIcon(icon);
                } else {
                    ImageIcon icon = new ImageIcon(".\\src\\imagens\\neuronioVermelho.png");
                    listaLblNeuronios.get(i).setIcon(icon);
                }
            }
            else break;
            i++;
                       
            label.setVisible(true);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JButton btnEscolher;
    private javax.swing.JButton btnParar;
    private javax.swing.JButton btnProximaEpoca;
    private javax.swing.JComboBox<String> cmbBoxDataset;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblAvisoDataset;
    private javax.swing.JLabel lblContaEpocas;
    private javax.swing.JLabel lblDataset;
    private javax.swing.JLabel lblDialogo;
    private javax.swing.JLabel lblFigura1;
    private javax.swing.JLabel lblFigura10;
    private javax.swing.JLabel lblFigura2;
    private javax.swing.JLabel lblFigura3;
    private javax.swing.JLabel lblFigura4;
    private javax.swing.JLabel lblFigura5;
    private javax.swing.JLabel lblFigura6;
    private javax.swing.JLabel lblFigura7;
    private javax.swing.JLabel lblFigura8;
    private javax.swing.JLabel lblFigura9;
    private javax.swing.JLabel lblNeuronio1;
    private javax.swing.JLabel lblNeuronio10;
    private javax.swing.JLabel lblNeuronio11;
    private javax.swing.JLabel lblNeuronio12;
    private javax.swing.JLabel lblNeuronio2;
    private javax.swing.JLabel lblNeuronio3;
    private javax.swing.JLabel lblNeuronio4;
    private javax.swing.JLabel lblNeuronio5;
    private javax.swing.JLabel lblNeuronio6;
    private javax.swing.JLabel lblNeuronio7;
    private javax.swing.JLabel lblNeuronio8;
    private javax.swing.JLabel lblNeuronio9;
    private javax.swing.JLabel lblReconhece1;
    private javax.swing.JLabel lblReconhece10;
    private javax.swing.JLabel lblReconhece11;
    private javax.swing.JLabel lblReconhece12;
    private javax.swing.JLabel lblReconhece2;
    private javax.swing.JLabel lblReconhece3;
    private javax.swing.JLabel lblReconhece4;
    private javax.swing.JLabel lblReconhece5;
    private javax.swing.JLabel lblReconhece6;
    private javax.swing.JLabel lblReconhece7;
    private javax.swing.JLabel lblReconhece8;
    private javax.swing.JLabel lblReconhece9;
    private javax.swing.JLabel lblResposta1;
    private javax.swing.JLabel lblResposta10;
    private javax.swing.JLabel lblResposta11;
    private javax.swing.JLabel lblResposta12;
    private javax.swing.JLabel lblResposta2;
    private javax.swing.JLabel lblResposta3;
    private javax.swing.JLabel lblResposta4;
    private javax.swing.JLabel lblResposta5;
    private javax.swing.JLabel lblResposta6;
    private javax.swing.JLabel lblResposta7;
    private javax.swing.JLabel lblResposta8;
    private javax.swing.JLabel lblResposta9;
    private javax.swing.JLabel lblTextoFigura1;
    private javax.swing.JLabel lblTextoFigura10;
    private javax.swing.JLabel lblTextoFigura2;
    private javax.swing.JLabel lblTextoFigura3;
    private javax.swing.JLabel lblTextoFigura4;
    private javax.swing.JLabel lblTextoFigura5;
    private javax.swing.JLabel lblTextoFigura6;
    private javax.swing.JLabel lblTextoFigura7;
    private javax.swing.JLabel lblTextoFigura8;
    private javax.swing.JLabel lblTextoFigura9;
    private javax.swing.JMenu menuAjuda;
    private javax.swing.JMenu menuDataset;
    private javax.swing.JMenu menuTreinamento;
    private javax.swing.JSeparator separador;
    private javax.swing.JMenuItem subMenuComoUsar;
    private javax.swing.JMenuItem subMenuCriarDataset;
    private javax.swing.JMenuItem subMenuDeletarDataset;
    private javax.swing.JMenuItem subMenuIniciar;
    private javax.swing.JMenuItem subMenuParar;
    private javax.swing.JMenuItem subMenuSair;
    private javax.swing.JMenuItem subMenuSobre;
    // End of variables declaration//GEN-END:variables
}