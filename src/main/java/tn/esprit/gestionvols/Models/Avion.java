package tn.esprit.gestionvols.Models;

public class Avion {
    private String  Model, serialNumber,State ;
    private int id, Capacity;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String Model) {
        this.Model = Model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getState () {
        return State ;
    }

    public void setState (String State ) {
        this.State = State ;
    }

    public int getCapacity() {
        return Capacity;
    }

    public void setCapacity(int Capacity) {
        this.Capacity = Capacity;
    }



    public Avion(int id, String Model, String serialNumber, String State , int Capacity) {
        this.id = id;
        this.Model = Model;
        this.serialNumber = serialNumber;
        this.State = State;
        this.Capacity = Capacity;
    }

}