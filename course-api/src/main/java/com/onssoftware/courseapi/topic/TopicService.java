package com.onssoftware.courseapi.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public void create(Topic topic) {
        topicRepository.save(topic);
    }

    public Topic read(String id) {
        return topicRepository.findById(id).get();
    }

    public List<Topic> readAll() {
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public void update(Topic topic) {
        topicRepository.save(topic);
    }

    public void delete(String id) {
        topicRepository.deleteById(id);
    }
}
