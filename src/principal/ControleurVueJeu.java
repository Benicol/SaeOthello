/*
 * ControleurVueJeu.java                                      26 2023
 * IUT Rodez, info1 2022-2023, pas de copyright ni "copyleft" 
 */
package principal;

import principal.modele.Plateau;
import principal.modele.Jeton;
import principal.modele.Modele;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    
    private boolean initialisation = true;

    @FXML
    private Label displayActionOrdinateur;
    
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
//        int randomSwitch = (int) (Math.random() * 2);
//        Joueur tmpJoueur = new Joueur(null);
//        if (randomSwitch == 0) {
//            tmpJoueur.setPseudo(Modele.getJoueur1().getPseudo());
//            Modele.getJoueur1().setPseudo(Modele.getJoueur2().getPseudo());
//            Modele.getJoueur2().setPseudo(tmpJoueur.getPseudo());;
//            if (Modele.getPalette().getCouleurJ1() == Modele.getPalette().getCouleurActive()) {
//                Modele.getPalette().setCouleurOrdinateur(Modele.getPalette().getCouleurJ2());
//            } else {
//                Modele.getPalette().setCouleurOrdinateur(Modele.getPalette().getCouleurJ1());
//            }
//        }
        if (!Modele.isPartieCharge()) {
            Modele.setPlateauJeu(new Plateau());
            Modele.getJoueur1().setScore(0);
            Modele.getJoueur2().setScore(0);
            Modele.getPalette().resetCouleurActive();
        }
        Modele.setCercles(new Circle[8][8]);
        Modele.setButtons(new Button[8][8]);
        registerBouttons();
        displayActionOrdinateur.setText("");
        nomJoueur1.setStyle("-fx-text-fill: " + Modele.getPalette().getCouleurJ1() + "; " + "-fx-background-color: #75BB99;");
        nomJoueur2.setStyle("-fx-text-fill: " + Modele.getPalette().getCouleurJ2() + "; " + "-fx-background-color: #75BB99;");
        scoreJoueur1.setStyle("-fx-text-fill: " + Modele.getPalette().getCouleurJ1() + "; " + "-fx-background-color: #75BB99;");
        scoreJoueur2.setStyle("-fx-text-fill: " + Modele.getPalette().getCouleurJ2() + "; " + "-fx-background-color: #75BB99;");
        nomJoueur1.setText(Modele.getJoueur1().getPseudo());
        nomJoueur2.setText(Modele.getJoueur2().getPseudo());
        if (!Modele.isPartieCharge()) {
            creerCercle(4, 3);
            creerCercle(3, 3);
            creerCercle(3, 4);
            initialisation = false;
            creerCercle(4, 4);
        } else {
            Jeton[][] tmp = Modele.getPlateauJeu().getMatriceJeton();
            for (int x = 0; x < 8; x++) {
                for (int y = 0; y < 8; y++) {
                    if (tmp[x][y].isAfficher()) {
                        creerCercle(x, y, Paint.valueOf(tmp[x][y].isCouleurJ1()?
                                           Modele.getPalette().getCouleurJ1(): 
                                           Modele.getPalette().getCouleurJ2()));
                    }
                }
            }
            couleurJoueurActif.setFill(Paint.valueOf(Modele.getPalette().getCouleurActive()));
        }
        initialisation = false;
        Modele.setPartieCharge(false);
    }

    @FXML
    void nodePressed(ActionEvent event) {
        Button btn = (Button) event.getSource();
        btn.setDisable(true);
        int[] coords = getNodeCoords((Node) event.getSource());
        retournerJetons(coords);
        creerCercle(coords[0], coords[1]);
    }
    
    void retournerJetons(int[] coords) {
        int nbChangement =  Modele.retournerJetons(coords);
        updateScore();
        if (Modele.estTourOrdinateur()) {
            displayActionOrdinateur.setText(displayActionOrdinateur.getText() + " et à gagner " + nbChangement + " points.");
        }
    }

    @FXML
    void passerSonTourPresse(ActionEvent event) {
        if (!Modele.estTourOrdinateur()) {
            passerSonTour();
        }
        checkOrdinateur();
    }
    
    void passerSonTour() {
        if (Modele.isJoueurPrecedentPasser()) { 
            Modele.fin();
        }
        changeCouleurJoueurActif();
        Modele.NouveauJouables(Modele.getPalette().getCouleurActive());
        Modele.setJoueurPrecedentPasser(true);
    }

    @FXML
    void menuPresse(ActionEvent event) {
        if (!Modele.estTourOrdinateur()) {
            EchangeurDeVue.echangerAvec(5, false);
        }
    }
    
    void registerBouttons() {
        List<Node> buttonsNodes = grille.getChildren().subList(0, 64);
        int[] coords = new int[2];
        for (int i = 0; i < buttonsNodes.size(); i++) {
            coords = getNodeCoords(buttonsNodes.get(i));
            Modele.getButtons()[coords[0]][coords[1]] = (Button) buttonsNodes.get(i);
        }
    }

    @FXML
    void buttonEntered(MouseEvent event) {
        Button boutton = (Button) event.getSource();
        String beforeStyle = boutton.getStyle();
        int premierePointVirgule = beforeStyle.indexOf(";") + 1;
        boutton.setStyle(
                "-fx-background-color: #008656;" + beforeStyle.substring(premierePointVirgule, beforeStyle.length()));
    }

    @FXML
    void buttonExited(MouseEvent event) {
        Button boutton = (Button) event.getSource();
        String beforeStyle = boutton.getStyle();
        int premierePointVirgule = beforeStyle.indexOf(";") + 1;
        boutton.setStyle(
                "-fx-background-color: #009E6D;" + beforeStyle.substring(premierePointVirgule, beforeStyle.length()));
    }

    /**
     * TODO comment method role
     * 
     * @param x
     * @param y
     */
    void creerCercle(Integer x, Integer y) {
        Modele.setJoueurPrecedentPasser(false);
        Circle cercle = new Circle(0, 0, 18);
        GridPane.setHalignment(cercle, HPos.CENTER);
        Paint couleur = Paint.valueOf(Modele.getPalette().getCouleurActive());
        cercle.setFill(couleur);
        Modele.creerCercleModele(x, y, couleur, cercle);
        grille.add(cercle, x, y);
        changeCouleurJoueurActif();
        updateScore();
        Modele.testFin();
        Modele.NouveauJouables(Modele.getPalette().getCouleurActive());
        if (!initialisation) {
            checkOrdinateur();
        }
    }
    
    /**
     * TODO comment method role
     * 
     * @param x
     * @param y
     */
    void creerCercle(Integer x, Integer y, Paint couleur) {
        Circle cercle = new Circle(0, 0, 18);
        GridPane.setHalignment(cercle, HPos.CENTER);
        cercle.setFill(couleur);
        Modele.creerCercleModele(x, y, couleur, cercle);
        grille.add(cercle, x, y);
        updateScore();
        Modele.testFin();
        Modele.NouveauJouables(Modele.getPalette().getCouleurActive());
        if (!initialisation) {
            checkOrdinateur();
        }
    }

    private static int[] getNodeCoords(Node noeud) {
        Integer x = GridPane.getColumnIndex(noeud);
        x = x == null ? 0 : x;
        Integer y = GridPane.getRowIndex(noeud);
        y = y == null ? 0 : y;
        int[] resultat = { x, y };
        return resultat;
    }

    


    void changeCouleurJoueurActif() {
        Modele.getPalette().switchCouleurActive();
        couleurJoueurActif.setFill(Paint.valueOf(Modele.getPalette().getCouleurActive()));
    }

    void updateScore() {
        scoreJoueur1.setText(Integer.toString(Modele.getJoueur1().getScore()));
        scoreJoueur2.setText(Integer.toString(Modele.getJoueur2().getScore()));
    }

    

    
    private void checkOrdinateur() {
        if (Modele.estTourOrdinateur()) {
            int[] actionOrdinateur = Modele.checkOrdinateur();
            if (actionOrdinateur[0] < 0) {
                passerSonTour();
            } else {
                displayActionOrdinateur.setText("L'ordinateur à jouer : [" + (actionOrdinateur[0] + 1) + ", " + (actionOrdinateur[1] + 1) + "]");
                retournerJetons(actionOrdinateur);
                creerCercle(actionOrdinateur[0], actionOrdinateur[1]);
            }
        }
    }

}