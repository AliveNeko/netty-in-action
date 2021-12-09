package org.example.chapter1;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class Example_1_2_ChannelHandler {
    public static class ConnectHandler extends ChannelInboundHandlerAdapter {
        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            // 当一个新的连接已经被建立时，channelActive(ChannelHandlerContext)将会被调用
            System.out.println("Client " + ctx.channel().remoteAddress() + " connected");
        }
    }
}
