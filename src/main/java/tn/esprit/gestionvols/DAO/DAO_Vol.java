package tn.esprit.gestionvols.DAO;

import tn.esprit.gestionvols.Models.Vol;
import tn.esprit.gestionvols.Utilities.SingletonConnexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO_Vol implements InterfaceDAO<Vol>{
    SingletonConnexion dbConnection = SingletonConnexion.getInstance();
    Connection connexion = dbConnection.getConnection();
    @Override
    public void create(Vol obj) {
            try {
                PreparedStatement ps = connexion.prepareStatement(
                        "insert into (`ref`, `destination` ,`etat` , `prix`,`nombre_places`,`date_vol`,`heure_depart`,`heure_atterissage`) values (?,?,?,?,?,?,?,?)");
                ps.setString(1, obj.getRef());
                ps.setString(2, obj.getDestination());
                ps.setString(3, obj.getEtat());
                ps.setInt(4, obj.getPrix());
                ps.setInt(5, obj.getNombre_places());
                ps.setDate(6, obj.getDate_vol());
                ps.setDate(7, obj.getHeure_depart());
                ps.setDate(8, obj.getHeure_atterissage());

                ps.executeUpdate();
                ps.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

    }

    @Override
    public Vol getById(int id) {
        Vol vol = new Vol();
        try {
            PreparedStatement ps = connexion.prepareStatement("select * from Vol where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                vol.setRef(rs.getString(1));
                vol.setDestination(rs.getString(2));
                vol.setEtat(rs.getString(3));
                vol.setPrix(rs.getInt(4));
                vol.setNombre_places(rs.getInt(5));
                vol.setDate_vol(rs.getDate(6));
                vol.setHeure_depart(rs.getDate(7));
                vol.setHeure_atterissage(rs.getDate(8));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vol;
    }

    @Override
    public List<Vol> getAll() {

        List<Vol> lst = new ArrayList<>();
        try {
            PreparedStatement ps = connexion.prepareStatement("select * from Vol");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Vol vol = new Vol();
                vol.setRef(rs.getString(1));
                vol.setDestination(rs.getString(2));
                vol.setEtat(rs.getString(3));
                vol.setPrix(rs.getInt(4));
                vol.setNombre_places(rs.getInt(5));
                vol.setDate_vol(rs.getDate(6));
                vol.setHeure_depart(rs.getDate(7));
                vol.setHeure_atterissage(rs.getDate(8));
                lst.add(vol);
            }
        } catch (SQLException e) {
            return null;
        }
        return lst;

    }

    @Override
    public void update(Vol obj) {
        try {
            PreparedStatement ps = connexion.prepareStatement("UPDATE Vol SET ref=?, destination=? , etat=? , prix=?, nombre_places=? ,date_vol=? , heure_depart=? , heure_atterissage=? WHERE ref=?");
            ps.setString(1, obj.getRef());
            ps.setString(2, obj.getDestination());
            ps.setString(3, obj.getEtat());
            ps.setInt(4, obj.getPrix());
            ps.setInt(5, obj.getNombre_places());
            ps.setDate(6, obj.getDate_vol());
            ps.setDate(7, obj.getHeure_depart());
            ps.setDate(8, obj.getHeure_atterissage());
            ps.executeUpdate();
} catch (SQLException e) {
        System.out.println(e.getMessage());
        }

        }

@Override
    public void delete(int id) {
        try {
            PreparedStatement ps = connexion.prepareStatement("delete from Vol where id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}
