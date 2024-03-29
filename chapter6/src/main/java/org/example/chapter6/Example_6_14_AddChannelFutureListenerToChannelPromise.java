package org.example.chapter6;

import io.netty.channel.*;

public class Example_6_14_AddChannelFutureListenerToChannelPromise {
    public static class OutboundExceptionHandler extends ChannelOutboundHandlerAdapter {
        @Override
        public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
            promise.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture f) throws Exception {
                    if (!f.isSuccess()) {
                        f.cause().printStackTrace();
                        f.channel().close();
                    }
                }
            });
        }
    }
}
