package org.example.chapter6;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.CharsetUtil;

public class Example_6_8_ChannelHandlerContextWrite {
    public static void main(String[] args) {
        // 获取到 ChannelHandlerContext 的引用
        ChannelHandlerContext ctx = null;
        // write()方法将把缓冲区数据发送到下一个 ChannelHandler
        ctx.write(Unpooled.copiedBuffer("Netty in Action", CharsetUtil.UTF_8));
    }
}
