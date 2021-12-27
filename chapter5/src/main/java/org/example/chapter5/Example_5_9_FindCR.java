package org.example.chapter5;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufProcessor;
import io.netty.buffer.Unpooled;

public class Example_5_9_FindCR {
    public static void main(String[] args) {
        ByteBuf buffer = Unpooled.buffer();
        int index = buffer.forEachByte(ByteBufProcessor.FIND_CR);
        buffer.forEachByte(b -> b != '\r');
    }
}
