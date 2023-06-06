/*
 * ControleurPseudo.java                                      3 Jun 2023
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
 * TODO comment class responsibility (SRP)
 * 
 * @author benji
 *
 */
public class ControleurPseudo {
    
    @FXML
    private Label messageErreur;

    @FXML
    private void initialize() {
        if (Modele.isMode1Joueur()) {
            labelPseudo.setText("joueur");
            entrer.setPromptText("Joueur humain");
        }
    }
    
    String pseudo1 = "";
    
    String pseudo2 = "";

    boolean phaseDeux = false;

    @FXML
    private TextField entrer;

    @FXML
    private Text labelPseudo;

    @FXML
    void buttonEntered(MouseEvent event) {
        Button boutton = (Button) event.getSource();
        boutton.getStyleClass().remove("buttonExited");
        boutton.getStyleClass().add("buttonEntered");
    }

    @FXML
    void buttonExited(MouseEvent event) {
        Button boutton = (Button) event.getSource();
        boutton.getStyleClass().remove("buttonEntered");
        boutton.getStyleClass().add("buttonExited");
    }

    @FXML
    void validerCliquer(ActionEvent event) {
        if (!entrer.getText().matches("^[a-zA-Z0-9 ]*$")) {
            messageErreur.setText("Veuillez uniquement utiliser des lettres et chiffres");
            messageErreur.setOpacity(1);
        } else if (entrer.getText().length() > 15){
            messageErreur.setText("Votre Pseudonyme doit faire moins de 15 caractères");
            messageErreur.setOpacity(1);
        } else {
            messageErreur.setOpacity(0);
            
            if (!Modele.isMode1Joueur()) {
                if (!phaseDeux) {
                    if (entrer.getText().length() == 0) {
                        pseudo1 = entrer.getPromptText();
                    } else {
                        pseudo1 = entrer.getText();
                    }
                    entrer.setPromptText("Joueur 2");
                    entrer.setText("");
                    labelPseudo.setText("Joueur 2");
                    labelPseudo.requestFocus();
                } else {
                    if (entrer.getText().length() == 0) {
                        pseudo2 = entrer.getPromptText();
                    } else {
                        pseudo2 = entrer.getText();
                    }
                }
            } else {
                if (entrer.getText().length() == 0) {
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
