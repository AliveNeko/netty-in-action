package org.example.chapter6;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class Example_6_9_WriteHandler {
    public static class WriteHandler extends ChannelHandlerAdapter {
        private ChannelHandlerContext ctx;

        @Override
        public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
            // 存储到 ChannelHandlerContext 的引用以供稍后使用
            this.ctx = ctx;
        }

        public void send(String msg) {
            // 使用之前存储的到 ChannelHandlerContext 的引用来发送消息
            ctx.writeAndFlush(msg);
        }
    }
}
