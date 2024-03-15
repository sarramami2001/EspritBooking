package tn.esprit.gestionvols.SQLDataAccess;

import tn.esprit.gestionvols.Models.Avion;
import tn.esprit.gestionvols.Utilities.SingletonConnexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SDAavion implements InterfaceDAO<Avion> {

    SingletonConnexion dbConnection = SingletonConnexion.getInstance();
    Connection connexion = dbConnection.getConnection();
    @Override
    public void create(Avion obj) {
        try {
            PreparedStatement ps = connexion.prepareStatement(
                    "insert into avion ( `Model`, `serialNumber`, `manufactureDate`, `Capacity`, `State`) values (?,?,?,?,?,?)");

            ps.setString(1, obj.getModel());
            ps.setString(2, obj.getSerialNumber());
            ps.setInt(3, obj.getCapacity());
            ps.setString(4, obj.getState());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }

    @Override
    public Avion getById(int id) {
        Avion Avion = new Avion(1 , "N12345", "200", "Good", 2000);
        try {
            PreparedStatement ps = connexion.prepareStatement("select * from avion where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Avion.setId(rs.getInt(1));
                Avion.setModel(rs.getString(2));
                Avion.setSerialNumber(rs.getString(3));
                Avion.setCapacity(rs.getInt(4));
                Avion.setState(rs.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Avion;
    }

    @Override
    public List<Avion> getAll() {

        List<Avion> lst = new ArrayList<>();
        try {
            PreparedStatement ps = connexion.prepareStatement("select * from avion");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Avion avion = new Avion(1, "N12345", "200", "Good", 2000);
                avion.setId(rs.getInt(1));
                avion.setModel(rs.getString(2));
                avion.setSerialNumber(rs.getString(3));
                avion.setCapacity(rs.getInt(4));
                avion.setState(rs.getString(5));
                lst.add(avion);
            }
        } catch (SQLException e) {
            return null;
        }
        return lst;

    }

    @Override
    public void update(Avion obj) {
        try {
            PreparedStatement ps = connexion.prepareStatement("UPDATE avion SET Model=?, serialNumber=?, Capacity=?, State=? WHERE id=?");
            ps.setString(1, obj.getModel());
            ps.setString(2,obj.getSerialNumber());
            ps.setInt(3,obj.getCapacity());
            ps.setString(4,obj.getState());
            ps.setInt(5, obj.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }


    @Override
    public void delete(int id) {
        try {
            PreparedStatement ps = connexion.prepareStatement("DELETE FROM avion WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }

    }

}