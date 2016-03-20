package com.demosoft.medievallife.server.controller;

import com.demosoft.medievallife.server.entity.User;
import com.demosoft.medievallife.server.service.ProfileService;
import com.demosoft.medievallife.server.service.entity.ProfileServiceResult;
import com.mongodb.DBCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * Created by demos_000 on 20.03.2016.
 */

@RestController
public class ProfileController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private ProfileService profileService;

    @RequestMapping("/create/{name}")
    public String index(@PathVariable(value = "name") String name) {
        DBCollection collection = mongoTemplate.getCollection("test");
        if (collection == null) {
            collection = mongoTemplate.createCollection("test");
        }
        mongoTemplate.insert(new User(name));
        return name + " Created";
    }

    @RequestMapping(path = "/reg", method = RequestMethod.POST)
    public ProfileServiceResult<User> reg(@RequestParam("name") String name, @RequestParam("password") String password, @RequestParam("confirmPassword") String confirmPassword) {
        User user = new User(name, password, confirmPassword);
        return profileService.registration(user);
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public ProfileServiceResult<User> login(@RequestParam("name") String name, @RequestParam("password") String password) {
        User user = new User(name, password);
        return profileService.login(user);
    }


    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}
