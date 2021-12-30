package org.example.chapter7;

import io.netty.channel.Channel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Example_7_5_ScheduledFuture {
    public static void main(String[] args) {
        Channel ch = new NioSocketChannel();
        // 调度任务，并获得所返回的ScheduledFuture
        ScheduledFuture<?> future = ch.eventLoop().scheduleAtFixedRate(() -> {}, 0, 10, TimeUnit.SECONDS);
        // Some other code that runs...
        boolean mayInterruptIfRunning = false;
        // 取消该任务，防止它再次运行
        future.cancel(mayInterruptIfRunning);
    }
}
