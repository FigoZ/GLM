package io.swagger.service;

import static org.junit.Assert.*;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import io.swagger.model.GeographicLocation;
import io.swagger.model.GeographicPoint;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;
import io.swagger.configuration.HibernateXMLConfTest;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {HibernateXMLConfTest.class},
        loader = AnnotationConfigContextLoader.class)
@Transactional
public class GeographicLocationServiceImplTest {

    @MockBean
    com.fasterxml.jackson.databind.ObjectMapper objectMapper;

    @MockBean
    HttpServletRequest httpServletRequest;

    @Resource
    GeographicLocationServiceImpl<GeographicLocation> objUnderTest;

    public static GeographicLocation geographicLocation (String prefix){
        GeographicLocation geographicLocation = new GeographicLocation();
        geographicLocation.setName("Name-"+prefix);
        geographicLocation.setHref("localhost/-"+prefix);
        geographicLocation.setType("type-"+prefix);
        return geographicLocation;
    }

    public static GeographicPoint createGP (String prefix){
        GeographicPoint geographicPoint = new GeographicPoint();
        geographicPoint.setAccuracy("Accuracy-"+prefix);
        geographicPoint.setSpatialRef("localhost/-"+prefix);
        geographicPoint.setX(prefix);
        geographicPoint.setY(prefix);
        geographicPoint.setZ(prefix);
        return geographicPoint;
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
        //create Geographicpoints
        GeographicPoint gp1 = createGP("1");
        GeographicPoint gp2 = createGP("2");
        GeographicPoint gp3 = createGP("3");
        GeographicPoint gp4 = createGP("4");


        // given
        GeographicLocation geographicLocation1 = geographicLocation("1");

       // geographicLocation1.addGeographicPointItem(gp1);
        geographicLocation1.setGeographicPoint(List.of(gp1,gp2,gp3));
        //object references an unsaved transient instance - save the transient instance before flushing
        objUnderTest.save(geographicLocation1);

        GeographicLocation geographicLocation2 = geographicLocation("2");
        geographicLocation2.addGeographicPointItem(gp4);
        objUnderTest.save(geographicLocation2);

        GeographicLocation geographicLocation3 = geographicLocation("3");
        objUnderTest.save(geographicLocation3);

        // when
        Serializable id = geographicLocation1.getId();
        System.out.println("==========id "+id);
        assertNotNull(id);

        // then
        List<GeographicLocation> geographicLocations = objUnderTest.list();
        assertEquals(3, geographicLocations.size());
       // assertEquals(id, geographicLocations.get(0).getId()); //false т.к. в БД строки поменялись местами get(0) - id3

    }

}
