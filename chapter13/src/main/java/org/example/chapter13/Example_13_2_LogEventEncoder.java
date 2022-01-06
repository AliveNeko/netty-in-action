package org.example.chapter13;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.util.CharsetUtil;

import java.net.InetSocketAddress;
import java.util.List;

import static org.example.chapter13.Example_13_1_LogEvent.LogEvent;

public class Example_13_2_LogEventEncoder {
    public static class LogEventEncoder extends MessageToMessageEncoder<LogEvent> {
        private final InetSocketAddress remoteAddress;

        public LogEventEncoder(InetSocketAddress remoteAddress) {
            this.remoteAddress = remoteAddress;
        }

        @Override
        protected void encode(ChannelHandlerContext channelHandlerContext, LogEvent logEvent, List<Object> out) throws Exception {
            byte[] file = logEvent.getLogfile().getBytes(CharsetUtil.UTF_8);
            byte[] msg = logEvent.getMsg().getBytes(CharsetUtil.UTF_8);
            ByteBuf buf = channelHandlerContext.alloc()
                    .buffer(file.length + msg.length + 1);
            // 将文件名写入到 ByteBuf 中
            buf.writeBytes(file);
            // 添加一个 SEPARATOR
            buf.writeByte(LogEvent.SEPARATOR);
            // 将日志消息写入 ByteBuf 中
            buf.writeBytes(msg);
            // 将一个拥有数据和目的地地址的新 DatagramPacket 添加到出站的消息列表中
            out.add(new DatagramPacket(buf, remoteAddress));
        }
    }
}
