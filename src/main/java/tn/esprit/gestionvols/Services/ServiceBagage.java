package tn.esprit.gestionvols.Services;

import tn.esprit.gestionvols.DAO.DAOAeroport;
import tn.esprit.gestionvols.DAO.DAOBagage;
import tn.esprit.gestionvols.Models.Aeroport;
import tn.esprit.gestionvols.Models.Bagage;

import java.util.List;

public class ServiceBagage {
    private DAOBagage service = new DAOBagage();
    Bagage a = new Bagage("VOL123",30,"Perdu");
    public void AjouterBagage(Bagage a){

        service.create(a);
    }
    public void SupprimerBagage(int id){

        service.delete(id);
    }
    public List<Bagage> GetAllBagaes(){

        return service.getAll();
    }

    public Bagage GetBagageById(int id){

        return service.getById(id);
    }

    public void ModifierBagage(Bagage a){

        service.update(a);
    }

}
