package io.javabrains.springbootquickstart.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;
	
	private List<Topic> topicList = new ArrayList<>(Arrays.asList(
			new Topic(101, "Java", "Java Description"),
			new Topic(102, "Spring Boot", "Spring Boot Description"),
			new Topic(103, "Spring", "Spring Description")
		));
	
	public List<Topic> getAllTopics() {
		return this.topicRepository.findAll();
	}
	
	public Topic getTopic(Integer id) {
		//return this.topicList.stream().filter(t-> t.getId() == id).findFirst().get();
		return this.topicRepository.getOne(id); // Topic
	}
	public Optional<Topic> getTopicOptional(Integer id) {
		return this.topicRepository.findById(id); //Optional<Topic>
	}
	
	public void addTopic(Topic topic) {
		//this.topicList.add(topic);
		this.topicRepository.save(topic);
	}

	public void updateTopic(Topic topic, Integer id) {
		System.out.print("Topic Name =====> "+topic.getName());
		for(int i=0;i<this.topicList.size();i++) {
			Topic t = this.topicList.get(i);
			if(t.getId() == id) {
				this.topicList.set(i,topic);
				return;
			}
		}
	}

	public void deleteTopic(Integer id) {
		this.topicList.removeIf(x->x.getId() == id);
	}
}
