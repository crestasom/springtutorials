package com.crestasom.courseapi.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.crestasom.courseapi.model.Topic;

@Service
public class TopicService {
	private List<Topic> topics = new ArrayList<>(
			Arrays.asList(new Topic("spring", "Spring Framework", "Spring Framework Description"),
					new Topic("java", "Core Java", "Core Java Description"),
					new Topic("javascript", "Javascript", "Javascript Description")));
	
	public TopicService() {
		System.out.println("Service is created");
	}

	public List<Topic> getTopics() {
		return topics;
	}

	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	public void updateTopic(Topic topic, String id) {
		// TODO Auto-generated method stub
		for (int i = 0; i < topics.size(); i++) {
			if (topics.get(i).getId().equals(id)) {
				topics.set(i, topic);
				break;
			}
		}

	}

	public void deleteTopic(String id) {
		// TODO Auto-generated method stub
		for (int i = 0; i < topics.size(); i++) {
			if (topics.get(i).getId().equals(id)) {
				topics.remove(i);
				break;
			}
		}
		//topics.removeIf(t->t.getId().equals(id));
	}
}
