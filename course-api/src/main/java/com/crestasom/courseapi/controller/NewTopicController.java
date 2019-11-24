package com.crestasom.courseapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crestasom.courseapi.model.Topic;
import com.crestasom.courseapi.service.TopicService;

@Controller
public class NewTopicController {

	public NewTopicController() {
		// TODO Auto-generated constructor stub
		System.out.println("Topic controller created");
	}

	@Autowired
	private TopicService topicService;

	@RequestMapping("/topiclist")
	public String getAllTopics(Model model) {
		List<Topic> topicList = topicService.getTopics();
		model.addAttribute("topics", topicList);
		return "topic";
	}
}
