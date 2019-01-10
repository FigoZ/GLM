package io.swagger.service;

import io.swagger.dao.GeographicLocationDaoImpl;
import io.swagger.dao.RetrieveLocationRelationDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional
public class RetrieveLocationRelationServiceImpl<T> extends newBaseServiceImpl {
    private static Logger log = Logger.getLogger(RetrieveLocationRelationServiceImpl.class.getName());

    @Autowired
    private RetrieveLocationRelationDaoImpl<T> retrieveLocationRelationDao;

    private List<T> retriveList;

    @Override
    @Transactional(propagation =  Propagation.REQUIRED, readOnly = true)
    public List<T> list() {
        log.info("retrieveLocationRelationDao: " + retrieveLocationRelationDao);
        return retrieveLocationRelationDao.find();
    }

    @Transactional(propagation =  Propagation.REQUIRED, readOnly = true)
    public List<T> findById(Serializable id) {
        log.info("retrieveLocationRelationDao: " + retrieveLocationRelationDao);
        return (List<T>) List.of(retrieveLocationRelationDao.get(id));
    }



    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.REPEATABLE_READ)
    public void save(T item) {
        log.info("save(): " + item);
        retrieveLocationRelationDao.save(item);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, value = "txManager")
    public void create(List<T> items) {
        log.info("create(): " + items);
        for (T t : items) {
            saveOne(t);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveOne(T item) {
        retrieveLocationRelationDao.save(item);
    }


}
