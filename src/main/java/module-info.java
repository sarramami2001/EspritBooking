
module tn.esprit.gestionvols {
        requires javafx.controls;
        requires javafx.fxml;
        requires java.sql;
        requires mysql.connector.j;

        opens tn.esprit.gestionvols to javafx.fxml;

        exports tn.esprit.gestionvols;

        exports tn.esprit.gestionvols.Controllers;
        opens tn.esprit.gestionvols.Controllers to javafx.fxml;

        }