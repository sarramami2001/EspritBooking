package tn.esprit.gestionvols.DAO;

import tn.esprit.gestionvols.Models.Vol;
import tn.esprit.gestionvols.Utilities.SingletonConnexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO_Vol implements InterfaceDAO<Vol>{
    SingletonConnexion dbConnection = SingletonConnexion.getInstance();
    Connection connexion = dbConnection.getConnection();
    @Override
    public void create(Vol obj) {
            try {
                PreparedStatement ps = connexion.prepareStatement(
                        "insert into vol (`ref`, `destination` ,`etat` , `prix`,`nombre_total_places`,`nombre_places_reservées`,`nombre_places_annulées`,`date_vol`,`heure_depart`,`heure_atterissage`) values (?,?,?,?,?,?,?,?,?,?)");
                ps.setString(1, obj.getRef());
                ps.setString(2, obj.getDestination());
                ps.setString(3, obj.getEtat());
                ps.setInt(4, obj.getPrix());
                ps.setInt(5, obj.getNombre_total_places());
                ps.setInt(6, obj.getNombre_places_reservées());
                ps.setInt(7, obj.getNombre_places_annulées());
                ps.setDate(8, obj.getDate_vol());
                ps.setDate(9, obj.getHeure_depart());
                ps.setDate(10, obj.getHeure_atterissage());

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
                vol.setNombre_total_places(rs.getInt(5));
                vol.setNombre_places_reservées(rs.getInt(6));
                vol.setNombre_places_annulées(rs.getInt(7));
                vol.setDate_vol(rs.getDate(8));
                vol.setHeure_depart(rs.getDate(9));
                vol.setHeure_atterissage(rs.getDate(10));
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
                vol.setNombre_total_places(rs.getInt(5));
                vol.setNombre_places_reservées(rs.getInt(6));
                vol.setNombre_places_annulées(rs.getInt(7));
                vol.setDate_vol(rs.getDate(8));
                vol.setHeure_depart(rs.getDate(9));
                vol.setHeure_atterissage(rs.getDate(10));
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
            PreparedStatement ps = connexion.prepareStatement("UPDATE Vol SET ref=?, destination=? , etat=? , prix=?, nombre_total_places=?, nombre_places_reservées=?,nombre_places_annulées=?,date_vol=? , heure_depart=? , heure_atterissage=? WHERE ref=?");
            ps.setString(1, obj.getRef());
            ps.setString(2, obj.getDestination());
            ps.setString(3, obj.getEtat());
            ps.setInt(4, obj.getPrix());
            ps.setInt(5, obj.getNombre_total_places());
            ps.setInt(6, obj.getNombre_places_reservées());
            ps.setInt(7, obj.getNombre_places_annulées());
            ps.setDate(8, obj.getDate_vol());
            ps.setDate(9, obj.getHeure_depart());
            ps.setDate(10, obj.getHeure_atterissage());
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

    public List<Vol> rechercherParDate(Date dateVol) throws SQLException {
        List<Vol> vols = new ArrayList<>();
        try (PreparedStatement ps = connexion.prepareStatement("SELECT * FROM vol WHERE date_vol = ?")) {
            ps.setDate(1, dateVol);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                vols.add(new Vol(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getDate(9), rs.getDate(10), rs.getDate(11)));
            }
        }
        return vols;
    }

    public List<Vol> rechercherParPrix(int prixMin, int prixMax) throws SQLException {
        List<Vol> vols = new ArrayList<>();
        try (PreparedStatement ps = connexion.prepareStatement("SELECT * FROM vol WHERE prix BETWEEN ? AND ?")) {
            ps.setInt(1, prixMin);
            ps.setInt(2, prixMax);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                vols.add(new Vol(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getDate(9), rs.getDate(10), rs.getDate(11)));
            }
        }
        return vols;
    }

    public List<Vol> rechercherParDestination(String destination) throws SQLException {
        List<Vol> vols = new ArrayList<>();
        try (PreparedStatement ps = connexion.prepareStatement("SELECT * FROM vol WHERE destination = ?")) {
            ps.setString(1, destination);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                vols.add(new Vol(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getDate(9), rs.getDate(10), rs.getDate(11)));
            }
        }
        return vols;
    }



}
