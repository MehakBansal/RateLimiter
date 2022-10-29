package RateLimiter.TokenBucketLimiter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static void main(String args[]){
        UserBucketCreator userBucketCreator=new UserBucketCreator(1);
        ExecutorService executorService= Executors.newFixedThreadPool(12);
        for(int i=0;i<12;i++){
            executorService.execute(()->userBucketCreator.accessApplication(1));
            //this block I added myself to test that if a thread is coming after 1 second, by that time
            //bucket is refreshed and hence it would be able to access application.
//            try {
//                Thread.sleep(1000);
//            }
//            catch(Exception e){
//                System.out.println("exception occurred-->"+e.getStackTrace());
//            }
        }
        executorService.shutdown();;
    }
}
