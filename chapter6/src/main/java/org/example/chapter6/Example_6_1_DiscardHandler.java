package org.example.chapter6;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

public class Example_6_1_DiscardHandler {
    @ChannelHandler.Sharable
    // 扩展了 ChannelInboundHandlerAdapter
    public static class DiscardHandler extends ChannelInboundHandlerAdapter {
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            // 丢弃已接收的消息
            ReferenceCountUtil.release(msg);
        }
    }
}
