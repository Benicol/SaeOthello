/*
 * ControleurPseudo.java                                      3 Jun 2023
 * IUT Rodez, info1 2022-2023, pas de copyright ni "copyleft" 
 */
package principal;

import principal.modele.Modele;
import principal.modele.Theme;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

/** TODO comment class responsibility (SRP)
 * @author benji
 *
 */
public class ControleurPseudo {
    
    @FXML
    private void initialize() {
        labelPseudo.setFill(Paint.valueOf(Modele.getPalette().getCouleurJ1()));
        labelPseudo.setStroke(Paint.valueOf(Modele.getPalette().getCouleurJ2()));
    }
    
    boolean phaseDeux = false;
    
    @FXML
    private TextField entrer;
    
    @FXML
    private Text labelPseudo;
    
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
    void validerCliquer(ActionEvent event) {
        if (!phaseDeux) {
            labelPseudo.setFill(Paint.valueOf(
                                           Modele.getPalette().getCouleurJ2()));
            labelPseudo.setStroke(Paint.valueOf(
                    Modele.getPalette().getCouleurJ1()));
            if(entrer.getText().length() == 0) {
                Modele.setPseudoJ1(entrer.getPromptText());
            } else {
                Modele.setPseudoJ1(entrer.getText());
            }
            entrer.setPromptText("Joueur 2");
            entrer.setText("");
            labelPseudo.requestFocus();
            phaseDeux = true;
        } else {
            if(entrer.getText().length() == 0) {
                Modele.setPseudoJ2(entrer.getPromptText());
            } else {
                Modele.setPseudoJ2(entrer.getText());
            }
            EchangeurDeVue.supprimerCache(2);
            EchangeurDeVue.echangerAvec(1, 700, 600);
        }
    }

}
