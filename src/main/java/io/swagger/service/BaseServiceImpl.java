package io.swagger.service;

import io.swagger.dao.BaseDaoImpl;
import io.swagger.model.RetrieveGeographicLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class BaseServiceImpl<T> {
    private static Logger log = Logger.getLogger(BaseDaoImpl.class.getName());


    @Autowired
    private BaseDaoImpl<RetrieveGeographicLocation> retrieveGeographicLocationBaseDao;

    public List<T> list(){
        log.info("retrieveGeographicLocationBaseDao" + retrieveGeographicLocationBaseDao);
        return (List<T>)retrieveGeographicLocationBaseDao.find();
    }
}
