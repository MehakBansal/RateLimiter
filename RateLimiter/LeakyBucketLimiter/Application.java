package RateLimiter.LeakyBucketLimiter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static void main(String args[]){
        UserBucketCreator userBucketCreator=new UserBucketCreator(1);
        ExecutorService executorService= Executors.newFixedThreadPool(12);
        for(int i=0;i<12;i++){
            executorService.execute(()->userBucketCreator.accessApplication(1));
            //I added this consumer ind of part to show that if there is a consumer for leaky bucket, it will
            //give access to all threads
//            if(i==9){
//                userBucketCreator.userIdBucketMap.get(1).bucketQueue.remove(1);
//                userBucketCreator.userIdBucketMap.get(1).bucketQueue.remove(1);
//            }
        }
        executorService.shutdown();
    }
}
