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
        cassandraTemplateRef = "cassandraTemplatePrueba"
)
public class CassandraPrueba extends AbstractCassandraConfiguration {

   /* @Value("${cassandra.data.external-port}")
    private int cassandraPort;

    @Value("${cassandra.data.external-contact-points}")
    private String contactPoints;

    @Value("${cassandra.data.external-local-datacenter}")
    private String localDatacenter;*/


    @Override
    protected String getKeyspaceName() {
        return "prueba";
    }

    @Bean
    @Primary
    @Qualifier("prueba")
    public CqlSession prueba() {
        return CqlSession.builder()
                .withKeyspace(getKeyspaceName())
                .withLocalDatacenter("datacenter1")
                .addContactPoint(new InetSocketAddress("localhost",9042))
                .build();
    }

    @Bean("cassandraTemplatePrueba")
    @Qualifier("cassandraTemplatePrueba")
    public CassandraTemplate cassandraTemplatePrueba(@Qualifier("prueba") CqlSession prueba) {
        return new CassandraTemplate(prueba);
    }
}
