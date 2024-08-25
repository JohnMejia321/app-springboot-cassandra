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
        cassandraTemplateRef = "cassandraTemplateFase5"
)
public class CassandraPrueba1 extends AbstractCassandraConfiguration {




    @Override
    protected String getKeyspaceName() {
        return "prueba1";
    }

    @Bean
    @Qualifier("sessionFase5")
    public CqlSessionFactoryBean sessionFase5() {
        CqlSessionFactoryBean session = new CqlSessionFactoryBean();
        session.setContactPoints("localhost");
        session.setPort(9042);
        session.setKeyspaceName(getKeyspaceName());
        session.setLocalDatacenter("datacenter1");
        return session;
    }

    @Bean("cassandraTemplateFase5")
    @Qualifier("cassandraTemplateFase5")
    public CassandraTemplate cassandraTemplateFase5(@Qualifier("sessionFase5") CqlSession sessionFase5) {
        return new CassandraTemplate(sessionFase5);
    }
}
