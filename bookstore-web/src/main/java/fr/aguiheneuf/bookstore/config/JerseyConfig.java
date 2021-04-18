package fr.aguiheneuf.bookstore.config;

import fr.aguiheneuf.bookstore.webservice.impl.BookWebServiceImpl;
import fr.aguiheneuf.bookstore.webservice.impl.OrderWebServiceImpl;
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
        register(BookWebServiceImpl.class);
        register(OrderWebServiceImpl.class);
    }
}
