package org.example.chapter2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

public class Example_2_3_EchoClientHandler {
    // 标记该类的实例可以被多个 Channel 共享
    @ChannelHandler.Sharable
    public static class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {
        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            // 当被通知 Channel是活跃的时候，发送一条消息
            ctx.writeAndFlush(Unpooled.copiedBuffer("Netty rocks!", CharsetUtil.UTF_8));
        }

        @Override
        protected void channelRead0(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
            // 记录已接收消息的转储
            System.out.println("Client received: " + in.toString(CharsetUtil.UTF_8));
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            // 在发生异常时，记录错误并关闭Channel
            cause.printStackTrace();
            ctx.close();
        }
    }
}
