package daxzel.model.services;

import java.util.List;

public interface AbstractService<T> {
	
	void add(T entity);

    List<T> getAll();
    
    T getByID(Long id);
    
    void remove(Long id);

}
