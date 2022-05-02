package razarm.tosan.repository;

import java.util.List;

public interface CrudRepository <T, ID>{

    T save(T t);
    void update(T t);
    void deleteById(ID id);
    T findById(ID id);
    List<T> findAll();
}
