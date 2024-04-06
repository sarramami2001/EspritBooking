package tn.esprit.gestionvols.Controllers;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javafx.scene.control.cell.PropertyValueFactory;
import tn.esprit.gestionvols.Models.Vol;
import tn.esprit.gestionvols.Services.serviceVol;

public class CrudVolController implements Initializable {

    @FXML
    private TextField  tfdestination, tfetat, tfprix, tddatevol ,tfheuredepart, tfheureatt, tfnbplaces;

    @FXML
    private TableView<Vol> tablevols;

    @FXML
    private TableColumn<Vol, Integer> colid, colnbplaces;

    @FXML
    private TableColumn<Vol, String> coldestination, coletat, colprix, coldatevol;

    @FXML
    private Button btninserer, btnmodifier, btnsupprimer;

    private ObservableList<Vol> volsList = FXCollections.observableArrayList();

    private serviceVol volService = new serviceVol(); // Instanciez la classe VolService

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /*// Configurez les colonnes du TableView
        colid.setCellValueFactory(new PropertyValueFactory<>("id"));
        coldestination.setCellValueFactory(new PropertyValueFactory<>("destination"));
        coletat.setCellValueFactory(new PropertyValueFactory<>("etat"));
        colprix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        coldatevol.setCellValueFactory(new PropertyValueFactory<>("date_vol"));
        colnbplaces.setCellValueFactory(new PropertyValueFactory<>("nombre_total_places"));
        System.out.println(coldestination.getText());
        // Assignez la liste observable au TableView
        tablevols.setItems(volsList);

        // Chargez les données initiales
        chargerDonnees();*/
        insererVol();
    }


    @FXML
    private void HandleButtonAction(ActionEvent event) {
        if (event.getSource() == btninserer) {
            insererVol();
        } else if (event.getSource() == btnmodifier) {
            modifierVol();
        } else if (event.getSource() == btnsupprimer) {
            supprimerVol();
        }
    }

    private void viderChamps() {
        tfdestination.clear();
        tfetat.clear();
        tfprix.clear();
        tddatevol.clear();
        tfheuredepart.clear();
        tfheureatt.clear();
        tfnbplaces.clear();
    }

    private void chargerDonnees() {
        try {
            volsList.clear();
            volsList.addAll(volService.getAll());
            tablevols.setItems(volsList);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de chargement des données");
            alert.setHeaderText("Echec du chargement des vols");
            alert.setContentText("Une erreur est survenue lors du chargement des données. Veuillez réessayer plus tard.");
            alert.showAndWait();
        }
    }

    @FXML
    private void insererVol() {
        String destination = tfdestination.getText();
        String etat = tfetat.getText();
        if (!tfnbplaces.getText().isEmpty() && !tfprix.getText().isEmpty()) {
        float prix = Float.parseFloat(tfprix.getText());
        //float prix = 0;
        String date_vol = tddatevol.getText();
        String heure_depart = tfheuredepart.getText();
        String heure_atterissage = tfheureatt.getText();


          int  nombre_total_places = Integer.parseInt(tfnbplaces.getText());



        Vol vol = new Vol(destination, etat, prix, nombre_total_places, date_vol, heure_depart, heure_atterissage);
        //vol.getId();
        System.out.println(vol);
        System.out.println(vol.getId());

        try {
            volService.create(vol);

            volsList.add(vol);

           // tablevols.refresh();
            chargerDonnees();
            viderChamps();
        } catch (Exception e) {
            e.printStackTrace();
        }}
    }



    @FXML
    private void modifierVol() {
        // Récupérer le vol sélectionné
        Vol volSelectionne = tablevols.getSelectionModel().getSelectedItem();

        // Vérifier si un vol est sélectionné
        if (volSelectionne != null) {
            // Récupérer les nouvelles données des champs
            String nouvelleDestination = tfdestination.getText();
            String nouvelEtat = tfetat.getText();
            int nouveauPrix;
            try {
                nouveauPrix = Integer.parseInt(tfprix.getText());
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur de validation");
                alert.setHeaderText("Prix invalide");
                alert.setContentText("Le prix du vol doit être un nombre entier.");
                alert.showAndWait();
                return;
            }
            String nouvelleDateVol = tddatevol.getText();
            String nouvelleHeureDepart = tfheuredepart.getText();
            String nouvelleHeureAtterrissage = tfheureatt.getText();
            int nouveauNombreTotalPlaces;
            try {
                nouveauNombreTotalPlaces = Integer.parseInt(tfnbplaces.getText());
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur de validation");
                alert.setHeaderText("Nombre de places invalide");
                alert.setContentText("Le nombre total de places du vol doit être un nombre entier.");
                alert.showAndWait();
                return;
            }

            // Mettre à jour les propriétés du vol sélectionné
            volSelectionne.setDestination(nouvelleDestination);
            volSelectionne.setEtat(nouvelEtat);
            volSelectionne.setPrix(nouveauPrix);
            volSelectionne.setDate_vol(nouvelleDateVol);
            volSelectionne.setHeure_depart(nouvelleHeureDepart);
            volSelectionne.setHeure_atterissage(nouvelleHeureAtterrissage);

            // Enregistrer les modifications
            try {
                volService.Update(volSelectionne); // Remplacez par votre méthode de modification
                chargerDonnees();
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur de modification");
                alert.setHeaderText("Le vol n'a pas pu être modifié");
                alert.setContentText("Une erreur est survenue lors de la modification du vol. Veuillez réessayer plus tard.");
                alert.showAndWait();
                e.printStackTrace();
            }
        } else {
            // Afficher un message d'erreur si aucun vol n'est sélectionné
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Aucun vol sélectionné");
            alert.setHeaderText("Sélectionnez un vol");
            alert.setContentText("Veuillez sélectionner un vol dans la liste avant de le modifier.");
            alert.showAndWait();
        }
    }



    @FXML
    private void supprimerVol() {
        // Récupérez le vol sélectionné
        Vol volSelectionne = tablevols.getSelectionModel().getSelectedItem();

        // Vérifiez si un vol est sélectionné
        if (volSelectionne != null) {
            // Confirmez la suppression avec l'utilisateur
            Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
            confirmationAlert.setTitle("Confirmation de suppression");
            //confirmationAlert.setHeaderText("Supprimer le vol " + volSelectionne.getId() + " ?");
            confirmationAlert.setContentText("Êtes-vous sûr de vouloir supprimer ce vol ? Cette action est irréversible.");
            ButtonType okButton = new ButtonType("Oui", ButtonBar.ButtonData.OK_DONE);
            ButtonType cancelButton = new ButtonType("Non", ButtonBar.ButtonData.CANCEL_CLOSE);
            confirmationAlert.getButtonTypes().setAll(okButton, cancelButton);

            Optional<ButtonType> result = confirmationAlert.showAndWait();
            if (((Optional<?>) result).get() == okButton) {
                // Supprimez le vol
                try {
                    //volService.delete(volSelectionne.getId());  // Remplacez par votre méthode de suppression
                    chargerDonnees();
                } catch (Exception e) {
                    // Affichez un message d'erreur à l'utilisateur
                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                    errorAlert.setTitle("Erreur de suppression");
                    errorAlert.setHeaderText("Le vol n'a pas pu être supprimé");
                    errorAlert.setContentText("Une erreur est survenue lors de la suppression du vol. Veuillez réessayer plus tard.");
                    errorAlert.showAndWait();
                }
            }
        } else {
            // Affichez un message d'erreur si aucun vol n'est sélectionné
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Aucun vol sélectionné");
            alert.setHeaderText("Sélectionnez un vol");
            alert.setContentText("Veuillez sélectionner un vol dans la liste avant de le supprimer.");
            alert.showAndWait();
        }
    }


}


