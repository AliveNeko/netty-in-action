package org.example.chapter10;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class Example_10_9_CharToByteEncoder {
    public static class CharToByteEncoder extends MessageToByteEncoder<Character> {

        @Override
        protected void encode(ChannelHandlerContext ctx, Character msg, ByteBuf out) throws Exception {
            // 将 Character 解码为 char，并将其写入到出站 ByteBuf 中
            out.writeChar(msg);
        }
    }
}
