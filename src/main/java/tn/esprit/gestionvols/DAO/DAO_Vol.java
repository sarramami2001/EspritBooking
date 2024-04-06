package tn.esprit.gestionvols.DAO;

import tn.esprit.gestionvols.Models.Vol;
import tn.esprit.gestionvols.Utilities.SingletonConnexion;

import java.sql.*;
//import java.time.LocalDate;
//import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class DAO_Vol implements InterfaceDAO<Vol> {

    private SingletonConnexion dbConnection = SingletonConnexion.getInstance();
    private Connection connexion = dbConnection.getConnection();


    @Override
    public void create(Vol obj) {
        try (PreparedStatement ps = connexion.prepareStatement(
                "INSERT INTO vol (destination, etat, prix, nombre_total_places, date_vol, heure_depart, heure_atterissage) VALUES (?, ?, ?, ?, ?, ?, ?)")) {
            ps.setString(1, obj.getDestination());
            ps.setString(2, obj.getEtat());
            ps.setFloat(3, obj.getPrix());
            ps.setInt(4, obj.getNombre_total_places());
            ps.setString(5, obj.getDate_vol());
            ps.setString(6, obj.getHeure_depart());
            ps.setString(7, obj.getHeure_atterissage());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Vol getById(int id) {
        Vol vol = new Vol();
        try (PreparedStatement ps = connexion.prepareStatement("SELECT * FROM vol WHERE id = ?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                vol.setDestination(rs.getString(1));
                vol.setEtat(rs.getString(2));
                vol.setPrix(rs.getFloat(3));
                vol.setNombre_total_places(rs.getInt(4));
                vol.setDate_vol(rs.getString(5));
                vol.setHeure_depart(rs.getString(6));
                vol.setHeure_atterissage(rs.getString(7));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vol;
    }

    @Override
    public List<Vol> getAll() {
        List<Vol> vols = new ArrayList<>();
        try (PreparedStatement ps = connexion.prepareStatement("SELECT * FROM vol")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Vol vol = new Vol();

                vol.setDestination(rs.getString(1));
                vol.setEtat(rs.getString(2));
                vol.setNombre_total_places(rs.getInt(3));
                vol.setPrix(rs.getFloat(4));
                vol.setDate_vol(rs.getString(5));
                vol.setHeure_depart(rs.getString(6));
                vol.setHeure_atterissage(rs.getString(7));
                vol.setId(rs.getInt(8));
                vols.add(vol);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vols;
    }

    @Override
    public void update(Vol obj) {
        System.out.println("obj="+obj);
        try (PreparedStatement ps = connexion.prepareStatement(
                "UPDATE vol SET destination = ?, etat = ?, prix = ?, nombre_total_places = ?, date_vol = ?, heure_depart = ?, heure_atterissage = ? WHERE id = ?")) {
            ps.setString(1, obj.getDestination());
            ps.setString(2, obj.getEtat());
            ps.setFloat(3, obj.getPrix());
            ps.setInt(4, obj.getNombre_total_places());
            ps.setString(5, obj.getDate_vol());
            ps.setString(6, obj.getHeure_depart());
            ps.setString(7, obj.getHeure_atterissage());
            ps.setInt(8,obj.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement ps = connexion.prepareStatement("DELETE FROM vol WHERE id = ?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Vol> rechercherParDate( String date_vol) throws SQLException {
        List<Vol> vols = new ArrayList<>();
        try (PreparedStatement ps = connexion.prepareStatement("SELECT * FROM vol WHERE date_vol = ?")) {
            ps.setString(1,date_vol);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Vol vol = new Vol();
                vol.setDestination(rs.getString(1));
                vol.setEtat(rs.getString(2));
                vol.setPrix(rs.getInt(3));
                vol.setNombre_total_places(rs.getInt(4));
                vol.setDate_vol(rs.getString(5));
                vol.setHeure_depart(rs.getString(6));
                vol.setHeure_atterissage(rs.getString(7));
                vols.add(vol);
            }
        }
        return vols;
    }

    public List<Vol> rechercherParPrix(Float prixMin, Float prixMax) throws SQLException {
        List<Vol> vols = new ArrayList<>();
        try (PreparedStatement ps = connexion.prepareStatement("SELECT * FROM vol WHERE prix BETWEEN ? AND ?")) {
            ps.setFloat(1, prixMin);
            ps.setFloat(2, prixMax);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Vol vol = new Vol();
                vol.setDestination(rs.getString(1));
                vol.setEtat(rs.getString(2));
                vol.setPrix(rs.getFloat(3));
                vol.setNombre_total_places(rs.getInt(4));
                vol.setDate_vol(rs.getString(5));
                vol.setHeure_depart(rs.getString(6));
                vol.setHeure_atterissage(rs.getString(7));
                vols.add(vol);
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
                Vol vol = new Vol();
                vol.setDestination(rs.getString(1));
                vol.setEtat(rs.getString(2));
                vol.setPrix(rs.getInt(3));
                vol.setNombre_total_places(rs.getInt(4));
                vol.setDate_vol(rs.getString(5));
                vol.setHeure_depart(rs.getString(6));
                vol.setHeure_atterissage(rs.getString(7));
                vols.add(vol);
            }
        }
        return vols;
    }

}
