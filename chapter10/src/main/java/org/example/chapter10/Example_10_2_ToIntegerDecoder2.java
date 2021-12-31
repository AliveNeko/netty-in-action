package org.example.chapter10;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

public class Example_10_2_ToIntegerDecoder2 {
    // 扩展 ReplayingDecoder<Void>以将字节解码为消息
    public static class ToIntegerDecoder2 extends ReplayingDecoder<Void> {
        @Override
        // 传入的 ByteBuf 是 ReplayingDecoderByteBuf
        protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
            // 从入站 ByteBuf 中读取一个 int，并将其添加到解码消息的 List 中
            out.add(in.readInt());
        }
    }
}
