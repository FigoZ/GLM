package io.swagger.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class GeographicLocationDaoImpl <T> extends newBaseDaoImpl{
    private static Logger log = Logger.getLogger(GeographicLocationDaoImpl.class.getName());

    @Autowired
    public GeographicLocationDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> find() {
        log.info("Call find()");
        return openSession().createQuery("from GeographicLocation").list();
    }

    public void save(T item) {
        openSession().saveOrUpdate(item);
    }
}
