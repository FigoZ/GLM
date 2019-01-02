package io.swagger.service;

import static org.junit.Assert.*;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import io.swagger.model.GeographicLocation;
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
        GeographicLocation geographicLocation1 = geographicLocation("1");
        objUnderTest.save(geographicLocation1);

        // when
        Serializable id = geographicLocation1.getId();
        System.out.println("==========id "+id);
        assertNotNull(id);

        // then
        List<GeographicLocation> geographicLocations = objUnderTest.list();
        assertEquals(1, geographicLocations.size());
        assertEquals(id, geographicLocations.get(0).getId());
    }

}
