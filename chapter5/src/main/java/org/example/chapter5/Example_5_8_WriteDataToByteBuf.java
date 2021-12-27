package org.example.chapter5;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.util.Random;

public class Example_5_8_WriteDataToByteBuf {
    public static void main(String[] args) {
        Random random = new Random();
        // Fills the writable bytes of a buffer with random integers.
        ByteBuf buffer = Unpooled.buffer(16);
        while (buffer.writableBytes() >= 4) {
            buffer.writeInt(random.nextInt());
        }
    }
}
