package io.swagger.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class EventSubscriptionDaoImpl<EventSubscription> extends newBaseDaoImpl{
    private static Logger log = Logger.getLogger(EventSubscriptionDaoImpl.class.getName());

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

    @SuppressWarnings("unchecked") //???
    public void save(EventSubscription item) {
        openSession().saveOrUpdate(item);
    }
}



//тест проходит, с сайте не сохраняет
//@Repository
//public class EventSubscriptionDaoImpl<T> extends newBaseDaoImpl{
//    private static Logger log = Logger.getLogger(EventSubscriptionDaoImpl.class.getName());
//
//    @Autowired
//    public EventSubscriptionDaoImpl(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//    @SuppressWarnings("unchecked")
//    @Override
//    public List<T> find() {
//        log.info("Call find()");
//        return openSession().createQuery("from EventSubscription").list();
//    }
//
//    public void save(T item) {
//        openSession().saveOrUpdate(item);
//    }
//}