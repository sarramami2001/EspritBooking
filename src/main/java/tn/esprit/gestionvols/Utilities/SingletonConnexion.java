package tn.esprit.gestionvols.Utilities;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnexion {

    private static volatile SingletonConnexion instance;
    private static Connection connexion ;
    private SingletonConnexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/db_vols","root","");
            System.out.println("ok");
        }catch (Exception e) {
            System.out.println("cnx failed");
            e.printStackTrace();
        }
    }
   public static SingletonConnexion getInstance() {

        SingletonConnexion result = instance;
        if (result != null) {
            return result;
        }
        synchronized(SingletonConnexion.class) {
            if (instance == null) {
                instance = new SingletonConnexion();
            }
            return instance;
        }
    }
    public static Connection getConnection() {
        return connexion;
    }
}
