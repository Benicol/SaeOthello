/*
 * ControleurEgalite.java                                      30 mai 2023
 * IUT Rodez, info1 2022-2023, pas de copyright ni "copyleft" 
 */
package principal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import principal.modele.Modele;

/**
 * Contrôleur de Egalite.fxml
 * @author groupe 32
 */
public class ControleurEgalite {
    
	/* Le texte permettant d'afficher les scores sur la console */
    @FXML
    private Text scores;
    
    /* Au lancement de cette vue, toutes les parties qu'il est possible de charger */
    @FXML
    private void initialize() {
        scores.setText(Modele.getJoueur1().getScore() + " à " + Modele.getJoueur2().getScore());
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
    
    /*
     * Permet de changer de vue pour relancer une partie
     * si le joueur clique sur "rejouer".
     */
    @FXML
    void rejouerPresser(ActionEvent event) {
        EchangeurDeVue.echangerAvec(1, false);
    }
    
    /*
     * Permet de changer de vue pour retourner au menu principal
     * si le joueur clique sur "menu principal".
     */
    @FXML
    void menuPresser(ActionEvent event) {
        EchangeurDeVue.echangerAvec(0, false);
    }
}
