package org.example.chapter11;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.CharsetUtil;

import java.util.concurrent.TimeUnit;

public class Example_11_7_IdleStateHandlerInitializer {
    public static class IdleStateHandlerInitializer extends ChannelInitializer<Channel> {
        @Override
        protected void initChannel(Channel ch) throws Exception {
            ChannelPipeline pipeline = ch.pipeline();
            // IdleStateHandler 将在被触发时发送一个IdleStateEvent 事件
            pipeline.addLast(new IdleStateHandler(0, 0, 60, TimeUnit.SECONDS));
            // 将一个HeartbeatHandler 添加到ChannelPipeline中
            pipeline.addLast(new HeartbeatHandler());
        }
    }

    // 实现 userEventTriggered()方法以发送心跳消息
    public static class HeartbeatHandler extends ChannelInboundHandlerAdapter {
        // 发送到远程节点的心跳消息
        private static final ByteBuf HEARTBEAT_SEQUENCE =
                Unpooled.unreleasableBuffer(Unpooled.copiedBuffer("HEARTBEAT", CharsetUtil.ISO_8859_1));

        @Override
        public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
            if (evt instanceof IdleStateEvent) {
                // 并在发送失败时关闭该连接
                ctx.writeAndFlush(HEARTBEAT_SEQUENCE.duplicate())
                        .addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
            } else {
                // 不是 IdleStateEvent事件，所以将它传递给下一个 ChannelInboundHandler
                super.userEventTriggered(ctx, evt);
            }
        }
    }
}
