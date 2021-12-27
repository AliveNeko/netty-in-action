package org.example.chapter6;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

public class Example_6_3_DiscardInboundHandler {
    @ChannelHandler.Sharable
    // 扩展了 ChannelInboundHandlerAdapter
    public static class DiscardInboundHandler extends ChannelInboundHandlerAdapter {
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            // 通过调用 ReferenceCountUtil.release() 方法释放资源
            ReferenceCountUtil.release(msg);
        }
    }
}
