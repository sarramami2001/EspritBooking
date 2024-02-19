package tn.esprit.gestionvols;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tn.esprit.gestionvols.Utilities.SingletonConnexion;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    /*@Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }*/

    public static void main(String[] args) {
       // launch();

        /* creation instance de la connexion
        SingletonConnexion dbConnection = SingletonConnexion.getInstance();
        Connection conn = dbConnection.getConnection();

        // Fermeture de la connexion à la base de données
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }
}