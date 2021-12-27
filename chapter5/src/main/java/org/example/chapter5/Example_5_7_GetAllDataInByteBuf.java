package org.example.chapter5;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class Example_5_7_GetAllDataInByteBuf {
    public static void main(String[] args) {
        ByteBuf buffer = Unpooled.buffer(16);
        while (buffer.isReadable()) {
            System.out.println(buffer.readByte());
        }
    }
}
