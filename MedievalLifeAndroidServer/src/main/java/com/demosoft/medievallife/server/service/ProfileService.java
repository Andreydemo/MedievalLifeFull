package com.demosoft.medievallife.server.service;

import com.demosoft.medievallife.server.entity.User;
import com.demosoft.medievallife.server.service.entity.ProfileServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.UUID;

/**
 * Created by demos_000 on 20.03.2016.
 */
@Component
public class ProfileService {

    @Autowired
    private MongoTemplate mongoTemplate;
    public static final String USERS_COLLECTIO = "users";
    @Autowired
    private SessionService sessionService;

    public ProfileServiceResult<User> registration(User user) {
        ProfileServiceResult<User> result = new ProfileServiceResult<>();
        result.setProcessedObject(user);
        result.setSuccessAction(false);
        if (isNotUserExist(user)) {
            if (user.isPasswordConfirmed()) {
                result.setSuccessAction(true);
                mongoTemplate.insert(user, USERS_COLLECTIO);
            } else {
                result.getErrorMgs().add("Passwords are not equal");
            }
        } else {
            result.getErrorMgs().add("User is Exist");
        }

        return result;
    }

    public ProfileServiceResult<User> login(User user) {
        ProfileServiceResult<User> result = new ProfileServiceResult<>();
        result.setProcessedObject(user);
        result.setSuccessAction(false);
        if (isUserExist(user)) {
            User dbUser = getUserByName(user.getName());
            if (user.getPassword().equals(dbUser.getPassword())) {
                result.setSuccessAction(true);
                result.setProcessedObject(dbUser);
                dbUser.setSecureToken(UUID.randomUUID().toString());
                dbUser.setLastActivityTime(Calendar.getInstance());
                sessionService.getAuthorizedTokens().put(dbUser.getSecureToken(), dbUser);
            } else {
                result.getErrorMgs().add("Login or password is incorrect");
            }
        } else {
            result.getErrorMgs().add("Login or password is incorrect");
        }
        return result;
    }

    public boolean isNotUserExist(User user) {
        return !isUserExist(user.getName());
    }

    public boolean isUserExist(User user) {
        return getUserByName(user.getName()) != null;
    }

    public User getUserByName(String name) {
        return mongoTemplate.findOne(new Query(Criteria.where("name").is(name)), User.class, USERS_COLLECTIO);
    }

    public boolean isUserExist(String name) {
        return getUserByName(name) != null;
    }

    public boolean isNotUserExist(String name) {
        return !isUserExist(name);
    }
}
