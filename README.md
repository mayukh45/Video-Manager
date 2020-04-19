## RedisProject

This is a short application that uses redis as its persistent data store.

#### Functionality:

1) User can add video for a particular topic.
2) User can like a video.
3) User can subscribe to one or more topics.
4) User can see all the videos in all topics subscribed by him/her sorted by number of likes.

#### How to use:
Clone this repo and make a client to consume the application, as given examples in the [client](https://github.com/mayukh45/RedisProject/tree/master/src/java/redis/myapplication/client) folder.

I am using [Jedis](https://github.com/xetorthio/jedis) as my redis client.

#### Key-Value mappings present:

1. User --> Set of topics subscribed.
2. Topics --> Sorted set of videos, sorted by the number of likes in each video.
3. User --> Sorted set of videos. (This is created in runtime and it stores all the videos in all the subscribed topics sorted by number of likes)

