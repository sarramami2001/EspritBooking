package tn.esprit.gestionvols.DAO;

import tn.esprit.gestionvols.Models.Vol;
import tn.esprit.gestionvols.Utilities.SingletonConnexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DAO_Vol implements InterfaceDAO<Vol>{
    SingletonConnexion dbConnection = SingletonConnexion.getInstance();
    Connection connexion = dbConnection.getConnection();
    @Override
    public void create(Vol obj) {
            try {
                PreparedStatement ps = connexion.prepareStatement(
                        "insert into CompanieAerienne (`nom`, `adresse`) values (?,?)");

               // ps.setString(1, obj.getNom());
               // ps.setString(2, obj.getAdresse());
                ps.executeUpdate();
                ps.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

    }

    @Override
    public Vol getById(int id) {
        return null;
    }

    @Override
    public List<Vol> getAll() {
        return null;
    }

    @Override
    public void update(Vol obj) {

    }

    @Override
    public void delete(Vol obj) {
        try {
            PreparedStatement ps = connexion.prepareStatement("delete from etudiant where ncin=?");
           // ps.setInt(1, cin);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}
