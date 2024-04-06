package tn.esprit.gestionvols.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import tn.esprit.gestionvols.Services.serviceVol; // Importez votre classe VolService

public class RechercheVolsController {

    @FXML
    private Label destinationLabel;
    @FXML
    private Label dateDepartLabel;
    @FXML
    private Label prixMinLabel;
    @FXML
    private Label prixMaxLabel;
    @FXML
    private TextField destinationField;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextField prixMinField;
    @FXML
    private TextField prixMaxField;
    @FXML
    private CheckBox escaleCheckBox;
    @FXML
    private Button rechercherButton;
    @FXML
    private Label nbPassagersLabel;
    @FXML
    private TextField nbPassagersField;

    private serviceVol volService; // Instance de VolService
    private ObservableList<String> flightResults; // Pour stocker les résultats de la recherche

    public RechercheVolsController() {
        volService = new serviceVol(); // Initialiser VolService
        flightResults = FXCollections.observableArrayList();
    }

    @FXML
    public void initialize() {
        // Optionnel: Définir les valeurs par défaut ou effectuer des initialisations
    }

    @FXML
    public void handleRechercherButton(ActionEvent event) {
        String destination = destinationField.getText();
        String strDateDepart = datePicker.getValue().toString(); // Obtenir la chaîne de date formatée
        int prixMin = Integer.parseInt(prixMinField.getText());
        int prixMax = Integer.parseInt(prixMaxField.getText());
        boolean escale = escaleCheckBox.isSelected();
        int nbPassagers = Integer.parseInt(nbPassagersField.getText());


        // Gérer les résultats de la recherche (p. ex., les afficher dans un tableau, naviguer vers un autre écran)
        System.out.println("Résultats de la recherche :");
        for (String flight : flightResults) {
            System.out.println(flight); // Afficher les résultats pour la démonstration
        }
    }
}
