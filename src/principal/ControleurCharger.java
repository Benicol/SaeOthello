/*
 * ControleurPseudo.java                                      3 Jun 2023
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
 * TODO comment class responsibility (SRP)
 * 
 * @author benji
 *
 */
public class ControleurCharger {
    
    private Map<String, String> sauvegardes = new HashMap<String, String>();

    @FXML
    private void initialize() throws IOException {
        updatePropositions();
        
    }

    /** TODO comment method role
     * @throws FileNotFoundException
     * @throws IOException
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
        new Sauvegarde("").importer(sauvegardes.get(
                       choiceBox.getSelectionModel().getSelectedItem().trim()));
        EchangeurDeVue.echangerAvec(1, true);
    }
    
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
    
    @FXML
    void retourPresser(ActionEvent event) {
        EchangeurDeVue.echangerAvec(Modele.getDernierMenuOuvert(), false);
    }

}
