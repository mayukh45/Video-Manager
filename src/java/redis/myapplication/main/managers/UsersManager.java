package redis.myapplication.main.managers;

import com.google.gson.Gson;
import com.google.inject.Inject;
import redis.clients.jedis.Jedis;
import redis.myapplication.main.models.Topic;
import redis.myapplication.main.models.User;
import redis.myapplication.main.models.Video;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * This class is used to manage the (user --> set) mapping and creates (user --> videos) mapping at runtime.
 */
public class UsersManager {

    @Inject
    Jedis client;

    @Inject
    Gson gson;

    public static final String KEY_SUFFIX = "_AllVideos";


    public void subscribeUserToTopic(User user, Topic topic){
        client.sadd(gson.toJson(user), topic.name());
    }

    public Set<Topic> getSubscribedTopicsForaUser(User user){
        return client.smembers(gson.toJson(user)).stream()
        .map(Topic::valueOf)
        .collect(Collectors.toSet());
    }

    public List<Video> getAllVideosInAllTopicsSubscribedByUser(User user){
        String[] topics = getSubscribedTopicsForaUser(user).stream()
                .map(Enum::name).toArray(String[]::new);

        String key = user.getName() + KEY_SUFFIX;
        client.zunionstore(key, topics);
        return client.zrevrange(key, 0, client.zcard(key)).stream()
                .map(video -> gson.fromJson(video, Video.class))
                .collect(Collectors.toList());

    }

    public void removeSubscribedTopicForAnUser(User user, Topic topic){
        client.srem(gson.toJson(user), topic.name());
    }
}
