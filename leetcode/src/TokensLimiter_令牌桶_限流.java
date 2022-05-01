/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 在这里编写类的功能描述
 *
 * @author luweiliang
 * @created 2020/8/14
 */
public class TokensLimiter_令牌桶_限流 {

    private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

    // 桶的容量
    public int capacity = 10;
    // 令牌生成速度10/s
    public int rate = 10;
    // 当前令牌数量
    public int tokens;
    // 最后一次令牌发放时间
    public long timeStamp = System.currentTimeMillis();

    public void acquire() {

        /**
         * scheduledExecutorService.scheduleWithFixedDelay
         * 可以理解为就是以固定延迟（时间）来执行线程任务，它实际上是不管线程任务的执行时间的，每次都要把任务执行完成后再延迟固定时间后再执行下一次。
         */
        scheduledExecutorService.scheduleWithFixedDelay(() -> {
            long now = System.currentTimeMillis();
            // 当前令牌数
            tokens = Math.min(capacity, (int) (tokens + (now - timeStamp) * rate / 1000));
            //每隔0.5秒发送随机数量的请求
            int permits = (int) (Math.random() * 9) + 1;
            System.out.println("请求令牌数：" + permits + "，当前令牌数：" + tokens);
            timeStamp = now;
            if (tokens < permits) {
                // 若不到令牌,则拒绝
                System.out.println("限流了");
            } else {
                // 还有令牌，领取令牌
                tokens -= permits;
                System.out.println("剩余令牌=" + tokens);
            }
        }, 1000, 500, TimeUnit.MILLISECONDS);
//        0, 500, TimeUnit.MILLISECONDS);

    }

    public static void main(String[] args) {
        TokensLimiter_令牌桶_限流 tokensLimiter = new TokensLimiter_令牌桶_限流();
        tokensLimiter.acquire();
    }

}
