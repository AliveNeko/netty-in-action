package org.example.chapter8;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.concurrent.Future;

public class Example_8_9_ShutdownGracefully {
    public static void main(String[] args) {
        // 创建处理 I/O 的 EventLoopGroup
        EventLoopGroup group = new NioEventLoopGroup();
        // 创建一个 Bootstrap 类的实例并配置它
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class);
        // ...
        // shutdownGracefully()方法将释放所有的资源，并且关闭所有的当前正在使用中的 Channel
        Future<?> future = group.shutdownGracefully();
        // block until the group has shutdown
        future.syncUninterruptibly();
    }
}
