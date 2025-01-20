package com.example.foro.config;

import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.flyway.FlywayProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@Configuration
@EnableConfigurationProperties(FlywayProperties.class)
public class FlywayDatabaseConfig {

    @Bean(initMethod = "migrate")
    public Flyway flyway(FlywayProperties flywayProperties) {
        // Registros de depuración
        System.out.println("URL de Flyway: " + flywayProperties.getUrl());
        System.out.println("Usuario de Flyway: " + flywayProperties.getUser());
        System.out.println("Contraseña de Flyway: " + flywayProperties.getPassword());

        return Flyway.configure()
                .dataSource(
                        flywayProperties.getUrl(),
                        flywayProperties.getUser(),
                        flywayProperties.getPassword()
                )
                .locations(flywayProperties.getLocations().toArray(new String[0]))
                .baselineOnMigrate(true)
                .load();
    }
}
