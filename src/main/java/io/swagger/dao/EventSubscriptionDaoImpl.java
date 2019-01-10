package io.swagger.dao;

import io.swagger.model.EventSubscription;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

/*@Repository
public class EventSubscriptionDaoImpl<EventSubscription> extends newBaseDaoImpl{

    private static Logger log = Logger.getLogger(EventSubscriptionDaoImpl.class.getName());

    Class<EventSubscription> tClass;


    @Autowired
    public EventSubscriptionDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<EventSubscription> find() {
        log.info("Call find()");
        return openSession().createQuery("from EventSubscription").list();
    }

// как передать класс?
    @Override
   public EventSubscription get(Serializable id) {
        return openSession().find(???, id);
    }

    @SuppressWarnings("unchecked") //???
    public void save(EventSubscription item) {
        openSession().saveOrUpdate(item);
    }


}*/




@Repository
public class EventSubscriptionDaoImpl<T> extends newBaseDaoImpl{
    private static Logger log = Logger.getLogger(EventSubscriptionDaoImpl.class.getName());
    private final static EventSubscription ES = new EventSubscription();

    @Autowired
    public EventSubscriptionDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> find() {
        log.info("Call find()");
        return openSession().createQuery("from EventSubscription").list();
    }

    public void save(T item) {
        openSession().saveOrUpdate(item);
    }
    @Override
    public T get(Serializable id) {
        return (T) openSession().find(ES.getClass(), id);
    }

    public void delete(T item){
        openSession().delete(item);
    }
}