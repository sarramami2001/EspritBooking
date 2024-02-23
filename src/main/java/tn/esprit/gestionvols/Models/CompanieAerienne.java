package tn.esprit.gestionvols.Models;




public class CompanieAerienne {

    private int id;
    private String nom;
    private String adresse;

    public CompanieAerienne() {

    }
    // private ArrayList<Vol> ListVol;
   // private ArrayList<Aeroport> listAeroport;
   // private ArrayList<Equipage> listEquipage;
   //private ArrayList<Avion> listAvion;
    //private ArrayList<Voyageur> listVoyageur;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CompanieAerienne( String nom, String adresse) {

        this.nom = nom;
        this.adresse = adresse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}


