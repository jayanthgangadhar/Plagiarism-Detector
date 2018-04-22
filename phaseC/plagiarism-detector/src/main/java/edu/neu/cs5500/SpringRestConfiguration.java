package edu.neu.cs5500;

import java.util.logging.Logger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Asim
 * 
 * Class used to define webmvc configuration with CORS setup
 *
 */
@Configuration
public class SpringRestConfiguration {
	// Logger
	private static Logger logger = Logger.getLogger(SpringRestConfiguration.class.getName());
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
            	logger.info("Configure cors");
                registry.addMapping("/**")
                .allowedOrigins("*")
        		.allowedMethods("GET", "POST", "PUT", "DELETE")
        		.allowedHeaders("Origin", "X-Requested-With", "Content-Type", "Accept");
            }
        };
    }
}
