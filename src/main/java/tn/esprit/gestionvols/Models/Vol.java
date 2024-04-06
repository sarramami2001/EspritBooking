package tn.esprit.gestionvols.Models;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;

import java.text.SimpleDateFormat;

public class Vol {
    private int id;
    private String destination;
    private String etat;
    private float prix;
    private int nombre_total_places;
    private String date_vol;
    private String heure_depart;
    private String heure_atterissage;


    public Vol() {
    }


    public Vol(String destination, String etat, float prix, int nombre_total_places, String date_vol, String heure_depart, String heure_atterissage) {
        this.destination = destination;
        this.etat = etat;
        this.prix = prix;
        this.nombre_total_places = nombre_total_places;
        this.date_vol = date_vol;
        this.heure_depart = heure_depart;
        this.heure_atterissage = heure_atterissage;
    }
    public Vol(int id ,String destination, String etat, float prix, int nombre_total_places, String date_vol, String heure_depart, String heure_atterissage) {
        this.destination = destination;
        this.etat = etat;
        this.prix = prix;
        this.nombre_total_places = nombre_total_places;
        this.date_vol = date_vol;
        this.heure_depart = heure_depart;
        this.heure_atterissage = heure_atterissage;
    }

    @Override
    public String toString() {
        return "Vol{" +
                "id=" + id +
                ", destination='" + destination + '\'' +
                ", etat='" + etat + '\'' +
                ", prix=" + prix +
                ", nombre_total_places=" + nombre_total_places +
                ", date_vol='" + date_vol + '\'' +
                ", heure_depart='" + heure_depart + '\'' +
                ", heure_atterissage='" + heure_atterissage + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getDate_vol() {
        return date_vol;
    }

    public void setDate_vol(String date_vol) {
        this.date_vol = date_vol;
    }

    public String getHeure_depart() {
        return heure_depart;
    }

    public void setHeure_depart(String heure_depart) {
        this.heure_depart = heure_depart;
    }

    public String getHeure_atterissage() {
        return heure_atterissage;
    }

    public void setHeure_atterissage(String heure_atterissage) {
        this.heure_atterissage = heure_atterissage;
    }

    public int getNombre_total_places() {
        return nombre_total_places;
    }


    public void setNombre_total_places(int nombre_total_places) {
        this.nombre_total_places = nombre_total_places;
    }



    public String getFormattedDateVol() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(date_vol); // Format the flight date
    }
    public String getFormattedHeureDepart() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        return formatter.format(heure_depart);
    }


    public String getFormattedHeureAtterrissage() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        return formatter.format(heure_atterissage);
    }






    /*public long getDureeVol() {
        // Créer une instance de Duration à partir des heures de départ et d'arrivée
        Duration duree = Duration.between((Temporal) heure_depart, (Temporal) heure_atterissage);

        // Convertir la durée en minutes
        long minutes = duree.toMinutes();

        // Retourner la durée en minutes
        return minutes;
    }*/


}