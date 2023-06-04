/*
 * ControleurEgalite.java                                      3 Jun 2023
 * IUT Rodez, info1 2022-2023, pas de copyright ni "copyleft" 
 */
package principal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import principal.modele.Modele;

/** TODO comment class responsibility (SRP)
 * @author benji
 *
 */
public class ControleurVictoire {
    
    @FXML
    private Text aGagneText;

    @FXML
    private Text felDefText;
    
    @FXML
    private Text pseudoVainqueur;

    @FXML
    private Text scores;
    
    @FXML
    private void initialize() {
        String couleurGagnant;
        pseudoVainqueur.setText(Modele.getPseudoVainqueur());
        if (Modele.getPseudoVainqueur() == Modele.getJoueur1().getPseudo()) {
            scores.setText(Modele.getJoueur1().getScore() + " à " 
                           + Modele.getJoueur2().getScore());
            couleurGagnant = Modele.getPalette().getCouleurJ1();
        } else {
            scores.setText(Modele.getJoueur2().getScore() + " à " 
                           + Modele.getJoueur1().getScore());
            couleurGagnant = Modele.getPalette().getCouleurJ2();
        }
        
        if (Modele.isMode1Joueur() && couleurGagnant == 
                Modele.getPalette().getCouleurOrdinateur()) {
            felDefText.setText("Dommage...");
        }
        aGagneText.setFill(Paint.valueOf(couleurGagnant));
        felDefText.setFill(Paint.valueOf(couleurGagnant));
        pseudoVainqueur.setFill(Paint.valueOf(couleurGagnant));
        scores.setFill(Paint.valueOf(couleurGagnant));
    }
    
    @FXML
    void buttonEntered(MouseEvent event) {
        Button boutton = (Button) event.getSource();
        String beforeStyle = boutton.getStyle();
        int premierePointVirgule = beforeStyle.indexOf(";") + 1;
        boutton.setStyle("-fx-background-color: #008656;"
                         + beforeStyle.substring(premierePointVirgule,
                                                         beforeStyle.length()));
    }

    @FXML
    void buttonExited(MouseEvent event) {
        Button boutton = (Button) event.getSource();
        String beforeStyle = boutton.getStyle();
        int premierePointVirgule = beforeStyle.indexOf(";") + 1;
        boutton.setStyle("-fx-background-color: #009E6D;"
                + beforeStyle.substring(premierePointVirgule,
                                                beforeStyle.length()));
    }
    
    @FXML
    void rejouerPresser(ActionEvent event) {
        EchangeurDeVue.echangerAvec(1, false);
    }
    
    @FXML
    void menuPresser(ActionEvent event) {
        EchangeurDeVue.echangerAvec(0, false);
    }
}
