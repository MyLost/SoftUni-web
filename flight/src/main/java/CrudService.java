import java.util.HashSet;
import java.util.Set;

public interface CrudService<ID, T> {

    Set<T> findAll() ;
    T findById(ID id);
    T save(ID id, T object);
    void deleteById(ID id);
    void delete(T object);
}
