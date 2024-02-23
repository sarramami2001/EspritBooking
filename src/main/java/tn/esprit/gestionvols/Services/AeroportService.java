package tn.esprit.gestionvols.Services;

import tn.esprit.gestionvols.DAO.AeroportMethods;
import tn.esprit.gestionvols.Models.Aeroport;
import tn.esprit.gestionvols.Utilities.SingletonConnexion;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AeroportService implements AeroportMethods <Aeroport> {
    private Connection cnx;

    public AeroportService(){
        this.cnx= SingletonConnexion.getInstance().getConnection();
    }

    @Override
    public void addAeroport(Aeroport a) {
        String qry ="INSERT INTO 'Aeroport'('nom','ville','pays','compagnieaerienne'VALUES ('"+a.getNom()+"','"+a.getVille()+"','"+a.getPays()+"','"+a.getCompagnieAerienneList()+")";
        try{
            Statement stm =cnx.createStatement();
            stm.executeUpdate(qry);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }




    @Override
    public ArrayList getAllAeroports() {
        return null;
    }

    @Override
    public void updateAeroport(Aeroport a) {

    }

    @Override
    public void deleteAeroport(Aeroport a) {

    }


}
