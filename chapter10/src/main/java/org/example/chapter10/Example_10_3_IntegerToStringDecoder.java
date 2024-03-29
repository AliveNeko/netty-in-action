package org.example.chapter10;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.util.List;

public class Example_10_3_IntegerToStringDecoder {
    public static class IntegerToStringDecoder extends MessageToMessageDecoder<Integer> {
        @Override
        protected void decode(ChannelHandlerContext ctx, Integer msg, List<Object> out) throws Exception {
            out.add(String.valueOf(msg));
        }
    }
}
