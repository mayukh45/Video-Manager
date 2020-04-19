package redis.myapplication.modules;

import com.google.gson.Gson;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import redis.clients.jedis.Jedis;

public class ApplicationModule extends AbstractModule {

    @Override
    public void configure(){

    }

    @Provides
    @Singleton
    public Jedis getRedisClient(){
        return new Jedis("localhost");
    }

    @Provides
    @Singleton
    public Gson getGsonObject(){
        return new Gson();
    }
}
