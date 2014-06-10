/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wireworld;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.border.LineBorder;
import static wireworld.ObsługaSiatki.odczytdanych;

/**
 *
 * @author Kamilka
 */
public class Wyświetlacz extends javax.swing.JFrame {

    private javax.swing.JMenuItem Exit;
    private javax.swing.JMenuItem Open;
    private javax.swing.JMenu jMenu;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JFileChooser fileChooser;
    public Siatka siatka = new Siatka();
    DrawPanel panel = new DrawPanel();
    public JButton start;
    public ObsługaSiatki obsługa = new ObsługaSiatki();

    public Wyświetlacz() {
        initComponents();
    }

    private void initComponents() {
        this.setLayout(new FlowLayout());
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jMenuBar = new javax.swing.JMenuBar();
        jMenu = new javax.swing.JMenu();
        Open = new javax.swing.JMenuItem();
        Exit = new javax.swing.JMenuItem();
        fileChooser = new JFileChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jMenu.setText("File");

        Open.setText("Open");
        Open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    OpenActionPerformed(evt);
                } catch (IOException ex) {
                    Logger.getLogger(Wyświetlacz.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        jMenu.add(Open);

        Exit.setText("Exit");
        jMenu.add(Exit);

        jMenuBar.add(jMenu);

        setJMenuBar(jMenuBar);
        /*
         javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
         getContentPane().setLayout(layout);
         layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGap(0, 400, Short.MAX_VALUE)
         );
         layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGap(0, 300, Short.MAX_VALUE)
         );
         */
        start = new JButton("start");
        start.setPreferredSize(new Dimension(100, 100));
        this.add(start);
        start.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    startMouseClicked(evt);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Wyświetlacz.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        panel.siatka = siatka;
        panel.setBorder(new LineBorder(Color.black, 1, true));
        panel.setBounds(0, 0, 500, 500);
        panel.setLayout(new GridLayout());
        panel.setPreferredSize(new Dimension(1000, 500));
        this.add(panel);

        pack();
    }// </editor-fold>    

    private void OpenActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            FileReader f = new FileReader(file);
            try {
                odczytdanych(f, panel.siatka);

            } catch (FileNotFoundException ex) {
                System.out.println("problem accessing file" + file.getAbsolutePath());
            }
        } else {
            System.out.println("File access cancelled by user.");
        }
    }

    private void startMouseClicked(java.awt.event.MouseEvent evt) throws InterruptedException {
        new Thread() {
            @Override
            public void run() {
                int generacje = 5;

                for (int i = 1; i < generacje + 1; i++) {
                    try {
                        Siatka nowaSiatka = ObsługaSiatki.nowaSiatka(panel.siatka);
                        panel.siatka = nowaSiatka;
                        TimeUnit.SECONDS.sleep(3);
                        panel.repaint();
                       
            ObsługaSiatki.zapisz(nowaSiatka, "plik", i);

                    } catch (InterruptedException | IOException ex) {
                        Logger.getLogger(Wyświetlacz.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        }.start();
    }
}
