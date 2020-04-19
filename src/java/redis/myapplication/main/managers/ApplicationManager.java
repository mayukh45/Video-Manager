package redis.myapplication.main.managers;

import com.google.inject.Inject;
import redis.myapplication.main.models.Topic;
import redis.myapplication.main.models.User;
import redis.myapplication.main.models.Video;

import java.util.List;
import java.util.Set;

/**
 * This class acts a abstraction between client and the application and can be used to avail all the functionalities present in the application.
 */
public class ApplicationManager {

    @Inject
    VideosManager videosManager;

    @Inject
    UsersManager usersManager;
    /**
     * This method can be used to add a video to the topic --> set of videos mapping.
     */
    public void addVideoTopic(Topic topic, Video video) {
        videosManager.addVideoToTopic(topic, video);
    }
    /**
     * This method can be used like a particular video in the topic --> set of videos mapping.
     */
    public void likeVideo(Topic topic, Video video) {
        videosManager.likeVideo(topic, video);
    }
    /**
     * This method can be used to fetch all videos present for a topic.
     */
    public Set<Video> getAllVideosOfaTopic(Topic topic) {
        return videosManager.getAllVideosOfaTopic(topic);
    }
    /**
     * This method can be used to get number of likes in a video.
     */
    public double getNumberOfLikes(Topic topic, Video video) {
        return videosManager.getNumberOfLikes(topic, video);
    }
    /**
     * This method can be used to delete a video from topic --> set of videos mapping.
     */
    public void removeVideoFromTopic(Topic topic, Video video) {
        videosManager.removeVideoFromTopic(topic, video);
    }
    /**
     * This method adds a topic to the (user -> topic) mapping for a user ie a user subscribing to a topic.
     */
    public void subscribeUserToTopic(User user, Topic topic) {
        usersManager.subscribeUserToTopic(user, topic);
    }
    /**
     * This method fetches all the topics subscribed by an user.
     */
    public Set<Topic> getSubscribedTopicsForaUser(User user) {
        return usersManager.getSubscribedTopicsForaUser(user);
    }
    /**
     * This method fetches all videos present in all the topics subscribed by the user.
     */
    public List<Video> getAllVideosInAllTopicSubscribedByUser(User user) {
        return usersManager.getAllVideosInAllTopicsSubscribedByUser(user);
    }
    /**
     * This method can be used to unsubscribe a topic for an user.
     */
    public void removeSubscribedTopicForAnUser(User user, Topic topic){
        usersManager.removeSubscribedTopicForAnUser(user, topic);
    }
}
