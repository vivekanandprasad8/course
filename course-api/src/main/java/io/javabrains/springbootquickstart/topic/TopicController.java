package io.javabrains.springbootquickstart.topic;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return this.topicService.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable Integer id) {
		Optional<Topic> t = this.topicService.getTopicOptional(id);
		if(t.isPresent()){
			return t.get();
		} else {
			return null;
		}
	}
	/*@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable Integer id) {
		return this.topicService.getTopic(id);
	}*/
	
	@RequestMapping(value="/topics", method=RequestMethod.POST)
	public void addTopic(@RequestBody Topic topic) {
		this.topicService.addTopic(topic);
	}
	
	@RequestMapping(value="/topics/{id}", method=RequestMethod.PUT)
	public void updateTopic( @PathVariable Integer id, @RequestBody Topic topic) {
		System.out.println("===================== Update Topics Starts =====================");
		this.topicService.updateTopic(topic, id);
	}
	
	@RequestMapping(value="/topics/{id}", method=RequestMethod.DELETE)
	public void deleteTopic(@PathVariable Integer id) {
		this.topicService.deleteTopic(id);
	}
}
