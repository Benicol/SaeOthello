/*
 * ControleurReglesCommentJouer.java                                      30 mai 2023
 * IUT Rodez, info1 2022-2023, pas de copyright ni "copyleft" 
 */
package principal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import principal.modele.Modele;

/** 
 * Contrôleur de ReglesCommentJouer.fxml
 * @author groupe 32
 */
public class ControleurReglesCommentJouer {
    
	/*
     * Permet de changer de vue pour retourner sur le menu sur lequel le joueur était avant d'acceder aux règles
     * (soit le menu principal, soit le menu en jeu)
     * si le joueur clique sur "suivant".
     */
    @FXML
    void suivantPresse(ActionEvent event) {
        EchangeurDeVue.echangerAvec(Modele.getDernierMenuOuvert(), false);
    }
    
    /*
     * Au survol d'un bouton, le style de celui-ci est modifié et devient plus foncé.
     */
    @FXML
    void buttonEntered(MouseEvent event) {
        Button boutton = (Button) event.getSource();
        String beforeStyle = boutton.getStyle();
        int premierePointVirgule = beforeStyle.indexOf(";") + 1;
        boutton.setStyle("-fx-background-color: #008656;"
                         + beforeStyle.substring(premierePointVirgule,
                                                         beforeStyle.length()));
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
        boutton.setStyle("-fx-background-color: #009E6D;"
                + beforeStyle.substring(premierePointVirgule,
                                                beforeStyle.length()));
    }
}
