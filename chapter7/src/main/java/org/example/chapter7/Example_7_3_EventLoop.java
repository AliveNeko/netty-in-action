package org.example.chapter7;

import io.netty.channel.Channel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.concurrent.TimeUnit;

public class Example_7_3_EventLoop {
    public static void main(String[] args) {
        Channel ch = new NioSocketChannel();
        ch.eventLoop().schedule(
                // 创建一个 Runnable 以供调度稍后执行
                new Runnable() {
                    @Override
                    public void run() {
                        // 要执行的代码
                        System.out.println("60 seconds later");
                    }
                },
                // 调度任务在从现在开始的 60 秒之后执行
                60, TimeUnit.SECONDS);
    }
}
