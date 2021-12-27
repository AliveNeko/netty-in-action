package org.example.chapter5;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.buffer.UnpooledByteBufAllocator;
import io.netty.channel.PreferHeapByteBufAllocator;

import java.nio.charset.StandardCharsets;

public class Example_5_1_SupportArray {
    public static void main(String[] args) {
        ByteBuf heapBuf = Unpooled.buffer(16);
//        heapBuf.writeBytes("hello ByteBuf".getBytes(StandardCharsets.UTF_8));
        // 检查 ByteBuf 是否有一个支撑数组
        if (heapBuf.hasArray()) {
            // 如果有，则获取对该数组的引用
            byte[] array = heapBuf.array();
            // 计算第一个字节的偏移量。
            int offset = heapBuf.arrayOffset() + heapBuf.readerIndex();
            // 获得可读字节数
            int length = heapBuf.readableBytes();
            // 使用数组、偏移量和长度作为参数调用你的方法
            handleArray(array, offset, length);
        }
    }

    private static void handleArray(byte[] array, int offset, int length) {
        System.out.println(new String(array));
    }
}
