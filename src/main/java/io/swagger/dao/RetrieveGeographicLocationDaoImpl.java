package io.swagger.dao;

import io.swagger.model.RetrieveGeographicLocation;
import io.swagger.model.RetrieveLocationRelation;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class RetrieveGeographicLocationDaoImpl<T> extends newBaseDaoImpl {
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
        return openSession().createQuery("FROM RetrieveGeographicLocation").list();
    }

    @Override
    public RetrieveGeographicLocation get(Serializable id) {
        log.info("Call find by ID(" + id + ")");
        return openSession().find(tClass, id);
    }

    public void save(T item) {
        openSession().saveOrUpdate(item);
    }

    public List<T> findByCriteria(List findResurses) {
        log.info("Call findfindByCriteria()");
        String selectAccuracy;
        if ((Float) findResurses.get(1) != 0F) {
            selectAccuracy = "RGL.requestedAccuracy = :f_accuracy";
        } else {
            selectAccuracy = "RGL.requestedAccuracy in (SELECT RGL.requestedAccuracy FROM RGL)";
        }
        ;

        String hql = "FROM RetrieveGeographicLocation RGL WHERE " +
                "RGL.status like :f_status AND " +
                selectAccuracy +
                " AND RGL.geographicLocation.name like :f_GLname" +
                " AND RGL.geographicLocation.type like :f_GLtype" +
                " AND RGL.thing.type like :f_Ttype" +
                " AND RGL.thing.uri like :f_Turi";

        Query query = openSession().createQuery(hql);
        query.setParameter("f_status", findResurses.get(0));

        if ((Float) findResurses.get(1) != 0F) {
            query.setParameter("f_accuracy", (Float) findResurses.get(1));
        }
        query.setParameter("f_GLname", findResurses.get(2));
        query.setParameter("f_GLtype", findResurses.get(3));
        query.setParameter("f_Ttype",findResurses.get(4));
        query.setParameter("f_Turi",findResurses.get(5));

        return query.list();
    }

}
