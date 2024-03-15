package tn.esprit.gestionvols.Services;

import tn.esprit.gestionvols.SQLDataAccess.SDAavion;
import tn.esprit.gestionvols.Models.Avion;

import java.util.List;

public class serviceAvion {
    private SDAavion service = new SDAavion();

    public void AjouterAvion(Avion avion){
        service.create(avion);
    }

    public void SupprimerAvion(int id){
        service.delete(id);
    }

    public List<Avion> GetAllAvion(){
        return service.getAll();
    }

    public Avion GetAvionById(int id){
        return service.getById(id);
    }

    public void ModifierAvion(Avion av){
        service.update(av);
    }

}