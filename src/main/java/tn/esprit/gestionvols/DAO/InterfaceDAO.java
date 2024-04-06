package tn.esprit.gestionvols.DAO;

import java.sql.SQLException;
import java.util.List;

public interface InterfaceDAO<T> {
    void create(T obj) throws SQLException;
    T getById(int id);
    List<T> getAll();
    void update(T obj);

    void delete(int id);
}

