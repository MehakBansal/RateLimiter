package RateLimiter.SlidingWindow;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static void main(String args[]){
        UserBucketCreator userBucketCreator= new UserBucketCreator(1);
        ExecutorService executorService= Executors.newFixedThreadPool(12);
        for(int i=0;i<12;i++){
            executorService.execute(()->userBucketCreator.accessApplication(1));
            //this part I added to check the sliding concept, that is after the timestamps more than the timewindow are removed
            // slidingwindow has space and thus all other threads can access application
//            try {
//                Thread.sleep(1000);
//            }
//            catch(Exception e){
//
//            }
        }
        executorService.shutdown();

    }
}
