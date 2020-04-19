package redis.myapplication.client;

import com.google.inject.Guice;
import redis.myapplication.managers.ApplicationManager;
import redis.myapplication.models.Topic;
import redis.myapplication.modules.ApplicationModule;

import static redis.myapplication.client.Data.VideoData.*;

public class ApplicationClient {

    public static void main(String[] args) {
        ApplicationManager applicationManager = Guice.createInjector(new ApplicationModule())
                .getInstance(ApplicationManager.class);

        addData(applicationManager);
        likeData(applicationManager);
        printData(applicationManager);
    }

    public static void addData(ApplicationManager applicationManager){
        applicationManager.addVideoTopic(Topic.PHYSICS, videoOnLawsOfMotion);
        applicationManager.addVideoTopic(Topic.PHYSICS, videoOnForce);
        applicationManager.addVideoTopic(Topic.MATHS, videoOnFractions);
        applicationManager.addVideoTopic(Topic.MATHS, videoOnAlgebra);
        applicationManager.addVideoTopic(Topic.CHEMISTRY, videoOnSolids);
        applicationManager.addVideoTopic(Topic.CHEMISTRY, videoOnOrganicChemistry);
    }

    public static void likeData(ApplicationManager applicationManager){
        applicationManager.likeVideo(Topic.PHYSICS, videoOnLawsOfMotion);
        applicationManager.likeVideo(Topic.PHYSICS, videoOnForce);
        applicationManager.likeVideo(Topic.PHYSICS, videoOnLawsOfMotion);
        applicationManager.likeVideo(Topic.PHYSICS, videoOnLawsOfMotion);
    }

    public static void printData(ApplicationManager applicationManager){
        System.out.println(applicationManager.getAllVideosOfaTopic(Topic.PHYSICS));
    }
}
