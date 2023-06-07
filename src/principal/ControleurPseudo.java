/*
 * ControleurPseudo.java                                      30 mai 2023
 * IUT Rodez, info1 2022-2023, pas de copyright ni "copyleft" 
 */
package principal;

import principal.modele.Modele;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/** 
 * Contrôleur de Pseudo.fxml
 * @author groupe 32
 */
public class ControleurPseudo {
    
	/* message qui s'affiche si l'utilisateur choisi un pseudo invalide */
    @FXML
    private Label messageErreur;
    
    /* pseudo choisi pour désigner le joueur 1 */
    String pseudo1 = "";
    
    /* pseudo choisi pour désigner le joueur 2 */
    String pseudo2 = "";

    /* permet de savoir si le pseudo choisi est 
     * celui du joueur 1 ou du joueur 2 */
    boolean phaseDeux = false;
    
    /* zone de saisie du pseudo */
    @FXML
    private TextField entrer;

    /* texte affiché en fonction du joueur */
    @FXML
    private Text labelPseudo;

    /* 
     * Au lancement de cette vue, permet de désigner le joueur en 
     * fonction du mode choisi 
     */
    @FXML
    private void initialize() {
        if (Modele.isMode1Joueur()) {
            labelPseudo.setText("joueur");
            entrer.setPromptText("Joueur humain");
        }
    }

    /*
     * Au survol d'un bouton, le style de celui-ci est modifié et devient plus foncé.
     */
    @FXML
    void buttonEntered(MouseEvent event) {
        Button boutton = (Button) event.getSource();
        boutton.getStyleClass().remove("buttonExited");
        boutton.getStyleClass().add("buttonEntered");
    }

    /*
     * Quand, en survol, on sort d'un bouton, le style de celui-ci 
     * est modifié pour revenir à son état initial.
     */
    @FXML
    void buttonExited(MouseEvent event) {
        Button boutton = (Button) event.getSource();
        boutton.getStyleClass().remove("buttonEntered");
        boutton.getStyleClass().add("buttonExited");
    }

    /* Méthode permettant de choisir et stocker les différents pseudo en 
     * fonction du mode de jeu.
     *     - Ouvre une seule fenêtre dans le cas d'une partie à 1 
     *       joueur (avec un pseudo par défaut "Joueur humain")
     *     - Ouvre deux fenêtres consécutives dans le cas d'une 
     *       partie à 2 joueurs (avec un pseudo par défaut 
     *       "Joueur 1" et "Joueur 2")  
     */
    @FXML
    void validerCliquer(ActionEvent event) {
        if (!entrer.getText().matches("^[a-zA-Z0-9 ]*$")) {
            messageErreur.setText("Veuillez uniquement utiliser des lettres et chiffres");
            messageErreur.setOpacity(1);
        } else if (entrer.getText().length() > 15){
            messageErreur.setText("Votre pseudonyme doit faire maximum 15 caractères");
            messageErreur.setOpacity(1);
        } else {
            messageErreur.setOpacity(0);
            
            if (!Modele.isMode1Joueur()) {
                if (!phaseDeux) {
                    if (entrer.getText().trim().length() == 0) {
                        pseudo1 = entrer.getPromptText();
                    } else {
                        pseudo1 = entrer.getText();
                    }
                    entrer.setPromptText("Joueur 2");
                    entrer.setText("");
                    labelPseudo.setText("Joueur 2");
                    labelPseudo.requestFocus();
                } else {
                    if (entrer.getText().trim().length() == 0) {
                        pseudo2 = entrer.getPromptText();
                    } else {
                        pseudo2 = entrer.getText();
                    }
                }
            } else {
                if (entrer.getText().trim().length() == 0) {
                    pseudo1 = entrer.getPromptText();
                } else {
                    pseudo1 = entrer.getText();
                }
                pseudo2 = "Ordinateur";
                phaseDeux = true;
            }
            if (phaseDeux) {
                int nbRandom = (int) (Math.random() * 2);
                if (nbRandom == 0) {
                    Modele.getPalette().setCouleurOrdinateurIsJ1(false);
                    Modele.getJoueur1().setPseudo(pseudo1);
                    Modele.getJoueur2().setPseudo(pseudo2);
                } else {
                    Modele.getPalette().setCouleurOrdinateurIsJ1(true);
                    Modele.getJoueur1().setPseudo(pseudo2);
                    Modele.getJoueur2().setPseudo(pseudo1);
                }
                EchangeurDeVue.echangerAvec(1, true);
            }
            phaseDeux = true;
        }
    }

}
