package redis.myapplication.main.managers;

import com.google.inject.Inject;
import redis.myapplication.main.models.Topic;
import redis.myapplication.main.models.User;
import redis.myapplication.main.models.Video;

import java.util.Set;

/**
 * This class acts a abstraction between client and the application.
 */
public class ApplicationManager {

    @Inject
    VideosManager videosManager;

    @Inject
    UsersManager usersManager;

    public void addVideoTopic(Topic topic, Video video) {
        videosManager.addVideo(topic, video);
    }

    public void likeVideo(Topic topic, Video video) {
        videosManager.likeVideo(topic, video);
    }

    public Set<Video> getAllVideosOfaTopic(Topic topic) {
        return videosManager.getAllVideosOfaTopic(topic);
    }

    public double getNumberOfLikes(Topic topic, Video video) {
        return videosManager.getNumberOfLikes(topic, video);
    }

    public void removeVideoFromTopic(Topic topic, Video video) {
        videosManager.removeVideo(topic, video);
    }

    public void subscribeUserToTopic(User user, Topic topic) {
        usersManager.subscribeUserToTopic(user, topic);
    }

    public Set<Topic> getSubscribedTopicsForaUser(User user) {
        return usersManager.getSubscribedTopicsForaUser(user);
    }
}
