package poc.dao;

import org.springframework.cache.annotation.Cacheable;
import poc.entity.Commit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * melk01
 */
@Repository
public interface CommitRepository extends CrudRepository<Commit, UUID> {

    @Cacheable(value="commitCache")
    Commit findByAuther(String auther);

    void deleteByAuther(String auther);
}
