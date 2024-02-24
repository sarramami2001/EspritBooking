package tn.esprit.gestionvols.Models;

import tn.esprit.gestionvols.Utilities.Role;

public class Utilisateur {
    private String nom,prenom,email,cin,numPasseport;
    private int utilisateur_id,numTel;
    private Role role;

    public Utilisateur() {
    }

    public Utilisateur(String nom, String prenom, String email, String cin, String numPasseport, int numTel, Role role) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.cin = cin;
        this.numPasseport = numPasseport;
        this.numTel = numTel;
        this.role = role;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUtilisateur_id() {
        return utilisateur_id;
    }

    public void setUtilisateur_id(int utilisateur_id) {
        this.utilisateur_id = utilisateur_id;
    }

    public int getNumTel() {
        return numTel;
    }

    public void setNumTel(int numTel) {
        this.numTel = numTel;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getNumPasseport() {
        return numPasseport;
    }

    public void setNumPasseport(String numPasseport) {
        this.numPasseport = numPasseport;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", utilisateur_id=" + utilisateur_id +
                ", numTel=" + numTel +
                ", cin=" + cin +
                ", numPasseport=" + numPasseport +
                ", role=" + role +
                '}';
    }
}
