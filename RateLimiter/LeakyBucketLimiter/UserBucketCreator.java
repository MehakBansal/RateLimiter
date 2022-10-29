package RateLimiter.LeakyBucketLimiter;

import java.util.HashMap;
import java.util.Map;

public class UserBucketCreator {
    Map<Integer,LeakyBucketRateLimiterImpl> userIdBucketMap=new HashMap<>();
    public UserBucketCreator(int id){
        this.userIdBucketMap.put(id,new LeakyBucketRateLimiterImpl(10));
    }
    void accessApplication(int id){
        if(userIdBucketMap.get(id).grantAccess()){
            System.out.println(Thread.currentThread().getName()+"-->able to access");
        }
        else{
            System.out.println(Thread.currentThread().getName()+"-->too many req");
        }
    }
}
