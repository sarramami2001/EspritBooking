package tn.esprit.gestionvols.Models;

public class Bagage {
    private int id ;
    private String numTicket;
    private  float poids ;

    private String status;

    public Bagage(String numTicket, float poids, String status) {
        this.poids = poids;
        this.numTicket = numTicket;
        this.status = status;
    }

    public Bagage() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPoids() {
        return poids;
    }

    public void setPoids(float poids) {
        this.poids = poids;
    }

    public String getNumTicket() {
        return numTicket;
    }

    public void setNumTicket(String numTicket) {
        this.numTicket = numTicket;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
