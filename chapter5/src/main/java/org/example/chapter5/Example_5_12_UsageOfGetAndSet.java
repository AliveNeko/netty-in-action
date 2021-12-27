package org.example.chapter5;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;

public class Example_5_12_UsageOfGetAndSet {
    public static void main(String[] args) {
        Charset utf8 = Charset.forName("UTF-8");
        // 创建一个新的 ByteBuf以保存给定字符串的字节
        ByteBuf buf = Unpooled.copiedBuffer("Netty in Action rocks!", utf8);
        // 打印第一个字符'N'
        System.out.println((char)buf.getByte(0));
        // 存储当前的 readerIndex和 writerIndex
        int readerIndex = buf.readerIndex();
        int writerIndex = buf.writerIndex();
        buf.setByte(0, (byte)'B');
        // 打印第一个字符，现在是'B'
        System.out.println((char)buf.getByte(0));
        // 将会成功，因为这些操作并不会修改相应的索引
        assert readerIndex == buf.readerIndex();
        assert writerIndex == buf.writerIndex();
    }
}
