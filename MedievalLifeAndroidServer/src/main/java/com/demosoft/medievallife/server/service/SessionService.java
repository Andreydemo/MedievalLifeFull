package com.demosoft.medievallife.server.service;

import com.demosoft.medievallife.server.entity.User;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by demos_000 on 20.03.2016.
 */
@Component
public class SessionService {

    private Map<String, User> authorizedTokens = new ConcurrentHashMap<>();

    public Map<String, User> getAuthorizedTokens() {
        return authorizedTokens;
    }

    public void setAuthorizedTokens(Map<String, User> authorizedTokens) {
        this.authorizedTokens = authorizedTokens;
    }
}
