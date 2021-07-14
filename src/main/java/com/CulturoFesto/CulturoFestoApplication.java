package com.CulturoFesto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.CulturoFesto")
@EnableJpaRepositories(basePackages="com.CulturoFesto.Repository")
public class CulturoFestoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CulturoFestoApplication.class, args);
	}
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(CulturoFestoApplication.class);
    }
}
