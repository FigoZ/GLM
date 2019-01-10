package io.swagger.dao;

import io.swagger.model.GeographicLocation;
import io.swagger.model.RetrieveLocationRelation;
import org.hibernate.SessionFactory;
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
}
