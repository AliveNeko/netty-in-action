package org.example.chapter5;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.nio.NioSocketChannel;

public class Example_5_14_GetAByteBufAllocator {
    public static void main(String[] args) {
        // 从 Channel 获取一个到 ByteBufAllocator 的引用
        Channel channel = new NioSocketChannel();
        ByteBufAllocator allocator = channel.alloc();
        // ....
        // 从 ChannelHandlerContext 获取一个到 ByteBufAllocator 的引用
        ChannelHandlerContext ctx = null;
        ByteBufAllocator allocator2 = ctx.alloc();
        // ...
    }
}
