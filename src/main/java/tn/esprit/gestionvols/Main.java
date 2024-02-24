package tn.esprit.gestionvols;
import tn.esprit.gestionvols.Models.Vol;
import tn.esprit.gestionvols.Services.service_vol;



public class Main {

    public static void main(String[] args) {
        Vol vol = new Vol("refvol1","Paris","atterri" ,700,220);
        service_vol s=new service_vol();
        s.create(vol);

    }
}