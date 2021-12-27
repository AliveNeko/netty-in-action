package org.example.chapter5;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.UnpooledByteBufAllocator;

public class Example_5_6_GetDataInByteBuf {
    public static void main(String[] args) {
        ByteBuf buffer = UnpooledByteBufAllocator.DEFAULT.buffer();
        for (int i = 0; i < buffer.capacity(); i++) {
            byte b = buffer.getByte(i);
            System.out.println((char)b);
        }
    }
}
