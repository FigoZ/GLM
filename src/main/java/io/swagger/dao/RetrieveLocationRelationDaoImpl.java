package io.swagger.dao;

import io.swagger.model.GeographicLocation;
import io.swagger.model.RetrieveLocationRelation;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class RetrieveLocationRelationDaoImpl<T> extends newBaseDaoImpl{
    private static Logger log = Logger.getLogger(RetrieveLocationRelationDaoImpl.class.getName());

    static Class<RetrieveLocationRelation> tClass = RetrieveLocationRelation.class;
    final static RetrieveLocationRelation RLR = new RetrieveLocationRelation();

    @Autowired
    public RetrieveLocationRelationDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> find() {
        log.info("Call find()");
        return openSession().createQuery("from RetrieveLocationRelation").list();
    }

    @Override
    public RetrieveLocationRelation get(Serializable id) {
//        return openSession().find(RLR.getClass(), id);
        return openSession().find(tClass, id);
    }

    public void save(T item) {
        openSession().saveOrUpdate(item);
    }

    public List<T> findByCriteria(List findResurses) {
        log.info("Call find By Criteria");

        String hql = "SELECT RLR.id, RLR.href, RLR.status, RLR.locationA, RLR.locationB, RLR.distance, RLR.time," +
                "I.id, I.href, I.name, I.type, GP.accuracy, GP.spatialRef, GP.x, GP.y, GP.z " +
                "FROM RetrieveLocationRelation RLR JOIN RLR.intersection I JOIN I.geographicPoint GP " +
                "WHERE RLR.status like :f_status " +
                      "AND RLR.locationA like :f_locA " +
                      "AND RLR.locationB like :f_locB " +
                      "AND RLR.distance like :f_distance " +
                      "AND I.name like :f_name " +
                      "AND I.type like :f_type";

        Query query = openSession().createQuery(hql);
        query.setParameter("f_status",findResurses.get(0));
        query.setParameter("f_locA",findResurses.get(1));
        query.setParameter("f_locB",findResurses.get(2));
        query.setParameter("f_distance",findResurses.get(3));
        query.setParameter("f_name",findResurses.get(4));
        query.setParameter("f_type",findResurses.get(5));

        return query.list();
    }
}
