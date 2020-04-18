import redis.clients.jedis.Jedis;

public class RedisConnector {

    public static void connect(String[] args) {
        Jedis jedis = new Jedis("localhost");
        String value = jedis.get("foo");




    }
}
