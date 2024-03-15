package tn.esprit.gestionvols.SQLDataAccess;

import java.util.List;

public interface InterfaceDAO<T> {
    void create(T obj);
    T getById(int id);
    List<T> getAll();
    void update(T obj);
    void delete(int id);

}

