package tn.esprit.gestionvols.Services;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import tn.esprit.gestionvols.SQLDataAccess.SDAavion;
import tn.esprit.gestionvols.Models.Avion;

import java.util.List;

public class serviceAvion {
    private SDAavion service = new SDAavion();

    @FXML
    private TextField idField;
    @FXML
    private TextField modelField;
    @FXML
    private TextField serialNumberField;
    @FXML
    private TextField capacityField;
    @FXML
    private TextField stateField;

    public void AjouterAvion(Avion avion){
        service.create(avion);
    }

    public void SupprimerAvion(int id){
        service.delete(id);
    }

    public List<Avion> GetAllAvion(){
        return service.getAll();
    }

    public Avion GetAvionById(int id){
        return service.getById(id);
    }

    public void ModifierAvion(Avion av){
        service.update(av);
    }

    public void handleAjouterAvion(ActionEvent actionEvent) {
        String model = modelField.getText();
        String serialNumber = serialNumberField.getText();
        int capacity = Integer.parseInt(capacityField.getText());
        String state = stateField.getText();

        Avion avion = new Avion(747, "12345", "416", "Active", 2000);
        AjouterAvion(avion);
    }

    public void handleModifierAvion(ActionEvent actionEvent) {
        int id = Integer.parseInt(idField.getText());
        String model = modelField.getText();
        String serialNumber = serialNumberField.getText();
        int capacity = Integer.parseInt(capacityField.getText());
        String state = stateField.getText();

        Avion avion = GetAvionById(id);
        avion.setModel(model);
        avion.setSerialNumber(serialNumber);
        avion.setCapacity(capacity);
        avion.setState(state);

        ModifierAvion(avion);
    }

    public void handleSupprimerAvion(ActionEvent actionEvent) {
        int id = Integer.parseInt(idField.getText());
        SupprimerAvion(id);
    }
}