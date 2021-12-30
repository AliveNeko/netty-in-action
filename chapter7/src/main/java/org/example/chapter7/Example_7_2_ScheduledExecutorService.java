package org.example.chapter7;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Example_7_2_ScheduledExecutorService {
    public static void main(String[] args) {
        // 创建一个其线程池具有 10 个线程的 ScheduledExecutorService
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(10);
        ScheduledFuture<?> future = executor.schedule(
                // 创建一个 Runnable，以供调度稍后执行
                new Runnable() {
                    @Override
                    public void run() {
                        // 该任务要打印的消息
                        System.out.println("60 seconds later");
                    }
                },
                // 调度任务在从现在开始的 60 秒之后执行
                60, TimeUnit.SECONDS);
        // ...
        // 一旦调度任务执行完成，就关闭 ScheduledExecutorService 以释放资源
        executor.shutdown();
    }
}
