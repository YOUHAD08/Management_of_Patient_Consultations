package ma.enset.management_of_patient_consultations.DAO;

import java.sql.SQLException;
import java.util.List;

public interface IGeneric_DAO<E,U>{
    void Create(E e) throws SQLException;
    void Update(E e) throws SQLException;
    void Delete(E e) throws SQLException;
    List<E> getAll() throws SQLException;
    E getById(U id) throws SQLException;
}
