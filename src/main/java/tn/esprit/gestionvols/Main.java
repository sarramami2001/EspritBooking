package tn.esprit.gestionvols;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tn.esprit.gestionvols.Services.ServiceUtilisateur;
import tn.esprit.gestionvols.Utilities.SingletonConnexion;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        ServiceUtilisateur s=new ServiceUtilisateur();
        System.out.println(s.AfficherUtilisateurById(9));

    }
}