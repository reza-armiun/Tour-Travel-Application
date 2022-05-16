package razarm.tosan.service;

import java.util.List;

public interface CrudService<T , ID>{
    T create(T t);
    void update( T t);
    T findById(ID id);
    void deleteById(ID id);
    List<T> findAll();
}
