package io.swagger.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public abstract class newBaseDaoImpl <T>{
    @Autowired
    SessionFactory sessionFactory;

    public abstract List<T> find();

    public boolean add(List<T> items) {
        return false;
    }

    abstract T get(Serializable id);

    Session openSession() {
        return sessionFactory.getCurrentSession();
    }
}
