package org.example.chapter8;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.oio.OioSocketChannel;

import java.net.InetSocketAddress;

public class Example_8_3_NotCompatibleChannelAndEventLoopGroup {
    public static void main(String[] args) {
        EventLoopGroup group = new NioEventLoopGroup();
        // 创建一个新的 Bootstrap 类的实例，以创建新的客户端Channe
        Bootstrap bootstrap = new Bootstrap();
        // 指定一个适用于 NIO 的EventLoopGroup 实现
        bootstrap.group(group)
                .channel(OioSocketChannel.class)
                // 设置一个用于处理 Channel 的 I/O 事件和数据的 ChannelInboundHandler
                .handler(new SimpleChannelInboundHandler<ByteBuf>() {
                    @Override
                    protected void channelRead0(
                            ChannelHandlerContext channelHandlerContext,
                            ByteBuf byteBuf) throws Exception {
                        System.out.println("Received data");
                    } } );
        // 尝试连接到远程节点
        ChannelFuture future = bootstrap.connect(
                new InetSocketAddress("www.manning.com", 80));
        future.syncUninterruptibly();
    }
}
