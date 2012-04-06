package daxzel.model.DAO;

import java.util.List;

public interface AbstractDAO<T> {

    void addOrUpdate(T entity);
 
    List<T> getAll();
 
    void remove(Long id);
    
    T getByID(Long id);
    
}
