package org.example.chapter6;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class Example_6_10_SharableChannelHandler {
    // 使用注解 @Sharable 标注
    @ChannelHandler.Sharable
    public static class SharableHandler extends ChannelInboundHandlerAdapter {
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            System.out.println("Channel read message: " + msg);
            // 记录方法调用，并转发给下一个 ChannelHandler
            ctx.fireChannelRead(msg);
        }
    }
}
