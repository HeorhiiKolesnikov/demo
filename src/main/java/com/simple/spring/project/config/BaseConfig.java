package com.simple.spring.project.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.simple.spring.project.client.BaseClient;
import com.simple.spring.project.client.ClientGetListDecorator;
import com.simple.spring.project.client.DemoClient;
import com.simple.spring.project.models.DemoModel;

@Configuration
public class BaseConfig {

    @Bean
    public DemoClient demoClient() {
        return new DemoClient();
    }

    @Bean
    public ClientGetListDecorator<DemoModel> demoClientDecorator(@Qualifier("demoClient") BaseClient demoClient) {
        return new ClientGetListDecorator<>(demoClient);
    }

    @Bean(name = "prototypeDemoModel")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public DemoModel prototypeDemoModel() {
        return DemoModel.newDemoModel();
    }

    @Bean(name = "singletonDemoModel")
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public DemoModel singletonDemoModel() {
        return DemoModel.newDemoModel();
    }
}
