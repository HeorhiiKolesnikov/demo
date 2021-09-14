package com.simple.spring.project.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import com.simple.spring.project.client.ClientGetListDecorator;
import com.simple.spring.project.client.DemoClient;
import com.simple.spring.project.config.BaseConfig;
import com.simple.spring.project.models.DemoModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest(classes = BaseConfig.class)
public abstract class BaseTest extends AbstractTestNGSpringContextTests {

    @Autowired
    protected DemoClient demoClient;
    @Autowired
    @Qualifier("demoClientDecorator")
    protected ClientGetListDecorator<DemoModel> demoClientClientDecorator;
}
