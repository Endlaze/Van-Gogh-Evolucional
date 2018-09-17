package gui;

import fitness.fitness_factory.FitnessFactory;
import fitness.fitness_factory.IFitness;
import fitness.fitness_ut.Test_Euclidean;
import fitness.fitness_ut.Test_MSE;
import fitness.fitness_utils.GrayScaleFilter;
import geneticAlgorithm.GeneticAlgorithm;
import geneticAlgorithm.Population;
import org.jfree.ui.RefineryUtilities;
import utils.FileManager;
import utils.ImageParser;
import utils.Sort;
import utils.XYSeriesDemo;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;

public class GUI extends javax.swing.JPanel {

    private javax.swing.JLabel title = new javax.swing.JLabel();
    private javax.swing.JLabel imagePathLabel = new javax.swing.JLabel();
    private javax.swing.JButton startGeneticAlgorithm = new javax.swing.JButton();
    private javax.swing.JLabel metaImageLabel = new javax.swing.JLabel();
    private javax.swing.JComboBox algorithmSelection = new javax.swing.JComboBox<>();
    private javax.swing.JLabel fittestImageLabel = new javax.swing.JLabel();
    public javax.swing.JPanel Visualization = new javax.swing.JPanel();
    private javax.swing.JPanel Params = new javax.swing.JPanel();
    private javax.swing.JPanel jPanel3 = new javax.swing.JPanel();
    private javax.swing.JTextField mutationPercent = new javax.swing.JTextField();
    private javax.swing.JTextField crossoverPercent = new javax.swing.JTextField();
    private javax.swing.JTextField generations = new javax.swing.JTextField();
    private javax.swing.JTextField imagePathTextField = new javax.swing.JTextField();
    private javax.swing.JTextField populationSize = new javax.swing.JTextField();

    private javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
    private javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
    private javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
    private javax.swing.JLabel jLabel7 = new javax.swing.JLabel();
    private javax.swing.JLabel jLabel8 = new javax.swing.JLabel();
    private javax.swing.JLabel jLabel9 = new javax.swing.JLabel();
    private javax.swing.JLabel jLabel10 = new javax.swing.JLabel();
    private javax.swing.JLabel jLabel12 = new javax.swing.JLabel();
    private javax.swing.JLabel worstPercentLabel = new javax.swing.JLabel();
    private javax.swing.JTextField worstPercent = new javax.swing.JTextField();

    private javax.swing.JLabel algoritmo = new javax.swing.JLabel();



    private boolean startGenetics = false;

    private void setStartGenetics(boolean startGenetics){
        this.startGenetics = startGenetics;
    }
    public boolean getStartGenetics(){
        return this.startGenetics;
    }





    public GUI() {
        initComponents();
    }


