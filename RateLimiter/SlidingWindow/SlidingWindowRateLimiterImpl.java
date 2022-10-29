package RateLimiter.SlidingWindow;

import RateLimiter.RateLimiter;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class SlidingWindowRateLimiterImpl implements RateLimiter {
    int bucketCapacity;
    int timeIntervalForWindowInSec;
    Queue<Long> slidingWindow;
    public SlidingWindowRateLimiterImpl(int bucketCapacity,int timeIntervalForWindowInSec){
        this.bucketCapacity=bucketCapacity;
        this.timeIntervalForWindowInSec=timeIntervalForWindowInSec;
        this.slidingWindow=new ConcurrentLinkedDeque<>();
    }
    @Override
    public boolean grantAccess() {
        Long currentTime=System.currentTimeMillis();
        checkAndUpdateQueue(currentTime);
        if(slidingWindow.size()<bucketCapacity){
            slidingWindow.offer(currentTime);
            return true;
        }
        return false;
    }

    public void checkAndUpdateQueue(Long currentTime){
        if(slidingWindow.isEmpty()) return;
        long calculatedTime=(currentTime-slidingWindow.peek())/1000;
        while(calculatedTime>=timeIntervalForWindowInSec){
            slidingWindow.poll();
            if(slidingWindow.isEmpty()) break;
            calculatedTime=(currentTime-slidingWindow.peek())/1000;

        }
    }
}
