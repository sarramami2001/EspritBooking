package tn.esprit.gestionvols.DAO;

import tn.esprit.gestionvols.Models.Reservation;
import tn.esprit.gestionvols.Utilities.SingletonConnexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO_Reservation implements InterfaceDAO<Reservation> {

    SingletonConnexion dbConnection = SingletonConnexion.getInstance();
    Connection connexion = dbConnection.getConnection();

    @Override
    public void create(Reservation obj) {
        try (PreparedStatement ps = connexion.prepareStatement(
                "INSERT INTO Reservation (idClient, idVol, dateReservation, nombrePlaces, etatReservation, prixTotal) VALUES (?, ?, ?, ?, ?, ?)")) {
            ps.setInt(1, obj.getIdClient());
            ps.setInt(2, obj.getIdVol());
            ps.setDate(3, obj.getDateReservation());
            ps.setInt(4, obj.getNombrePlaces());
            ps.setString(5, obj.getEtatReservation());
            ps.setInt(6, obj.getPrixTotal());
            ps.executeUpdate();
        } catch (SQLException e1) {
            e1.printStackTrace();
        } // Missing closing parenthesis fixed here
    }

    @Override
    public Reservation getById(int id) {
        Reservation reservation = new Reservation();
        try (PreparedStatement ps = connexion.prepareStatement("select * from Reservation where id=?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                reservation.setId(rs.getInt(1));
                reservation.setIdClient(rs.getInt(2));
                reservation.setIdVol(rs.getInt(3));
                reservation.setDateReservation(rs.getDate(4));
                reservation.setNombrePlaces(rs.getInt(5));
                reservation.setEtatReservation(rs.getString(6));
                reservation.setPrixTotal(rs.getInt(7));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservation;
    }

    @Override
    public List<Reservation> getAll() {

        List<Reservation> reservations = new ArrayList<>();
        try (PreparedStatement ps = connexion.prepareStatement("select * from Reservation")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Reservation reservation = new Reservation();
                reservation.setId(rs.getInt(1));
                reservation.setIdClient(rs.getInt(2));
                reservation.setIdVol(rs.getInt(3));
                reservation.setDateReservation(rs.getDate(4));
                reservation.setNombrePlaces(rs.getInt(5));
                reservation.setEtatReservation(rs.getString(6));
                reservation.setPrixTotal(rs.getInt(7));
                reservations.add(reservation);
            }
        } catch (SQLException e) {
            return null;
        }
        return reservations;
    }

    @Override
    public void update(Reservation obj) {
        try (PreparedStatement ps = connexion.prepareStatement("UPDATE Reservation SET idClient = ?, idVol = ?, dateReservation = ?, nombrePlaces = ?, etatReservation = ?, prixTotal = ? WHERE id = ?")) {
            ps.setInt(1, obj.getIdClient());
            ps.setInt(2, obj.getIdVol());
            ps.setDate(3, obj.getDateReservation());
            ps.setInt(4, obj.getNombrePlaces());
            ps.setString(5, obj.getEtatReservation());
            ps.setInt(6, obj.getPrixTotal());
            ps.setInt(7, obj.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement ps = connexion.prepareStatement("delete from Reservation where id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}
