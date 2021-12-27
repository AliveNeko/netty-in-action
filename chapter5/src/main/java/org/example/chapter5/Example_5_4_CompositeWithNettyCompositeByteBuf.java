package org.example.chapter5;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;

public class Example_5_4_CompositeWithNettyCompositeByteBuf {
    public static void main(String[] args) {
        CompositeByteBuf messageBuf = Unpooled.compositeBuffer();
        ByteBuf headerBuf = Unpooled.buffer(16); // can be backing or direct
        ByteBuf bodyBuf = Unpooled.buffer(16); // can be backing or direct
        // 将 ByteBuf 实例追加 到 CompositeByteBuf
        messageBuf.addComponents(headerBuf, bodyBuf);

        // .....

        // 删除位于索引位置为 0
        //（第一个组件）的 ByteBuf
        messageBuf.removeComponent(0); // remove the header
        for (ByteBuf buf : messageBuf) {
            System.out.println(buf.toString());
        }
    }
}
