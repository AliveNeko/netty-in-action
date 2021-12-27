package org.example.chapter6;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.util.ReferenceCountUtil;

public class Example_6_4_DiscardOutboundHandler {
    @ChannelHandler.Sharable
    // 扩展了 ChannelOutboundHandlerAdapter
    public static class DiscardOutboundHandler extends ChannelOutboundHandlerAdapter {
        @Override
        public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
            // 通过使用 ReferenceCountUtil.release(...) 方法释放资源
            ReferenceCountUtil.release(msg);
            // 通知 ChannelPromise 数据已经被处理了
            promise.setSuccess();
        }
    }
}
