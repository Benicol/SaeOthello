/*
 * ControleurVueJeu.java                                      26 mai 2023
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
 * Contrôleur de VueJeu.fxml
 * @author groupe 32
 */
public class ControleurVueJeu {
    
	/* */
    private boolean initialisation = true;

    /* */
    @FXML
    private Label displayActionOrdinateur;
    
    /* Texte affichant le pseudo du Joueur 1 */
    @FXML
    private TextField nomJoueur1;

    /* Texte affichant le score du Joueur 1 */
    @FXML
    private TextField scoreJoueur1;

    /* Texte affichant le pseudo du Joueur 2 */
    @FXML
    private TextField nomJoueur2;

    /* Texte affichant le score du Joueur 2 */
    @FXML
    private TextField scoreJoueur2;

    /* Bouton permettant d'accéder au menu en jeu */
    @FXML
    private Button menu;

    /* Grille permettant de représenter le plateau de jeu */
    @FXML
    private GridPane grille;

    /* Bouton permettant de passer son tour */
    @FXML
    private Button passerTour;

    /* 
     * Cercle dans le bandeau permettant d'afficher la couleur 
     * du joueur actif 
     */
    @FXML
    private Circle couleurJoueurActif;

    /*
     * Au lancement de cette vue, permet d'adapter la vue en fonction 
     * du type de partie.
     */
    @FXML
    private void initialize() {
        Modele.setCercles(new Circle[8][8]);
        Modele.setButtons(new Button[8][8]);
        registerBouttons();
        
        if (!Modele.isPartieCharge()) {
            Modele.setPlateauJeu(new Plateau());
            Modele.getJoueur1().setScore(0);
            Modele.getJoueur2().setScore(0);
            Modele.getPalette().resetCouleurActive();
        }
        
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
        if (Modele.isOrdinateurIsWaiting()) {
            Modele.afficherContourBoutton(Modele.getOrdinateurVeutJouer()[0], 
                    Modele.getOrdinateurVeutJouer()[1], 
                    "#FF0000");
            passerTour.setText("suivant");
            passerTour.setStyle("-fx-background-color : #8888FF;"
                    + " -fx-background-radius : 50px;");
        }
        initialisation = false;
        Modele.setPartieCharge(false);
    }

    /*
     * Se lance quand on appuie sur l'une des cases de la grille (le plateau).
     */
    @FXML
    void nodePressed(ActionEvent event) {
        if (!Modele.estTourOrdinateur()) {
            Button btn = (Button) event.getSource();
            btn.setDisable(true);
            int[] coords = getNodeCoords((Node) event.getSource());
            retournerJetons(coords);
            creerCercle(coords[0], coords[1]);
        }
    }
    
    /* Permet de retourner les jetons. */
    void retournerJetons(int[] coords) {
        int nbChangement =  Modele.retournerJetons(coords);
        updateScore();
    }

    /*
     * Permet de passer son tour si le joueur clique sur "passer son tour".
     * Déclenche également l'action si, lors du tour de l'ordinateur, 
     * celui-ci ne peut pas jouer.
     */
    @FXML
    void passerSonTourPresse(ActionEvent event) {
        if (Modele.estTourOrdinateur()) {
            ordinateurJoue();
        } else {
            passerSonTour();
        }
        checkOrdinateur();
    }
    
    /*
     * Permet au joueur actif de finir son tour sans poser de nouveau jeton.
     */
    void passerSonTour() {
        if (Modele.isJoueurPrecedentPasser()) { 
            Modele.fin();
        }
        changeCouleurJoueurActif();
        Modele.NouveauJouables(Modele.getPalette().getCouleurActive());
        Modele.setJoueurPrecedentPasser(true);
    }

    /*
     * Permet de changer de vue pour la menu du jeu
     * si le joueur clique sur "menu".
     */
    @FXML
    void menuPresse(ActionEvent event) {
        EchangeurDeVue.echangerAvec(5, false);
    }
    
    /* Renvoit les coordonnées de tous les boutons */
    void registerBouttons() {
        List<Node> buttonsNodes = grille.getChildren().subList(0, 64);
        
        int[] coords = new int[2];
        for (int i = 0; i < buttonsNodes.size(); i++) {
            coords = getNodeCoords(buttonsNodes.get(i));
            Modele.getButtons()[coords[0]][coords[1]] = (Button) buttonsNodes.get(i);
        }
    }

