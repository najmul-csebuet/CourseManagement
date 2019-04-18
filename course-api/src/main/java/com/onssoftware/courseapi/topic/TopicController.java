package com.onssoftware.courseapi.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @PostMapping("/topics")
    public String create(@RequestBody Topic topic) {

        topicService.create(topic);
        return "Topic created";
    }

    @GetMapping("/topics/{id}")
    public Topic read(@PathVariable String id) {

        return topicService.read(id);
    }

    @GetMapping("/topics")
    public List<Topic> readAll() {

        return topicService.readAll();
    }

    @PutMapping("/topics/{id}")
    public String update(@RequestBody Topic topic) {

        topicService.update(topic);
        return "Topic updated";
    }

    @DeleteMapping("/topics/{id}")
    public String delete(@PathVariable String id) {

        topicService.delete(id);
        return "Topic deleted";
    }
}