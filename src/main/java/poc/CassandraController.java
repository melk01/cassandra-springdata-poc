package poc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import poc.dao.CommitRepository;
import poc.entity.Commit;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class CassandraController {

    @Autowired
    private CommitRepository commitRepository;

    @RequestMapping(value = "/commits",method = RequestMethod.GET)
    @ResponseBody
    public List<Commit> commit() {
        final List<Commit> commits = new ArrayList<Commit>();
        commitRepository.findAll().forEach(v->commits.add(v));
        return commits;
    }

    @RequestMapping(value = "/commit/{auther}/",method = RequestMethod.GET)
    @ResponseBody
    public Commit commitAuther(@PathVariable String auther) {
        return commitRepository.findByAuther(auther);
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public String saveGreeting(@RequestBody Commit commit) {
        commit.setAuther("test");
        commit.setDate(new Date());
        commitRepository.save(commit);
        return "OK";
    }
}
