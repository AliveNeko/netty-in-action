package org.example.chapter8;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

public class Example_8_4_PilotServer {
    public static void main(String[] args) {
        NioEventLoopGroup group = new NioEventLoopGroup();
        // 创建 ServerBootstrap
        ServerBootstrap bootstrap = new ServerBootstrap();
        // 设置 EventLoopGroup，其提供了用于处理Channel 事件的EventLoop
        bootstrap.group(group)
                // 指定要使用的 Channel 实现
                .channel(NioServerSocketChannel.class)
                // 设置用于处理已被接受的子Channel的I/O及数据的 ChannelInboundHandler
                .childHandler(new SimpleChannelInboundHandler<ByteBuf>() {
                    @Override
                    protected void channelRead0(ChannelHandlerContext ctx,
                                                ByteBuf byteBuf) throws Exception {
                        System.out.println("Received data");
                    }
                });
        // 通过配置好的 ServerBootstrap 的实例绑定该 Channe
        ChannelFuture future = bootstrap.bind(new InetSocketAddress(8080));
        future.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture channelFuture)
                    throws Exception {
                if (channelFuture.isSuccess()) {
                    System.out.println("Server bound");
                } else {
                    System.err.println("Bound attempt failed");
                    channelFuture.cause().printStackTrace();
                }
            }
        });
    }
}
