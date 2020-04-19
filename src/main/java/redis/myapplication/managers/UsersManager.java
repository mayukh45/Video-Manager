package redis.myapplication.managers;

import com.google.gson.Gson;
import com.google.inject.Inject;
import redis.clients.jedis.Jedis;
import redis.myapplication.models.Topic;
import redis.myapplication.models.User;

import java.util.Set;
import java.util.stream.Collectors;

public class UsersManager {

    @Inject
    Jedis client;

    @Inject
    Gson gson;

    public void subscribeUserToTopic(User user, Topic topic){
        client.sadd(gson.toJson(user), topic.name());
    }

    public Set<Topic> getSubscribedTopicsForaUser(User user){
        return client.smembers(gson.toJson(user)).stream()
        .map(Topic::valueOf)
        .collect(Collectors.toSet());
    }
}
