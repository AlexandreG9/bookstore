package fr.aguiheneuf.bookstore.config;

import fr.aguiheneuf.bookstore.webservice.BookWebService;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration bean for Jersey
 *
 * @author Alexandre Guiheneuf
 */
@Configuration
public class JerseyConfig extends ResourceConfig {

    /**
     * Constructor
     */
    public JerseyConfig() {
        register(BookWebService.class);
    }
}
