package springbootstarter.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping(method = RequestMethod.GET,value = "/topics")
    public List<Topic> getAllTopics(){
        return topicService.getAllTopics();
    }

    @RequestMapping(method = RequestMethod.GET,value = "/topics/{foo}")
     public Optional<Topic> getTopic(@PathVariable("foo") Integer id){
        return topicService.getTopic(id);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/topics")
    public void addTpoic(@RequestBody Topic topic){

        topicService.addTopic(topic);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/topics/{id}")
    public void updateTpoic(@RequestBody Topic topic,@PathVariable Integer id)
    {
        topicService.updateTopic(id,topic);

    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/topics/{foo}")
    public void deleteTopic(@PathVariable("foo") Integer id){
        topicService.deleteTopic(id);
    }

}
