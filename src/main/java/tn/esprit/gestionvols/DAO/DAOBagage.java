package tn.esprit.gestionvols.DAO;

import tn.esprit.gestionvols.Models.Aeroport;
import tn.esprit.gestionvols.Models.Bagage;
import tn.esprit.gestionvols.Utilities.SingletonConnexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOBagage implements InterfaceDAO<Bagage> {

    SingletonConnexion dbConnection = SingletonConnexion.getInstance();
    Connection connexion = dbConnection.getConnection();
    @Override
    public void create(Bagage obj) {
        try {
            PreparedStatement ps = connexion.prepareStatement(
                    "insert into Bagage (`numticket`, `poids`,`status`) values (?,?,?)");

            ps.setString(1, obj.getNumTicket());
            ps.setFloat(2, obj.getPoids());
            ps.setString(3, obj.getStatus());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }

    @Override
    public Bagage getById(int id) {
        Bagage b = new Bagage();
        try {
            PreparedStatement ps = connexion.prepareStatement("select * from Bagage where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                b.setId(rs.getInt(1));
                b.setNumTicket(rs.getString(2));
                b.setPoids(rs.getFloat(3));
                b.setStatus(rs.getString(4));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return b;
    }

    @Override
    public List<Bagage> getAll() {

        List<Bagage> lst = new ArrayList<>();
        try {
            PreparedStatement ps = connexion.prepareStatement("select * from Bagage");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Bagage a = new Bagage();
                a.setId(rs.getInt(1));
                a.setNumTicket(rs.getString(2));
                a.setPoids(rs.getFloat(3));
                a.setStatus(rs.getString(4));
                lst.add(a);
            }
        } catch (SQLException e) {
            return null;
        }
        return lst;

    }

    @Override
    public void update(Bagage obj) {
        try {
            PreparedStatement ps = connexion.prepareStatement("UPDATE Bagage SET numTicket=?, poids=?, status=? WHERE id=?");
            ps.setString(1, obj.getNumTicket());
            ps.setFloat(2,obj.getPoids());
            ps.setString(3,obj.getStatus());

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }


    @Override
    public void delete(int id) {
        try {
            PreparedStatement ps = connexion.prepareStatement("DELETE FROM Bagage WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }

    }

}
