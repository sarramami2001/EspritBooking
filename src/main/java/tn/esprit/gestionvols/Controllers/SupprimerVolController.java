package tn.esprit.gestionvols.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import tn.esprit.gestionvols.Models.Vol;
import tn.esprit.gestionvols.Services.serviceVol;
import javafx.scene.control.ButtonType;


import java.sql.SQLException;
import java.util.Optional;

public class SupprimerVolController {

    @FXML
    private TextField tfidvol;

    @FXML
    private TextField tfdestination;

    @FXML
    private Button btnsupprimer;

    private serviceVol service = new serviceVol();

    public void initialize() {

    }

    @FXML
    void supprimerVol() {
        try {
            int idVol = Integer.parseInt(tfidvol.getText());
            String destinationVol = tfdestination.getText();

            // Vérifier si l'ID et la destination ne sont pas vides
            if (!tfidvol.getText().isEmpty() && !destinationVol.isEmpty()) {
                // Vérifier si l'ID du vol existe dans la base de données
                Vol existingVol = service.getById(idVol);
                if (existingVol != null) {
                    // Afficher une boîte de dialogue de confirmation
                    Alert confirmation = new Alert(AlertType.CONFIRMATION);
                    confirmation.setTitle("Confirmation de suppression");
                    confirmation.setHeaderText(null);
                    confirmation.setContentText("Êtes-vous sûr de vouloir supprimer le vol avec l'ID " + idVol + " ?");

                    // Attendre la réponse de l'utilisateur
                    Optional<ButtonType> result = confirmation.showAndWait();

                    // Si l'utilisateur confirme la suppression
                    if (result.isPresent() && result.get() == ButtonType.OK) {
                        // Supprimer le vol
                        service.delete(idVol);

                        // Afficher un message de succès
                        Alert success = new Alert(AlertType.INFORMATION);
                        success.setTitle("Suppression réussie");
                        success.setHeaderText(null);
                        success.setContentText("Le vol avec l'ID " + idVol + " a été supprimé avec succès.");
                        success.showAndWait();
                    }
                } else {
                    // Afficher un message indiquant que le vol avec cet ID n'existe pas
                    Alert notFound = new Alert(AlertType.WARNING);
                    notFound.setTitle("Vol introuvable");
                    notFound.setHeaderText(null);
                    notFound.setContentText("Le vol avec l'ID " + idVol + " n'existe pas dans la base de données.");
                    notFound.showAndWait();
                }
            } else {
                // Afficher un message d'avertissement si l'ID ou la destination est vide
                Alert warning = new Alert(AlertType.WARNING);
                warning.setTitle("Champs requis");
                warning.setHeaderText(null);
                warning.setContentText("Veuillez saisir l'ID du vol à supprimer et sa destination.");
                warning.showAndWait();
            }
        } catch (NumberFormatException e) {
            // Afficher un message d'erreur si l'ID n'est pas un nombre valide
            Alert error = new Alert(AlertType.ERROR);
            error.setTitle("ID invalide");
            error.setHeaderText(null);
            error.setContentText("Veuillez saisir un ID de vol valide.");
            error.showAndWait();
        }
    }





}
