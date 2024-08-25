package com.kesypace.cassandra.config;


import com.datastax.oss.driver.api.core.CqlSession;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.net.InetSocketAddress;
import org.springframework.context.annotation.Primary;

@Configuration
@EnableCassandraRepositories(
        basePackages = "com.kesypace.cassandra.repositories.prueba",
        cassandraTemplateRef = "cassandraTemplateFase2"
)
public class CassandraPrueba extends AbstractCassandraConfiguration {


    @Override
    protected String getKeyspaceName() {
        return "prueba";
    }

    @Bean
    @Primary
    @Qualifier("sessionFase2")
    public CqlSession sessionFase2() {
        return CqlSession.builder()
                .withKeyspace(getKeyspaceName())
                .withLocalDatacenter("datacenter1")
                .addContactPoint(new InetSocketAddress("localhost",9042))
                .build();
    }

    @Bean("cassandraTemplateFase2")
    @Qualifier("cassandraTemplateFase2")
    public CassandraTemplate cassandraTemplateFase2(@Qualifier("sessionFase2") CqlSession sessionFase2) {
        return new CassandraTemplate(sessionFase2);
    }
}
