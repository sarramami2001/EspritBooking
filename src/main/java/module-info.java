module tn.esprit.gestionvols {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.controlsfx.controls;

    opens tn.esprit.gestionvols to javafx.fxml;
    exports tn.esprit.gestionvols;
}