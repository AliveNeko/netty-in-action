package org.example.chapter5;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;

public class Example_5_13_ReadAndWriteOfByteBuf {
    public static void main(String[] args) {
        // 创建一个新的ByteBuf 以保存给定字符串的字节
        Charset utf8 = Charset.forName("UTF-8");
        ByteBuf buf = Unpooled.copiedBuffer("Netty in Action rocks!", utf8);
        // 打印第一个字符'N'
        System.out.println((char)buf.readByte());
        // 存储当前的readerIndex
        int readerIndex = buf.readerIndex();
        // 存储当前的writerIndex
        int writerIndex = buf.writerIndex();
        // 将字符'?'追加到缓冲区
        buf.writeByte((byte)'?');
        // 将会成功，因为 writeByte() 方法移动了 writerIndex
        assert readerIndex == buf.readerIndex();
        assert writerIndex != buf.writerIndex();
    }
}
