package tn.esprit.gestionvols.Services;

import tn.esprit.gestionvols.DAO.DAO_Vol;
import tn.esprit.gestionvols.Models.Vol;

import java.util.List;
public class serviceVol {

    private DAO_Vol service  = new DAO_Vol();

    public void create(Vol vol){
        service.create(vol);
    }
    public void delete(int id){
        service.delete(id);
    }
    public List<Vol> getAll(){
        return service.getAll();
    }

    public Vol getById(int id){
        return service.getById(id);
    }

    public void Update(Vol vol){
        service.update(vol);
    }



}
