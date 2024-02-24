package tn.esprit.gestionvols.Services;

import tn.esprit.gestionvols.DAO.DAOavion;
import tn.esprit.gestionvols.Models.avion;
import java.time.LocalDate;

import java.util.List;

public class serviceAvion {
    private DAOavion service = new DAOavion();
    avion Avion = new avion("Boeing 747","N12345",200,"Good");
    public void AjouterAvion(avion Avion){
        service.create(Avion);
    }
    public void SupprimerAvion(int id){
        service.delete(id);
    }
    public List<avion> GetAllAvion(){
        return service.getAll();
    }

    public avion GetAvionById(int id){
        return service.getById(id);
    }

    public void ModifierAvion(avion av){
        service.update(av);
    }

}