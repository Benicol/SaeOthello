/*
 * Controleur.java                                      26 2023
 * IUT Rodez, info1 2022-2023, pas de copyright ni "copyleft" 
 */
package principal;

import principal.modele.Plateau;
import principal.modele.SetCouleur;
import principal.modele.Joueur;

import java.util.Stack;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

/**
 * TODO comment class responsibility (SRP)
 * 
 * @author Groupe 32
 *
 */
public class Controleur {
    
    private SetCouleur couleurs = new SetCouleur("#FFFFFF", "#000000");
    
    @FXML
    private void initialize() {
        updateScore();
        nomJoueur1.setStyle("-fx-text-fill: " + couleurs.getCouleurJ1() + "; "
                            + "-fx-background-color: #75BB99;");
        nomJoueur2.setStyle("-fx-text-fill: " + couleurs.getCouleurJ2() + "; "
                            + "-fx-background-color: #75BB99;");
        scoreJoueur1.setStyle("-fx-text-fill: " + couleurs.getCouleurJ1() + "; "
                            + "-fx-background-color: #75BB99;");
        scoreJoueur2.setStyle("-fx-text-fill: " + couleurs.getCouleurJ2() + "; "
                            + "-fx-background-color: #75BB99;");
        nomJoueur1.setText(joueur1.getPseudo());
        nomJoueur2.setText(joueur2.getPseudo());
        creerCercle(4, 3);
        creerCercle(3, 3);
        creerCercle(3, 4);
        creerCercle(4, 4);
    }
    
    
    
    private Plateau plateauJeu = new Plateau(couleurs);
    
    
    private Joueur joueur1 = new Joueur("chubakah");
    
    private Joueur joueur2 = new Joueur("Jedi");
    
    private Circle[][] cercles = new Circle[8][8];
    
    @FXML
    private TextField nomJoueur1;

    @FXML
    private TextField scoreJoueur1;

    @FXML
    private TextField nomJoueur2;

    @FXML
    private TextField scoreJoueur2;

    @FXML
    private Button menu;

    @FXML
    private GridPane grille;

    @FXML
    private Button passerTour;

    @FXML
    private Circle couleurJoueurActif;
    
    @FXML
    void testing(ActionEvent event) {
        plateauJeu.test();
    }
    
    @FXML
    void nodePressed(ActionEvent event) {
        Button btn = (Button) event.getSource();
        btn.setDisable(true);
        Integer x = GridPane.getColumnIndex((Node) event.getSource());
        x = x == null ? 0 : x;
        Integer y = GridPane.getRowIndex((Node) event.getSource());
        y = y == null ? 0 : y;
        int[][] tmp = plateauJeu.retournerJetons(x, y);
        for (int[] element : tmp) {
            changeCouleur(element[0], element[1]);
        }
        creerCercle(x, y);
    }
    
    @FXML
    void passerSonTour(ActionEvent event) {
        changeCouleurJoueurActif();
    }
    
    /** TODO comment method role
     * @param x
     * @param y
     */
    void creerCercle(Integer x, Integer y) {
        Circle cercle = new Circle(0,0,18);
        GridPane.setHalignment(cercle, HPos.CENTER);
        Paint couleur = Paint.valueOf(couleurs.getCouleurActive());
        cercle.setFill(couleur);
        plateauJeu.jetonExiste(x, y, couleur);
        if (couleur.equals(Paint.valueOf(couleurs.getCouleurJ1()))) {
            joueur2.incrementer(1);
        } else {
            joueur1.incrementer(1);
        }
        updateScore();
        cercles[x][y] = cercle;
        grille.add(cercle, x, y);
        changeCouleurJoueurActif();
    }
    
    void changeCouleurJoueurActif() {
        couleurs.switchCouleurActive();
        couleurJoueurActif.setFill(Paint.valueOf(couleurs.getCouleurActive()));
    }
    
    void changeCouleurJ1(int x, int y) {
        cercles[x][y].setFill(Paint.valueOf(couleurs.getCouleurJ1()));
        //TODO : changer dans modele
    }
    
    void changeCouleurJ2(int x, int y) {
        cercles[x][y].setFill(Paint.valueOf(couleurs.getCouleurJ2()));
    }
    
    void changeCouleur(int x, int y) {
        if (cercles[x][y].getFill().equals(
                Paint.valueOf(couleurs.getCouleurJ1()))) {
            changeCouleurJ2(x, y);
            
        } else {
            changeCouleurJ1(x, y);
        }
    }
    
    void updateScore() {
        scoreJoueur1.setText(Integer.toString(joueur1.getScore()));
        scoreJoueur2.setText(Integer.toString(joueur2.getScore()));
    }
 
}