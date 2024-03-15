package tn.esprit.gestionvols.SQLDataAccess;

import tn.esprit.gestionvols.Models.CompanieAerienne;
import tn.esprit.gestionvols.Utilities.SingletonConnexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOCompanie implements InterfaceDAO<CompanieAerienne> {

    SingletonConnexion dbConnection = SingletonConnexion.getInstance();
    Connection connexion = dbConnection.getConnection();
    @Override
    public void create(CompanieAerienne obj) {
        try {
            PreparedStatement ps = connexion.prepareStatement(
                    "insert into CompanieAerienne (`nom`, `adresse`) values (?,?)");

            ps.setString(1, obj.getNom());
            ps.setString(2, obj.getAdresse());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }

    @Override
    public CompanieAerienne getById(int id) {
        CompanieAerienne ca = new CompanieAerienne();
        try {
            PreparedStatement ps = connexion.prepareStatement("select * from CompanieAerienne where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ca.setId(rs.getInt(1));
                ca.setNom(rs.getString(2));
                ca.setAdresse(rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ca;
    }

    @Override
    public List<CompanieAerienne> getAll() {

            List<CompanieAerienne> lst = new ArrayList<>();
            try {
                PreparedStatement ps = connexion.prepareStatement("select * from CompanieAerienne");
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    CompanieAerienne ca = new CompanieAerienne();
                    ca.setId(rs.getInt(1));
                    ca.setNom(rs.getString(2));
                    ca.setAdresse(rs.getString(3));
                    lst.add(ca);
                }
            } catch (SQLException e) {
                return null;
            }
            return lst;

    }

    @Override
    public void update(CompanieAerienne obj) {
        try {
            PreparedStatement ps = connexion.prepareStatement("UPDATE CompanieAerienne SET nom=?, adresse=? WHERE id=?");
            ps.setString(1, obj.getNom());
            ps.setString(2,obj.getAdresse());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }


    @Override
    public void delete(int id) {
        try {
            PreparedStatement ps = connexion.prepareStatement("DELETE FROM CompanieAerienne WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }

    }

}
