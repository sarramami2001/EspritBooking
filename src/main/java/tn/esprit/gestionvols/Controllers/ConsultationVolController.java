package tn.esprit.gestionvols.Controllers;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import tn.esprit.gestionvols.Models.Vol;
import tn.esprit.gestionvols.Services.serviceVol;

import java.util.List;
import java.util.Optional;

public class ConsultationVolController {

    @FXML
    private TableView<Vol> table;

    @FXML
    private TableColumn<Vol, String> coldestination;

    @FXML
    private TableColumn<Vol, String> coletat;

    @FXML
    private TableColumn<Vol, Integer> colnbplaces;

    @FXML
    private TableColumn<Vol, Float> colprix;

    @FXML
    private TableColumn<Vol, String> coldatevol;

    @FXML
    private TableColumn<Vol, String> colheuredepart;

    @FXML
    private TableColumn<Vol, String> colheureatt;

    @FXML
    private TableColumn<Vol, Integer> colid;
    @FXML
    private Button btnSup;
    @FXML
    private Button btnmodif;
    int id =0;
    String des ="";
    String state ="";
    String datedep ="";
    String heurdep="";
    String heurarr="";
    float prix=0;
    int nbreP=0;




    @FXML
    void supprimerVol(ActionEvent event) {
        service.delete(id);
        show();
    }
    @FXML
    void ModifierVol(ActionEvent event) {
        showCustomAlert(id);
    }

    private void showCustomAlert(int id) {
        // Créer un formulaire personnalisé
        GridPane formGrid = new GridPane();
        ButtonType saveButtonType = new ButtonType("Save");
        formGrid.setPadding(new Insets(10));
        formGrid.setHgap(5);
        formGrid.setVgap(5);

        TextField textField1 =new TextField() ;
        TextField textField2 = new TextField();
        TextField textField3 = new TextField();
        TextField textField4 = new TextField();
        TextField textField5 = new TextField();
        TextField textField6 = new TextField();
        TextField textField7 = new TextField();// houni nzid les fields fel popup
textField1.setText(des);
textField2.setText(state);
textField3.setText(datedep);
textField4.setText(heurdep);
textField5.setText(heurarr);
textField6.setText(Integer.toString(nbreP));
textField7.setText(Float.toString(prix));/// houni zeda
        formGrid.addRow(0, new Label("Destination:"), textField1);
        formGrid.addRow(1, new Label("Etat:"), textField2);
        formGrid.addRow(2, new Label("Date Vol:"), textField3);
        formGrid.addRow(3, new Label("Heure Départ:"), textField4);
        formGrid.addRow(4, new Label("Heure atterissage:"), textField5);
        formGrid.addRow(5, new Label("Nombre de places:"), textField6);
        formGrid.addRow(6, new Label("Prix:"), textField7);
        //houni zede

        // Créer une alerte personnalisée avec le formulaire
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Modifier Vol");
        alert.setHeaderText("Vous venez de modifier ce vol ");
        alert.getDialogPane().setContent(formGrid);
        alert.getButtonTypes().setAll(saveButtonType, ButtonType.CANCEL);

        Optional<ButtonType> result = alert.showAndWait();

        if ( result.get() == saveButtonType) {
            System.out.println(id);
            Vol vol = new Vol(id,des,state,prix,nbreP,datedep,heurdep,heurarr);//houni zede
            vol.setId(id);
            vol.setDestination(textField1.getText());
            vol.setEtat(textField2.getText());
            vol.setDate_vol(textField3.getText());
            vol.setPrix(Float.parseFloat(textField7.getText()));
            vol.setHeure_depart(textField4.getText());
            vol.setHeure_atterissage(textField5.getText());
            vol.setNombre_total_places(Integer.parseInt(textField6.getText()));//houni zede
            System.out.println(id);
            System.out.println(vol);
            service.Update(vol);
            show();
        }
       // System.out.println(vol);
        //alert.showAndWait();
    }

    @FXML
    void getData(MouseEvent event) {
        Vol vol= table.getSelectionModel().getSelectedItem();
        id = vol.getId();
        des = vol.getDestination();
        state = vol.getEtat();
        datedep =vol.getDate_vol();
        heurarr=vol.getHeure_atterissage();
        heurdep= vol.getHeure_depart();;
        nbreP=vol.getNombre_total_places();
        prix= vol.getPrix();
    }

    private serviceVol service = new serviceVol();
    public void show(){
        try {
            // Get all flights from the service layer
            List<Vol> vols = service.getAll();

            // Set up table columns
            coldestination.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDestination()));
            coletat.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEtat()));
            colnbplaces.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getNombre_total_places()).asObject());
            colprix.setCellValueFactory(cellData -> new SimpleFloatProperty(cellData.getValue().getPrix()).asObject());
            coldatevol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDate_vol()));
            colheuredepart.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getHeure_depart()));
            colheureatt.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getHeure_atterissage()));
            colid.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getId()).asObject());

            // Add data to the table
            table.setItems(FXCollections.observableArrayList(vols));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void initialize() {
      show();
    }


}
