package org.example.chapter5;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;

public class Example_5_11_CopyAByteBuf {
    public static void main(String[] args) {
        Charset utf8 = Charset.forName("UTF-8");
        // 创建 ByteBuf 以保存所提供的字符串的字节
        ByteBuf buf = Unpooled.copiedBuffer("Netty in Action rocks!", utf8);
        // 创建该 ByteBuf 从索引 0 开始到索引 15结束的分段的副本
        ByteBuf copy = buf.copy(0, 15);
        // 将打印“Netty in Action”
        System.out.println(copy.toString(utf8));
        // 更新索引 0 处的字节
        buf.setByte(0, (byte) 'J');
        // 将会成功，因为数据不是共享的
        assert buf.getByte(0) != copy.getByte(0);
    }
}
