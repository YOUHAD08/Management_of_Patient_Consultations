package ma.enset.management_of_patient_consultations.DAO;

import java.util.List;

public interface Generic_DAO <E,U>{
    void Create(E e);
    void Update(E e);
    void Delete(E e);
    List<E> getAll();
    E getById(U id);
}
