package org.example.chapter10;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class Example_10_1_ToIntegerDecoder {
    // 扩展 ByteToMessageDecoder 类，以将字节解码为特定的格式
    public static class ToIntegerDecoder extends ByteToMessageDecoder {
        @Override
        protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
            // 检查是否至少有 4 字节可读（一个 int 的字节长度）
            if (in.readableBytes() >= 4) {
                // 从入站 ByteBuf 中读取一个 int，并将其添加到解码消息的 List 中
                out.add(in.readInt());
            }
        }
    }
}
