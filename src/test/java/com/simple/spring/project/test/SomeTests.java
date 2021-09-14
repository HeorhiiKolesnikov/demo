package com.simple.spring.project.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.testng.annotations.Test;

import com.simple.spring.project.models.DemoModel;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;

public class SomeTests extends BaseTest {

    @Autowired
    @Qualifier("prototypeDemoModel")
    private DemoModel prototypeDemoModel1;
    @Autowired
    @Qualifier("prototypeDemoModel")
    private DemoModel prototypeDemoModel2;
    @Autowired
    @Qualifier("singletonDemoModel")
    private DemoModel singletonDemoModel1;
    @Autowired
    @Qualifier("singletonDemoModel")
    private DemoModel singletonDemoModel2;

    @Test
    public void baseUrlTest() {
        var response = demoClientClientDecorator.requestAsList();
        var body = response.body();

        logger.info("ALL OBJECTS:\n");
        assertFalse(body.isEmpty());
    }

    @Test
    public void prototypeTest() {
        final String LOGGER_STR = "\nOBJ 1:\t%s\nOBJ 2:\t%s";
        logger.info(String.format(LOGGER_STR, prototypeDemoModel1.toString(), prototypeDemoModel2.toString()));

        assertNotEquals(prototypeDemoModel1, prototypeDemoModel2);
        assertNotEquals(prototypeDemoModel1.hashCode(), prototypeDemoModel2.hashCode());
    }

    @Test
    public void singletonTest() {
        final String LOGGER_STR = "\nOBJ 1:\t%s\nOBJ 2:\t%s";
        logger.info(String.format(LOGGER_STR, singletonDemoModel1.toString(), singletonDemoModel2.toString()));

        assertEquals(singletonDemoModel1, singletonDemoModel2);
        assertEquals(singletonDemoModel1.hashCode(), singletonDemoModel2.hashCode());
    }
}
