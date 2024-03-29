package org.example.chapter10;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

public class Example_10_6_IntegerToStringEncoder {
    public static class IntegerToStringEncoder extends MessageToMessageEncoder<Integer> {
        @Override
        protected void encode(ChannelHandlerContext ctx, Integer msg, List<Object> out) throws Exception {
            // 将 Integer 转换为 String，并将其添加到 List 中
            out.add(String.valueOf(msg));
        }
    }
}
