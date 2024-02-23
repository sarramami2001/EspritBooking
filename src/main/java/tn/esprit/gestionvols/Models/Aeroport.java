package tn.esprit.gestionvols.Models;

import java.util.List;

public class Aeroport {
    private int id;
    private  String nom,ville,pays;
    private List<CompagnieAerienne> compagnieAerienneList;

    public Aeroport() {

    }

    public Aeroport( String nom, String ville, String pays, List<CompagnieAerienne> compagnieAerienneList) {

        this.nom = nom;
        this.ville = ville;
        this.pays = pays;
        this.compagnieAerienneList = compagnieAerienneList;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public List<CompagnieAerienne> getCompagnieAerienneList() {
        return compagnieAerienneList;
    }

    public void setCompagnieAerienneList(List<CompagnieAerienne> compagnieAerienneList) {
        this.compagnieAerienneList = compagnieAerienneList;
    }

    @Override
    public String toString() {
        return "Aeroport{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", ville='" + ville + '\'' +
                ", pays='" + pays + '\'' +
                ", compagnieAerienneList=" + compagnieAerienneList +
                '}';
    }
}
