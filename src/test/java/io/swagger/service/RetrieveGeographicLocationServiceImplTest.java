package io.swagger.service;

import io.swagger.configuration.HibernateXMLConfTest;
import io.swagger.model.GeographicLocation;
import io.swagger.model.Object;
import io.swagger.model.RetrieveGeographicLocation;
import io.swagger.model.RetrieveLocationRelation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;
import org.threeten.bp.OffsetDateTime;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.List;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {HibernateXMLConfTest.class},
        loader = AnnotationConfigContextLoader.class)
@Transactional
public class RetrieveGeographicLocationServiceImplTest {

    @MockBean
    com.fasterxml.jackson.databind.ObjectMapper objectMapper;

    @MockBean
    HttpServletRequest httpServletRequest;

    @Resource
    RetrieveGeographicLocationServiceImpl objUnderTest;

    @Resource
    RetrieveGeographicLocationServiceImpl returRGL;


    public static RetrieveGeographicLocation createRLR (String prefix){
        RetrieveGeographicLocation RGL = new RetrieveGeographicLocation();
        RGL.setHref("Localhost/- "+prefix);
        RGL.setRequestedAccuracy(Float.valueOf(prefix));
        RGL.setStatus("Status-"+prefix);
        RGL.setTime(OffsetDateTime.now());
        return RGL;
    }


    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
   // @Ignore
    public void list() {
        // given
        RetrieveGeographicLocation RGL1 = createRLR("1");
// TODO: 11.01.2019 поставить @Autowaried ??

       GeographicLocation GL = new GeographicLocation();
       GL.setName("Test RGL-Service");
        RGL1.setGeographicLocation(GL);

        Object object = new Object();
        object.setType("Type RGL");
        object.setUri("host/objectRGL/nanana");
        RGL1.setThing(object);

        objUnderTest.save(RGL1);

        // when
        Serializable id = RGL1.getId();
        System.out.println("==========id "+id);
        assertNotNull(id);


        //сравнение даты
        List<RetrieveGeographicLocation> newRLR = returRGL.findById(id);
        assertEquals(RGL1.getTime(),newRLR.get(0).getTime());


        // then
        List<RetrieveGeographicLocation> retrieveGeographicLocationsList = objUnderTest.list();
      //  assertEquals(1, retrieveLocationRelationList.size());  //база заполняется и возвращает больше обьектов
        assertEquals(id, retrieveGeographicLocationsList.get(0).getId());
    }

}
