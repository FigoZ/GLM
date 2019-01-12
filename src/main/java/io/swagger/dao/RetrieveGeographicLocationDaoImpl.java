package io.swagger.dao;

import io.swagger.model.RetrieveGeographicLocation;
import io.swagger.model.RetrieveLocationRelation;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class RetrieveGeographicLocationDaoImpl<T> extends newBaseDaoImpl{
    private static Logger log = Logger.getLogger(RetrieveGeographicLocationDaoImpl.class.getName());

    static Class<RetrieveGeographicLocation> tClass = RetrieveGeographicLocation.class;

    @Autowired
    public RetrieveGeographicLocationDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> find() {
        log.info("Call find()");
        return openSession().createQuery("from RetrieveGeographicLocation").list();
    }

    @Override
    public RetrieveGeographicLocation get(Serializable id) {
        log.info("Call find by ID("+id+")");
        return openSession().find(tClass, id);
    }

    public void save(T item) {
        openSession().saveOrUpdate(item);
    }
}
