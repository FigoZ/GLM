package io.swagger.dao;


import io.swagger.model.RetrieveGeographicLocation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BaseDaoImpl <T>{
    public List<T> find(){
        return List.of(testData("1"),testData("2"),testData("3"));
    }
    public boolean add (List<T> items){
        return false;
    }

    private T testData(String prefix){

        RetrieveGeographicLocation RGL = new RetrieveGeographicLocation();
        RGL.setId(prefix);
        RGL.setStatus("active "+prefix);
        RGL.setRequestedAccuracy(15F);

        return (T) RGL;
    }
}
