/*
 * ControleurCharger.java                                      30 mai 2023
 * IUT Rodez, info1 2022-2023, pas de copyright ni "copyleft" 
 */
package principal;

import principal.modele.Modele;
import principal.modele.Sauvegarde;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 * Contrôleur de Charger.fxml
 * @author groupe 32
 */
public class ControleurCharger {
    
	/* DECLARATION DES VARIABLES */
	/* variable qui stocke les sauvegardes avec une clé 
	 * (le nom de la sauvegarde) et une valeur (la sauvegarde) */
    private Map<String, String> sauvegardes = new HashMap<String, String>();
    
    /* Le bouton permettant de lister toutes les sauvegardes */
    @FXML
    private ChoiceBox<String> choiceBox;

    /* Au lancement de cette vue, toutes les parties qu'il est possible de charger */
    @FXML
    private void initialize() throws IOException {
        updatePropositions();
        
    }

    /* 
     * Méthode permettant de trouver toutes les sauvegardes disponibles
     * et de les afficher dans la liste déroulante prévue à cet effet.
     */
    private void updatePropositions() throws FileNotFoundException, IOException {
        choiceBox.getItems().clear();
        sauvegardes.clear();
        BufferedReader br = new BufferedReader(new FileReader("sauvegardes.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            sauvegardes.put(line.split("[|]")[0], line);
        }
        for (String key : sauvegardes.keySet()) {
            choiceBox.getItems().add(String.format("%34s", key));
        }
        br.close();
    }
    
    /*
     * Au survol d'un bouton, le style de celui-ci est modifié et devient plus foncé.
     */
    @FXML
    void buttonEntered(MouseEvent event) {
        Button boutton = (Button) event.getSource();
        String beforeStyle = boutton.getStyle();
        int premierePointVirgule = beforeStyle.indexOf(";") + 1;
        boutton.setStyle(
                "-fx-background-color: #008656;" + beforeStyle.substring(premierePointVirgule, beforeStyle.length()));
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
        boutton.setStyle(
                "-fx-background-color: #009E6D;" + beforeStyle.substring(premierePointVirgule, beforeStyle.length()));
    }

    /*
     * Permet de changer de vue pour aller sur la vue d'une partie précédemment
     * sauvegardé si le joueur clique sur "charger cette partie".
     */
    @FXML
    void chargerPresser(ActionEvent event) {
        new Sauvegarde("").importer(sauvegardes.get(
                       choiceBox.getSelectionModel().getSelectedItem().trim()));
        EchangeurDeVue.echangerAvec(1, true);
    }
    
    /*
     * Permet de supprimer une sauvegarde sélectionnée par le joueur
     * si celui clique sur "supprimer".
     */
    @FXML
    void supprimerPresse(ActionEvent event) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("sauvegardes.txt"));
        StringBuilder nouveauText = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            if (!line.split("[|]")[0].equals( 
                       choiceBox.getSelectionModel().getSelectedItem().trim())) {
                nouveauText.append(line + "\n");
            }
        }
        br.close();
        BufferedWriter writer = new BufferedWriter(
                                            new FileWriter("sauvegardes.txt"));
        writer.write(nouveauText.toString());
        writer.close();
        updatePropositions();
    }
    
    /*
     * Permet de changer de vue pour retourner au menu précédent
     * si le joueur clique sur "retour".
     */
    @FXML
    void retourPresser(ActionEvent event) {
        EchangeurDeVue.echangerAvec(Modele.getDernierMenuOuvert(), false);
    }

}