    private void initComponents() {

        algoritmo.setText("Algoritmo: ");

        algorithmSelection.addItem("Euclidean");
        algorithmSelection.addItem("MSE");
        algorithmSelection.addItem("Our algorithm");


        startGeneticAlgorithm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent)  {
                setStartGenetics(true);

            }
        });

        setPreferredSize(new java.awt.Dimension(600, 400));

        title.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Van Gogh Evolutional");
        title.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(215, 215, 215)
                                .addComponent(title)
                                .addContainerGap(214, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(title)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Visualization.setPreferredSize(new java.awt.Dimension(295, 295));

        metaImageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        metaImageLabel.setFocusable(false);
        metaImageLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        fittestImageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fittestImageLabel.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createCompoundBorder()));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Meta");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Fittest");

        jLabel10.setText("Fitness Algorithm");

        javax.swing.GroupLayout VisualizationLayout = new javax.swing.GroupLayout(Visualization);
        Visualization.setLayout(VisualizationLayout);
        VisualizationLayout.setHorizontalGroup(
                VisualizationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(VisualizationLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(VisualizationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(VisualizationLayout.createSequentialGroup()
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VisualizationLayout.createSequentialGroup()
                                                .addGroup(VisualizationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(metaImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(VisualizationLayout.createSequentialGroup()
                                                                .addGap(30, 30, 30)
                                                                .addComponent(jLabel10)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(VisualizationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(fittestImageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 100, 100)
                                                        .addComponent(algorithmSelection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(27, 27, 27))
        );
        VisualizationLayout.setVerticalGroup(
                VisualizationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(VisualizationLayout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(VisualizationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(VisualizationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(metaImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fittestImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(VisualizationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel10)
                                        .addComponent(algorithmSelection))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))


        );






        Params.setPreferredSize(new java.awt.Dimension(287, 100));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Genetic Algorithm Params");
        jLabel7.setText("Mutation %");
        jLabel8.setText("Crossover %");
        jLabel9.setText("Generations");
        jLabel12.setText("Population size");
        worstPercentLabel.setText("Worst Individuals %");

        imagePathLabel.setText("Image Path");
        algoritmo.setText("Algoritmo");

        startGeneticAlgorithm.setText("Start");

        javax.swing.GroupLayout ParamsLayout = new javax.swing.GroupLayout(Params);
        Params.setLayout(ParamsLayout);
        ParamsLayout.setHorizontalGroup(
                ParamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ParamsLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                        .addComponent(imagePathLabel)
                                        .addGap(22, 22, 22)
                                .addComponent(imagePathTextField)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                )
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ParamsLayout.createSequentialGroup()
                                .addContainerGap(71, Short.MAX_VALUE)
                                .addGroup(ParamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ParamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ParamsLayout.createSequentialGroup()
                                                        .addComponent(jLabel6)
                                                        .addGap(68, 68, 68))
                                                .addGroup(ParamsLayout.createSequentialGroup()
                                                        .addGroup(ParamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ParamsLayout.createSequentialGroup()
                                                                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                                                        .addGap(17, 17, 25)
                                                                        .addComponent(generations, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ParamsLayout.createSequentialGroup()
                                                                        .addGroup(ParamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addGroup(ParamsLayout.createSequentialGroup()
                                                                                        .addComponent(jLabel8)
                                                                                        .addGap(17, 17, 100))
                                                                                .addGroup(GroupLayout.Alignment.TRAILING, ParamsLayout.createSequentialGroup()
                                                                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addGap(17, 17, 100)))
                                                                        .addGap(1, 1, 1)
                                                                        .addGroup(ParamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                .addComponent(crossoverPercent, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                                                                .addComponent(mutationPercent)))
                                                                .addGroup(ParamsLayout.createSequentialGroup()
                                                                        .addComponent(jLabel12)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addComponent(populationSize)))
                                                        .addContainerGap()))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ParamsLayout.createSequentialGroup()
                                                .addComponent(startGeneticAlgorithm)
                                                .addGap(107, 107, 107))))
        );
        ParamsLayout.setVerticalGroup(
                ParamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ParamsLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addGroup(ParamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(mutationPercent, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)
                                .addGroup(ParamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(crossoverPercent, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addGroup(ParamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9)
                                        .addComponent(generations, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(ParamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel12)
                                        .addComponent(populationSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                                .addGroup(ParamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(imagePathLabel)
                                        .addComponent(imagePathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        )
                                .addGap(18, 18, 18)
                                .addComponent(startGeneticAlgorithm)
                                .addContainerGap())

        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(Visualization, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(5, 5, 5)
                                                .addComponent(Params, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(Params, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                                        .addComponent(Visualization, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

    }

    public void setMetaImageLabel(BufferedImage image){
         this.metaImageLabel.setIcon(new ImageIcon(image));
    }

    public void setFittestImageLabel(BufferedImage image) {
        this.fittestImageLabel.setIcon(new ImageIcon(image));
    }

    public String getFitnessAlgorithm(){
        return this.algorithmSelection.getSelectedItem().toString().toUpperCase();

    }

    public double getCrossoverPercent() {
        return Double.parseDouble(this.crossoverPercent.getText());
    }
    public double getMutationPercent(){
        return  Double.parseDouble(this.mutationPercent.getText());
    }
    public int getPopulationSize(){
        return Integer.parseInt(this.populationSize.getText());
    }
    public String getImagePath(){
        return this.imagePathTextField.getText();
    }
    public int getGenerations(){
        return Integer.parseInt(this.generations.getText());
    }






}