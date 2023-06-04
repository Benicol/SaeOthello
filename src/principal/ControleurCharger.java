/*
 * ControleurPseudo.java                                      3 Jun 2023
 * IUT Rodez, info1 2022-2023, pas de copyright ni "copyleft" 
 */
package principal;

import principal.modele.Modele;
import principal.modele.Sauvegarde;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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
public class ControleurCharger {
    
    private Sauvegarde[] sauvegardes;

    @FXML
    private void initialize() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("sauvegardes.txt"));
        String line;
        int nbSauvegarde = 0;
        while ((line = br.readLine()) != null) {
            nbSauvegarde++;
        }
        sauvegardes = new Sauvegarde[nbSauvegarde];
        br = new BufferedReader(new FileReader("sauvegardes.txt"));
        for (int i = 0; i < nbSauvegarde; i++) {
            sauvegardes[i].importer();
        }
        System.out.println(nbSauvegarde);
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
    
    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    void chargerPresser(ActionEvent event) {
        
    }
    
    @FXML
    void supprimerPresse(ActionEvent event) {

    }
    
    @FXML
    void retourPresser(ActionEvent event) {
        EchangeurDeVue.echangerAvec(Modele.getDernierMenuOuvert(), false);
    }

}
