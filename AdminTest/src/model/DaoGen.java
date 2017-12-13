
package model;

import java.util.List;


public interface DaoGen<T> {
    
    public List<T> getAll();
    public T getById(Long id);
    public void delete(T model);
    public void add(T model);
    public void update(T model, Long id);

}
