/*
 * ControleurVictoire.java                                      30 mai 2023
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

/** 
 * Contrôleur de Victoire.fxml
 * @author groupe 32
 */
public class ControleurVictoire {
    
	/* Texte de félicitation pour le vainqueur */
    @FXML
    private Text aGagneText;

    /* Texte de félicitation ou d'encouragement en fonction de si 
     * le joueur a gagné ou perdu contre l'ordinateur. */ 
    @FXML
    private Text felDefText;
    
    /* Texte affichant le pseudo du vainqueur */
    @FXML
    private Text pseudoVainqueur;

    /* Texte affichant les scores des joueurs */
    @FXML
    private Text scores;
    
    /*
     * Au lancement de cette vue, présente le résultat de la partie effectué :
     *     - Selon le mode de jeu sélectionné
     *     - Selon le vainqueur
     */
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
     * Permet de changer de vue pour la vue du jeu
     * si le joueur clique sur "rejouer".
     */
    @FXML
    void rejouerPresser(ActionEvent event) {
        EchangeurDeVue.echangerAvec(1, false);
    }
    
    /*
     * Permet de changer de vue pour la vue du menu principal
     * si le joueur clique sur "menu principal".
     */
    @FXML
    void menuPresser(ActionEvent event) {
        EchangeurDeVue.echangerAvec(0, false);
    }
}
