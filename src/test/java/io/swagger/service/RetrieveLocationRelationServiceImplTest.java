package io.swagger.service;

import io.swagger.configuration.HibernateXMLConfTest;
import io.swagger.model.EventSubscription;
import io.swagger.model.GeographicLocation;
import io.swagger.model.GeographicLocationRef;
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
public class RetrieveLocationRelationServiceImplTest {

    @MockBean
    com.fasterxml.jackson.databind.ObjectMapper objectMapper;

    @MockBean
    HttpServletRequest httpServletRequest;

    @Resource
    RetrieveLocationRelationServiceImpl objUnderTest;

    @Resource
    RetrieveLocationRelationServiceImpl returRLR;
  //  EventSubscriptionServiceImpl<EventSubscription> objUnderTest;

//    @Resource
//    GeographicLocationServiceImpl GLServiceImpl;

 //   @Resource
 //  GeographicLocation GL;

    public static RetrieveLocationRelation createRLR (String prefix){
        RetrieveLocationRelation retrieveLocationRelation = new RetrieveLocationRelation();
        retrieveLocationRelation.setHref("Localhost/- "+prefix);
        retrieveLocationRelation.setLocationA("LocationA- "+prefix);
        retrieveLocationRelation.setLocationB("LocationB- "+prefix);
        retrieveLocationRelation.setStatus("Status-"+prefix);
        retrieveLocationRelation.setDistance(prefix+"00");
        retrieveLocationRelation.setTime(OffsetDateTime.now());
        return retrieveLocationRelation;
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
        RetrieveLocationRelation RLR1 = createRLR("1");
        GeographicLocationRef GLRef1 = new GeographicLocationRef ();
        GLRef1.setHref("LOcalhost_GLRef_1");
        RLR1.setGeographicLocation(GLRef1);
       // RLR1.setIntersection(GLServiceImpl.findById("ecd84af1-46d7-47aa-ac6f-0109c24b5953"));
// TODO: 07.01.2019 поставить @Autowaried ??
       GeographicLocation GL = new GeographicLocation();
       GL.setName("Test RLRService");
       RLR1.addIntersectionItem(GL);

        objUnderTest.save(RLR1);

        // when
        Serializable id = RLR1.getId();
        System.out.println("==========id "+id);
        assertNotNull(id);


        //сравнение даты
        List<RetrieveLocationRelation> newRLR = returRLR.findById(id);
        assertEquals(RLR1.getTime(),newRLR.get(0).getTime());


        // then
        List<RetrieveLocationRelation> retrieveLocationRelationList = objUnderTest.list();
      //  assertEquals(1, retrieveLocationRelationList.size());  //база заполняется и возвращает больше обьектов
        assertEquals(id, retrieveLocationRelationList.get(0).getId());
    }

}
