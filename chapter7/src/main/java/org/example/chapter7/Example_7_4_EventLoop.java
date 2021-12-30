package org.example.chapter7;

import io.netty.channel.Channel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.concurrent.TimeUnit;

public class Example_7_4_EventLoop {
    public static void main(String[] args) {
        Channel ch = new NioSocketChannel();
        ch.eventLoop().scheduleAtFixedRate(
                // 创建一个 Runnable，以供调度稍后执行
                new Runnable() {
                    @Override
                    public void run() {
                        // 这将一直运行，直到 ScheduledFuture 被取消
                        System.out.println("Run every 60 seconds");
                    }
                },
                // 调度在 60 秒之后，并且以后每间隔 60 秒运行
                60, 60, TimeUnit.SECONDS
        );
    }
}
