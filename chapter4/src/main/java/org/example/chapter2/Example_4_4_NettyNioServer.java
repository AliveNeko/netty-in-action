package org.example.chapter2;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.oio.OioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.oio.OioServerSocketChannel;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

public class Example_4_4_NettyNioServer {
    public static class NettyNioServer {
        public void server(int port) throws Exception {
            final ByteBuf buf = Unpooled.unreleasableBuffer(
                    Unpooled.copiedBuffer("Hi!\r\n", Charset.forName("UTF-8")));
            // 为非阻塞模式使用NioEventLoopGroup
            EventLoopGroup group = new NioEventLoopGroup();
            try {
                // 创建 ServerBootstrap
                ServerBootstrap b = new ServerBootstrap();
                b.group(group)
                        .channel(NioServerSocketChannel.class)
                        .localAddress(new InetSocketAddress(port))
                        // 指定 ChannelInitializer，对于每个已接受的连接都调用它
                        .childHandler(new ChannelInitializer<SocketChannel>() {
                            @Override
                            public void initChannel(SocketChannel ch)
                                    throws Exception {
                                // 添加一个 ChannelInboundHandlerAdapter 以拦截和处理事件
                                ch.pipeline().addLast(new ChannelInboundHandlerAdapter() {
                                    @Override
                                    public void channelActive(ChannelHandlerContext ctx)
                                            throws Exception {
                                        // 将消息写到客户端，并添加 ChannelFutureListener，以便消息一被写完就关闭连接
                                        ctx.writeAndFlush(buf.duplicate())
                                                .addListener(ChannelFutureListener.CLOSE);
                                    }
                                });
                            }
                        });
                // 绑定服务器以接受连接
                ChannelFuture f = b.bind().sync();
                f.channel().closeFuture().sync();
            } finally {
                // 释放所有的资源
                group.shutdownGracefully().sync();
            }
        }
    }
}
