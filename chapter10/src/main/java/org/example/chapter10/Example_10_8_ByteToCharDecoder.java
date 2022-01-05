package org.example.chapter10;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class Example_10_8_ByteToCharDecoder {
    public static class ByteToCharDecoder extends ByteToMessageDecoder {
        @Override
        protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
            // 将一个或者多个 Character 对象添加到传出的 List 中
            while (in.readableBytes() >= 2) {
                out.add(in.readChar());
            }
        }
    }
}
