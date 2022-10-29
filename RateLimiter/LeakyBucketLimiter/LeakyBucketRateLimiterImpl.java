package RateLimiter.LeakyBucketLimiter;

import RateLimiter.RateLimiter;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class LeakyBucketRateLimiterImpl implements RateLimiter {
    BlockingQueue<Integer> bucketQueue;
    public LeakyBucketRateLimiterImpl(int bucketCapacity){
       this.bucketQueue= new LinkedBlockingQueue<>(bucketCapacity);
    }
    @Override
    public boolean grantAccess(){
        if(bucketQueue.remainingCapacity()>0){
            bucketQueue.add(1);
            return true;
        }
        return false;
    }
}
