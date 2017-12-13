
package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import java.util.List;

public class DaoGenImpl<T> implements DaoGen<T>{
    
    private final Class<T> clazz;
    protected Session session;
    protected ServiceRegistry serviceRegistry;

    public DaoGenImpl(Class<T> clazz) {
        this.clazz = clazz;
    }
    
    public void openSession(){
        Configuration configuration = new Configuration().configure();
        serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        session = sessionFactory.openSession();
        session.beginTransaction();
    }
    
    public void closeSession(){
        session.getTransaction().commit();
        session.close();
        StandardServiceRegistryBuilder.destroy(serviceRegistry);
    }
    
    @Override
    public List<T> getAll() {
        openSession();
        List<T> list = session.createCriteria(clazz).list();
        closeSession();
        return list;
    }

    @Override
    public T getById(Long id) {
        openSession();
        T location = (T) session.load(clazz, id);
        closeSession();
        return location;
    }

    @Override
    public void delete(T model) {
        openSession();
        session.delete(model);
        closeSession();
    }

    @Override
    public void add(T model) {
        openSession();
        session.save(model);
        closeSession();
    }

    @Override
    public void update(T model, Long id) {
        openSession();
        session.update(model);
        session.flush();
        closeSession();
    }
    
}
