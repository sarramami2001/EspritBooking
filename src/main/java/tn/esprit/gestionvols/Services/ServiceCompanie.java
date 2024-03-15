package tn.esprit.gestionvols.Services;

import tn.esprit.gestionvols.SQLDataAccess.DAOCompanie;
import tn.esprit.gestionvols.Models.CompanieAerienne;

import java.util.List;

public class ServiceCompanie {
    private DAOCompanie service = new DAOCompanie();
    CompanieAerienne ca = new CompanieAerienne("tunisieBooking","tunis");
    public void AjouterCompanie(CompanieAerienne ca){
        service.create(ca);
    }
    public void SupprimerCompanie(int id){
        service.delete(id);
    }
     public List<CompanieAerienne> GetAllCompanies(){
       return service.getAll();
    }

    public CompanieAerienne GetCompanieById(int id){
        return service.getById(id);
    }

    public void ModifierCompanie(CompanieAerienne companieAerienne){
        service.update(companieAerienne);
    }

}
