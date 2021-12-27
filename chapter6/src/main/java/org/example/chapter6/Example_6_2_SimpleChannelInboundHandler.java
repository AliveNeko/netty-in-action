package org.example.chapter6;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class Example_6_2_SimpleChannelInboundHandler {
    @ChannelHandler.Sharable
    // 扩展了SimpleChannelInboundHandler
    public static class SimpleDiscardHandler extends SimpleChannelInboundHandler<Object> {
        @Override
        protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
            // 不需要任何显式的资源释放
        }
    }
}
