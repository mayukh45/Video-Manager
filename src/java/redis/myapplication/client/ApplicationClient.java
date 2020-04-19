package redis.myapplication.client;

import com.google.inject.Guice;
import redis.myapplication.main.managers.ApplicationManager;
import redis.myapplication.main.models.Topic;
import redis.myapplication.main.modules.ApplicationModule;

import static redis.myapplication.client.Data.UserData.userMayukh;
import static redis.myapplication.client.Data.VideoData.*;

/**
 * This is a client class to test the application.
 * NOTE : This is just an example, there are more functionalities in the application which is not tested in this version of client class.
 */
public class ApplicationClient {

    public static void main(String[] args) {
        ApplicationManager applicationManager = Guice.createInjector(new ApplicationModule())
                .getInstance(ApplicationManager.class);

        addData(applicationManager);
        likeData(applicationManager);
        subscribeTopic(applicationManager);
        printData(applicationManager);
    }

    /**
     * Can be used to add videos.
     */

    public static void addData(ApplicationManager applicationManager){
        applicationManager.addVideoTopic(Topic.PHYSICS, videoOnLawsOfMotion);
        applicationManager.addVideoTopic(Topic.PHYSICS, videoOnForce);
        applicationManager.addVideoTopic(Topic.MATHS, videoOnFractions);
        applicationManager.addVideoTopic(Topic.MATHS, videoOnAlgebra);
        applicationManager.addVideoTopic(Topic.CHEMISTRY, videoOnSolids);
        applicationManager.addVideoTopic(Topic.CHEMISTRY, videoOnOrganicChemistry);
    }

    /**
     * Can be used to used to like a video, in some particular topic.
     *
     */
    public static void likeData(ApplicationManager applicationManager){
        applicationManager.likeVideo(Topic.PHYSICS, videoOnLawsOfMotion);
        applicationManager.likeVideo(Topic.PHYSICS, videoOnForce);
        applicationManager.likeVideo(Topic.PHYSICS, videoOnLawsOfMotion);
        applicationManager.likeVideo(Topic.PHYSICS, videoOnLawsOfMotion);
        applicationManager.likeVideo(Topic.CHEMISTRY, videoOnOrganicChemistry);
        applicationManager.likeVideo(Topic.PHYSICS, videoOnOrganicChemistry);

    }
    /**
     * Can be used to subscribe a topic for a particular user.
     *
     */
    public static void subscribeTopic(ApplicationManager applicationManager){
        applicationManager.subscribeUserToTopic(userMayukh, Topic.PHYSICS);
        applicationManager.subscribeUserToTopic(userMayukh, Topic.CHEMISTRY);

    }
    /**
     * Can be used test the results by printing to console.
     *
     */
    public static void printData(ApplicationManager applicationManager){
        System.out.println(applicationManager.getAllVideosOfaTopic(Topic.PHYSICS));
        System.out.println(applicationManager.getAllVideosInAllTopicSubscribedByUser(userMayukh));
    }
}
