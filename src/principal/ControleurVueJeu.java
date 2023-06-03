/*
 * ControleurVueJeu.java                                      26 2023
 * IUT Rodez, info1 2022-2023, pas de copyright ni "copyleft" 
 */
package principal;

import principal.modele.Plateau;
import principal.modele.Theme;
import principal.modele.Joueur;
import principal.modele.Modele;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

/**
 * TODO comment class responsibility (SRP)
 * 
 * @author Groupe 32
 *
 */
public class ControleurVueJeu {
    
    private Theme couleurs = Modele.getPalette();
    
    private Plateau plateauJeu = new Plateau(couleurs);
    
    private Joueur joueur1 = new Joueur(Modele.getPseudoJ1());
    
    private Joueur joueur2 = new Joueur(Modele.getPseudoJ2());
    
    private Circle[][] cercles = new Circle[8][8];
    
    private Button[][] buttons = new Button[8][8];
    
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
    private void initialize() {
        registerBouttons();
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
    
    @FXML
    void nodePressed(ActionEvent event) {
        Button btn = (Button) event.getSource();
        btn.setDisable(true);
        int[]coords = getNodeCoords((Node) event.getSource());
        int[][] tmp = plateauJeu.retournerJetons(coords[0], coords[1]);
        for (int[] element : tmp) {
            changeCouleur(element[0], element[1]);
        }
        creerCercle(coords[0], coords[1]);
    }
    
    @FXML
    void passerSonTour(ActionEvent event) {
        changeCouleurJoueurActif();
        NouveauJouables(couleurs.getCouleurActive());
    }
    
    @FXML
    void menuTest(ActionEvent event) {
        System.out.println("boutonMenuAppuyer");
        EchangeurDeVue.echangerAvec(0, 700, 600);
        EchangeurDeVue.supprimerCache(1);
    }
    
    void registerBouttons() {
        List<Node> buttonsNodes = grille.getChildren().subList(0, 64);
        int[] coords = new int[2];
        for (int i = 0; i < buttonsNodes.size(); i++) {
            coords = getNodeCoords(buttonsNodes.get(i));
            buttons[coords[0]][coords[1]] = (Button) buttonsNodes.get(i);
        }
    }
    
    @FXML
    void buttonEntered(MouseEvent event) {
        Button boutton = (Button) event.getSource();
        String beforeStyle = boutton.getStyle();
        int premierePointVirgule = beforeStyle.indexOf(";") + 1;
        boutton.setStyle("-fx-background-color: #60A383;"
                         + beforeStyle.substring(premierePointVirgule,
                                                         beforeStyle.length()));
    }

    @FXML
    void buttonExited(MouseEvent event) {
        Button boutton = (Button) event.getSource();
        String beforeStyle = boutton.getStyle();
        int premierePointVirgule = beforeStyle.indexOf(";") + 1;
        boutton.setStyle("-fx-background-color: #75BB99;"
                + beforeStyle.substring(premierePointVirgule,
                                                beforeStyle.length()));
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
            joueur1.incrementer();
        } else {
            joueur2.incrementer();
        }
        cercles[x][y] = cercle;
        grille.add(cercle, x, y);
        changeCouleurJoueurActif();
        updateScore();
        testFin();
        NouveauJouables(couleurs.getCouleurActive());
    }
    
    private static int[] getNodeCoords(Node noeud) {
        Integer x = GridPane.getColumnIndex(noeud);
        x = x == null ? 0 : x;
        Integer y = GridPane.getRowIndex(noeud);
        y = y == null ? 0 : y;
        int[] resultat = {x, y};
        return resultat;
    }
    
    private void NouveauJouables(String couleur) {
        resetAllPlayables();
        int[][] coordsJouable = plateauJeu.chercherPlacementsPossible();
        for (int[] elt : coordsJouable) {
            afficherContourBoutton(elt[0], elt[1], couleur);
            buttons[elt[0]][elt[1]].setDisable(false);
        }
    }
    
    void afficherContourBoutton(int x, int y, String couleur) {
        buttons[x][y].setStyle("-fx-border-color: " + couleur + " ;"
                             + " -fx-border-radius: 50;"
                             + " -fx-border-style: segments(5, 5, 5, 5);"
                             + " -fx-border-width: 2;"
                             + " -fx-background-color: #ff000000;");
    }
    
    void resetAllPlayables() {
        for (Button[] eltListe : buttons) {
            for (Button elt : eltListe) {
                elt.setStyle("-fx-border-color: #ff000000;"
                             + "-fx-border-radius: 50;"
                             + " -fx-border-style: segments(5, 5, 5, 5);"
                             + " -fx-border-width: 2;"
                             + " -fx-background-color: #ff000000;");
                elt.setDisable(true);
            }
        }
    }
    
    void changeCouleurJoueurActif() {
        couleurs.switchCouleurActive();
        couleurJoueurActif.setFill(Paint.valueOf(couleurs.getCouleurActive()));
    }
    
    void changeCouleur(int x, int y) {
        if (cercles[x][y].getFill().equals(
                Paint.valueOf(couleurs.getCouleurJ1()))) {
            changeCouleurJ2(x, y);
            
        } else {
            changeCouleurJ1(x, y);
        }
        updateScore();
    }
    
    void changeCouleurJ1(int x, int y) {
        cercles[x][y].setFill(Paint.valueOf(couleurs.getCouleurJ1()));
        joueur1.incrementer();
        joueur2.decrementer();
    }
    
    void changeCouleurJ2(int x, int y) {
        cercles[x][y].setFill(Paint.valueOf(couleurs.getCouleurJ2()));
        joueur2.incrementer();
        joueur1.decrementer();;
    }
    
    void updateScore() {
        scoreJoueur1.setText(Integer.toString(joueur1.getScore()));
        scoreJoueur2.setText(Integer.toString(joueur2.getScore()));
    }
    
    private void testFin() {
        if (plateauJeu.chercherPlacementsPossible().length == 0 
            && joueur1.getScore() + joueur2.getScore() > 4) {
            EchangeurDeVue.supprimerCache(1);
            int[] tmp = {joueur1.getScore(), joueur2.getScore()};
            Modele.setScores(tmp);
            if (joueur1.getScore() == joueur2.getScore()) {
                EchangeurDeVue.echangerAvec(3, 525, 900);
            } else {
                EchangeurDeVue.echangerAvec(3, 525, 900);
            }
        }
    }
 
}