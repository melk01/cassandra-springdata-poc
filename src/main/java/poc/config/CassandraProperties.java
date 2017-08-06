package poc.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by melk on 03/08/17.
 */
@Configuration
@ConfigurationProperties
@PropertySource("classpath:cassandra.properties")
public class CassandraProperties {

    private String contactpoints;
    private String port;
    private String keyspace;

    public String getContactpoints() {
        return contactpoints;
    }

    public String getPort() {
        return port;
    }

    public String getKeyspace() {
        return keyspace;
    }

    public void setContactpoints(String contactpoints) {
        this.contactpoints = contactpoints;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setKeyspace(String keyspace) {
        this.keyspace = keyspace;
    }
}
