package org.example.chapter6;

import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.CharsetUtil;

public class Example_6_6_GetChannelFromChannelHandlerContext {
    public static void main(String[] args) {
        ChannelHandlerContext ctx = null;
        // 获取到与 ChannelHandlerContext 相关联的 Channel 的引用
        Channel channel = ctx.channel();
        // 通过 Channel 写入缓冲区
        channel.write(Unpooled.copiedBuffer("Netty in Action", CharsetUtil.UTF_8));
    }
}
