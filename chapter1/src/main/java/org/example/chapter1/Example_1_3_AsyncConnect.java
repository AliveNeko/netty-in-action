package org.example.chapter1;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

public class Example_1_3_AsyncConnect {
    public void asyncConnect() {
        Channel channel = new NioSocketChannel();
        // Does not block
        // 异步地连接到远程节点
        ChannelFuture future = channel.connect(new InetSocketAddress("192.168.0.1", 25));
    }
}
