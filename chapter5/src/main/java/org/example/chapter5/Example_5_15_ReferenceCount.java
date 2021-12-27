package org.example.chapter5;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class Example_5_15_ReferenceCount {
    public static void main(String[] args) {
        Channel channel = new NioSocketChannel();
        // 从 Channel 获取 ByteBufAllocator
        ByteBufAllocator allocator = channel.alloc();
        // ...
        // 从 ByteBufAllocator 分配一个 ByteBuf
        ByteBuf buffer = allocator.directBuffer();
        // 检查引用计数是否为预期的 1
        assert buffer.refCnt() == 1;
        // ...
    }
}
