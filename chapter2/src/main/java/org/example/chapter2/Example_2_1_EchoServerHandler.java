package org.example.chapter2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

public class Example_2_1_EchoServerHandler {
    // 标示一个 ChannelHandler 可以被多个 Channel 安全地共享
    @ChannelHandler.Sharable
    public static class EchoServerHandler extends ChannelInboundHandlerAdapter {
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) {
            ByteBuf in = (ByteBuf) msg;
            // 将消息记录到控制台
            System.out.println("Server received: " + in.toString(CharsetUtil.UTF_8));
            // 将接收到的消息写给发送者，而不冲刷出站消息
            ctx.write(in);
        }

        @Override
        public void channelReadComplete(ChannelHandlerContext ctx) {
            // 将未决消息冲刷到远程节点，并且关闭该 Channel
            ctx.writeAndFlush(Unpooled.EMPTY_BUFFER)
                    .addListener(ChannelFutureListener.CLOSE);
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
            // 打印异常栈跟踪
            cause.printStackTrace();
            // 关闭该 Channel
            ctx.close();
        }
    }
}
