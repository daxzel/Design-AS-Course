package daxzel.model.DAO;

import com.google.appengine.api.datastore.Key;

import java.util.List;

public interface AbstractDAO<T> {

    void addOrUpdate(T entity);
 
    List<T> getAll();
 
    void remove(Long id);

    void remove(Key key);
    
    T getByID(Long id);

    T getByID(Key key);
    
}
