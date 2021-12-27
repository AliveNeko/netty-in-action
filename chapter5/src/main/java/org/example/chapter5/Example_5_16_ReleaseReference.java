package org.example.chapter5;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.buffer.Unpooled;

public class Example_5_16_ReleaseReference {
    public static void main(String[] args) {
        ByteBuf buffer = PooledByteBufAllocator.DEFAULT.heapBuffer();
        // 减少到该对象的活动引用。当减少到 0 时，该对象被释放，并且该方法返回 true
        boolean released = buffer.release();
    }
}
