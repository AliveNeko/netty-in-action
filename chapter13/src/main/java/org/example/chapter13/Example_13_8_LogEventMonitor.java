package org.example.chapter13;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;

import java.net.InetSocketAddress;

public class Example_13_8_LogEventMonitor {
    public static class LogEventMonitor {
        private final EventLoopGroup group;
        private final Bootstrap bootstrap;

        public LogEventMonitor(InetSocketAddress address) {
            group = new NioEventLoopGroup();
            bootstrap = new Bootstrap();
            bootstrap.group(group)
                    // 引导该 NioDatagramChannel
                    .channel(NioDatagramChannel.class)
                    // 设置套接字选项 SO_BROADCAST
                    .option(ChannelOption.SO_BROADCAST, true)
                    .handler(new ChannelInitializer<Channel>() {
                        @Override
                        protected void initChannel(Channel channel)
                                throws Exception {
                            ChannelPipeline pipeline = channel.pipeline();
                            pipeline.addLast(new Example_13_6_LogEventDecoder.LogEventDecoder());
                            // 将 LogEventDecoder 和 LogEventHandler 添加到 ChannelPipeline 中
                            pipeline.addLast(new Example_13_7_LogEventHandler.LogEventHandler());
                        }
                    })
                    .localAddress(address);
        }

        public Channel bind() {
            // 绑定 Channel。注意，DatagramChannel 是无连接的
            return bootstrap.bind().syncUninterruptibly().channel();
        }

        public void stop() {
            group.shutdownGracefully();
        }

    }

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            throw new IllegalArgumentException(
                    "Usage: LogEventMonitor <port>");
        }
        // 构造一个新的 LogEventMonitor
        LogEventMonitor monitor = new LogEventMonitor(
                new InetSocketAddress(Integer.parseInt(args[0])));
        try {
            Channel channel = monitor.bind();
            System.out.println("LogEventMonitor running");
            channel.closeFuture().sync();
        } finally {
            monitor.stop();
        }
    }
}
