package springbootstarter.course;

import org.springframework.beans.factory.annotation.Autowired;
import springbootstarter.topic.Topic;

import javax.persistence.*;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @Column
    private  String name;

    @Column
    private  String description;

    @ManyToOne
    private Topic topic;

    public Course(){

    }

    public Course(Integer id, String name, String description,Integer topicId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.topic=new Topic(topicId,"","");
    }
    public Course(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
