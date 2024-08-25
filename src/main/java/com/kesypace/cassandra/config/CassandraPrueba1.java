package com.kesypace.cassandra.config;

import com.datastax.oss.driver.api.core.CqlSession;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CqlSessionFactoryBean;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories(
        basePackages = "com.kesypace.cassandra.repositories.prueba1",
        cassandraTemplateRef = "cassandraTemplatePrueba1"
)
public class CassandraPrueba1 extends AbstractCassandraConfiguration {




    @Override
    protected String getKeyspaceName() {
        return "prueba1";
    }

    @Bean
    @Qualifier("sessionPrueba1")
    public CqlSessionFactoryBean sessionPrueba1() {
        CqlSessionFactoryBean session = new CqlSessionFactoryBean();
        session.setContactPoints("localhost");
        session.setPort(9042);
        session.setKeyspaceName(getKeyspaceName());
        session.setLocalDatacenter("datacenter1");
        return session;
    }

    @Bean("cassandraTemplatePrueba1")
    @Qualifier("cassandraTemplatePrueba1")
    public CassandraTemplate cassandraTemplatePrueba1(@Qualifier("sessionPrueba1") CqlSession sessionPrueba1) {
        return new CassandraTemplate(sessionPrueba1);
    }
}
