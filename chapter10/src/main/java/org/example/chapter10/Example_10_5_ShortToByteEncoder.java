package org.example.chapter10;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class Example_10_5_ShortToByteEncoder {
    public static class ShortToByteEncoder extends MessageToByteEncoder<Short> {
        @Override
        protected void encode(ChannelHandlerContext ctx, Short msg, ByteBuf out) throws Exception {
            // 将 Short 写入ByteBuf 中
            out.writeShort(msg);
        }
    }
}
