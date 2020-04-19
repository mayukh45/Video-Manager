package redis.myapplication.main.managers;

import com.google.gson.Gson;
import com.google.inject.Inject;
import redis.clients.jedis.Jedis;
import redis.myapplication.main.models.Topic;
import redis.myapplication.main.models.Video;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * This class is used to manage the topic --> set of videos mapping.
 */
public class VideosManager {

    @Inject
    Jedis client;

    @Inject
    Gson gson;

    /**
     * This method can be used to add a video to the topic --> set of videos mapping.
     */
    public void addVideo(Topic topic, Video video){
        client.zadd(topic.name(), 0, gson.toJson(video));
    }
    /**
     * This method can be used like a particular video in the topic --> set of videos mapping.
     */
    public void likeVideo(Topic topic, Video video){
        client.zincrby(topic.name(), 1, gson.toJson(video));
    }
    /**
     * This method can be used to fetch all videos present for a topic.
     */
    public Set<Video> getAllVideosOfaTopic(Topic topic){
        return client.zrevrange(topic.name(), 0, client.zcard(topic.name()))
                .stream()
                .map(jsonString -> gson.fromJson(jsonString, Video.class))
                .collect(Collectors.toSet());
    }
    /**
     * This method can be used to get number of likes in a video.
     */
    public double getNumberOfLikes(Topic topic, Video video){
        return client.zscore(topic.name(), gson.toJson(video));
    }
    /**
     * This method can be used to delete a video from topic --> set of videos mapping.
     */
    public void removeVideo(Topic topic, Video video){
        client.zrem(topic.name(), gson.toJson(video));
    }
}
