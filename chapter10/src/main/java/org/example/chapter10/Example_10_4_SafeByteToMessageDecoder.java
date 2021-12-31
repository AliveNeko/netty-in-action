package org.example.chapter10;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.TooLongFrameException;

import java.util.List;

public class Example_10_4_SafeByteToMessageDecoder {
    public static class SafeByteToMessageDecoder extends ByteToMessageDecoder {
        private static final int MAX_FRAME_SIZE = 1024;
        @Override
        protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
            // 检查缓冲区中是否有超过 MAX_FRAME_SIZE 个字节
            int readable = in.readableBytes();
            if (readable > MAX_FRAME_SIZE) {
                // 跳过所有的可读字节，抛出TooLongFrameException 并通知ChannelHandler
                in.skipBytes(readable);
                throw new TooLongFrameException("Frame too big!");
            }
            // do something
            // ...
        }
    }
}
