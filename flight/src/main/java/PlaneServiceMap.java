import java.util.Set;

public class PlaneServiceMap extends AbstractMapService<Plane, Long> implements CrudService<Long, Plane> {

    @Override
    public Set<Plane> findAll() {
        return super.findAll();
    }

    @Override
    public Plane findById(Long id) {
        return super.findById(id);
    }

    @Override
    public void delete(Plane object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Plane save(Long id, Plane object) {
        return super.save(id, object);
    }
}
