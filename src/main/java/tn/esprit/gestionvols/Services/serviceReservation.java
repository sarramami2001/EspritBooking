package tn.esprit.gestionvols.Services;

import tn.esprit.gestionvols.DAO.DAO_Reservation;
import tn.esprit.gestionvols.Models.Reservation;

import java.util.List;
public class serviceReservation {

    private DAO_Reservation service  = new DAO_Reservation();

    public void create(Reservation reservation){
        service.create(reservation);
    }
    public void delete(int id){
        service.delete(id);
    }
    public List<Reservation> getAll(){
        return service.getAll();
    }

    public Reservation getById(int id){
        return service.getById(id);
    }

    public void Update(Reservation reservation){
        service.update(reservation);
    }



}
