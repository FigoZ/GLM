package io.swagger.dao;

import io.swagger.model.GeographicLocation;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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

    public List<T> findByCriteria(List findResurses) {
        log.info("Call find By Criteria");

        String hql = "SELECT GL.id,GL.href,GL.name,GL.type,GP.accuracy,GP.spatialRef,GP.x,GP.y,GP.z " +
                "FROM GeographicLocation GL JOIN GL.geographicPoint GP " +
                "WHERE GL.name like :f_name " +
                "AND GL.type like :f_type " +
                "AND GP.accuracy like :f_accuracy " +
                "AND GP.spatialRef like :f_SpatialRef " +
                "AND GP.x like :f_x " +
                "AND GP.y like :f_y " +
                "AND GP.z like :f_z";

        Query query = openSession().createQuery(hql);
        query.setParameter("f_name",findResurses.get(0));
        query.setParameter("f_type",findResurses.get(1));
        query.setParameter("f_accuracy",findResurses.get(2));
        query.setParameter("f_SpatialRef",findResurses.get(3));
        query.setParameter("f_x",findResurses.get(4));
        query.setParameter("f_y",findResurses.get(5));
        query.setParameter("f_z",findResurses.get(6));

        return query.list();
    }

}
