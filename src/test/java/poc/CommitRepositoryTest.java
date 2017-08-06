package poc;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import poc.dao.CommitRepository;
import poc.entity.Commit;

import java.util.Date;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CommitRepositoryTest {

    @Autowired
	private CommitRepository commitRepository;
	
	@Test
	public void testFindByAuther(){
		commitRepository.deleteAll();
		Commit commit =  new Commit();
		commit.setAuther("melk01");
		commit.setMessage("commit test");
		commit.setDate(new Date());
		Commit result = commitRepository.save(commit);
		Assert.assertTrue(commitRepository.findByAuther("melk01").getId().equals(result.getId()));
	}

}