package tn.esprit.gestionvols.Models;
import java.sql.Date;

public class Reservation {
    private int id;
    private int idClient;
    private int idVol;
    private Date dateReservation;
    private int nombrePlaces;
    private String etatReservation;
    private int prixTotal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdVol() {
        return idVol;
    }

    public void setIdVol(int idVol) {
        this.idVol = idVol;
    }

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    public int getNombrePlaces() {
        return nombrePlaces;
    }

    public void setNombrePlaces(int nombrePlaces) {
        this.nombrePlaces = nombrePlaces;
    }

    public String getEtatReservation() {
        return etatReservation;
    }

    public void setEtatReservation(String etatReservation) {
        this.etatReservation = etatReservation;
    }

    public int getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(int prixTotal) {
        this.prixTotal = prixTotal;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", idClient=" + idClient +
                ", idVol=" + idVol +
                ", dateReservation=" + dateReservation +
                ", nombrePlaces=" + nombrePlaces +
                ", etatReservation='" + etatReservation + '\'' +
                ", prixTotal=" + prixTotal +
                '}';
    }

    public Reservation() {
    }

    public Reservation(int id, int idClient, int idVol, Date dateReservation, int nombrePlaces, String etatReservation, int prixTotal) {
        this.id = id;
        this.idClient = idClient;
        this.idVol = idVol;
        this.dateReservation = dateReservation;
        this.nombrePlaces = nombrePlaces;
        this.etatReservation = etatReservation;
        this.prixTotal = prixTotal;
    }

    public int calculerPrixTotal(Vol vol) {
        if (vol == null || nombrePlaces <= 0) {
            return 0;
        }
        return nombrePlaces * vol.getPrix();
    }


}
