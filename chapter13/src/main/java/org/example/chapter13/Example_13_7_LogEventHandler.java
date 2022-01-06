package org.example.chapter13;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import static org.example.chapter13.Example_13_1_LogEvent.LogEvent;

public class Example_13_7_LogEventHandler {
    public static class LogEventHandler extends SimpleChannelInboundHandler<LogEvent> {
        @Override
        public void exceptionCaught(ChannelHandlerContext ctx,
                                    Throwable cause) throws Exception {
            cause.printStackTrace();
            ctx.close();
        }

        @Override
        protected void channelRead0(ChannelHandlerContext ctx, LogEvent event) throws Exception {
            StringBuilder builder = new StringBuilder();
            builder.append(event.getReceivedTimestamp());
            builder.append(" [");
            builder.append(event.getSource().toString());
            builder.append("] [");
            builder.append(event.getLogfile());
            builder.append("] : ");
            builder.append(event.getMsg());
            System.out.println(builder.toString());
        }
    }
}
