package tn.esprit.gestionvols.DAO;
import java.util.ArrayList;
public interface AeroportMethods<T>{

    void addAeroport (T a);

    ArrayList<T> getAllAeroports();

    void updateAeroport(T a);

    void deleteAeroport(T a);
}
