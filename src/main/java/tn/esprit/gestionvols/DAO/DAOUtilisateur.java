package tn.esprit.gestionvols.DAO;

import tn.esprit.gestionvols.Models.Utilisateur;
import tn.esprit.gestionvols.Utilities.Role;
import tn.esprit.gestionvols.Utilities.SingletonConnexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOUtilisateur implements InterfaceDAO<Utilisateur> {
    SingletonConnexion dbConnection = SingletonConnexion.getInstance();
    Connection connexion = dbConnection.getConnection();

    @Override
    public void create(Utilisateur obj) {
        try {
            PreparedStatement ps = connexion.prepareStatement(
                    "insert into utilisateur (`nom`, `prenom`, `email`, `numTel`, `cin`, `numPasseport`, `role`) values (?,?,?,?,?,?,?)");

            ps.setString(1, obj.getNom());
            ps.setString(2, obj.getPrenom());
            ps.setString(3, obj.getEmail());
            ps.setInt(4, obj.getNumTel());
            ps.setString(5, obj.getCin());
            ps.setString(6, obj.getNumPasseport());
            ps.setString(7,obj.getRole().toString());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public Utilisateur getById(int id) {
        Utilisateur user = new Utilisateur();
        try {
            PreparedStatement ps = connexion.prepareStatement("select * from utilisateur where utilisateur_id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user.setUtilisateur_id((rs.getInt(1)));
                user.setNom(rs.getString(2));
                user.setPrenom(rs.getString(3));
                user.setEmail(rs.getString(4));
                user.setNumTel(rs.getInt(5));
                user.setCin(rs.getString(6));
                user.setNumPasseport(rs.getString(7));
                user.setRole(Role.valueOf(rs.getString(8)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<Utilisateur> getAll() {
        List<Utilisateur> listeUtilisateur = new ArrayList<>();
        try {
            PreparedStatement ps = connexion.prepareStatement("select * from utilisateur");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Utilisateur user = new Utilisateur();
                user.setUtilisateur_id((rs.getInt(1)));
                user.setNom(rs.getString(2));
                user.setPrenom(rs.getString(3));
                user.setEmail(rs.getString(4));
                user.setNumTel(rs.getInt(5));
                user.setCin(rs.getString(6));
                user.setNumPasseport(rs.getString(7));
                user.setRole(Role.valueOf(rs.getString(8)));
                listeUtilisateur.add(user);
            }
        } catch (SQLException e) {
            return null;
        }
        return listeUtilisateur;
    }

    @Override
    public void update(Utilisateur obj) {
        try {
            PreparedStatement ps = connexion.prepareStatement(

                    "update utilisateur set nom=?,prenom=? ,email=? ,numTel=?  where utilisateur_id=?");
            ps.setString(1, obj.getNom());
            ps.setString(2, obj.getPrenom());
            ps.setString(3,obj.getEmail());
            ps.setInt(4, obj.getNumTel());
            ps.setInt(5, obj.getUtilisateur_id());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement ps = connexion.prepareStatement("DELETE FROM utilisateur WHERE utilisateur_id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }

    }

    public void changerRole(Utilisateur obj,Role role) {
        try {
            PreparedStatement ps = connexion.prepareStatement(

                    "update utilisateur set role=?  where utilisateur_id=?");
            ps.setString(1, role.toString());
            ps.setInt(2, obj.getUtilisateur_id());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

}
