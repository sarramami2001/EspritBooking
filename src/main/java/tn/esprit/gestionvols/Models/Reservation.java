package tn.esprit.gestionvols.Models;

import java.time.LocalDate;
import java.util.Scanner;

public class reservation {

    private int nbr_billets_achetes, identifiant=0;
    private LocalDate date_reservation;
    private Passager client;
    private String mode;
    private Vol vol;

    public Vol getVol() {
        return vol;
    }
    public void setVol(Vol vol) {
        this.vol = vol;
    }
    @Override
    public String toString() {
        return "reservation [nbr_billets_achetes=" + nbr_billets_achetes + ", identifiant=" + identifiant
                + ", date_reservation=" + date_reservation + ", client=" + client + ", mode=" + mode + "]";
    }
    public int getNbr_billets_achetes() {
        return nbr_billets_achetes;
    }
    public void setNbr_billets_achetes(int nbr_billets_achetes) {
        this.nbr_billets_achetes = nbr_billets_achetes;
    }
    public int getIdentifiant() {
        return identifiant;
    }
    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }
    public LocalDate getDate_reservation() {
        return date_reservation;
    }
    public void setDate_reservation(LocalDate date_reservation) {
        this.date_reservation = date_reservation;
    }
    public Passager getClient() {
        return client;
    }
    public void setClient(Passager client) {
        this.client = client;
    }
    public String getMode() {
        return mode;
    }
    public void setMode(String mode) {
        this.mode = mode;
    }

    public reservation(Passager client,Vol vol) {
        Scanner sc  = new Scanner(System.in);
        this.client=client;
        this.vol = vol;

        this.identifiant =+1;

        System.out.println("Saisir le nombre de billets achetes : \n");
        this.nbr_billets_achetes=sc.nextInt();

        do{
            System.out.println("Saisir le mode de paiement :\n (esp) pour espece | (cheq) pour cheque | (carte) pour carte : \n ");
            this.mode = sc.nextLine();
        }while (!this.mode.equals("esp") && !this.mode.equals("cheq") &&!this.mode.equals("carte") );

        this.date_reservation=LocalDate.now();
    }

    public int montant_final() {
        return nbr_billets_achetes * vol.getPrix();
    }

}