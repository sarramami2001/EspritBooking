package tn.esprit.gestionvols.Models;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Vol {

    private int id;
    private String ref;
    private String destination;
    private String etat;
    private int prix;
    private int nombre_total_places;
    private int nombre_places_reservées;
    private int nombre_places_annulées;
    private Date date_vol;
    private Date heure_depart;
    private Date heure_atterissage;


    public Vol() {
    }


    public Vol(int id, String ref, String destination, String etat, int prix, int nombre_total_places, int nombre_places_reservées, int nombre_places_annulées, Date date_vol, Date heure_depart, Date heure_atterissage) {
        this.id = id;
        this.ref = ref;
        this.destination = destination;
        this.etat = etat;
        this.prix = prix;
        this.nombre_total_places = nombre_total_places;
        this.nombre_places_reservées = nombre_places_reservées;
        this.nombre_places_annulées = nombre_places_annulées;
        this.date_vol = date_vol;
        this.heure_depart = heure_depart;
        this.heure_atterissage = heure_atterissage;
    }

    @Override
    public String toString() {
        return "Vol{" +
                "id=" + id +
                ", ref='" + ref + '\'' +
                ", destination='" + destination + '\'' +
                ", etat='" + etat + '\'' +
                ", prix=" + prix +
                ", nombre_total_places=" + nombre_total_places +
                ", nombre_places_reservées=" + nombre_places_reservées +
                ", nombre_places_annulées=" + nombre_places_annulées +
                ", date_vol=" + date_vol +
                ", heure_depart=" + heure_depart +
                ", heure_atterissage=" + heure_atterissage +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
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

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }


    public Date getDate_vol() {
        return date_vol;
    }

    public void setDate_vol(Date date_vol) {
        this.date_vol = date_vol;
    }

    public Date getHeure_depart() {
        return heure_depart;
    }

    public void setHeure_depart(Date heure_depart) {
        this.heure_depart = heure_depart;
    }

    public Date getHeure_atterissage() {
        return heure_atterissage;
    }

    public void setHeure_atterissage(Date heure_atterissage) {
        this.heure_atterissage = heure_atterissage;
    }

    public int getNombre_total_places() {
        return nombre_total_places;
    }

    public void setNombre_total_places(int nombre_total_places) {
        this.nombre_total_places = nombre_total_places;
    }

    public int getNombre_places_reservées() {
        return nombre_places_reservées;
    }

    public void setNombre_places_reservées(int nombre_places_reservées) {
        this.nombre_places_reservées = nombre_places_reservées;
    }

    public int getNombre_places_annulées() {
        return nombre_places_annulées;
    }

    public void setNombre_places_annulées(int nombre_places_annulées) {
        this.nombre_places_annulées = nombre_places_annulées;
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

    public long getDureeVol() {
        // Différence en millisecondes entre l'heure d'atterrissage et l'heure de départ
        long differenceMillisecondes = heure_atterissage.getTime() - heure_depart.getTime();

        // Conversion en heures et minutes
        long heures = differenceMillisecondes / (60 * 60 * 1000);
        long minutes = (differenceMillisecondes % (60 * 60 * 1000)) / (60 * 1000);

        // Retourne la durée du vol en heures et minutes
        return heures * 60 + minutes;
    }

    public String isVolComplet() {
        // Calculer le nombre de places disponibles
        int nombre_places_disponibles = nombre_total_places - nombre_places_reservées + nombre_places_annulées;
        if (nombre_places_disponibles <= 0) {
            return "Le vol est complet !";
        } else {
            return "Des places sont encore disponibles.";
        }
    }



}