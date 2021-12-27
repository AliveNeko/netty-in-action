package org.example.chapter5;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Example_5_10_SliceByteBuf {
    public static void main(String[] args) {
        Charset utf8 = Charset.forName("UTF-8");
        // 创建一个用于保存给定字符串的字节的 ByteBuf
        ByteBuf buf = Unpooled.copiedBuffer("Netty in Action rocks!", utf8);
        // 创建该 ByteBuf 从索引 0 开始到索引 15结束的一个新切片
        ByteBuf sliced = buf.slice(0, 15);
        // 将打印“Netty in Action”
        System.out.println(sliced.toString(utf8));
        // 更新索引 0 处的字节
        buf.setByte(0, (byte)'J');
        // 将会成功，因为数据是共享的，对其中一个所做的更改对另外一个也是可见的
        assert buf.getByte(0) == sliced.getByte(0);
    }
}
