package org.example.chapter5;

import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;

public class Example_5_5_GetDataInCompositeByteBuf {
    public static void main(String[] args) {
        CompositeByteBuf compBuf = Unpooled.compositeBuffer();
        // 获得可读字节数
        int length = compBuf.readableBytes();
        // 分配一个具有可读字节数长度的新数组
        byte[] array = new byte[length];
        // 将字节读到该数组中
        compBuf.getBytes(compBuf.readerIndex(), array);
        // 使用偏移量和长度作为参数使用该数组
        handleArray(array, 0, array.length);
    }

    private static void handleArray(byte[] array, int offset, int length) {
        System.out.println(new String(array));
    }
}
