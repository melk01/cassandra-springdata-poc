package poc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import poc.config.CacheConfig;
import poc.dao.CommitRepository;
import poc.entity.Commit;

import java.util.Date;

/**
 * melk01
 */
@Component
public class CassandraRunner  implements CommandLineRunner {

    private final static Logger LOGGER = LoggerFactory.getLogger(CassandraRunner.class);

    @Autowired
    private CommitRepository commitRepository;

    @Autowired
    CacheManager cacheManager;

    @Override
    public void run(String... strings) {
        commitRepository.deleteAll();
        Commit commit = new Commit();
        commit.setAuther("melk10");
        commit.setMessage("first commit");
        commit.setDate(new Date());
        this.commitRepository.save(commit);
        //Commit result = this.commitRepository.findByAuther("melk10");
        //LOGGER.info("commit : "+result);
        //this.commitRepository.deleteAll();
        //this.commitRepository.deleteByAuther("mlek10");

        testCache();
    }

    public void testCache(){
        ApplicationContext context = new AnnotationConfigApplicationContext(CacheConfig.class);

        LOGGER.info("Result : {}", commitRepository.findByAuther("melk10"));

        Cache cache = cacheManager.getCache("commitCache");
        Cache.ValueWrapper wrapper = cache.get("melk10");

        // assertThat(wrapper.get(), is((Object) dave));
        Commit commit = (Commit) wrapper.get();

        LOGGER.info("cache : "+commit);
        if(commit.getAuther().equals("melk10")){
            LOGGER.info("CACHE-OK -->" + wrapper.get());
        } else {
            LOGGER.info("CACHE-NOT-OK -->" + "NO CACHE");
        }

        //shut down the Spring context so that Ehcache got chance to shut down as well
        ((ConfigurableApplicationContext)context).close();
    }

}