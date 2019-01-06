package io.swagger.service;

import io.swagger.configuration.HibernateXMLConfTest;
import io.swagger.model.EventSubscription;
import io.swagger.model.GeographicLocation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

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
public class EventSubscriptionServiceImplTest {

    @MockBean
    com.fasterxml.jackson.databind.ObjectMapper objectMapper;

    @MockBean
    HttpServletRequest httpServletRequest;

    @Resource
    EventSubscriptionServiceImpl objUnderTest;
  //  EventSubscriptionServiceImpl<EventSubscription> objUnderTest;

    public static EventSubscription eventSubscription (String prefix){
        EventSubscription eventSubscription = new EventSubscription();
        eventSubscription.setCallback("Callback- "+prefix);
        eventSubscription.setQuery("Query- "+prefix);
        return eventSubscription;
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
        EventSubscription eventSubscription1 = eventSubscription("1");
        objUnderTest.save(eventSubscription1);

        // when
        Serializable id = eventSubscription1.getId();
        System.out.println("==========id "+id);
        assertNotNull(id);

        // then
        List<EventSubscription> eventSubscription = objUnderTest.list();
        assertEquals(1, eventSubscription.size());
        assertEquals(id, eventSubscription.get(0).getId());
    }

}
