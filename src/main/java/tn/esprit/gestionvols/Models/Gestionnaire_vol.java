package tn.esprit.gestionvols.Models;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalTime;

public class Gestionnaire_vol {

    private ArrayList <Vol> liste_vols;
    private ArrayList <Passager> liste_passagers;
    private ArrayList <Reservation> liste_reservations;

    public Gestionnaire_vol(){
        liste_vols=new ArrayList();
        liste_passagers= new ArrayList();
        liste_reservations= new ArrayList();
    }



    //Recherche passager
    public Passager recherche_passager(String pass ) {
        for (int i = 0 ; i<liste_passagers.size(); i++)
            if (liste_passagers.get(i).getNum_passeport().equals(pass))
                return liste_passagers.get(i);
        return null;
    }


    // ajout_passager
    public void ajout_passager() {
        Scanner sc  = new Scanner(System.in);
        System.out.println("Donne le numero du passport du passager: \n");
        String temp = sc.next();
        if (recherche_passager(temp) == null)
            liste_passagers.add(new Passager(temp));
        else System.out.println("DEJA EXISTANT !\n");

    }


    //ajout_vol
    public void ajout_vol() {
        Scanner sc  = new Scanner(System.in);
        System.out.println("Donne la reference du vol: \n");
        String temp = sc.next();
        if (recherche_vol(temp) == null)
            liste_vols.add(new Vol(temp));
        else System.out.println("DEJA EXISTANT !\n");

    }


    //RECHERCHE_VOL
    public Vol recherche_vol(String ref ) {
        for (int i = 0 ; i<liste_vols.size(); i++)
            if (liste_vols.get(i).getRef().equals(ref))
                return liste_vols.get(i);
        return null;
    }

    // CREATION RESERVATION
    public void creer_reservation() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Saisir le numero du passport du passager : \n");
        String temp = sc.next();
        if (recherche_passager(temp) !=null)
        {System.out.println("Saisir la reference du vol: \n");
            String temp2 = sc.next();
            if (recherche_vol(temp2) != null)
                liste_reservations.add(new reservation(recherche_passager(temp),recherche_vol(temp2)));
            else System.out.println("Vol nexiste pas\n");

        }else {System.out.println("Passager nexiste pas\n");}
    }



    //Liste passager par vol
    public void affcichage_par_vol() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Donner la reference du vol \n");
        String temp2 = sc.next();
        if (recherche_vol(temp2) != null)
            for (int i = 0 ; i<liste_reservations.size();i++)
                if (liste_reservations.get(i).getVol().getRef().equals(temp2))
                    System.out.println(liste_reservations.get(i).getClient().toString());
                else
                    System.out.println("Vol nexiste pas \n");g..
    }


    //informer le passager des vols annulés 24h en avance
    public void info_passager() {
        for (int i = 0 ; i<liste_reservations.size(); i++)
            if (liste_reservations.get(i).getVol().getEtat().equals("annulé"))
                if (liste_reservations.get(i).getVol().getHeure_depart().minusHours(24).equals(LocalTime.now()));
        System.out.println("Bonjour, Le VOL EST ANNULE");
    }

}
