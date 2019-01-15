package io.swagger.dao;

import io.swagger.model.GeographicLocation;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class GeographicLocationDaoImpl <T> extends newBaseDaoImpl{
    private static Logger log = Logger.getLogger(GeographicLocationDaoImpl.class.getName());

    static Class<GeographicLocation> tClass;
    final static GeographicLocation GL = new GeographicLocation();

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

    @Override
    public GeographicLocation get(Serializable id) {
        return openSession().find(GL.getClass(), id);
    }

    public void save(T item) {
        openSession().saveOrUpdate(item);
    }

    //test===============
  /*  public List<T> findByCriteria(List findResurses) {
        log.info("Call findfindByCriteria()");

        String hql = "FROM RetrieveGeographicLocation RGL WHERE RGL.thing.type like :f_type";

        Query query = openSession().createQuery(hql);
        query.setParameter("f_type",findResurses.get(4));

        return query.list();
    }*/
}
