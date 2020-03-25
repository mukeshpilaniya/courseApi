package springbootstarter.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping(method = RequestMethod.GET,value = "/topics")
    public List<Topic> getAllTopics(){
        return topicService.getAllTopics();
    }

    @GetMapping("/topics/{foo}")
     public Topic getTopic(@PathVariable("foo") String id){
        return topicService.getTopic(id);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/topics")
    public void addTpoic(@RequestBody Topic topic){
        topicService.addTopic(topic);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/topics/{id}")
    public void updateTpoic(@RequestBody Topic topic,@PathVariable String id){
        topicService.updateTopic(id,topic);
    }

    @DeleteMapping("/topics/{foo}")
    public void deleteTopic(@PathVariable("foo") String id){
        topicService.deleteTopic(id);
        return;
    }

}
