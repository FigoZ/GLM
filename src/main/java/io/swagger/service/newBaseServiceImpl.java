package io.swagger.service;

import java.util.List;
import java.util.logging.Logger;

public abstract class newBaseServiceImpl <T> {
    private static Logger log = Logger.getLogger(newBaseServiceImpl.class.getName());

    public abstract List<T> list();
}
