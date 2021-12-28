package org.example.chapter6;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class Example_6_11_SharableWrongUsage {
    // 使用注解 @Sharable 标注
    @ChannelHandler.Sharable
    public static class UnsharableHandler extends ChannelInboundHandlerAdapter {
        private int count;

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            // 将 count 字段的值加 1
            count++;
            // 记录方法调用，并转发给下一个ChannelHandler
            System.out.println("channelRead(...) called the " + count + " time");
            ctx.fireChannelRead(msg);
        }
    }
}
