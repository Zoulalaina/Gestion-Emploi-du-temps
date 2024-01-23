package Gestion;
import javax.swing.*;
import java.awt.*;

public class TableauDePanels extends JFrame {
	 JPanel[][] panels = new JPanel[2][6];
    public TableauDePanels() {
        setTitle("Tableau de JPanels");
        setDefaultCloseOperation(TableauDePanels.EXIT_ON_CLOSE);
        setSize(600, 400);

        // Création du tableau bidimensionnel de JPanels
        

        // Création et ajout des JPanels avec JLabels pour les jours de la semaine au tableau
        String[] joursSemaine = {"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi"};

        for (int i = 0; i < panels.length; i++) {
            for (int j = 0; j < panels[i].length; j++) {
                panels[i][j] = new JPanel();
                panels[i][j].setBackground(Color.lightGray);

                // Ajout d'un JLabel avec le nom du jour
                JLabel label = new JLabel(joursSemaine[j]);
                panels[i][j].add(label);

                add(panels[i][j]);
                GridLayout grille = new GridLayout (5, 1) ;
                panels[i][j].setLayout ( grille ) ;
              
            }
        }

        // Mise en page en 2 lignes et 5 colonnes avec GridLayout
        setLayout(new GridLayout(2, 6));

        // Affichage de la fenêtre
        //setVisible(true);
        
    }
    void remove() {
    	for (int i = 0; i < panels.length; i++) {
            for (int j = 0; j < panels[i].length; j++) {
                panels[i][j].removeAll();
              
            }
        }
    	
    }

    
}