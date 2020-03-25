package springbootstarter.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springbootstarter.topic.Topic;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(method = RequestMethod.GET,value = "/topics/{id}/courses")
    public List<Course> getAllCourses(@PathVariable Integer id){
        return courseService.getAllCourses(id);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/topics/{topicId}/courses/{foo}")
    public Optional<Course> getCourses(@PathVariable("foo") Integer id){
        return courseService.getCourse(id);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/topics/{topicId}/courses")
    public void addCourse(@RequestBody Course course,@PathVariable Integer topicId){
        course.setTopic(new Topic(topicId,"",""));
        courseService.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/topics/{topicId}/courses/{id}")
    public void updateCourse(@RequestBody Course course,@PathVariable Integer topicId)
    {   course.setTopic(new Topic(topicId,"",""));
        courseService.updateCourse(course);

    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/topics/{topicId}/courses/{id}")
    public void deleteCourse(@PathVariable Integer topicId,@PathVariable Integer id){
        courseService.deleteCourse(id);
    }
}