    /*
     * Au survol d'un bouton, le style de celui-ci est modifié et devient plus foncé.
     */
    @FXML
    void buttonEntered(MouseEvent event) {
        Button boutton = (Button) event.getSource();
        String beforeStyle = boutton.getStyle();
        int premierePointVirgule = beforeStyle.indexOf(";") + 1;
        if (Modele.isOrdinateurIsWaiting() && boutton == passerTour) {
            boutton.setStyle("-fx-background-color: #7777EE;"
                    + beforeStyle.substring(premierePointVirgule, beforeStyle.length()));
        } else {
            boutton.setStyle("-fx-background-color: #60A383;"
                    + beforeStyle.substring(premierePointVirgule, beforeStyle.length()));
        }
        
    }

    /*
     * Quand, en survol, on sort d'un bouton, le style de celui-ci 
     * est modifié pour revenir à son état initial.
     */
    @FXML
    void buttonExited(MouseEvent event) {
        Button boutton = (Button) event.getSource();
        String beforeStyle = boutton.getStyle();
        int premierePointVirgule = beforeStyle.indexOf(";") + 1;
        if (Modele.isOrdinateurIsWaiting() && boutton == passerTour) {
            boutton.setStyle("-fx-background-color: #8888FF;"
                    + beforeStyle.substring(premierePointVirgule, beforeStyle.length()));
        } else {
            boutton.setStyle("-fx-background-color: #75BB99;"
                    + beforeStyle.substring(premierePointVirgule,
                                                beforeStyle.length()));
        }
        
    }

    /**
     * Crée un nouveau cercle aux coordonnées indiquées.
     * @param x les coordonnées en x du cercle à créer
     * @param y les coordonnées en y du cercle à créer
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
     * Crée un nouveau cercle selon les coordonnées et la couleur 
     * indiquées.
     * @param x les coordonnées en x du cercle à créer
     * @param y les coordonnées en y du cercle à créer
     * @param Paint la couleur du cercle à créer
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

    /* Permet d'obtenir les coordonnées d'une case de la grille */
    private static int[] getNodeCoords(Node noeud) {
        Integer x = GridPane.getColumnIndex(noeud);
        x = x == null ? 0 : x;
        Integer y = GridPane.getRowIndex(noeud);
        y = y == null ? 0 : y;
        int[] resultat = { x, y };
        return resultat;
    }

    /* Permet de changer la couleur du joueur actif */
    void changeCouleurJoueurActif() {
        Modele.getPalette().switchCouleurActive();
        couleurJoueurActif.setFill(Paint.valueOf(Modele.getPalette().getCouleurActive()));
    }

    /* Permet de modifier le score des 2 joueurs */
    void updateScore() {
        scoreJoueur1.setText(Integer.toString(Modele.getJoueur1().getScore()));
        scoreJoueur2.setText(Integer.toString(Modele.getJoueur2().getScore()));
    }

    /* Vérifie si c'est le tour de l'ordinateur et fait son action 
     * (en indiquant où il place son nouveau jeton) */
    private void checkOrdinateur() {
        if (Modele.estTourOrdinateur()) {
            int[] actionOrdinateur = Modele.checkOrdinateur();
            if (actionOrdinateur[0] < 0) {
                passerSonTour();
            } else {
                Modele.setOrdinateurVeutJouer(actionOrdinateur);
                Modele.setOrdinateurIsWaiting(true);
                Modele.afficherContourBoutton(actionOrdinateur[0], 
                                              actionOrdinateur[1], 
                                              "#FF0000");
                passerTour.setText("suivant");
                passerTour.setStyle("-fx-background-color : #8888FF;"
                        + " -fx-background-radius : 50px;");
            }
        }
    }
    
    /* Vérifie si c'est le tour de l'ordinateur et fait son action 
     * (en indiquant où il place son nouveau jeton) */
    private void ordinateurJoue() {
            retournerJetons(Modele.getOrdinateurVeutJouer());
            creerCercle(Modele.getOrdinateurVeutJouer()[0], 
                        Modele.getOrdinateurVeutJouer()[1]);
            Modele.setOrdinateurIsWaiting(false);
            passerTour.setStyle("-fx-background-color : #75BB99;"
                    + " -fx-background-radius : 50px;");
            passerTour.setText("Passer son tour");
        }

}