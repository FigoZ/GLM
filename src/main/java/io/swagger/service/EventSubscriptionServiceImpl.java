package io.swagger.service;

import io.swagger.dao.EventSubscriptionDaoImpl;
import io.swagger.dao.GeographicLocationDaoImpl;
import io.swagger.model.EventSubscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional
public class EventSubscriptionServiceImpl extends newBaseServiceImpl {
    private static Logger log = Logger.getLogger(EventSubscriptionServiceImpl.class.getName());

    private final EventSubscriptionDaoImpl<EventSubscription> eventSubscriptionDao;

    @Autowired
    public EventSubscriptionServiceImpl(EventSubscriptionDaoImpl<EventSubscription> eventSubscriptionDao){
        this.eventSubscriptionDao = eventSubscriptionDao;
    }

    @Override
    @Transactional(propagation =  Propagation.REQUIRED, readOnly = true)
    public List<EventSubscription> list() {
        log.info("eventSubscriptionDao: " + eventSubscriptionDao);
        return eventSubscriptionDao.find();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.REPEATABLE_READ)
    @SuppressWarnings("unchecked")
    public void save(EventSubscription item) {
        log.info("save(): " + item);
        eventSubscriptionDao.save(item);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, value = "txManager")
    public void create(List<EventSubscription> items) {
        log.info("create(): " + items);
        for (EventSubscription t : items) {
            eventSubscriptionDao.save(t);
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.REPEATABLE_READ)
  //  @SuppressWarnings("unchecked")
    public void del(String id) {
        log.info("delete(): " + id);
//    EventSubscription ES= eventSubscriptionDao.get(id);
//        System.out.println(ES.getCallback()+"==========getCallback===========");
//       eventSubscriptionDao.delete(ES);
       eventSubscriptionDao.delete(eventSubscriptionDao.get(id));
    }




//    @Transactional(propagation = Propagation.REQUIRED)
//    public EventSubscription retrieve(String id) {
//
//        return eventSubscriptionDao.get(id);
//    }
}


//тест проходит, со страницы не сохраняет
//public class EventSubscriptionServiceImpl <T> extends newBaseServiceImpl {
//    private static Logger log = Logger.getLogger(EventSubscriptionServiceImpl.class.getName());
//
//    @Autowired
//    private EventSubscriptionDaoImpl<T> eventSubscriptionDao;
//
//    @Override
//    @Transactional(propagation =  Propagation.REQUIRED, readOnly = true)
//    public List<T> list() {
//        log.info("eventSubscriptionDao: " + eventSubscriptionDao);
//        return eventSubscriptionDao.find();
//    }
//
//    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.REPEATABLE_READ)
//    @SuppressWarnings("unchecked")
//    public void save(T item) {
//        log.info("save(): " + item);
//        eventSubscriptionDao.save(item);
//    }
//
//    @Transactional(propagation = Propagation.REQUIRES_NEW, value = "txManager")
//    public void create(List<T> items) {
//        log.info("create(): " + items);
//        for (T t : items) {
//            saveOne(t);
//        }
//    }
//
//    @Transactional(propagation = Propagation.REQUIRED)
//    public void saveOne(T item) {
//        eventSubscriptionDao.save(item);
//    }
//}
