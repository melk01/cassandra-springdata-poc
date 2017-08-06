package poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by melk on 03/08/17.
 */
@SpringBootApplication
public class CassandraApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(CassandraApplication.class, args);
    }
}
