package org.example.chapter11;

import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.handler.codec.LineBasedFrameDecoder;

public class Example_11_8_LineBasedHandlerInitializer {
    public static class LineBasedHandlerInitializer extends ChannelInitializer<Channel> {
        @Override
        protected void initChannel(Channel ch) throws Exception {
            ChannelPipeline pipeline = ch.pipeline();
            // 该 LineBasedFrameDecoder将提取的帧转发给下一个 ChannelInboundHandler
            pipeline.addLast(new LineBasedFrameDecoder(64 * 1024));
            // 添加 FrameHandler 以接收帧
            pipeline.addLast(new FrameHandler());
        }
    }

    public static class FrameHandler extends SimpleChannelInboundHandler<ByteBuf> {
        @Override
        // 传入了单个帧的内容
        protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
            // Do something with the data extracted from the frame
        }
    }
}
