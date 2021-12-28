package org.example.chapter6;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.util.CharsetUtil;

public class Example_6_7_GetChannelPipelineFromChannelHandlerContext {
    public static void main(String[] args) {
        ChannelHandlerContext ctx = null;
        // 获取到与 ChannelHandlerContext 相关联的 ChannelPipeline 的引用
        ChannelPipeline pipeline = ctx.pipeline();
        // 通过 ChannelPipeline 写入缓冲区
        pipeline.write(Unpooled.copiedBuffer("Netty in Action", CharsetUtil.UTF_8));
    }
}
