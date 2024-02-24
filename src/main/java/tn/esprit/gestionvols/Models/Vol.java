package tn.esprit.gestionvols.Models;

import java.sql.Date;

public class Vol {

        private String ref, destination,etat;
        private int id,prix,nombre_places;
        private Date date_vol;
        private Date heure_depart, heure_atterissage;
        public String getRef() {
            return ref;
        }
        public void setRef(String ref) {
            this.ref = ref;
        }

    public int getId() {
        return id;
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

        public int getNombre_places() {
            return nombre_places;
        }

        public void setNombre_places(int nombre_places) {
            this.nombre_places = nombre_places;
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

        public Vol() {
        }

        public Vol(String ref, String destination, String etat, int prix, int nombre_places, Date date_vol,
                   Date heure_depart, Date heure_atterissage) {
            this.ref = ref;
            this.destination = destination;
            this.etat = etat;
            this.prix = prix;
            this.nombre_places = nombre_places;
            this.date_vol = date_vol;
            this.heure_depart = heure_depart;
            this.heure_atterissage = heure_atterissage;
        }

        @Override
        public String toString() {
            return "Vol [ref=" + ref + ", destination=" + destination + ", etat=" + etat + ", prix=" + prix
                    + ", nombre_places=" + nombre_places + ", date_vol=" + date_vol + ", heure_depart=" + heure_depart
                    + ", heure_atterissage=" + heure_atterissage + "]";
        }

}

