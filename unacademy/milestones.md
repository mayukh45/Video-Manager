## Milestones

**1) What are the redis commands in this project?**
* SADD
* ZADD
* ZREVRANGE
* SMEMBERS
* ZUNIONSTORE
* ZSCORE
* ZREM
* ZINCRBY
* ZCARD


**2. Which language I chose and why?**

I chose Java as its one of the most widely used programming languages and it gives the advantages of OO paradigm.

**3. Which datastructures I have used and why?**

I used Sets and Sorted Sets mainly in this application. 
1. Sets were used to store topics subscribed by each due to following reasons:
    1. There cannot be duplicate topics chosen by user.
    2. We can have faster complexity for functionalities like un-subscribing a topic ie removing a topic from the set of a user.
    
2. Sorted Sets were used to store videos against each topic due to following reasons:
    1. We have the functionality of liking videos in a topic, so we would like the videos to be stored in sorted by the number of likes.
    2. Sorted Sets gives the faster complexity compared to Lists for maintaining a sorted ds at runtime.
    
**4. What are the further improvements that can be made to make it
efficient?**

Currently (topic -> videos) and (user -> topics) and (user -> videos) mappings are maintained separately. So if any new likes comes in any video or a new video is added, its not reflected in user -> videos mapping. We need to refresh it every time.
More functionalities could have been added.

**5.Does your implementation support multi threaded operations? If No
    why can’t it be? If yes then how?**
    
This topic needs more deep dive into Jedis implementation.

