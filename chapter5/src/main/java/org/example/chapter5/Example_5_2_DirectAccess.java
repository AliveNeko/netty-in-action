package org.example.chapter5;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.unix.PreferredDirectByteBufAllocator;

public class Example_5_2_DirectAccess {
    public static void main(String[] args) {
        ByteBuf directBuf = PreferredDirectByteBufAllocator.DEFAULT.directBuffer(16);
        // 检查 ByteBuf 是否由数组支撑。如果不是，则这是一个直接缓冲区
        if (!directBuf.hasArray()) {
            // 获取可读字节数
            int length = directBuf.readableBytes();
            // 分配一个新的数组来保存具有该长度的字节数据
            byte[] array = new byte[length];
            // 将字节复制到该数组
            directBuf.getBytes(directBuf.readerIndex(), array);
            handleArray(array, 0, length);
        }
    }

    private static void handleArray(byte[] array, int offset, int length) {
        System.out.println(new String(array));
    }
}
