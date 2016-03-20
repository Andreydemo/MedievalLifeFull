package com.demosoft.medievallife.server.controller;

import com.demosoft.medievallife.server.entity.User;
import com.mongodb.DBCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by demos_000 on 20.03.2016.
 */

@RestController
public class RegistrationController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @RequestMapping("/create/{name}")
    public String index(@PathVariable(value = "name") String name) {
        DBCollection collection = mongoTemplate.getCollection("test");
        if (collection == null) {
            collection = mongoTemplate.createCollection("test");
        }
        mongoTemplate.insert(new User(name));
        return name +  " Created";
    }


    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}
