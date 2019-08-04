package com.org.house.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class dslConfiguration {
    @Autowired
    private EntityManager entityManager;

    @Bean
    public JPAQueryFactory query() {
        return new JPAQueryFactory(entityManager);
    }

}
