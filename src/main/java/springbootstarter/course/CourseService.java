package springbootstarter.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    private List<Course> courses=new ArrayList<>(Arrays.asList(
            new Course(1,"spring framework","spring boot development"),
            new Course(2,"core framework","spring boot development"),
            new Course(3,"javascript framework","spring boot development"),
            new Course(4,"typescript framework","spring boot development")
    ));

    public List<Course> getAllCourses(Integer id){

        //return topics;
        List<Course> courses=new ArrayList<>();
        courseRepository.findByTopicId(id).forEach(courses::add);
        return courses;
    }

    public Optional<Course> getCourse(Integer id)
    {
        //return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
        return courseRepository.findById(id);
    }

    public void addCourse(Course course)
    {
        //topics.add(topic);
        courseRepository.save(course);
    }

    public void updateCourse( Course course) {
//        for(int i=0;i<topics.size();i++){
//            Topic t=topics.get(i);
//            if(t.getId().equals(id)){
//                topics.set(i,topic);
//                return;
//            }
//        }
        courseRepository.save(course);
    }

    public void  deleteCourse(Integer id) {
//            topics.removeIf(t->t.getId().equals(id));
//            return;
        courseRepository.deleteById(id);
    }
}
