package dao;

import model.Owner;

import java.sql.SQLException;
import java.util.List;

public interface OwnerDao {
    //Добавить новое авто
    void addOwner(Owner owner) throws SQLException;

    //Изменить авто
    void updateOwner(Owner owner) throws SQLException;

    //Удалить авто
    void dellOwner(Owner owner) throws SQLException;

    //Вывести список авто
    List<Owner> findAllOwners() throws SQLException;
}
